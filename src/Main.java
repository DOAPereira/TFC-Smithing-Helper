import calculator.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int targetValue = 93;
        List<Action> finalActions = new ArrayList<>();
        finalActions.add(new LightHit());
        finalActions.add(new LightHit());

        Calculator calculator = new StandardCalculator();
        List<Action> sequence = calculator.getActionList(targetValue, finalActions);
        for (Action action : sequence) System.out.println(action);
    }
}