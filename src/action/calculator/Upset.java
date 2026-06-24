package action.calculator;

public class Upset implements Action {
    @Override
    public int getVALUE() {
        return 13;
    }

    @Override
    public String toString() {
        return "Upset the metal. Hurt its feelings!";
    }
}