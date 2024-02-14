package com.timeboost.assignments.repository;

import com.timeboost.assignments.model.AssignmentSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentSubmissionRepository extends JpaRepository<AssignmentSubmission, String> {
}