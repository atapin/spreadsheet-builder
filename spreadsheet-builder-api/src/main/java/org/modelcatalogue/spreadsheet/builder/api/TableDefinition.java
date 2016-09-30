package org.modelcatalogue.spreadsheet.builder.api;


import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;

public interface TableDefinition {

    /**
     * Crates new empty row.
     */
    void row();

    /**
     * Creates new row in the spreadsheet.
     * @param rowDefinition closure defining the content of the row
     */
    void row(@DelegatesTo(TableRowDefinition.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.TableRowDefinition") Closure rowDefinition);

    /**
     * Creates new row in the spreadsheet.
     * @param row row number (1 based - the same as is shown in the file)
     * @param rowDefinition closure defining the content of the row
     */
    void row(int row, @DelegatesTo(TableRowDefinition.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.TableRowDefinition") Closure rowDefinition);


}
