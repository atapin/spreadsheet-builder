package org.modelcatalogue.spreadsheet.builder.api;


import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public interface TableRowDefinition {

    void cell();
    void cell(Object value);
    void cell(@DelegatesTo(TableCellDefinition.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.TableCellDefinition") Closure cellDefinition);
    void cell(int column, @DelegatesTo(TableCellDefinition.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.TableCellDefinition") Closure cellDefinition);
    void cell(String column, @DelegatesTo(TableCellDefinition.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.TableCellDefinition") Closure cellDefinition);

}
