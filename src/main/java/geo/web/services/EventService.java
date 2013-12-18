package geo.web.services;

import geo.web.model.Event;

import java.util.ArrayList;
import java.util.List;

public class EventService {
    public List<Event> events() {
        List<Event> events = new ArrayList<Event>();

        Event eventCallDrop = new Event("CallDrop", "call-drop");
        Event eventCallFailure = new Event("CallFailure", "call-failure");

        events.add(eventCallDrop);
        events.add(eventCallFailure);

        return events;
    }
}
