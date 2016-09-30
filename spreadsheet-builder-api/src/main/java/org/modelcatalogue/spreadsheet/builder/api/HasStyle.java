package org.modelcatalogue.spreadsheet.builder.api;

public interface HasStyle {

    /**
     * Applies a customized named style to the current element.
     *
     * @param name the name of the style
     * @param styleDefinition the definition of the style customizing the predefined style
     */
    void style(String name, Builder<CellStyleDefinition> styleDefinition);

    /**
     * Applies the style defined by the closure to the current element.
     * @param styleDefinition the definition of the style
     */
    void style(Builder<CellStyleDefinition> styleDefinition);

    /**
     * Applies the named style to the current element.
     *
     * The style can be changed no longer.
     *
     * @param name the name of the style
     */
    void style(String name);

    /**
     * Applies the named style to the current element.
     *
     * The style can be changed no longer.
     *
     * @param names style names to be applied
     */
    void styles(String... names);
    /**
     * Applies the named style to the current element.
     *
     * The style can be changed no longer.
     *
     * @param names style names to be applied
     */
    void styles(Iterable<String> names);
}
