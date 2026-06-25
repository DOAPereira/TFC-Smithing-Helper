package action.calculator;

public class ActionBuilder {
    public Action getAction(String action) {
        return switch (action) {
            case "light lit" -> new LightHit();
            case "medium hit" -> new MediumHit();
            case "hard hit" -> new HardHit();
            case "any hit" -> new AnyHit();
            case "draw" -> new Draw();
            case "punch" -> new Punch();
            case "bend" -> new Bend();
            case "upset" -> new Upset();
            case "shrink" -> new Shrink();
            default -> null;
        };
    }
}