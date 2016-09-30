package org.modelcatalogue.spreadsheet.builder.api;


import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public interface RowDefinition extends HasStyle, TableRowDefinition {

    void cell(@DelegatesTo(CellDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CellDefinition") Closure cellDefinition);
    void cell(int column, @DelegatesTo(CellDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CellDefinition") Closure cellDefinition);
    void cell(String column, @DelegatesTo(CellDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CellDefinition") Closure cellDefinition);

    void group(@DelegatesTo(RowDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.RowDefinition") Closure insideGroupDefinition);
    void collapse(@DelegatesTo(RowDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.RowDefinition") Closure insideGroupDefinition);

}
