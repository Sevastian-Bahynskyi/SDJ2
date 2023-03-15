package Ex3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScoreBoard implements PropertyChangeListener
{
    private int dreamTeamScore;
    private int oldBoysScore;
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        String propertyName = evt.getPropertyName();
        if(propertyName.equals("DreamTeamScore"))
        {
            System.err.println("Score: \nDream team - " + ++dreamTeamScore + "\nOld Boys - " + oldBoysScore + '\n');
        }
        else if(propertyName.equals("OldBoysScore"))
        {
            System.err.println("Score: \nDream team - " + dreamTeamScore + "\nOld Boys - " + ++oldBoysScore + '\n');
        }
    }
}
