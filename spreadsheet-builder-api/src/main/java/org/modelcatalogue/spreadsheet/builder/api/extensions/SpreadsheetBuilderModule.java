package org.modelcatalogue.spreadsheet.builder.api.extensions;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.FirstParam;
import groovy.transform.stc.FromString;
import org.modelcatalogue.spreadsheet.api.Keywords;
import org.modelcatalogue.spreadsheet.builder.api.*;

public class SpreadsheetBuilderModule {

    private static class ClosureBuilder<D> implements Builder<D> {

        private final Closure closure;

        private ClosureBuilder(Closure closure) {
            this.closure = (Closure) closure.clone();
        }

        @Override
        public void configure(D definition) {
            closure.setDelegate(definition);
            closure.setResolveStrategy(Closure.DELEGATE_FIRST);
            closure.call(definition);
        }
    }

    public static <D> void group(@DelegatesTo.Target CanDefineGroups<D> self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, genericTypeIndex = 0) @ClosureParams(value= FirstParam.FirstGenericType.class) Closure insideGroupDefinition) {
        self.group(new ClosureBuilder<D>(insideGroupDefinition));
    }

    public static <D> void collapse(@DelegatesTo.Target("self") CanDefineGroups<D> self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, target = "self", genericTypeIndex = 0) @ClosureParams(value= FirstParam.FirstGenericType.class) Closure insideGroupDefinition) {
        self.collapse(new ClosureBuilder<D>(insideGroupDefinition));
    }

    public static <D> void cell(@DelegatesTo.Target("self") TableRowDefinition<D> self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, target = "self", genericTypeIndex = 0) @ClosureParams(value= FirstParam.FirstGenericType.class) final Closure cellDefinition) {
        self.cell(new ClosureBuilder<D>(cellDefinition));
    }

    public static <D> void cell(@DelegatesTo.Target("self") TableRowDefinition<D> self, int column, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, target = "self", genericTypeIndex = 0) @ClosureParams(value= FirstParam.FirstGenericType.class) final Closure cellDefinition) {
        self.cell(column, new ClosureBuilder<D>(cellDefinition));
    }

    public static <D> void cell(@DelegatesTo.Target("self") TableRowDefinition<D> self, String column, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, target = "self", genericTypeIndex = 0) @ClosureParams(value= FirstParam.FirstGenericType.class) final Closure cellDefinition) {
        self.cell(column, new ClosureBuilder<D>(cellDefinition));
    }

    public static void comment(CellDefinition self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = CommentDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CommentDefinition") Closure commentDefinition) {
        self.comment(new ClosureBuilder<CommentDefinition>(commentDefinition));
    }

    public static void text(CellDefinition self, String text, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = FontDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.FontDefinition") Closure fontConfiguration) {
         self.text(text, new ClosureBuilder<FontDefinition>(fontConfiguration));
    }

    public static void style(CanDefineStyle stylable, String name, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = CellStyleDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CellStyleDefinition") Closure styleDefinition) {
        stylable.style(name, new ClosureBuilder<CellStyleDefinition>(styleDefinition));
    }

    public static void sheet(WorkbookDefinition self, String name, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = SheetDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.SheetDefinition") Closure sheetDefinition) {
        self.sheet(name, new ClosureBuilder<SheetDefinition>(sheetDefinition));
    }

    public static void style(HasStyle self, String name, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = CellStyleDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CellStyleDefinition") Closure styleDefinition) {
        self.style(name, new ClosureBuilder<CellStyleDefinition>(styleDefinition));
    }

    public static void style(HasStyle self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = CellStyleDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.CellStyleDefinition") Closure styleDefinition) {
        self.style(new ClosureBuilder<CellStyleDefinition>(styleDefinition));
    }

    public static void font(CellStyleDefinition self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = FontDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.FontDefinition") Closure fontConfiguration) {
        self.font(new ClosureBuilder<FontDefinition>(fontConfiguration));
    }

    public static void border(CellStyleDefinition self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = BorderDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.BorderDefinition") Closure borderConfiguration) {
        self.border(new ClosureBuilder<BorderDefinition>(borderConfiguration));
    }

    public static void border(CellStyleDefinition self, Keywords.BorderSide location, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = BorderDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.BorderDefinition") Closure borderConfiguration) {
        self.border(location, new ClosureBuilder<BorderDefinition>(borderConfiguration));
    }

    public static void border(CellStyleDefinition self, Keywords.BorderSide first, Keywords.BorderSide second, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = BorderDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.BorderDefinition") Closure borderConfiguration) {
        self.border(first, second, new ClosureBuilder<BorderDefinition>(borderConfiguration));
    }

    public static void border(CellStyleDefinition self, Keywords.BorderSide first, Keywords.BorderSide second, Keywords.BorderSide third, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = BorderDefinition.class) @ClosureParams(value=FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.BorderDefinition") Closure borderConfiguration) {
        self.border(first, second, third, new ClosureBuilder<BorderDefinition>(borderConfiguration));
    }

    public static <D> void row(@DelegatesTo.Target("self") TableDefinition<D> self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, target = "self", genericTypeIndex = 0) @ClosureParams(value= FirstParam.FirstGenericType.class)  Closure rowDefinition) {
        self.row(new ClosureBuilder<D>(rowDefinition));
    }

    public static <D> void row(@DelegatesTo.Target("self") TableDefinition<D> self, int row, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, target = "self", genericTypeIndex = 0) @ClosureParams(value= FirstParam.FirstGenericType.class) Closure rowDefinition) {
        self.row(row, new ClosureBuilder<D>(rowDefinition));
    }

    public static SpreadsheetDefinition build(SpreadsheetBuilder self, @DelegatesTo(strategy = Closure.DELEGATE_FIRST, value = WorkbookDefinition.class) @ClosureParams(value = FromString.class, options = "org.modelcatalogue.spreadsheet.builder.api.WorkbookDefinition") Closure workbookDefinition) {
        return self.build(new ClosureBuilder<WorkbookDefinition>(workbookDefinition));
    }

    public static void foo(SpreadsheetBuilder self) {
        System.out.print("Hello World!");
    }


}
