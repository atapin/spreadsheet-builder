package org.modelcatalogue.spreadsheet.api;

public interface Sheet extends Table<Row> {

    String getName();
    Workbook getWorkbook();

    Sheet getNext();
    Sheet getPrevious();

}
