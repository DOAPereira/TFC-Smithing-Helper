package action.calculator;

public class AnyHit implements Action {
    @Override
    public int getVALUE() {
        return -3;
        //The algorithm will always choose -3 as the best possible option, so might as well have AnyHit default to that.
        //There are two or more edge cases where this results in a less than optimal result,
        //but the time spent covering this is not worth it.
    }

    @Override
    public String toString() {
        return "Lightly hit the metal.";
    }
}
