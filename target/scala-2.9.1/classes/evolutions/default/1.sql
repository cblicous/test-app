# --- First database schema

# --- !Ups

set ignorecase true;

drop table if exists company;

drop table if exists item;

drop table if exists users;

drop table if exists item_owner;

create table company (
  id                        bigint not null,
  name                      varchar(255) not null,
  constraint pk_company primary key (id))
;

create table item (
  id                        bigint not null,
  name                      varchar(255) not null,
  image                     text not null,
  url                       text not null,
  itemtype                  varchar(255) not null,
  introduced                timestamp,
  company_id                bigint,
  constraint pk_item primary key (id))
;

create table user (
  email                      varchar(255) not null,
  password                     text not null,
  name                       text not null,

  constraint pk_user primary key (email))
;

create table item_owner ( 
	item_id   bigint not null,
 	user_email    varchar(255) not null,
 	foreign key(item_id)   references item(id) on delete cascade,
  	foreign key(user_email)   references user(email) on delete cascade
);


create table image ( 
 	id    bigint not null,
 	name  	varchar(1024) not null,
 	image  	varchar(255) not null, 	
 	url  	varchar(2048) not null,
	item_id   bigint not null,
 	user_email    varchar(255) not null,
 	foreign key(item_id)   references item(id) on delete cascade,
  	foreign key(user_email)   references user(email) on delete cascade
  	
);


create sequence company_seq start with 1000;

create sequence item_seq start with 1000;

create sequence image_seq start with 1000;


alter table item add constraint fk_item_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_item_company_1 on item (company_id);


# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists company;

drop table if exists item;

drop table if exists users;

drop table if exists item_owner_image;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists company_seq;

drop sequence if exists item_seq;

drop sequence if exists item_owner_image_seq;


