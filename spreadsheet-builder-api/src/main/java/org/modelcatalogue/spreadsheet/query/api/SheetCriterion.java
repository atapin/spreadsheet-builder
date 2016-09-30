package org.modelcatalogue.spreadsheet.query.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;
import org.modelcatalogue.spreadsheet.api.Row;

public interface SheetCriterion extends TableCriterion<Row> {

    void row (@DelegatesTo(RowCriterion.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.RowCriterion") Closure rowCriterion);
    void row (int row, @DelegatesTo(RowCriterion.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.RowCriterion") Closure rowCriterion);
    void row (Predicate<Row> predicate, @DelegatesTo(RowCriterion.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.RowCriterion") Closure rowCriterion);
    void or(@DelegatesTo(SheetCriterion.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.SheetCriterion") Closure sheetCriterion);

}
