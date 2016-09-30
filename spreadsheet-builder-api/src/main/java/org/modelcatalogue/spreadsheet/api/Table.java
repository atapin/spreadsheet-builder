package org.modelcatalogue.spreadsheet.api;

import java.util.Collection;

public interface Table<RowType> {
    Collection<RowType> getRows();
}
