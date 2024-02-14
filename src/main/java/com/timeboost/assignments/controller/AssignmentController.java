package com.timeboost.assignments.controller;

import com.timeboost.assignments.service.AssignmentService;
import com.timeboost.assignments.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping("/submit_assignment")
    public String submitAssignment(@RequestParam String studentId,
                                   @RequestParam String assignmentId,
                                   @RequestParam String assignmentDescription,
                                   @RequestParam String assignmentEvaluationCriterias,
                                   @RequestParam String assignmentContent) {
        return assignmentService.submitAssignment(studentId, assignmentId, assignmentDescription,
                assignmentEvaluationCriterias, assignmentContent);
    }

    @GetMapping("/retrieve_assessment")
    public String retrieveAssessment(@RequestParam String submissionConfirmationId) {
        return feedbackService.retrieveFeedback(submissionConfirmationId);
    }
}