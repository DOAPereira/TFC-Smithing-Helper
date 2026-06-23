package calculator;

import java.util.List;

public interface Calculator {
    List<Action> getActionList(int targetValue, List<Action> finalActions);
}