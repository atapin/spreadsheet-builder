package org.modelcatalogue.spreadsheet.query.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;
import org.modelcatalogue.spreadsheet.api.Row;
import org.modelcatalogue.spreadsheet.api.TableRow;

public interface TableCriterion<RowType extends TableRow> {

    Predicate<RowType> number(int row);
    Predicate<RowType> range(int from, int to);

    void row(@DelegatesTo(RowCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.RowCriterion") Closure rowCriterion);
    void row(int row);
    void row(int row, @DelegatesTo(RowCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.RowCriterion") Closure rowCriterion);
    void row(Predicate<RowType> predicate, @DelegatesTo(RowCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.RowCriterion") Closure rowCriterion);
    void row(Predicate<RowType> predicate);
    void or(@DelegatesTo(TableCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.SheetCriterion") Closure sheetCriterion);
}
