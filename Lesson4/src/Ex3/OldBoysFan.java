package Ex3;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFan implements PropertyChangeListener
{
    public void onReact(String propertyName)
    {
        if (propertyName.equals("DreamTeamScore")) {
            System.out.println("Old Boys fans: BOOOO!");
        } else if (propertyName.equals("OldBoysScore")) {
            System.out.println("Old Boys fans: YEEEAAH!");
        } else if (propertyName.equals("OldBoysRoughTackle")) {
            System.out.println("Old Boys fans: BOOOO!");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        String propertyName = evt.getPropertyName();
        onReact(propertyName);
    }
}
