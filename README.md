# WarehouseWebDB

# 전자상거래 주문과 물류센터 관리
<Objective of project>

이 프로젝트는 쿠팡(전자상거래 회사)의 로켓 배송(당일 배송)을 위해 자체적인 물류센터를 관리하는 것을 본 따서 만든 것이다.

여러 판매자들의 상품을 받아 물류센터에 입고시키고 저장한 다음, 고객의 주문이 들어오면 그 상품을 물류센터에서 출고하여 배송시키는 시스템이다. 원래는 입고할 때 직접 사람들이 상품을 그 장소에 집어넣는데, 나는 여기서 그것을 최대한 비슷하게 구현하기 위해 입고할 때 장소를 직접 선택하는 UI를 적용시켰다.


# DB Design

- ER Diagram

![image](https://user-images.githubusercontent.com/37825527/90023931-43bd5f00-dcef-11ea-8b12-5bfd55dafeb9.png)

1.	ORDER(고객의 주문) – 재고 수량이 있는 상품(PRODUCT)을 주문할 수 있다. 고객(CUSTOMER)이 주문을 하면 ORDER_LIST에 추가되고 상품의 개수는 주문한 만큼 줄어든다. ORDER_LIST의 PROCESS 는 기본적으로 ‘준비중’으로 추가된다.
2.	RELEASE(직원의 출고) – 고객의 주문 목록에 있는 상품들 중 한 상품을 출고하게 되면 PROCESS를 배송중으로 바꿔준다. 그리고 출고 처리한 주문을 출고 처리 목록(RELEASING)에 직원의 아이디와 같이 저장한다. 출고 처리 목록은 관리자만 볼 수 있다.
3.	WAREHOUSE(직원의 입고) – 물류 센터에 입고 처리를 기다리고 있는 목록(WAITING_LIST) 중 한 상품을 입고 처리 하면 PRODUCT에서 해당 물품의 수량이 증가한다. 그리고 입고 처리한 것을 입고 처리 목록(WAREHOUSE)에 직원의 아이디와 같이 저장한다. 입고 처리 목록은 관리자만 볼 수 있다.


- Relational Model

![image](https://user-images.githubusercontent.com/37825527/90024018-62235a80-dcef-11ea-8fb4-4e3f6c1ff688.png)

1.	EMPLOYEE – 직원의 ID, 비밀번호, 이름, 나이, 성별이다.
2.	CUSTOMER – 고객의 ID, 비밀번호, 이름, 나이, 성별, 주소이다.
3.	WAITING_LIST – 입고 처리를 기다리는 목록이다. ATTRIBUTE는 ID, 상품 ID, 수량이다.
4.	PRODUCT – 재고 상품이다. ATTRIBUTE는 상품 ID, 이름, 종류, 가격, 수량, 장소이다.
5.	ORDER_LIST – 주문 목록이다. ATTRIBUTE는 ID, 상품 ID, 고객 ID, 수량, 처리 상태이다.
6.	WAREHOUSE – 입고 처리 목록이다. ATTRIBUTE는 ID, 입고 ID, 상품 ID, 수량, 직원 ID이다.
7.	RELEASING – 출고 처리 목록이다. ATTRIBUTE는 ID, 출고 ID, 상품 ID, 수량, 직원 ID, 고객 ID이다.


# Implementation and Results

![image](https://user-images.githubusercontent.com/37825527/90024044-664f7800-dcef-11ea-8e6b-147f632c582d.png)

1.	고객(직원) 회원가입 – 아이디가 존재하는지 확인하고 없다면 회원가입 승인

![image](https://user-images.githubusercontent.com/37825527/90024102-75cec100-dcef-11ea-9e07-8c7d0ff51520.png)
![image](https://user-images.githubusercontent.com/37825527/90024698-22a93e00-dcf0-11ea-92ea-1345aec32987.png)

2.	고객 로그인 – 아이디와 비밀번호가 회원가입 할 때 저장했던 것들과 일치할 때 로그인 성공

![image](https://user-images.githubusercontent.com/37825527/90024772-3bb1ef00-dcf0-11ea-9b62-91c0b0dc8f98.png)
![image](https://user-images.githubusercontent.com/37825527/90024781-3eacdf80-dcf0-11ea-812b-1113d516bee7.png)

3.	고객(직원) 로그아웃은 세션을 종료시키고 메인 페이지로 돌아가고, 고객(직원) 회원 탈퇴는 DB에서 정보를 삭제하고 메인 페이지로 돌아간다. 굳이 스크린샷을 첨부하지는 않았다.
4.	고객 주문하기 & 주문 목록 – 재고 수량보다 많이는 주문하지 못한다. 주문을 하면 주문한 개수만큼 재고 수량이 줄어든다.

![image](https://user-images.githubusercontent.com/37825527/90024803-453b5700-dcf0-11ea-8bca-254e03673c19.png)
![image](https://user-images.githubusercontent.com/37825527/90024809-48364780-dcf0-11ea-8bdf-3e130d13cc71.png)
![image](https://user-images.githubusercontent.com/37825527/90024829-51bfaf80-dcf0-11ea-9465-26bd78a94909.png)
![image](https://user-images.githubusercontent.com/37825527/90024846-55ebcd00-dcf0-11ea-9c1b-744548bf940e.png)
![image](https://user-images.githubusercontent.com/37825527/90024854-584e2700-dcf0-11ea-9856-4127d3585387.png)

5.	직원 재고 목록 확인 – PRODUCT 목록을 확인한다.

![image](https://user-images.githubusercontent.com/37825527/90024882-600dcb80-dcf0-11ea-9e50-3f9667ebbc88.png)
![image](https://user-images.githubusercontent.com/37825527/90024894-62702580-dcf0-11ea-88dc-7e8e32358500.png)

6.	직원 입고하기 – 입고 대기 목록 중 하나를 입고 처리한다. 결과로는 해당 PRODUCT의 수량이 증가한다. 원래는 해당 상품의 장소가 아닌 다른 곳을 선택하면 오류가 나야 하지만 거기까지 구현하지는 못했다.

![image](https://user-images.githubusercontent.com/37825527/90024927-6a2fca00-dcf0-11ea-9d16-992f492cb0b3.png)
![image](https://user-images.githubusercontent.com/37825527/90024954-72880500-dcf0-11ea-9d89-6e30a97bdc1f.png)

7.	직원 출고하기 – 고객의 주문 목록 중 ‘배송중’이 아닌 것들이 출고 대기 목록이다. 출고 처리를 하면 ‘배송중’이 된다.

![image](https://user-images.githubusercontent.com/37825527/90024986-7d429a00-dcf0-11ea-9aeb-66c4e7640f51.png)
![image](https://user-images.githubusercontent.com/37825527/90025016-85023e80-dcf0-11ea-959c-2e73ed7a95fb.png)

8.	관리자 입고 처리 목록 – 직원들이 입고 처리한 목록을 본다.

![image](https://user-images.githubusercontent.com/37825527/90025041-8df31000-dcf0-11ea-89ec-42df733542fc.png)

9.	관리자 출고 처리 목록 – 직원들이 출고 처리한 목록을 본다.

![image](https://user-images.githubusercontent.com/37825527/90025086-9a776880-dcf0-11ea-8720-5082d6efa5fe.png)


* Eclipse(java ee), tomcat 8.5, java 1.8 환경에서 구현했습니다.
* Web content 폴더의 index.html을 실행시키시면 됩니다.
* MySql 쿼리문들은 src폴더(Java resources)의 DAO 클래스들의 안에 있습니다.
