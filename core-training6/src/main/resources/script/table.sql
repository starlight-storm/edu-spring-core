DROP TABLE CUSTOMER if exists
CREATE TABLE CUSTOMER(ID INTEGER IDENTITY PRIMARY KEY,NAME VARCHAR(20) NOT NULL,ADDRESS VARCHAR(20) NOT NULL,EMAIL_ADDRESS VARCHAR(20) NOT NULL)