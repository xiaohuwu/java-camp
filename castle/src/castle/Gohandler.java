package castle;

public class Gohandler extends Handler {

    public Gohandler(Game game) {
        super(game);
    }
    @Override
    public void Cmd(String direction) {
        game.goRoom(direction);
    }
}
