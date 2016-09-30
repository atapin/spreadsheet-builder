package org.modelcatalogue.spreadsheet.api;

import java.util.Collection;

public interface TableRow<TableType extends Table, CellType extends TableCell> {

    TableType getTable();

    int getNumber();

    Collection<CellType> getCells();

    TableRow<TableType, CellType> getAbove();

    TableRow<TableType, CellType> getAbove(int howMany);

    TableRow<TableType, CellType> getBellow();

    TableRow<TableType, CellType> getBellow(int howMany);
}
