package Ex3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Referee implements PropertyChangeListener
{
    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        String propertyName = evt.getPropertyName();
        if(propertyName.equals("DreamTeamRoughTackle"))
        {
            System.out.println("\nReferee gives Dream Team a yellow card for a rough tackle\n");
        }
        else if(propertyName.equals("OldBoysRoughTackle"))
        {
            System.out.println("\nReferee gives Old Boys a yellow card for a rough tackle\n");
        }
    }
}
