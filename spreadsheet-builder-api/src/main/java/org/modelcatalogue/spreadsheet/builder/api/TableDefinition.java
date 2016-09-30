package org.modelcatalogue.spreadsheet.builder.api;


public interface TableDefinition<RowDefinitionType> {

    /**
     * Crates new empty row.
     */
    void row();

    /**
     * Creates new row in the spreadsheet.
     * @param rowDefinition closure defining the content of the row
     */
    void row(Builder<RowDefinitionType> rowDefinition);

    /**
     * Creates new row in the spreadsheet.
     * @param row row number (1 based - the same as is shown in the file)
     * @param rowDefinition closure defining the content of the row
     */
    void row(int row, Builder<RowDefinitionType> rowDefinition);


}
