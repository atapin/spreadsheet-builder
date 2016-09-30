package org.modelcatalogue.spreadsheet.query.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;
import org.modelcatalogue.spreadsheet.api.Cell;

public interface RowCriterion extends TableRowCriterion<Cell> {

    void cell(Predicate<Cell> predicate);
    void cell(Predicate<Cell> predicate, @DelegatesTo(CellCriterion.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.CellCriterion") Closure cellCriterion);
    void or(@DelegatesTo(RowCriterion.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.RowCriterion") Closure rowCriterion);

}
