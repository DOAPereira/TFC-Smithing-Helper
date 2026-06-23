package calculator;

import java.util.List;

public interface Calculator {
    List<Action> getSequenceList(int targetValue, List<Action> finalActions);
}