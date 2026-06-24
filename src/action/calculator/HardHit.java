package action.calculator;

public class HardHit implements Action {
    @Override
    public int getVALUE() {
        return -9;
    }

    @Override
    public String toString() {
        return "Hit the metal hard.";
    }
}