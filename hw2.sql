-- homework 2.sql
runscript from '~/Downloads/courses-ddl.sql';
runscript from '~/Downloads/courses-small.sql';

-- 1. show the name and salary of all instructors
select name, salary from instructor;

-- 2. show all columns for instructors in the 'Comp. Sci.' department
select * from instructor where dept_name='Comp. Sci.';

-- 3. show name, salary, department for instructors with salaries less than $50,000.
select name, salary, dept_name from instructor where (salary<50000);

-- 4. show the student name, major department and total credits for 
--    students with at least 90 credits
select name, dept_name, tot_cred from student where (tot_cred<90);

-- 5. show the student ID and name for students who are majoring in  
--    Electrical Engineering  (Elec. Eng.) or Comp. Sci.  and have at least 90 credits
select id, name from student where (dept_name='Elec. Eng.' or dept_name='Comp. Sci.') and tot_cred>=90;

-- 6. insert a new Student with an ID 12399, name is Fred Brooks, student is majoring in Comp. Sci., total credits is 0.
insert into student values ('12399', 'Fred Brooks', 'Comp. Sci.', '0');

-- 7. increase the total credits by 8 for student with ID 19991
update student set tot_cred=tot_cred+8 where id=19991

-- 8. change the tot_cred for student ID=12399 to 100.
update student set tot_cred =100 where id=12399

-- 9. show all columns for all students
select * from student;

-- 10.  Give all faculty a 4% increase in salary.
update INSTRUCTOR  set salary = salary*1.04

-- 11.  Give all faculty in the Physics department a $3,500 salary increase.
-- select dept_name, salary from instructor
update INSTRUCTOR  set SALARY = case when dept_name='Physics' then (SALARY +3500) end

-- 12.  show the  ID, name and salary for all instructors
select id, name, salary from instructor;

-- 13.  try to delete the course 'PHY-101'.  
delete from course where course_id ='PHY-101'; 

-- 14.  Why does the delete fail?
-- Because the column course_id is a foreign key?

-- 15.  Delete the course 'CS-315'
delete from COURSE  where COURSE_ID ='CS-315';

-- 16.  Show a list of all course_id.
select course_id from course;

-- 17.  Show all the student majors.  Do not show duplicates.
select distinct dept_name from student order by dept_name; 

-- 18.  create a table "company" with columns id, name and ceo. 
-- Make "id" the primary key.
-- insert the following data 
--    id   name          ceo
--    ACF  Acme Finance  Mike Dempsey
--    TCA  Tara Capital  Ava Newton
--    ALB  Albritton     Lena Dollar
create table company
    ( ID          varchar(5),
      name    varchar(20) not null,
      ceo       varchar(20) not null,
      primary key (ID)
    );
insert into company values('ACF', 'Abhi Engineering', 'Mike Dempsey');
insert into company values('TCA', 'Tara Capital', 'Ava Newton');
insert into company values('ALB', 'Albritton', 'Lena Dollar');


-- create a table "security" with columns id, name, type.
-- Make "id" the primary key.
-- insert the following data
--    id    name                type
--    AE    Abhi Engineering    Stock
--    BH    Blues Health        Stock
--    CM    County Municipality Bond
--    DU    Downtown Utlity     Bond
--    EM    Emmitt Machines     Stock
create table security 
	( 	ID		varchar(5),
		name	varchar(20),
		type	varchar(20),
		primary key (ID)
	);
insert into security values('AE', 'Abhi Engineering', 'Stock');
insert into security values('BH', 'Blues Health', 'Stock');
insert into security values('CM', 'County Municipality', 'Bond');
insert into security values('DU', 'Downtown Utlity', 'Bond');
insert into security values('EM', 'Emmitt Machines', 'Stock');

-- create a table "funds"   
-- Make "FundID" the primary key.  
-- Make "CompanyID" a foreign key.
-- add the following data
-- CompanyID  InceptionDate   FundID Name
--    ACF      2005-01-01     BG     Big Growth
--    ACF      2006-01-01     SG     Steady Growth
--    TCA      2005-01-01     LF     Tiger Fund
--    TCA      2006-01-01     OF     Owl Fund
--    ALB      2005-01-01     JU     Jupiter
--    ALB      2006-01-01     SA     Saturn
create table funds
	(	CompanyID		varchar(5),
		InceptionDate	varchar(20),
		FundID			varchar(5),
		Name			varchar(20),
		primary key (FundID),
		foreign key (CompanyID) references company(id)
	);
insert into funds values('ACF', '2005-01-01', 'BG', 'Big Growth');
insert into funds values('ACF', '2006-01-01', 'SG', 'Steady Growth');
insert into funds values('TCA', '2005-01-01', 'LF', 'Tiger Fund');
insert into funds values('TCA', '2006-01-01', 'OF', 'Owl Fund');
insert into funds values('ALB', '2005-01-01', 'JU', 'Jupiter');
insert into funds values('ALB', '2006-01-01', 'SA', 'Saturn');


-- create a table holdings
-- Make fundID, securityID the primary key.
-- Make fundID a foreign key.
-- Make securityID a foreign key.
-- add the following data  
--    fundID   securityID   quantity
--     BG       AE           500
--     BG       EM           300
--     SG       AE           300
--     SG       DU           300
--     LF       EM          1000
--     LF       BH          1000
--     OF       CM          1000
--     OF       DU          1000
--     JU       EM          2000
--     JU       DU          1000
--     SA       EM          1000
--     SA       DU          2000
create table holdings
	(	fundID		varchar(5),
		securityID	varchar(5),
		quantity	numeric(5),
		primary key(fundID, securityID),
		foreign key(fundID) references security(ID) on delete set null
	);
insert into holdings values('BG', 'AE', '500');
insert into holdings values('BG', 'EM', '300');
insert into holdings values('SG', 'AE', '300');
insert into holdings values('SG', 'DU', '300');
insert into holdings values('LF', 'EM', '1000');
insert into holdings values('LF', 'BH', '1000');
insert into holdings values('OF', 'CM', '1000');
insert into holdings values('OF', 'DU', '1000');
insert into holdings values('JU', 'EM', '2000');
insert into holdings values('JU', 'DU', '1000');
insert into holdings values('SA', 'EM', '1000');
insert into holdings values('SA', 'DU', '2000');

-- 19.  alter the security table to add a column price numeric(7,2)
alter table security add price numeric(7,2);

-- 20.  drop the tables. Because of the foreign keys, you must drop the 
--   tables in a particular order.
drop table if exists prereq; 
drop table if exists takes; 
drop table if exists teaches; 
drop table if exists section; 
drop table if exists advisor;
drop table if exists instructor; 
drop table if exists course; 
drop table if exists student; 
drop table if exists department; 
drop table if exists classroom; 
drop table if exists time_slot; 
drop table if exists time_slot_1;
drop table if exists grade_points;
drop table if exists company;
drop table if exists security;
drop table if exists holdings;
drop table if exists funds;