-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS  students ;
CREATE TABLE  students  (
   no  varchar(8) NOT NULL,
   name  varchar(10) NOT NULL,
   age int,
   PRIMARY KEY ( no )  
); 
CREATE INDEX idx_student_name ON students (name);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS  users ;
CREATE TABLE  users  (
   no  int NOT NULL,
   name  varchar(10) NOT NULL,
   age varchar(10) NOT NULL,
   PRIMARY KEY ( no )  
); 
CREATE INDEX idx_users_name ON users (name);