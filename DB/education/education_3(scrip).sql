use education;
select * from student;
select sname, sdept from student where sdept = '컴퓨터공학과';
select count(scode) from student where sdept = '컴퓨터공학과';
select * from student where sname like '김%'; #김으로 시작함 %김으로 끝나는 %김% 김이란 글자는 다 불러옴
select *from student order by sname;


