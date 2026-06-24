package action.calculator;

public class Draw implements Action {
    @Override
    public int getVALUE() {
        return -15;
    }

    @Override
    public String toString() {
        return "Draw air from the metal. I think.";
    }
}