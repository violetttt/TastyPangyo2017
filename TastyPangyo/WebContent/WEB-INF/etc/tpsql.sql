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
	
DROP TABLE 	restaurant_image;
CREATE TABLE 	restaurant_image(
					image						VARCHAR2(100) 	NOT NULL,
					restaurant_id				NUMBER				NOT NULL,
CONSTRAINT	restaurant_image_fk	FOREIGN KEY(restaurant_id) REFERENCES  restaurant ON DELETE CASCADE
					);
				
DROP TABLE 	review;
CREATE TABLE 	review (
					review_no      		NUMBER(5)      		PRIMARY KEY,
					member_id      		VARCHAR2(50)  		NOT NULL,
					restaurant_id   		NUMBER(6)      		NOT NULL,
					restaurant_name   	VARCHAR2(100)   	NOT NULL,
					registered_date   	DATE        			NOT NULL,
					title         			VARCHAR2(120)   	NOT NULL,
					comments      		VARCHAR2(1000)   	NOT NULL,
					kostar         		NUMBER(2)      		NOT NULL,   
CONSTRAINT   review_restaurant_fk   FOREIGN   KEY   (restaurant_id)   REFERENCES restaurant ON DELETE CASCADE,														
CONSTRAINT   review_member_fk      FOREIGN KEY (member_id)      REFERENCES member ON DELETE CASCADE
					);

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
DROP sequence review_no;


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

INSERT INTO RESTAURANT values(6,'양식','삼환하이펙스A','김밥천국3',10,'01041953154','냉면전문점','냉면 갈비 등등');
INSERT INTO RESTAURANT values(1,'중식','삼환하이펙스','이츠',20,'01041841109','냉면전문점','냉면 갈비 등등');
INSERT INTO RESTAURANT values(2,'한식','유스페이스1','청년다방',50,'01052651244','냉면전문점','냉면 갈비 등등');
INSERT INTO RESTAURANT values(3,'분식','H스퀘어','신기소',100,'01041953154','냉면전문점','냉면 갈비 등등');
INSERT INTO RESTAURANT values(5,'기타','유스페이스2','고메부인',70,'01041953154','냉면전문점','냉면 갈비 등등');

insert into member values('shh', '000', '서현화', '2017,05,01');
insert into member values('lbm', '111', '이병문', '2017,05,01');
insert into member values('lsh', '222', '이승헌', '2017,05,01');
insert into member values('jgh', '555', '장규현', '2017,05,01');
insert into member values('sey', '777', '성은영', '2017,05,01');

insert into member values('admin', 'java', '관리자', '2017,01,01');


INSERT INTO restaurant_image	values ('새마을식당',2);
INSERT INTO restaurant_image	values ('새마을식당',2);
INSERT INTO restaurant_image	values ('새마을식당1',2);
INSERT INTO restaurant_image	values ('브루클린2',1);
INSERT INTO restaurant_image	values ('브루클린1',1);

INSERT INTO review VALUES	(3 ,'152',1,'교동- ','2017-05-28' ,'ㅇㅇ','맛난다',1);

DELETE FROM member WHERE visit_date < '2017,05,20'

SELECT    restaurant_id,
			 food_category,
			 location,
			 restaurant_name,
			 hits,
			 restaurant_tel_num,
			introduction
	FROM   restaurant
	ORDER BY hits
	
	SELECT  r.restaurant_id,
			 r.food_category,
			 r.location,
			 r.restaurant_name,
			 r.hits,
			 r.restaurant_tel_num,
			r.introduction,
			i.image
	FROM   restaurant r, restaurant_image i
	WHERE	r.restaurant_id = i.restaurant_id(+)
	ORDER BY r.hits
	
	
	
	SELECT	avg(v.kostar),
			v.restaurant_id,
			r.food_category,
			r.location,
			r.restaurant_name,
			r.hits,
			r.restaurant_tel_num,
			r.introduction,
			i.image
	FROM REVIEW v, RESTAURANT r, RESTAURANT_IMAGE i
	WHERE v.restaurant_id=r.restaurant_id 
	AND r.restaurant_id=i.restaurant_id(+)
	GROUP BY v.restaurant_id,
			r.food_category,
			r.location,
			r.restaurant_name,
			r.hits,
			r.restaurant_tel_num,
			r.introduction,
			i.image
	ORDER BY AVG(v.kostar) DESC
