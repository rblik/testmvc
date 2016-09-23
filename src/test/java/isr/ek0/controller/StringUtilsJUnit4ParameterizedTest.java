package isr.ek0.controller;

import isr.ek0.model.User;
import isr.ek0.service.ServiceUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilsJUnit4ParameterizedTest {

    @Mock
    ServiceUser serviceUser;
    @InjectMocks
    ControllerMain controllerMain;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controllerMain).build();
    }

    @Test
    public void simpleMethod() throws Exception {
        when(serviceUser.getUserById(3)).thenReturn(new User());
        mockMvc.perform(get("/edit/form?id=3")).andExpect(status().isOk());
    }
}
