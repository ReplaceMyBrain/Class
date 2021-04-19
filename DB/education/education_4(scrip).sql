use education;
select * from course;

#mysql 과목을 강의하는 교수님의 이름, 전화번호 강의실 검색
select p.pname, p.pphone, c.croom
from professor as p, course as c, lecture as l 
where c.cname = 'MySQL' and 
c.ccode = l.lccode and l.lpcode = p.pcode;

#김구 교수님이 강의하는 과목명. 강의시간과 강의실을 검색
select c.cname, c.ctime, c.croom
from course as c, professor as p, lecture as l 
where p.pname = '김구' and
c.ccode = l.lccode and l.lpcode = p.pcode;

#각 학생이 수강 신청한 과목에 대해서 학생이름, 과목명, 강의실, 강의시간을 검색
select s.sname, c.cname, c.ctime, c.croom
from course as c, student as s, register as r
where s.scode = r.rscode and c.ccode=r.rccode;

select * from score;
desc score;
select sum(v2) from score;
select count(v2) from score;
select avg(v2) as 평균 from score;
select max(v2) from score;
select min(v2) from score;
select max(v2)-min(v2) from score;

# 학과별 교수님은 몇분인지 구하는 검색
select pdept, count(*) from professor group by pdept;

#각 학생이 신청한 총 학점을 구하는 검색
select s.sname, s.sdept, sum(c.ctime)
from course as c, student as s, register as r 
where s.scode = r.rscode and c.ccode=r.rccode group by s.sname, s.sdept;






