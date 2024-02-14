package com.timeboost.assignments.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class ChatGPTCommunicationServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ChatGPTCommunicationService service;

    @Test
    public void testSendRequestToChatGPT() {
        // Given
        String prompt = "Test prompt";

        // When
        //String result = service.sendRequestToChatGPT(prompt);

       // System.out.println(result);

        // Then
       // verify(restTemplate, times(1)).exchange(anyString(), any(), any(), eq(String.class));
    }
}