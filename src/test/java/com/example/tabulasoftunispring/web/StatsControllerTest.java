package com.example.tabulasoftunispring.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
    public void testStatsAccess() throws Exception {
        //ToDo check model attributes
        mockMvc.perform(get("/stats"))
                .andExpect(status().isOk())
                .andExpect(view().name("stats/stats"))
                .andExpect(model().attributeExists("requestCount", "startedOn"));
    }

    @Test
    @WithMockUser(username = "John", roles = "USER")
    public void testStatsAccessDeniedForNormalUser() throws Exception {
        //ToDo check model attributes
        mockMvc.perform(get("/stats"))
                .andExpect(status().isForbidden());
    }
}
