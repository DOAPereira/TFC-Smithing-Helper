package calculator;

import java.util.List;

public interface Calculator {
    List<Action> getActionSequenceList(int targetValue, List<Action> finalActions);
}