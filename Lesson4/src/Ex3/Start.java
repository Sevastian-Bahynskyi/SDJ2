package Ex3;

public class Start
{
    public static void main(String[] args) throws InterruptedException
    {
        OldBoysFan oldBoysFan = new OldBoysFan();
        DreamTeamFan dreamTeamFan = new DreamTeamFan();
        AngryCoach angryCoach = new AngryCoach();
        ScoreBoard scoreBoard = new ScoreBoard();
        Referee referee = new Referee();
        SoccerMatch soccerMatch = new SoccerMatch();
        soccerMatch.addPropertyChangeListener(scoreBoard);
        Thread.sleep(1000);
        soccerMatch.addPropertyChangeListener(angryCoach);
        soccerMatch.addPropertyChangeListener(referee);
        soccerMatch.addPropertyChangeListener(oldBoysFan);
        soccerMatch.addPropertyChangeListener(dreamTeamFan);
        soccerMatch.startMatch();
    }
}
