package console;

import action.calculator.Action;
import action.calculator.ActionCalculator;
import action.calculator.StandardActionCalculator;

import java.util.List;

public class ConsoleOutput {
    public void greetUser() {
        System.out.println("Welcome dear user! I'm in charge of helping you perfectly smith your tools!");
    }

    public void requestTargetValue() {
        System.out.println("Please write down the target value of the tool. You'll need the better smithing texture pack for this");
    }

    public void requestFinalActions() {
        System.out.println("Thank you! Now I just need the final actions of the smithing process.");
        System.out.println("Send the final actions in the same order in which you see them in TFC.");
        System.out.println("If, let's say, 'Bend' is last, send it first.");
        System.out.println("The actions you can send are the following:");
        System.out.println("""
                Light Hit
                Medium Hit
                Hard Hit
                Any Hit
                Draw
                Punch
                Bend
                Upset
                Shrink""");
        System.out.println("Note that the action you send must be spelled exactly the same as the action in the list above.");
        System.out.println("Please input the amount of finishing actions the process has first.");
    }

    public void confirmAdditionOfAction() {
        System.out.println("Action added to the list!");
    }

    public void showActionSequence(int targetValue, List<Action> finalActions) {
        System.out.println("Perform the actions in the exact same order as shown below.");

        ActionCalculator actionCalculator = new StandardActionCalculator();
        List<Action> actions = actionCalculator.getActionSequenceList(targetValue, finalActions);
        for (Action action : actions) System.out.println(action);
    }

    public void endOfOutput() {
        System.out.println("Are you ready to smith another tool? If so, type 'Restart'!");
        System.out.println("If you wish to stop, type 'Stop'!");
        System.out.println("Either way, thank you for choosing me as your assistant today.");
    }
}