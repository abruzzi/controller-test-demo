package geo.web.controllers;

import geo.web.model.Event;
import geo.web.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EventController {
    @Autowired
    private EventService eventService;

    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public @ResponseBody List<Event> get(ModelMap modelMap) {
        return eventService.events();
    }

}
