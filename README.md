# Database_2024_1
데베 팀 프로젝트: java와 SQL연동
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
How to execute
- 메인함수가 들어있는 클래스 : UserInterface.java 
- printTable버튼: 테이블 출력 버튼
	1. 프린트하고 싶은 테이블을 선택
	2. printTable버튼 클릭
- clearResult버튼: 출력창 클리어 버튼
- Insert버튼: insert 기능
	1. Insert하고싶은 테이블을 선택
	2. Insert버튼 클릭
	3. 콘솔창에 요구사항 입력
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
https://yoon990.tistory.com/58 <- 참고 블로그

ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
코더지시사항
0. main브랜치에서 본인 브랜치파기
1. 본인 mysql에서 데이터베이스 생성 & create.sql과 init.sql실행
2. UrlUserPassword 클래스에서 본인의 url, user, password에 맞게 수정 
//본인 user 확인: mySql에서 select user(); 로 확인가능
3. dao클래스에 메소드 추가
4. main문에서 버튼 이벤트 메소드에 dao클래스의 메소드 호출
5. 기능 완성하면 main에 merge