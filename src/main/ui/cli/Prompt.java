package ui.cli;


import model.IsSatisfiable;

import java.util.Scanner;

/*
 * represents a question that the programs asks for getting information */
public class Prompt {
    public static final int REPEAT_ON_FAIL = 0;
    public static final int NULL_ON_FAIL = 1;
    public static final int FALSE_STRING_ON_FAIL = 2;
    private final IsSatisfiable criteria;
    private final int strategyOnFail;
    private final String question;

    // constructor for Prompt
    // EFFECTS: creates a prompt with the given Question, exit sequence and strategy if user input fails
    public Prompt(String question, int strategy, IsSatisfiable criteria) {
        this.question = question;
        this.strategyOnFail = strategy;
        this.criteria = criteria;
    }

    public int getStrategyOnFail() {
        return strategyOnFail;
    }

    public String getQuestion() {
        return question;
    }

    // MODIFIES: this
    // EFFECTS: returns user inputted answer if it satisfies the Criteria,
    //          otherwise follow the strategy;
    public String ask() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(question);
            String answer = scanner.nextLine().trim();
            if (criteria.isSatisfiedBy(answer)) {
                return answer;
            } else if (strategyOnFail == NULL_ON_FAIL) {
                System.out.println("\nInvalid Input! Skipping!");
                return null;
            } else if (strategyOnFail == FALSE_STRING_ON_FAIL) {
                System.out.println("\nInvalid Input! Skipping!");
                return "false";
            }
            System.out.println("\nInvalid Input! Please try again!");
        }
    }

}
