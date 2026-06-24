package action.calculator;

import java.util.List;

public interface ActionCalculator {
    List<Action> getActionSequenceList(int targetValue, List<Action> finalActions);
}