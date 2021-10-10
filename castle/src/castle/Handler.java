package castle;

public class Handler {
    protected Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public void Cmd(String direction){};

    public boolean exit(){
        return false;
    }
}
