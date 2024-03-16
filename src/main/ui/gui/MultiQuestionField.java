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
        this(1, questionFields.length);
        for (QuestionField field : questionFields) {
            add(field);
        }
    }

    // EFFECTS: returns joined String values of children, if they are a questionField,
    //          by comma.
    @Override
    protected String stringValue() {
        return String.join(",", getStringListVal());
    }

    // EFFECTS: returns the joined list of getStringListVal() of MultiQuestionField children
    //                  falls back String values of children, if they are a questionField
    //                  ignores other children
    public List<String> getStringListVal() {
        List<String> out = new LinkedList<>();
        for (Component field : getComponents()) {
            if (field instanceof MultiQuestionField) {
                MultiQuestionField multiQuestionField = (MultiQuestionField) field;
                out.addAll(multiQuestionField.getStringListVal());
            } else if (field instanceof QuestionField) {
                QuestionField questionField = (QuestionField) field;
                out.add(questionField.getStringVal());
            }
        }
        return out;
    }
}
