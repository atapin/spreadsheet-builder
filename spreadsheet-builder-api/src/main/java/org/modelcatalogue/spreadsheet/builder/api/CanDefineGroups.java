package org.modelcatalogue.spreadsheet.builder.api;

public interface CanDefineGroups<RowDefinitionType> {

    void group(Builder<RowDefinitionType> builder);
    void collapse(Builder<RowDefinitionType> builder);

}
