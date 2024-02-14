package com.timeboost.assignments.service;

import com.timeboost.assignments.model.AssignmentSubmission;
import com.timeboost.assignments.repository.AssignmentSubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FeedbackService {

    @Autowired
    private AssignmentSubmissionRepository assignmentSubmissionRepository;

    public String retrieveFeedback(String submissionConfirmationId) {
        AssignmentSubmission submission = assignmentSubmissionRepository.findById(submissionConfirmationId).orElseThrow();

        return submission.getFeedback();
    }
}
