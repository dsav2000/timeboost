package com.timeboost.assignments.service;

import com.timeboost.assignments.model.AssignmentSubmission;
import com.timeboost.assignments.repository.AssignmentSubmissionRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ChatGPTAsyncServiceTest {

    @Mock
    private ChatGPTCommunicationService chatGPTCommunicationService;

    @Mock
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @InjectMocks
    private ChatGPTAsyncService service;

    @Test
    public void testQueryChatGPTAndStoreFeedback() {
        // Given
        String submissionConfirmationId = "sample_submission_id";
        String prompt = "Test prompt";

        when(assignmentSubmissionRepository.findById(anyString()))
                .thenReturn(java.util.Optional.of(new AssignmentSubmission()));

        // When
        service.queryChatGPTAndStoreFeedback(submissionConfirmationId, prompt);

        // Then
        verify(chatGPTCommunicationService, times(1)).sendRequestToChatGPT(anyString());
        verify(assignmentSubmissionRepository, times(1)).save(any(AssignmentSubmission.class));
    }
}