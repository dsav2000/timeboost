package com.timeboost.assignments.service;

import com.timeboost.assignments.model.AssignmentSubmission;
import com.timeboost.assignments.repository.AssignmentSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ChatGPTAsyncService {

    @Autowired
    private ChatGPTCommunicationService chatGPTCommunicationService;
    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Async
    public void queryChatGPTAndStoreFeedback(String submissionConfirmationId, String prompt) {
        // Send the prompt to ChatGPT and get feedback
        String chatGPTFeedback = chatGPTCommunicationService.sendRequestToChatGPT(prompt);

        // Find the submission in the database
        AssignmentSubmission submission = assignmentSubmissionRepository.findById(submissionConfirmationId).orElseThrow();

        // Store the feedback from ChatGPT in the submission
        submission.setFeedback(chatGPTFeedback);
        assignmentSubmissionRepository.save(submission);
    }
}
