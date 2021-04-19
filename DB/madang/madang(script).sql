use madang;
SELECT * FROM madang.book;
SELECT * FROM madang.customer;
SELECT * FROM madang.orders;

#1.도서번호가 1인 도서의 이름
select bookname from book where bookid=1;

#2.가격이 20,000원 이상인 도서의이름
select bookname from book b where b.price >= 20000;

#3.박지성의 총 구매액?
select name, sum(o.saleprice) as 총구매액 from customer c, orders o 
where c.name = '박지성' and c.custid = o.custid; 

#4.박지성이 구매한 도서의 수?
select name, count(*) as 총구매도서 from customer c, orders o 
where c.name = '박지성' and c.custid = o.custid; 

#5.박지성이 구매한 도서의 출반사 수? #distinct 중복되지 않는 값의 카운트
select name, count(distinct(b.publisher))orders from customer c, orders o, book b
where c.name = '박지성' and c.custid = o.custid and b.bookid= o.bookid;

#6.마당서적 도서의 총 개수?
select count(*) from book;

#7.모든고객의 이름. 주소출력
select name, address from customer;

#8.박지성이 구매한 도서의 이름, 가격, 정가와 판매가격의 차이를 출력
select b.bookname as 책이름, b.price as 가격, b.price-o.saleprice as 정가와판매가격의차이 from customer c, orders o, book b
where c.name = '박지성' and c.custid = o.custid and b.bookid= o.bookid;

#9.2014년 7월 4일부터 7월 7일 사이에 주문받은 도서의 주문번호 출력
select * from orders where orderdate between '2014-07-04' and  '2014-07-07';  

#10.2014년 7월 4일부터 7월 7일 사이에 주문받은 도서를 제외한도서의 주문정보 출력.
select * from orders where not orderdate between '2014-07-04' and  '2014-07-07';

#11.성이 김씨인 고객의 이름과 주소 출력
select name, address from customer where name like '김%';

#12.성이 김씨이고 이름이 아로 끝나는 고객의 이름과 주소 출력
select name, address from customer where name like '김%아'; 

#13.고객의 이름과 고객이름별 구매액을 출력
select c.name, sum(o.saleprice) from customer c, orders o 
where c.custid = o.custid group by c.name;  

#14.주문하지 않은 고객의 이름
select name from customer c
where name not in (select name from orders o  where c.custid=o.custid);




   




 