DROP TABLE IF EXISTS Department;

DROP TABLE IF EXISTS Instructor;

DROP TABLE IF EXISTS Course;

DROP TABLE IF EXISTS Student;

DROP TABLE IF EXISTS Course_Student;

CREATE TABLE `Department`
(
 `ID`       int NOT NULL ,
 `name`     varchar(255) NOT NULL ,
 `location` varchar(255) NOT NULL ,

PRIMARY KEY (`ID`)
);




CREATE TABLE `Instructor`
(
 `ID`             int NOT NULL ,
 `headed_by`       varchar(255) NOT NULL ,
 `first_name`      varchar(255) NOT NULL ,
 `last_name`       varchar(255) NOT NULL ,
 `phone`          varchar(255) NOT NULL ,
 `department_name` varchar(255) NOT NULL ,

PRIMARY KEY (`ID`)

);


CREATE TABLE `Course`
(
 `ID`             int NOT NULL ,
 `duration`       int NOT NULL ,
 `name`           varchar(255) NOT NULL ,
 `department_name` varchar(255) NOT NULL ,
 `instructor_id`   int NOT NULL ,

PRIMARY KEY (`ID`)

);



CREATE TABLE `Student`
(
 `ID`        int NOT NULL ,
 `first_name` varchar(255) NOT NULL ,
 `last_name`  varchar(255) NOT NULL ,
 `phone`     varchar(255) NOT NULL ,

PRIMARY KEY (`ID`)
);




CREATE TABLE `Course_Student`
(
 `course_id`  int NOT NULL ,
 `student_id` int NOT NULL ,
 `ID`        int NOT NULL ,

PRIMARY KEY (`ID`)

);



















