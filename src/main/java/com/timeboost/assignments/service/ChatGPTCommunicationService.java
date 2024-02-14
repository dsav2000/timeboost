package com.timeboost.assignments.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class ChatGPTCommunicationService {

    private final String chatGPTApiUrl = "https://api.openai.com/v1/chat/completions"; // Replace with actual ChatGPT API URL
    //@Value("${chatgpt.apikey}")
    private String apiKey="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";

    public String sendRequestToChatGPT(String prompt) {
        RestTemplate restTemplate = new RestTemplate();

        // Set up headers with API key
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setBearerAuth(apiKey);
        //headers.set("Authorization", "Bearer " + apiKey);

        // Create request body with prompt
        String requestBody = String.format("{\"messages\": [{\"role\": \"user\", \"content\": \""+prompt+"\"}], \"temperature\": 0.7, \"model\": \"gpt-3.5-turbo\"}", prompt);

        // Send request and get response
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
        try {
            ResponseEntity<String> response = restTemplate.exchange(chatGPTApiUrl, HttpMethod.POST, entity, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // Handle HTTP errors
            System.err.println("HTTP Error: " + e.getStatusCode() + " - " + e.getStatusText());
            return null;
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            return null;
        }
    }
}