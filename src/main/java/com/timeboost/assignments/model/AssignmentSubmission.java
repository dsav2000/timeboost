package com.timeboost.assignments.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class AssignmentSubmission {
    @Id
    private String submissionConfirmationId;
    private String studentId;
    private String assignmentId;
    private String assignmentDescription;
    private String assignmentEvaluationCriterias;
    private String assignmentContent;
    private String feedback;

}