package org.modelcatalogue.spreadsheet.query.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;
import org.modelcatalogue.spreadsheet.api.Cell;
import org.modelcatalogue.spreadsheet.api.TableCell;

public interface TableRowCriterion<CellType extends TableCell> {

    Predicate<CellType> column(int number);
    Predicate<CellType> columnAsString(String name);
    Predicate<CellType> range(int from, int to);
    Predicate<CellType> range(String from, String to);

    void cell(Predicate<CellType> predicate);
    void cell(int column);
    void cell(String column);

    void cell(@DelegatesTo(TableCellCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.TableCellCriterion") Closure cellCriterion);
    void cell(int column, @DelegatesTo(TableCellCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.TableCellCriterion") Closure cellCriterion);
    void cell(String column, @DelegatesTo(TableCellCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.TableCellCriterion") Closure cellCriterion);
    void cell(Predicate<CellType> predicate, @DelegatesTo(TableCellCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.TableCellCriterion") Closure cellCriterion);
    void or(@DelegatesTo(TableRowCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.TableRowCriterion") Closure rowCriterion);

}
