# --- Second database schema

# --- !Ups


delete from item;
delete from company;
delete from user;


INSERT INTO user (email, password, name)
VALUES ('cb@test.de','test','ceebeee');

insert INTO  company (
  id,
  name)
 VALUES (1,'Chanel');



INSERT INTO item (id,name ,image,url,itemtype,company_id) VALUES (1,'Le Vernis 539','/assets/images/P128000_MEDIUM.jpg','','Nail',1);
INSERT INTO item (id,name ,image,url,itemtype,company_id) VALUES (2,'Le Vernis 549','/assets/images/P148457_MEDIUM.jpg','','Nail',1);
INSERT INTO item (id,name ,image,url,itemtype,company_id) VALUES (3,'Le Vernis 469','/assets/images/P158170_MEDIUM.jpg','','Nail',1);
INSERT INTO item (id,name ,image,url,itemtype,company_id) VALUES (4,'Beaute de Frommage','/assets/images/P158310_MEDIUM.jpg','','Nail',1);
INSERT INTO item (id,name ,image,url,itemtype,company_id) VALUES (5,'Le Vernis 134','/assets/images/P158320_MEDIUM.jpg','','Nail',1);