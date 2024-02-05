package model.mla;

import model.AuthorName;
import model.Citable;
import model.Field;

import java.util.ArrayList;
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
        fields.add(new Field<AuthorName>("Author Full Name(s)", "%2$s", false));
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
