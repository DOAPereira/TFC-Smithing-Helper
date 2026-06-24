package action.calculator;

public class Shrink implements Action {
    @Override
    public int getVALUE() {
        return 16;
    }

    @Override
    public String toString() {
        return "Shrink the metal.";
    }
}