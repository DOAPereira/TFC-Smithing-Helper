package action.calculator;

public class Bend implements Action {
    @Override
    public int getVALUE() {
        return 7;
    }

    @Override
    public String toString() {
        return "Bend the metal.";
    }
}