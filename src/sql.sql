insert into test_customer values(1, 'admin', 'admin', '0000', '하다현', '01011119296', '2303110264@office.kopo.ac.kr',
00000, ' ', ' ', '123456', 1, 0, sysdate);
insert into test_customer values(202, 'k202', '', '0000', '하다현', '01026539296', 'ruhyeon_j@daum.net',
00000, ' ', '주소 미제공', 'RRN 미제공', 1, 0, sysdate);
select * from test_product_list;
insert into test_product_list
values(1, 1, 'Hi정기예금', '<b>제1조 은행의 책임</b><br>은행은 통장에 기록된 금액을 고객에게 현물로 지급하지 않는다.<br><br><b>제2조 개인정보 이용</br>은행은 고객의 개인정보가 유출되지 않도록 주의한다. 실수로 유출되었을 경우 고객은 은행에게 손해배상을 청구할 수 없다.', 4.5, 10000, 6, 1);
insert into test_product_list
values(2, 1, '내일부터적금', '<b>제1조 은행의 책임</b><br>은행은 통장에 기록된 금액을 고객에게 현물로 지급하지 않는다.<br><br><b>제2조 개인정보 이용</br>은행은 고객의 개인정보가 유출되지 않도록 주의한다. 실수로 유출되었을 경우 고객은 은행에게 손해배상을 청구할 수 없다.', 3.2, 100000, 12, 1);
insert into test_product_list
values(3, 1, '오예금', '<b>제1조 은행의 책임</b><br>은행은 통장에 기록된 금액을 고객에게 현물로 지급하지 않는다.<br><br><b>제2조 개인정보 이용</br>은행은 고객의 개인정보가 유출되지 않도록 주의한다. 실수로 유출되었을 경우 고객은 은행에게 손해배상을 청구할 수 없다.', 3.9, 50000, 6, 1);
commit;


CREATE TABLE TEST_CUSTOMER(
	CUSTOMER_ID NUMBER PRIMARY KEY
	, BANK_ID VARCHAR2(20) UNIQUE
	, PASSWORD VARCHAR2(256) 
	, CREDIT_PASSWORD VARCHAR2(256) 
	, NAME VARCHAR2(18) NOT NULL
	, PHONE_NUM VARCHAR2(13) NOT NULL UNIQUE
	, EMAIL VARCHAR2(30) NOT NULL
	, ZIP_CODE NUMBER(5) NOT NULL 
	, ADDRESS VARCHAR2(300) NOT NULL
	, ADDRESS_DETAIL VARCHAR2(300)
	, RRN VARCHAR2(13) NOT NULL UNIQUE
	, CUSTOMER_TYPE NUMBER(3) NOT NULL
	, AVAILABLE_BALANCE	NUMBER(15) NOT NULL
	, reg_date date NOT NULL
--	, CONSTRAINT FK_CUSTOMER_TYPE FOREIGN KEY(CUSTOMER_TYPE) REFERENCES TEST_CUSTOMER_TYPE(CUSTOMER_TYPE)
);


--CREATE TABLE TEST_EMPLOYEE(
--	EMPLOYEE_ID NUMBER PRIMARY KEY --직원번호
--	, BANK_ADMIN_ID VARCHAR2(20) UNIQUE --온라인뱅크 관리자ID
--	, PASSWORD VARCHAR2(256) 
--	, NAME VARCHAR2(13) NOT NULL
--	, EMAIL VARCHAR2(30) NOT NULL
--	, PHONE_NUM VARCHAR2(13) NOT NULL UNIQUE
--	, HIRE_DATE DATE DEFAULT sysdate NOT NULL
----	, JOB_ID VARCHAR2(15) NOT NULL
--);

CREATE TABLE TEST_PRODUCT_LIST(
	PRODUCT_NUM NUMBER(3) PRIMARY KEY
--	, PRODUCT_TYPE VARCHAR2(30) NOT NULL --예적금/대출 >> 예금/대출을 같은 테이블에서 관리 불가
	, PRODUCT_TARGET NUMBER(1) NOT NULL --가입대상 개인 및 법인(단체)
	, PRODUCT_NAME VARCHAR2(30) NOT NULL --상품명
	, DESCRIPTION VARCHAR2(600) NOT NULL --상품설명
	, INTEREST_RATE NUMBER(5,4) NOT NULL --금리
	, INITIAL_DEPOSIT NUMBER(15) NOT NULL --가입금액 또는 대출한도 >> 가입금액
	, DATE_OF_DEPOSIT NUMBER(2) NOT NULL --가입기간
--	, AVAILABLE DATE DEFAULT sysdate NOT NULL --신규가입 한도일자
	, AVAILABLE NUMBER(1) NOT NULL --신규가입 가능여부
);
	
CREATE TABLE CB_ACCOUNT(
	ACC_NUM NUMBER PRIMARY KEY
	, ACC_NAME VARCHAR2(21) NOT NULL
	, PRODUCT_NUM NUMBER(2) NOT NULL
	, CUSTOMER_ID NUMBER(8) NOT NULL
	, INTEREST_RATE NUMBER(5,4) NOT NULL
	, REG_DATE DATE DEFAULT sysdate NOT NULL
	, RET_DATE DATE NOT NULL
	, AVALIABLE NUMBER(1) NOT NULL
	, FOREIGN KEY(CUSTOMER_ID) REFERENCES TEST_CUSTOMER(CUSTOMER_ID)
	, FOREIGN KEY(PRODUCT_NUM) REFERENCES TEST_PRODUCT_LIST(PRODUCT_NUM)
);

CREATE TABLE CB_TRANSACTION(
  TRANSACTION_ID NUMBER PRIMARY KEY
	, TRANSACTION_TYPE VARCHAR2(8) NOT NULL
	, TRANSACTION_DATE TIMESTAMP NOT NULL
	, ACC_NUM NUMBER NOT NULL
	, TRAN_NAME VARCHAR2(21) NOT NULL
	, AMOUNT NUMBER(9) NOT NULL
	, AFTER_BALANCE NUMBER(16,2) NOT NULL -- double 한계치 (이자계산때문에 소수점권장)
	, CONSTRAINT FK_ACC_NUM FOREIGN KEY(ACC_NUM) REFERENCES CB_ACCOUNT(ACC_NUM)
);

CREATE SEQUENCE cb_tran_seq;