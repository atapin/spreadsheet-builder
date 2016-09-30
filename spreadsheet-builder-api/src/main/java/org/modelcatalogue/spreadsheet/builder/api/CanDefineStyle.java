package org.modelcatalogue.spreadsheet.builder.api;

public interface CanDefineStyle {
    /**
     * Declare a named style.
     * @param name name of the style
     * @param styleDefinition definition of the style
     */
    void style(String name, Builder<CellStyleDefinition> styleDefinition);

    void apply(Class<? extends Stylesheet> stylesheet);
    void apply(Stylesheet stylesheet);
}
