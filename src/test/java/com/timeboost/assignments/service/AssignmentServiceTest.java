package com.timeboost.assignments.service;


import com.timeboost.assignments.repository.AssignmentSubmissionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AssignmentServiceTest {

    @Mock
    private AssignmentSubmissionRepository repository;

    @InjectMocks
    private AssignmentService service;
/*
    @Test
    public void testSubmitAssignment() {
        // Given
        String studentId = "student1";
        String assignmentId = "assignment1";
        String description = "description";
        String criteria = "criteria";
        String content = "content";

        // When
        service.submitAssignment(studentId, assignmentId, description, criteria, content);

        // Then
        verify(repository, times(1)).save(any());
    }*/

    @Test
    public void testGenerateChatGPTPrompt() {
        // Given
        String description = "description";
        String criteria = "criteria";
        String content = "content";

        // When
        String prompt = service.generateChatGPTPrompt(description, criteria, content);

        // Then
        String expectedPrompt = String.format("Please evaluate the following assignment submission based on the given criteria: " +
                        "Assignment Description: %s. " +
                        "Evaluation Criteria: %s. " +
                        "Student Submission: %s. " +
                        "Please provide a grade and feedback.",
                description, criteria, content);
        assert prompt.equals(expectedPrompt) : "Prompt generation failed!";
    }
}