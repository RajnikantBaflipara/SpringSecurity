CREATE TABLE USERS 
( 
    USERNAME VARCHAR(255) NOT NULL, 
    PASSWORD VARCHAR(255) NOT NULL, 
    PRIMARY KEY (USERNAME)
);
  
CREATE TABLE USER_ROLES 
( 
    ROLE VARCHAR(255) NOT NULL, 
    USERNAME VARCHAR(255) NOT NULL, 
    PRIMARY KEY (ROLE),
    CONSTRAINT fk_username FOREIGN KEY (USERNAME) REFERENCES USERS(USERNAME)
);

insert into USERS (USERNAME,PASSWORD) values ('admin', 'password');
insert into USER_ROLES (ROLE, USERNAME) values ('ROLE_ADMIN','admin');