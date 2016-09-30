package org.modelcatalogue.spreadsheet.builder.api;

public interface SpreadsheetBuilder {

    SpreadsheetDefinition build(Builder<WorkbookDefinition> workbookDefinition);

}
