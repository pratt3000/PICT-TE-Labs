use A1_professor_schema;

select * from professor;
select * from professor where city in ('Mumbai') UNION select * from professor where city in ('Pune');

update professor set salary = salary + 0.05*salary where prof_id = (select prof_id from works where dob = '1980-01-01');
select * from professor;

select fname, lname from professor where city in ('Pune') UNION select fname, lname from professor where city in ('Mumbai');

select professor.prof_id, fname, lname, professor.dept_id, designation from professor join works on professor.prof_id = works.prof_id where dob in ("2015-01-01") UNION select professor.prof_id, fname, lname, professor.dept_id, designation from professor join works on professor.prof_id = works.prof_id where dob in ("2016-01-01");

select max(salary) from professor;

select prof_id, fname, lname, designation from professor where salary between 10000 and 20000;

update professor set salary = 15000 where prof_id = 7;

select prof_id, fname, lname, designation from professor where salary between 10000 and 20000;

select professor.prof_id, fname, lname, dob, salary from professor join works using(prof_id) order by salary desc;

select professor.prof_id, fname, lname, dob, salary from professor join works using(prof_id) where salary in (30000, 40000, 50000);
