package ui.gui;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// represent a field with multiple Questions
public class MultiQuestionField extends QuestionField {

    // constructor
    // EFFECTS: creates a multi question field with a given dimension(and therefore a set number of allowed components);
    public MultiQuestionField(int rows, int columns) {
        super(rows, columns);
    }

    // alt. constructor
    // EFFECTS: creates a multi question field such that it can store multiple questions in an Area;
    public MultiQuestionField(QuestionField[] questionFields) {
        super(questionFields.length, 1);
        for (QuestionField field : questionFields) {
            add(field);
        }
    }

    // EFFECTS: returns joined String values of children, if they are a questionField,
    //          by semicolon.
    @Override
    protected String stringValue() {
        return String.join(";", getStringListVal());
    }

    // EFFECTS: returns String values of children, if they are a questionField
    public List<String> getStringListVal() {
        List<String> out = new LinkedList<>();
        for (Component child : children) {
            if (child instanceof QuestionField && !((QuestionField) child).getStringVal().isEmpty()) {
                out.add(((QuestionField) child).getStringVal());
            }
        }
        return out;
    }
}
