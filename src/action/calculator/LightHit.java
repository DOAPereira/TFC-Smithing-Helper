package action.calculator;

public class LightHit implements Action {
    @Override
    public int getVALUE() {
        return -3;
    }

    @Override
    public String toString() {
        return "Lightly hit the metal.";
    }
}