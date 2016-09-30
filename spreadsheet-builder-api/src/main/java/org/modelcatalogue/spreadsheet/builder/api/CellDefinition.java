package org.modelcatalogue.spreadsheet.builder.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;
import org.modelcatalogue.spreadsheet.api.Keywords;

public interface CellDefinition extends HasStyle, TableCellDefinition {

    void name(String name);
    void formula(String formula);
    void comment(String comment);
    void comment(@DelegatesTo(CommentDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CommentDefinition") Closure commentDefinition);

    LinkDefinition link(Keywords.To to);

    void colspan(int span);
    void rowspan(int span);

    /**
     * Sets the width as multiplier of standard character width.
     *
     * The width applies on the whole column.
     *
     * @param width the width as multiplier of standard character width
     */
    void width(double width);

    /**
     * Sets the height of the cell in points (multiples of 20 twips).
     *
     * The height applies on the whole row.
     *
     * @param height the height of the cell in points (multiples of 20 twips)
     */
    void height(double height);

    /**
     * Sets that the current column should have automatic width.
     * @param auto keyword
     */
    void width(Keywords.Auto auto);

    Keywords.Auto getAuto();
    Keywords.To getTo();

    /**
     * Add a new text run to the cell.
     *
     * This method can be called multiple times. The value of the cell will be result of appending all the text
     * values supplied.
     *
     * @param text new text run
     */
    void text(String text);

    /**
     * Add a new text run to the cell.
     *
     * This method can be called multiple times. The value of the cell will be result of appending all the text
     * values supplied.
     *
     * @param text new text run
     */
    void text(String text, @DelegatesTo(FontDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.FontDefinition") Closure fontConfiguration);

    ImageCreator png(Keywords.Image image);
    ImageCreator jpeg(Keywords.Image image);
    ImageCreator pict(Keywords.Image image);
    ImageCreator emf(Keywords.Image image);
    ImageCreator wmf(Keywords.Image image);
    ImageCreator dib(Keywords.Image image);

    Keywords.Image getImage();

}
