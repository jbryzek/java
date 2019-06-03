drop table if exists USER;
drop table if exists ANSWER;
drop table if exists SURVEY;

create table USER(
    ID int not null auto_increment,
    userName varchar(100) not null,
    primary key (ID)
);

create table ANSWER(
    ID int not null auto_increment,
    USER_ID int not null,
    SURVEY_ID int not null,
    RATING int not null,
    primary key (ID),
    foreign key (USER_ID) references USER,
    foreign key (SURVEY_ID) references SURVEY
);

create table SURVEY(
    ID int not null auto_increment,
    SURVEY_TITLE varchar(100) not null,
    QUESTION varchar(200) not null,
    USER_ID int not null,
    primary key (ID),
    foreign key (USER_ID) references USER
);