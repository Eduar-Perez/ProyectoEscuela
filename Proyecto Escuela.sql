create database escuela;
use  escuela;


create table classroom;

insert into classroom values (1,"A1","primer piso");
insert into classroom values (2,"B1","segundo piso");
insert into classroom values (3,"C1","tercer piso");

select * from  classroom;


create table student;

insert into student values (1088976084,"Perez","Camilo", 3113931865);
insert into student values (1144081028,"Ordoñez","Jorge", 3146554355);
insert into student values (1007411016,"Polo","Fabian", 3136809765);

select * from  student;

create table teacher;
insert into teacher values (1, "Grijalba", "Alvaro",222323);
insert into teacher values (2, "Montañez", "Jose", 222424);
insert into teacher values (3, "Quintero", "Pedro", 222525);

select * from  teacher;


create table subjectM;

insert into subjectM values (1,"Matematicas", 1, 1);
insert into subjectM values (2,"Quimica", 2, 2);
insert into subjectM values (3,"Calculo",3, 3);

select * from  subjectM;


create table SubjectStudent_Entity;

insert into subject_student_entity ( studententity_subjectstudent_entity,subjectentity_subjectstudent_entity) values (1088976084, 1);
insert into subject_student_entity ( studententity_subjectstudent_entity,subjectentity_subjectstudent_entity) values (1088976084, 2);
insert into subject_student_entity (studententity_subjectstudent_entity,subjectentity_subjectstudent_entity) values (1088976084, 3 );
insert into subject_student_entity (studententity_subjectstudent_entity,subjectentity_subjectstudent_entity) values (1144081028, 1 );
insert into subject_student_entity (studententity_subjectstudent_entity,subjectentity_subjectstudent_entity) values (1144081028, 3 );
insert into subject_student_entity (studententity_subjectstudent_entity,subjectentity_subjectstudent_entity) values (1007411016, 3 );
select * from  subject_student_entity;
