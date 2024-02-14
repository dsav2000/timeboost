CREATE TABLE IF NOT EXISTS assignment_submission (
    id INT AUTO_INCREMENT PRIMARY KEY,
    submission_confirmation_id VARCHAR(255) NOT NULL,
    student_id VARCHAR(255) NOT NULL,
    assignment_id VARCHAR(255) NOT NULL,
    assignment_description MEDIUMTEXT,
    assignment_evaluation_criterias MEDIUMTEXT,
    assignment_content MEDIUMTEXT,
    feedback MEDIUMTEXT
);