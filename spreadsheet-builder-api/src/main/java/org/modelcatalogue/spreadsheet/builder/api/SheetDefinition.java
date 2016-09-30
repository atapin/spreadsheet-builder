package org.modelcatalogue.spreadsheet.builder.api;


public interface SheetDefinition extends TableDefinition<RowDefinition>, CanDefineGroups<SheetDefinition> {

    /**
     * Freeze some column or row or both.
     * @param column last freeze column
     * @param row last freeze row
     */
    void freeze(int column, int row);

    /**
     * Freeze some column or row or both.
     * @param column last freeze column
     * @param row last freeze row
     */
    void freeze(String column, int row);

    Object getLocked();

    void password(String password);

}
