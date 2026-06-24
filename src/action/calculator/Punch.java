package action.calculator;

public class Punch implements Action {
    @Override
    public int getVALUE() {
        return 2;
    }

    @Override
    public String toString() {
        return "Punch the metal (not with your bare hands).";
    }
}