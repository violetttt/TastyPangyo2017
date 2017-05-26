-- 테이블
DROP TABLE		restaurant;
CREATE TABLE  restaurant(
					restaurant_id 			NUMBER				PRIMARY KEY,
					food_category			VARCHAR2(50)  		NOT NULL,
					location					VARCHAR2(100)		NOT NULL,
					restaurant_name		VARCHAR2(100)		NOT NULL,
					hits						NUMBER				NOT NULL,
					restaurant_tel_num		VARCHAR2(50)		NOT NULL,
					introduction				VARCHAR2(1000)	NOT NULL,
					menu						VARCHAR2(500)		NOT NULL
					);
	
DROP TABLE 	restaurantimage;
CREATE TABLE 	restaurant_image(
					image						VARCHAR2(100) 	NOT NULL,
					restaurant_id				NUMBER				NOT NULL,
CONSTRAINT	restaurant_image_fk	FOREIGN KEY(restaurant_id) REFERENCES  restaurant ON DELETE CASCADE
					);
				
DROP TABLE 	review;
CREATE TABLE 	review (
					review_no      		NUMBER(5)      		PRIMARY KEY,
					member_id      		VARCHAR2(20)  		NOT NULL,
					restaurant_id   		NUMBER(6)      		NOT NULL,
					restaurant_name   	VARCHAR2(20)   	NOT NULL,
					registered_date   	DATE        			NOT NULL,
					title         			VARCHAR2(120)   	NOT NULL,
					comments      		VARCHAR2(1000)   	NOT NULL,
					kostar         		NUMBER(2)      		NOT NULL,   
CONSTRAINT   review_restaurant_fk   FOREIGN   KEY   (restaurant_id)   REFERENCES restaurant ON DELETE CASCADE,														
CONSTRAINT   review_member_fk      FOREIGN KEY (member_id)      REFERENCES member ON DELETE CASCADE
					);

--은영이가 한거---			
SELECT	avg(v.kostar), 
		v.restaurant_id,
		 r.food_category,
		  r.location,
		  r.restaurant_name,
		  r.hits,
		  r.restaurant_tel_num,
		  r.introduction
FROM REVIEW v, RESTAURANT r, restaurant_image i
WHERE v.restaurant_id=r.restaurant_id(+)
GROUP BY v.restaurant_id, 
		 r.food_category,
		  r.location,
		  r.restaurant_name,
		  r.hits,
		  r.restaurant_tel_num,
		  r.introduction
ORDER BY AVG(v.kostar) DESC


SELECT	avg(kostar), 
		restaurant_id, 
FROM REVIEW 
GROUP BY restaurant_id
ORDER BY AVG(kostar) DESC
---------------
					
DROP TABLE 	member;
CREATE TABLE 	member(
					member_id 		varchar2(50) 		PRIMARY KEY,
					member_pw 		varchar2(50) 		NOT NULL,
					member_name 	varchar2(50) 		NOT NULL,
					visit_date 			DATE 				NOT NULL
					);

-- 시퀀스
CREATE SEQUENCE restaurant_id_seq; 
DROP SEQUENCE restaurant_id_seq;

CREATE sequence review_no_seq;
DROP sequence review_no_seq;


-- 조회
SELECT * FROM member;
SELECT * FROM restaurant;
SELECT * FROM restaurant_image;
SELECT * FROM review;

SELECT restaurant_id_seq.nextval FROM DUAL;
SELECT review_no_seq.nextval FROM DUAL;

SELECT  r.restaurant_id,
		  r.food_category,
		  r.location,
		  r.restaurant_name,
		  r.hits,
		  r.restaurant_tel_num,
		  r.introduction,
		  i.image,
		  v.review_no,
  	 	  v.member_id,
   		  v.restaurant_id,
   		  v.restaurant_name ,
   		  v.registered_date ,
   		  v.title    ,
   		  v.comments ,
   		  v.kostar   
FROM   restaurant r, restaurant_image i, review v
WHERE  r.restaurant_id = i.restaurant_id(+)
AND	   r.restaurant_id = v.restaurant_id(+)
AND	   r.restaurant_id = 1	

-- 삽입
INSERT INTO member VALUES('152','1234','이병문','2016-05-23');
INSERT INTO member VALUES('admin','1234','이병문','2016-05-23');

INSERT INTO RESTAURANT 	values(4,'양식','삼환하이펙스A','김밥천국3',10,'01041953154','냉면전문점','냉면 갈비 등등');

INSERT INTO restaurantimage	values ('c:\java\교동1',4);
INSERT INTO restaurantimage	values ('c:\java\교동2',4);
INSERT INTO restaurantimage	values ('c:\java\교동3',4);
INSERT INTO restaurantimage	values ('c:\java\교동4',4);
INSERT INTO restaurantimage	values ('c:\java\교동5',4);

INSERT INTO review VALUES	(3 ,'152',1,'교동- ','2017-05-28' ,'ㅇㅇ','맛난다',1);

SELECT review_no_seq.nextval     FROM dual
