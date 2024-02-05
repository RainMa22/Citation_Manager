package model;

import java.util.List;

/*
 * An interface that represent a citable object, capable of converting filled-in
 * Field information in a citation String.
 */
public interface Citable {
    //getter for all the fields required for Citation
    List<Field<?>> getFields();

    // EFFECTS: returns true if all non-optional fields are defined, false otherwise
    boolean isValid();

    // REQUIRE: Citable.isValid()
    // EFFECTS: Condense all the Fields into a valid citation string and outputs it.
    String cite();
}
