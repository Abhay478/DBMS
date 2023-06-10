-- For exercises 4 and 5
    drop table atoi cascade; -- weird errors if I didn't do this, so.
    create table atoi (
        "grade varchar(2),"+
        "points int"+
    );
    insert into atoi values('A+', 10);
    insert into atoi values('A ', 9);
    insert into atoi values('A-', 8);
    insert into atoi values('B+', 7);
    insert into atoi values('B ', 6);
    insert into atoi values('B-', 5);
    insert into atoi values('C+', 4);
    insert into atoi values('C ', 3);
    insert into atoi values('C-', 2);

    create or replace view GPA3 as (select \"id\", credits, grade, (select points from atoi where grade = T.grade) from course natural join takes as T);
    create or replace view CGPA as select \"id\", sum(points * credits) / sum(credits) as cgpa from GPA3 group by "id" order by cgpa desc;
