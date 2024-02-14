package com.timeboost.assignments.service;

import com.timeboost.assignments.model.AssignmentSubmission;
import com.timeboost.assignments.repository.AssignmentSubmissionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class AssignmentServiceIntegrationTest {

    @Autowired
    private AssignmentSubmissionRepository repository;

    @Test
    public void testSaveAndFindById() {
        // Given
        AssignmentSubmission submission = new AssignmentSubmission();
        submission.setStudentId("student1");
        submission.setAssignmentId("assignment1");
        submission.setAssignmentDescription("description");
        submission.setAssignmentEvaluationCriterias("criteria");
        submission.setAssignmentContent("content");
        submission.setFeedback("fsddfsdhjfsdkgfjhgfhgvmnbvjhbkjhfsdlkjghsdlkfjhgsldfkjhgslkdfbglksdfjhglsdfkjhglsdfkjhgljhgfsdkljhgfdskjhdsfsadfgk.sdfjgskdfljghlksdfjhglksjdfhglksjfdhglskdfjhglksfdjhglskdfjhglksdjfhglksjdfhglkjshdfglkjsfdhglkjhsfdlkgjhsdflkjghsldfkjgnsfkmnvlkdsjhtlrkjsdhgksfjdhglksdfjhglskdfjnglskdfjhglkajrhtglksdfjngsdfkjhglsdfkjghskdfjnglsakjhgfslkdjfghsfdkjghslkdjfghlakejrhglksjdfglsdfkjhglskjdfghsdfkjlhglsdfkfjhglsdkjfghlsdkfjhgfldskjhgflskdjflk");
        submission.setSubmissionConfirmationId("123");
        // When
        AssignmentSubmission savedSubmission = repository.save(submission);

        // Then
        AssignmentSubmission retrievedSubmission = repository.findById(savedSubmission.getSubmissionConfirmationId()).orElse(null);
        assertThat(retrievedSubmission).isNotNull();
        assertThat(retrievedSubmission.getStudentId()).isEqualTo("student1");
        assertThat(retrievedSubmission.getAssignmentId()).isEqualTo("assignment1");
        assertThat(retrievedSubmission.getAssignmentDescription()).isEqualTo("description");
        assertThat(retrievedSubmission.getAssignmentEvaluationCriterias()).isEqualTo("criteria");
        assertThat(retrievedSubmission.getAssignmentContent()).isEqualTo("content");
    }
}