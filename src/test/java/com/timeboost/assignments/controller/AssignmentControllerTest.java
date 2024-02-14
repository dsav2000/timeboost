package com.timeboost.assignments.controller;

import com.timeboost.assignments.service.AssignmentService;
import com.timeboost.assignments.service.FeedbackService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AssignmentController.class)
@ExtendWith(SpringExtension.class)
public class AssignmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AssignmentService assignmentService;

    @MockBean
    private FeedbackService feedbackService;

    @Test

    public void submitAssignment_ShouldReturnStatusOk() throws Exception {
        // Mocking service layer
        when(assignmentService.submitAssignment(anyString(), anyString(), anyString(), anyString(), anyString()))
                .thenReturn("sample_submission_id");

        // Performing POST request and validating the response
        mockMvc.perform(post("/api/submit_assignment")
                        .param("studentId", "student1")
                        .param("assignmentId", "assignment1")
                        .param("assignmentDescription", "description")
                        .param("assignmentEvaluationCriterias", "criteria")
                        .param("assignmentContent", "content"))
                .andExpect(status().isOk());
    }

    @Test
    public void retrieveAssessment_ShouldReturnStatusOk() throws Exception {
        // Mocking service layer
        when(feedbackService.retrieveFeedback(anyString())).thenReturn("sample_feedback");

        // Performing GET request and validating the response
        mockMvc.perform(get("/api/retrieve_assessment")
                        .param("submissionConfirmationId", "sample_submission_id"))
                .andExpect(status().isOk());
    }
}