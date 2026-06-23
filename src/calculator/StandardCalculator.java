package calculator;

import java.util.ArrayList;
import java.util.List;

public class StandardCalculator implements Calculator {
    private final Action[] POSITIVE_ACTIONS = {new Punch(), new Bend(), new Upset(), new Shrink()};
    private final Action[] NEGATIVE_ACTIONS = {new LightHit(), new MediumHit(), new HardHit(), new Draw()};
    private final List<Action> ACTION_SEQUENCE_LIST = new ArrayList<>();

    @Override
    public List<Action> getActionSequenceList(int targetValue, List<Action> finalActions) {
        int adjustedTargetValue = getAdjustedTargetValue(targetValue, finalActions);
        addActionSequence(adjustedTargetValue, adjustedTargetValue, List.of(POSITIVE_ACTIONS));
        addFinalActions(finalActions);
        return ACTION_SEQUENCE_LIST;
    }

    private void addActionSequence(int targetValue, int difference, List<Action> actionPool) {
        if (difference == 0) return;

        Action bestAction = getBestAction(difference, actionPool);
        double repetitions = (double) difference / bestAction.getVALUE();

        addRepeatedAction(repetitions, bestAction);

        if (repetitions != 1) {
            int nextDifference = targetValue - getCurrentValue(ACTION_SEQUENCE_LIST);
            List<Action> nextActionPool = List.of((nextDifference > 0) ? POSITIVE_ACTIONS : NEGATIVE_ACTIONS);
            addActionSequence(targetValue, nextDifference, nextActionPool);
        }
    }

    private void addRepeatedAction(double amount, Action action) {
        int limiter = (int) ((amount > 1) ? Math.floor(amount) : Math.ceil(amount));
        for (int i = 0; i < limiter; i++) ACTION_SEQUENCE_LIST.add(action);
    }

    private void addFinalActions(List<Action> actions) {
        ACTION_SEQUENCE_LIST.addAll(actions);
    }

    private Action getBestAction(int target, List<Action> actions) {
        Action bestAction = null;
        double lowestValue = Double.MAX_VALUE;

        for (Action action : actions) {
            double currentValue = (double) target / action.getVALUE();
            currentValue = Math.abs(1 - currentValue);
            if (currentValue < lowestValue) {
                lowestValue = currentValue;
                bestAction = action;
            }
        }

        return bestAction;
    }

    private int getAdjustedTargetValue(int initialValue, List<Action> actions) {
        int adjustedTargetValue = initialValue;
        for (Action action : actions) adjustedTargetValue += (action.getVALUE() * -1);
        return adjustedTargetValue;
    }

    private int getCurrentValue(List<Action> actions) {
        int combinedValue = 0;
        for (Action action : actions) combinedValue += action.getVALUE();
        return combinedValue;
    }
}