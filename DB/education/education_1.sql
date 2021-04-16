use education;
select * from student;
update student set scode='s001' where sname='박소명';
select * from student where sdept = '컴퓨터공학과';

select * from professor; # comment
select pname from professor where pdept = '컴퓨터공학과';

#professor에서 주소가 서울인 교수님의 이름과 전공을 출력하기
select pname,pdept from professor where paddress ='서울';

#professor에서 전공이 국문학과 주소가 강원도인 교수님 출력하기alter
select * from professor where pdept='국문학과' or paddress='강원도';

#propessor table을 이름 오름차순으로 정렬하기
select * from professor order by pname;

#propessor table을 이름 기준으로 내림차순 정렬하기
select * from professor order by pname desc;

#propessor에서 전공기준으로 오름차순 정렬하기
select * from professor order by pdept, pname desc;

#국문학과 교수 리스트를 이름 순서로 출력

select * from professor where pdept = '국문학과' order by pname;









