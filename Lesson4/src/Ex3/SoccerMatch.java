package Ex3;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch
{
    private PropertyChangeSupport support;
    private int DreamTeamScore;
    private int OldBoysScore;
    private int DreamTeamRoughTackle;
    private int OldBoysRoughTackle;

    private String team0 = "Dream Team";
    private String team1 = "Old Boys";

    public SoccerMatch()
    {
        support = new PropertyChangeSupport(this);
        OldBoysScore = 0;
        OldBoysRoughTackle = 0;
        DreamTeamScore = 0;
        DreamTeamRoughTackle = 0;
    }

    public void startMatch() {
        System.out.println("Match starting \n\n");
        Random random = new Random();
        for(int i = 0; i < 90; i++) {

            int rand = random.nextInt(100);
            int whichTeam = random.nextInt(2);

            if(rand < 8) {
                // score goal
                scoreGoal(whichTeam);
            } else if(rand < 12) {
                // penalty
                roughTackle(whichTeam);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }

        System.out.println("\n\nMatch ended");
    }

    private void roughTackle(int whichTeam) {
        if(whichTeam == 0) {
            int temp = DreamTeamRoughTackle;
            DreamTeamRoughTackle++;
            support.firePropertyChange("DreamTeamRoughTackle", temp, DreamTeamRoughTackle);
            // TODO team0 made a rough tackle
        } else {
            int temp = OldBoysRoughTackle;
            OldBoysRoughTackle++;
            support.firePropertyChange("OldBoysRoughTackle", temp, OldBoysRoughTackle);
            // TODO team1 made a rough tackle
        }
    }

    private void scoreGoal(int whichTeam) {
        if(whichTeam == 0) {
            int temp = DreamTeamScore;
            DreamTeamScore++;
            support.firePropertyChange("DreamTeamScore", temp, DreamTeamScore);
            // TODO team0 scored
        } else {
            int temp = OldBoysScore;
            OldBoysScore++;
            support.firePropertyChange("OldBoysScore", temp, OldBoysScore);
            // TODO team1 scored
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }
}
