use A1_professor_schema;
show tables;
select * from professor;

select * from professor natural join department;

select professor.prof_id, fname, lname, shift from professor join shift using(prof_id);

select department.dept_id, dept_name, fname, lname from department left join professor on professor.dept_id = department.dept_id;

select fname, lname, dept_name from department right join professor on professor.dept_id = department.dept_id;

select fname, lname, dept_name, salary, shift from professor join department using(dept_id) join shift on professor.prof_id = shift.prof_id  where professor.prof_id = 1;

select professor.dept_id, dept_name,  count(*) from professor left join department on professor.dept_id = department.dept_id  group by dept_id;
select * from professor;

select prof_id, fname, lname, dept_name, department.dept_id from professor join department using(dept_id) where dept_id = ( select dept_id from department where dept_name = 'COMP');

select dept_name from department where dept_id in(select dept_id from professor where dob = '2015-01-01');

create view ProfShift as select fname, lname, shift, working_hrs from professor join shift using(prof_id);
select * from ProfShift;

create view ProfDetails as select prof_id, fname, lname, designation from professor;
select * from ProfDetails;
insert into ProfDetails values(102, 'Pranjali', 'Joshi', 'Professor');
select * from ProfDetails;
update ProfDetails set designation = 'Professor' where prof_id = 10;
select * from ProfDetails;
select * from professor;
delete from ProfDetails where prof_id = 102;
select * from ProfDetails;

drop view if exists ProfDetails;
drop view if exists ProfShift;