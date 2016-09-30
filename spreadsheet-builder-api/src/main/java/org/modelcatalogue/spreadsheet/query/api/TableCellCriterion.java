package org.modelcatalogue.spreadsheet.query.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FromString;
import org.modelcatalogue.spreadsheet.api.Comment;

import java.util.Date;

public interface TableCellCriterion {

    void date(Date value);
    void date(Predicate<Date> predicate);

    void number(Double value);
    void number(Predicate<Double> predicate);

    void string(String value);
    void string(Predicate<String> predicate);

    void value(Object value);
    void bool(Boolean value);

    void or(@DelegatesTo(TableCellCriterion.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.query.api.TableCellCriterion") Closure sheetCriterion);

}
