package ui.gui;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

// represent a field with multiple Questions
public class MultiQuestionField extends QuestionField {
    protected LinkedList<QuestionField> questionFields;

    // constructor
    // EFFECTS: creates a multi question field with a given dimension(and therefore a set number of allowed components);
    public MultiQuestionField(int rows, int columns) {
        super(rows, columns);
        questionFields = new LinkedList<>();
    }

    // alt. constructor
    // EFFECTS: creates a multi question field such that it can store multiple questions in an Area;
    public MultiQuestionField(QuestionField[] questionFields) {
        this(1, questionFields.length);
        for (QuestionField field : questionFields) {
            this.questionFields.add(field);
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
        for (QuestionField field : questionFields) {
            if (!field.getStringVal().isEmpty()) {
                out.add(field.getStringVal());
            }
        }
        return out;
    }
}
