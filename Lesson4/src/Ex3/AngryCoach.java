package Ex3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AngryCoach implements PropertyChangeListener
{
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        String propertyName = evt.getPropertyName();
        if(propertyName.equals("DreamTeamScore"))
        {
            System.out.println("Angry coach: Yeaaah!");
        }
        else if(propertyName.equals("OldBoysRoughTackle"))
        {
            System.out.println("Hey, stupid referee give them yellow card!!!");
        }
    }
}
