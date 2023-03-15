package Ex3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFan implements PropertyChangeListener
{
    public void onReact(String propertyName)
    {
        if (propertyName.equals("DreamTeamScore")) {
            System.out.println("Dream team fans: YEEEAAH!");
        } else if (propertyName.equals("OldBoysScore")) {
            System.out.println("Dream team fans: BOOOO!");
        } else if (propertyName.equals("DreamTeamRoughTackle")) {
            System.out.println("Dream team fans: BOOOO!");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        String propertyName = evt.getPropertyName();
        onReact(propertyName);
    }
}
