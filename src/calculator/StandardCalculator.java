package calculator;

import java.util.ArrayList;
import java.util.List;

public class StandardCalculator implements Calculator {
    private final Action[] POSITIVE_ACTIONS = {new Punch(), new Bend(), new Upset(), new Shrink()};
    private final Action[] NEGATIVE_ACTIONS = {new LightHit(), new MediumHit(), new HardHit(), new Draw()};
    private final List<Action> ACTION_LIST = new ArrayList<>();

    @Override
    public List<Action> getActionList(int targetValue, List<Action> finalActions) {
        int adjustedTargetValue = getAdjustedTargetValue(targetValue, finalActions);
        calculateActions(adjustedTargetValue, adjustedTargetValue, List.of(POSITIVE_ACTIONS));
        addActions(finalActions);
        return ACTION_LIST;
    }

    private void calculateActions(int combinedValue, int target, List<Action> actions) {
        if (target == 0) return;

        Action bestAction = getBestAction(target, actions);
        double repetitions = (double) target / bestAction.getVALUE();

        addRepeatedAction(repetitions, bestAction);

        if (repetitions != 1) {
            int nextTarget = combinedValue - getCombinedValue(ACTION_LIST);
            List<Action> nextActions = List.of((nextTarget > 0) ? POSITIVE_ACTIONS : NEGATIVE_ACTIONS);
            calculateActions(combinedValue, nextTarget, nextActions);
        }
    }

    private void addRepeatedAction(double amount, Action action) {
        int limiter = (int) ((amount > 1) ? Math.floor(amount) : Math.ceil(amount));
        for (int i = 0; i < limiter; i++) {
            ACTION_LIST.add(action);
        }
    }

    private void addActions(List<Action> actions) {
        ACTION_LIST.addAll(actions);
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

    private int getCombinedValue(List<Action> actions) {
        int combinedValue = 0;
        for (Action action : actions) combinedValue += action.getVALUE();
        return combinedValue;
    }
}