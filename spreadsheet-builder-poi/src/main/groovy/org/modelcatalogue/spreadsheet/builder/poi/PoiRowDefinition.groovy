package org.modelcatalogue.spreadsheet.builder.poi

import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.modelcatalogue.spreadsheet.api.Cell
import org.modelcatalogue.spreadsheet.api.Row
import org.modelcatalogue.spreadsheet.api.Sheet
import org.modelcatalogue.spreadsheet.builder.api.Builder
import org.modelcatalogue.spreadsheet.builder.api.CellDefinition
import org.modelcatalogue.spreadsheet.builder.api.CellStyleDefinition
import org.modelcatalogue.spreadsheet.builder.api.RowDefinition

class PoiRowDefinition implements RowDefinition, Row {

    private final XSSFRow xssfRow
    private final PoiSheetDefinition sheet

    private String styleName
    private String[] styleNames
    private Builder<CellStyleDefinition> styleDefinition

    private final List<Integer> startPositions = []
    private int nextColNumber = 0
    private final Map<Integer, PoiCellDefinition> cells = [:]

    PoiRowDefinition(PoiSheetDefinition sheet, XSSFRow xssfRow) {
        this.sheet = sheet
        this.xssfRow = xssfRow
    }

    List<PoiCellDefinition> getCells() {
        // TODO: reuse existing cells
        xssfRow.collect { new PoiCellDefinition(this, it as XSSFCell) }
    }

    private PoiCellDefinition findOrCreateCell(int zeroBasedCellNumber) {
        PoiCellDefinition cell = cells[zeroBasedCellNumber + 1]

        if (cell) {
            return cell
        }

        XSSFCell xssfCell = xssfRow.createCell(zeroBasedCellNumber)

        cell = new PoiCellDefinition(this, xssfCell)

        cells[zeroBasedCellNumber + 1] = cell

        return cell
    }

    @Override
    void cell() {
        cell null as Builder<CellDefinition>
    }

    @Override
    int getNumber() {
        return xssfRow.rowNum + 1
    }

    @Override
    void cell(Object value) {
        PoiCellDefinition poiCell = findOrCreateCell nextColNumber++

        if (styleNames) {
            poiCell.styles styleNames
        }
        if (styleName) {
            if (styleDefinition) {
                poiCell.style styleName, styleDefinition
            } else {
                poiCell.style styleName
            }
        } else if(styleDefinition) {
            poiCell.style styleDefinition
        }

        poiCell.value value

        poiCell.resolve()
    }

    @Override
    void cell(Builder<CellDefinition> cellDefinition) {
        PoiCellDefinition poiCell = findOrCreateCell nextColNumber

        if (styleName) {
            if (styleDefinition) {
                poiCell.style styleName, styleDefinition
            } else {
                poiCell.style styleName
            }
        } else if (styleDefinition) {
            poiCell.style styleDefinition
        }

        cellDefinition.configure(poiCell)

        nextColNumber += poiCell.colspan

        handleSpans(poiCell)

        poiCell.resolve()
    }

    private void handleSpans(PoiCellDefinition poiCell) {
        if (poiCell.colspan > 1 || poiCell.rowspan > 1) {
            xssfRow.sheet.addMergedRegion(poiCell.cellRangeAddress);
        }
    }

    @Override
    void cell(int column, Builder<CellDefinition> cellDefinition) {
        nextColNumber = column

        PoiCellDefinition poiCell = findOrCreateCell column - 1

        if (styleName) {
            if (styleDefinition) {
                poiCell.style styleName, styleDefinition
            } else {
                poiCell.style styleName
            }
        } else if(styleDefinition) {
            poiCell.style styleDefinition
        }

        cellDefinition.configure(poiCell)

        handleSpans(poiCell)

        poiCell.resolve()
    }

    @Override
    void cell(String column, Builder<CellDefinition> cellDefinition) {
        cell Cell.Util.parseColumn(column), cellDefinition
    }

    @Override
    void style(Builder<CellStyleDefinition> styleDefinition) {
        this.styleDefinition = styleDefinition
    }

    @Override
    void style(String name) {
        this.styleName = name
    }

    @Override
    void style(String name, Builder<CellStyleDefinition>  styleDefinition) {
        style name
        style styleDefinition
    }

    @Override
    void styles(String... names) {
        this.styleNames = names
    }

    @Override
    void styles(Iterable<String> names) {
        styles(names.toList().toArray(new String[names.size()]))
    }

    @Override
    PoiSheetDefinition getSheet() {
        return sheet
    }

    protected XSSFRow getRow() {
        return xssfRow
    }

    @Override
    void group(Builder<RowDefinition> insideGroupDefinition) {
        createGroup(false, insideGroupDefinition)
    }

    @Override
    void collapse(Builder<RowDefinition>  insideGroupDefinition) {
        createGroup(true, insideGroupDefinition)
    }

    @Override
    PoiRowDefinition getAbove(int howMany) {
        aboveOrBellow(-howMany)
    }

    @Override
    PoiRowDefinition getAbove() {
        return getAbove(1)
    }

    @Override
    PoiRowDefinition getBellow(int howMany) {
        aboveOrBellow(howMany)
    }

    @Override
    PoiRowDefinition getBellow() {
        return getBellow(1)
    }

    private PoiRowDefinition aboveOrBellow(int howMany) {
        if (xssfRow.rowNum + howMany < 0 || xssfRow.rowNum + howMany >  xssfRow.sheet.lastRowNum) {
            return null
        }
        PoiRowDefinition existing = sheet.getRowByNumber(number + howMany)
        if (existing) {
            return existing
        }
        return sheet.createRowWrapper(number + howMany)
    }

    private void createGroup(boolean collapsed, Builder<RowDefinition> insideGroupDefinition) {
        startPositions.push nextColNumber

        insideGroupDefinition.configure(this)

        int startPosition = startPositions.pop()

        if (nextColNumber - startPosition > 1) {
            int endPosition = nextColNumber - 1
            sheet.sheet.groupColumn(startPosition, endPosition)
            if (collapsed) {
                sheet.sheet.setColumnGroupCollapsed(endPosition, true)
            }
        }

    }

    PoiCellDefinition getCellByNumber(int oneBasedColumnNumber) {
        cells[oneBasedColumnNumber]
    }

    @Override
    String toString() {
        return "Row[${sheet.name}!${number}]"
    }

    @Override
    Sheet getTable() {
        return sheet
    }
}
