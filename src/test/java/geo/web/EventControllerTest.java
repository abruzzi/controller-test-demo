package geo.web;

import geo.web.controllers.EventController;
import geo.web.model.Event;
import geo.web.services.EventService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.server.MockMvc;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.server.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.server.setup.MockMvcBuilders.standaloneSetup;

public class EventControllerTest {
    private EventController controller;
    private MockMvc mockMvc;

    private EventService eventService;

    @Before
    public void setup(){
        eventService = mock(EventService.class);
        controller = new EventController();

        controller.setEventService(eventService);

        mockMvc = standaloneSetup(controller).build();
    }

    @Test
    public void shouldReturnEventsList() throws Exception {
        List<Event> expected = asList(new Event("NAME", "TYPE"));
        when(eventService.events()).thenReturn(expected);

        mockMvc.perform(get("/events"))
                .andExpect(status().isOk())
                .andExpect(content().type("application/json;charset=UTF-8"))
                .andExpect(content().string("[{\"name\":\"NAME\",\"type\":\"TYPE\"}]"));
    }
}
