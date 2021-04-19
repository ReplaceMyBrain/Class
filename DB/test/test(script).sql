use test;
SELECT * FROM test.employee_tbl;
select name, count(*) from employee_tbl group by name;

#같은 방식 다른 문법
select * from employee_tbl where daily_typing_pages = 250 or  daily_typing_pages = 220 or  daily_typing_pages = 170;
select * from employee_tbl where daily_typing_pages in (250,220,170);  #파이썬에서 사용한다고함. sql함수 훨씬 좋다.
select * from employee_tbl where daily_typing_pages >=170 and daily_typing_pages <= 300;
select * from employee_tbl where daily_typing_pages between 170 and 300; #sql함수 훨씬 좋다.

#연결시켜주는 union 
select * from prospect;
select * from customer;
select * from vendor;

select fname, lname, addr from prospect
union
select first_name, last_name, address from customer
union
select company,'',street from vendor;

select a.first_name, a.last_name from customer a, prospect b where a.first_name = b.fname;
#first name이 같은 사람의 이름을 표시하라 

#employee_tbl에서 이름이 zara는 몇명인가?
select name, count(*) from employee_tbl where name = 'Zara';

#employee_tbl에서 최대 타이핑 페이지 수는?
select max(daily_typing_pages) from employee_tbl;

#employee_tbl에서 이름별 name, 최대 타이핑수 출력하기
select name, max(daily_typing_pages) from employee_tbl group by name;

#employee_tbl에서 이름별 name, 최소 타이핑수 출력하기
select name, min(daily_typing_pages) from employee_tbl group by name;

#employee_tbl에서 이름별 name, 평균 타이핑수 출력하기
select name, avg(daily_typing_pages) from employee_tbl group by name;

#employee_tbl에서 이름별 name, 타이핑수 합계 구하기
select name, sum(daily_typing_pages) from employee_tbl group by name;
select name, sum(daily_typing_pages) as 합계, sum(daily_typing_pages) *500 as fee from employee_tbl group by name;

#etc
select 1+2; 
select sqrt(16); #루트
select rand();#랜덤?
select *from employee_tbl order by rand();#랜덤?
select concat(id, name, workdate) from employee_tbl; #이어붙이기
select now(); #현재시간
select adddate('2021-04-19', interval 20 day);#시간더하기
select adddate('2021-04-19',20); #시간더하기
select curdate(); #시간
select curdate() + 20; #시간
select curtime(); #시간
select dayname('2021-04-19'); #요일
select dayname(now()); #요일
select timediff('2021-04-19 12:00:00', '2021-01-01 12:00:00'); #시간차이
select datediff('2021-01-01',now()); #날짜차이

select abs(-2); #절대값
select ceil(7.45); #올림
select floor(7.55); #올림
select round(7.45); #반올림
select mod(29, 3); #나머지
select power(2,3); #2의 3승
select truncate(7.536432,2); #두번째 자리까지 출력alter
select char_length('text'); #글자갯수
select insert('abcdefg', 3, 4, '123'); #3번째부터 4개를 없애고 123삽입
select trim('     1234     '); #공백삭제
select replace('111.gogle.com', '1', 'w'); #1을w로 바꿔라
select reverse('4321'); # 앞뒤로 바꾸기
select strcmp('aac', 'aab'); # string1 = string2 경우,  0 반환 string1 < string2 경우, -1 반환 string1 > string2 경우,  1 반환
select substring('abcdefg', 5); #n번째부터 끝까지 가져오기
select substring('abcdefg', 1,3); #1~3까지 가져오기




















 


