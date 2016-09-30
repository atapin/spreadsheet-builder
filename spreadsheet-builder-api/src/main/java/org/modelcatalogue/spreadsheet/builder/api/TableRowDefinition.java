package org.modelcatalogue.spreadsheet.builder.api;


public interface TableRowDefinition<CellDefinitionType> {

    void cell();
    void cell(Object value);
    void cell(Builder<CellDefinitionType> cellDefinition);
    void cell(int column, Builder<CellDefinitionType> cellDefinition);
    void cell(String column, Builder<CellDefinitionType> cellDefinition);

}
