package action.calculator;

public class MediumHit implements Action {
    @Override
    public int getVALUE() {
        return -6;
    }

    @Override
    public String toString() {
        return "Hit the metal with medium force.";
    }
}