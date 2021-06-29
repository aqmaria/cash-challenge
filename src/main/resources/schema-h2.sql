CREATE TABLE USERS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE LOANS (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     total DECIMAL(13, 2) NOT NULL,
     user_id BIGINT NOT NULL ,
     foreign key (user_id) references USERS(id)
);