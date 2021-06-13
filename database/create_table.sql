use new_servlet_jdbc;

create table role(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) not null,
    modifiedby varchar(255) not null
);

create table user(
	id bigint not null primary key auto_increment,
    username varchar(150) not null,
    password varchar(150) not null,
    fullname varchar(150) null,
    status int not null,
    roleid bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) not null,
    modifiedby varchar(255) not null
);

alter table user add constraint fk_user_role foreign key(roleid) references role(id);

create table news(
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumbnail varchar(255) null,
    shortdescription text null,
    content text null,
    categoryid bigint not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) not null,
    modifiedby varchar(255) not null
);

create table category(
	id bigint not null primary key auto_increment,
    name varchar(255) not null,
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

alter table news add constraint fk_news_category foreign key(categoryid) references category(id);

create table comment(
	id bigint not null primary key auto_increment,
    content text not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);


