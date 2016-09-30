package org.modelcatalogue.spreadsheet.api;

public interface TableCell<RowType extends TableRow, CellType extends TableCell> {

    RowType getRow();

    int getColumn();

    Object getValue();

    String getColumnAsString();

    <T> T read(Class<T> type);

    CellType getAbove();

    CellType getBellow();

    CellType getLeft();

    CellType getRight();

    CellType getAboveLeft();

    CellType getAboveRight();

    CellType getBellowLeft();

    CellType getBellowRight();
}
