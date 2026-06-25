package console;

import action.calculator.Action;
import action.calculator.ActionBuilder;

import java.util.Scanner;

public class ConsoleInput {
    Scanner inputScanner = new Scanner(System.in);
    ActionBuilder actionBuilder = new ActionBuilder();

    public int requestTargetValue() {
        return inputScanner.nextInt();
    }

    public int requestActionAmount() {
        return inputScanner.nextInt();
    }

    public Action requestFinalAction() {
        return actionBuilder.getAction(inputScanner.nextLine().toLowerCase());
    }

    public boolean requestContinuation() {
        String decision = inputScanner.nextLine();

        return decision.equals("Restart");
    }

    public void skipLine() {
        inputScanner.nextLine();
    }
}