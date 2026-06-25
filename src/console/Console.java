package console;

import action.calculator.Action;

import java.util.ArrayList;
import java.util.List;

public class Console {
    private static final ConsoleInput INPUT = new ConsoleInput();
    private static final ConsoleOutput OUTPUT = new ConsoleOutput();

    public static void start() {
        boolean continueLoop = true;

        while (continueLoop) continueLoop = loopLogic();
    }

    private static boolean loopLogic() {
        OUTPUT.greetUser();
        OUTPUT.requestTargetValue();

        int targetValue = INPUT.requestTargetValue();

        OUTPUT.requestFinalActions();
        int actionAmount = INPUT.requestActionAmount();
        List<Action> actions = new ArrayList<>();
        INPUT.skipLine();

        while (actions.size() < actionAmount) actions.add(INPUT.requestFinalAction());

        OUTPUT.showActionSequence(targetValue, actions);
        OUTPUT.endOfOutput();

        return INPUT.requestContinuation();
    }
}