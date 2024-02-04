package model;

/*
 * Represents a Field to be filled of information.
 */
public class Field<T> {
    private T info;
    private String name;
    private String toStringTemplate;

    // constructs a field
    // EFFECT: Field is created with the given name and given template;
    public Field(String name, String toStringTemplate) {
        this.name = name;
        this.toStringTemplate = toStringTemplate;
        info = null;
    }

    // constructs a field
    // EFFECT: Field is created with the given name and "" as its template;
    public Field(String name) {
        this(name, "");
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
    // EFFECTS: Outputs the name and the data, formatted with the template. returns null if info is null
    @Override
    public String toString() {
        if (info != null) {
            return String.format(toStringTemplate, name, info);
        }
        return null;
    }
}
