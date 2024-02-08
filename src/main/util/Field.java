package util;

/*
 * Represents a Field to be filled of information.
 */
public class Field<T> {
    private T info;
    private String name;
    private String toStringTemplate;
    private boolean optional;

    // constructs a field
    // EFFECT: Field is created with the given name and given template;
    public Field(String name, String toStringTemplate, boolean optional) {
        this.setName(name);
        this.setToStringTemplate(toStringTemplate);
        this.setInfo(null);
        this.setOptional(optional);
    }

    // getter for optional
    public boolean isOptional() {
        return optional;
    }

    // setter for optional
    // MODIFIES: this
    // EFFECTS: sets optional to the given boolean
    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    // getter for info
    public T getInfo() {
        return this.info;
    }

    // setter for info
    // MODIFIES: this
    // EFFECTS: change info to the given info;
    public void setInfo(T info) {
        this.info = info;
    }

    // getter for name
    public String getName() {
        return this.name;
    }

    // setter for name
    // MODIFIES: this
    // EFFECTS: change name to the given name;
    public void setName(String name) {
        this.name = name;
    }

    // getter for the template
    public String getToStringTemplate() {
        return this.toStringTemplate;
    }

    // setter for the template
    // MODIFIES: this
    // EFFECTS: change the template of the given Template
    public void setToStringTemplate(String template) {
        this.toStringTemplate = template;
    }

    // Requires: toStringTemplate has 2 % formatters
    // EFFECTS: Outputs the name and the data, formatted with the template. returns an empty String if info is null
    @Override
    public String toString() {
        if (getInfo() != null) {
            return String.format(toStringTemplate, name, getInfo());
        }
        return "";
    }
}
