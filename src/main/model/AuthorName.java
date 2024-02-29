package model;

import org.json.JSONObject;

public abstract class AuthorName extends CitationComponent {
    protected String firstName;
    protected String middleName;
    protected String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AuthorName() {
        super();
    }

    // Requires: rawString contains more than just space
    // EFFECTS: process the given name, delimited by space, into a format according to the citation
    protected abstract void processName(String rawString);

    //EFFECTS: returns a JSONObject representation of the AuthorName;
    //         stores head, tail, mode, firstName, middleName, and lastName
    @Override
    public JSONObject asJson() {
        JSONObject out = new JSONObject();
        out.put("head", getHead());
        out.put("tail", getTail());
        out.put("mode", getMode());
        out.put("firstName", firstName);
        out.put("middleName", middleName);
        out.put("lastName", lastName);
        return out;
    }
}
