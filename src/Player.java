
public abstract class Player {
    public boolean whiteSide;
    public boolean humanPlayer;

    public boolean isWhiteSide()
    {
        return this.whiteSide;
    }
    public boolean isHumanPlayer()
    {
        return this.humanPlayer;
    }
}

public class HumanPlayer extends Player {

    public HumanPlayer(boolean whiteSide)
    {
        this.whiteSide = whiteSide;
        this.humanPlayer = true;
    }
}

public class ComputerPlayer extends Player {

    public ComputerPlayer(boolean whiteSide)
    {
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
    }
} 