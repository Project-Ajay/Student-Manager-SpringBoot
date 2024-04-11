CREATE TABLE Course (
    id INT AUTO_INCREMENT PRIMARY KEY,
    courseName VARCHAR(255) NOT NULL,
    courseCode VARCHAR(50) NOT NULL,
    courseCredit VARCHAR(10) NOT NULL,
    edit BOOLEAN
);
