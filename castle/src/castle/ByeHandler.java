package castle;

public class ByeHandler extends Handler {

    public ByeHandler(Game game) {
        super(game);
    }
    @Override
    public boolean exit() {
        return true;
    }
}
