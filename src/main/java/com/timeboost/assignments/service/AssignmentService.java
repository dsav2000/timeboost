package com.timeboost.assignments.service;

import com.timeboost.assignments.model.AssignmentSubmission;
import com.timeboost.assignments.repository.AssignmentSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    @Autowired
    private ChatGPTAsyncService chatGPTAsyncService;


    public String submitAssignment(String studentId, String assignmentId, String assignmentDescription,
                                   String assignmentEvaluationCriterias, String assignmentContent) {
        String submissionConfirmationId = UUID.randomUUID().toString();

        AssignmentSubmission submission = new AssignmentSubmission();
        submission.setSubmissionConfirmationId(submissionConfirmationId);
        submission.setStudentId(studentId);
        submission.setAssignmentId(assignmentId);
        submission.setAssignmentDescription(assignmentDescription);
        submission.setAssignmentEvaluationCriterias(assignmentEvaluationCriterias);
        submission.setAssignmentContent(assignmentContent);
        assignmentSubmissionRepository.save(submission);

        // Generate prompt for ChatGPT
        String chatGPTPrompt = generateChatGPTPrompt(assignmentDescription, assignmentEvaluationCriterias, assignmentContent);

        // Send the prompt to ChatGPT and get feedback
        chatGPTAsyncService.queryChatGPTAndStoreFeedback(submissionConfirmationId, chatGPTPrompt);

        return submissionConfirmationId;
    }

    protected String generateChatGPTPrompt(String assignmentDescription, String assignmentEvaluationCriterias, String assignmentContent) {
        return String.format("Please evaluate the following assignment submission based on the given criteria: " +
                        "Assignment Description: %s. " +
                        "Evaluation Criteria: %s. " +
                        "Student Submission: %s. " +
                        "Please provide a grade and feedback.",
                assignmentDescription, assignmentEvaluationCriterias, assignmentContent);
    }

}
