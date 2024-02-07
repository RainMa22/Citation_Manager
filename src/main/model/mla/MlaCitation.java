package model.mla;

import model.AuthorNameList;
import model.Citable;
import model.Field;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * A citation by MLA format
 */

public class MlaCitation implements Citable {
    List<Field<?>> fields;

    // Constructs a MlaCitation Class
    // EFFECTS: creates a MLACitation with a predefined List of fields, according to the MLA format
    public MlaCitation() {
        fields = new ArrayList<>();
        fields.add(new Field<AuthorNameList>("Author Full Name(s), delimited by comma: ",
                "%2$s", true));
        fields.add(new Field<String>("Name of Work: ", "%2$s.", false));
        fields.add(new Field<String>("Name of Collection(if applicable)(YYYY-MM-DD): ",
                "%2$s.", true));
        fields.add(new Field<Date>("Publishing Date(if accessible) ", "%2$t", true));
        fields.add(new Field<String>("Publisher/Organization(if different from Author): ",
                "%2$s.", true));
        fields.add(new Field<Date>("Access Date(Recommended)(YYYY-MM-DD) ",
                "%2$t", true));
        //...
    }

    //getter for all the fields required for Citation
    @Override
    public List<Field<?>> getFields() {
        return null;
    }

    // EFFECTS: returns true if all non-optional fields are defined, false otherwise
    @Override
    public boolean isValid() {
        return false;
    }

    // REQUIRE: Citable.isValid()
    // EFFECTS: Condense all the Fields into a valid citation string and outputs it.
    @Override
    public String cite() {
        return null;
    }
}
