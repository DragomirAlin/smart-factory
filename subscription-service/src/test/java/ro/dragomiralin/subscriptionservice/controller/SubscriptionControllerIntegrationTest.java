package ro.dragomiralin.subscriptionservice.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;
import ro.dragomiralin.subscriptionservice.BaseIntegrationTest;
import ro.dragomiralin.subscriptionservice.dto.SubscriptionDTO;
import ro.dragomiralin.subscriptionservice.repository.SubscriptionRepository;
import ro.dragomiralin.subscriptionservice.util.JsonUtil;
import ro.dragomiralin.subscriptionservice.util.TestDataUtil;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class SubscriptionControllerIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @AfterEach
    @DisplayName("Clean up")
    void cleanUp() {
        subscriptionRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = "USER")
    @DisplayName("When create subscription successfully")
    public void testWhenCreateSubscriptionSuccesfully() throws Exception {
        mockMvc.perform(post("/api/v1/subscriptions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.asJsonString(TestDataUtil.givenSubscriptionDTO()))
                        .with(csrf().asHeader()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }
}