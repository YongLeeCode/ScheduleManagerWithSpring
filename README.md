# Schedule Manager!
일정을 관리해주는 프로그램을 위한 API

***
## 개요
>이 개인 프로젝트는 스파르타 부트캠프 Spring 6기의 세번째 과제인 일정 관리 앱을 만드는 과제입니다.
이 프로젝트는 단계별로 진행되었으며 branch로 순차적으로 변화하는 과정을 보실 수 있습니다.
이 개인 프로젝트의 목표는 레벨별 요구사항을 충족시키는 것이며, JDBC를 사용하여 Spring의 이해도를 높이기 위함입니다.

***
## 언어, 도구, 라이브러리
- [Postman](https://www.postman.com/)
- [Spring Boot](https://spring.io/) : v 3.4.3
- [MySQL](https://www.mysql.com/)

- Java
- JDBC
- Lombok

***
## 스프링으로 개발하면서 기본적으로 사용하거나 지키길 바라는 것들!

- Postman을 사용하여 API 실행 및 테스트 하기!
    - 이 프로젝트는 실제 웹사이트나 앱을 만드는 것이 목표가 아닌 API를 만드는 것에 목표로 하기 때문에 Postman만으로도 충분하다 생각한다.
- Controller에서 Entity를 그대로 반환하지 x
    - DTO에 담아서 반환 o
- ResponseEntity
    - ResponseEntity는 Spring Framework에서 제공하는 클래스 중 하나로 HTTP 요청(Request) 또는 응답(Response)에 해당하는 HttpHeader와 HttpBody를 포함하고 있는 클래스
    - HTTP 요청에 대한 응답을 처리할 때 해당 클래스를 사용하면 유연하고 편리하게 처리할 수 있으므로 적용

공통 조건:
- 예약 일정 작성, 예약 일정 수정, 예약 조회 시 반환 받은 일정 정보에 `비밀번호`는 제외
- 예약 일정 일정 수정, 삭제 시 선택한 일정의 `비밀번호`와 요청할 때 함께 보낸 `비밀번호`가 일치할 경우에만 가능
    - 비밀번호가 일치하지 않을 경우 적절한 오류 코드 및 메세지 반환
- `3 Layer Architecture` 에 따라 각 Layer의 목적에 맞게 개발
- CRUD 필수 기능은 모두 데이터베이스 연결 및 `JDBC` 를 사용해서 개발
    - 데이터베이스와의 연동을 위해 JDBC를 사용해보며, 기본적인 SQL 쿼리 작성과 데이터 관리 연습
    - 다음 과제에서 JPA를 사용할 예정

***
## Lv 0. API 명세 및 ERD 작성
[ERD는 블로그를 확인해주세요](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0)
### API 명세서
| 기능 이름       | Method | Url        | Request                                     | Response                | Status        |
|-------------|--------|------------|---------------------------------------------|-------------------------|---------------|
| 🔍 모든 일정 보기 | GET    | /task      |                                             | List<TaskInfo> | 200: 정상 조회    | 
| 🔍 한 일정 보기  | GET    | /task/{id} |                                             | TaskInfo                | 200: 정상 조회    |
| 📅 일정 만들기   | POST   | /task      | Parameter: password / RequestBody: TaskInfo |                         | 201: 정상 예약    |
| 🔨 일정 변경하기  | PUT    | /task{id}  | Parameter: password / RequestBody: TaskInfo |                         | 200: 정상 예약 변경 |
| ❌ 일정 취소하기   | DELETE | /task/{id} | Parameter: password                         |                         | 200: 정상 삭제    |

#### TaskInfo
~~~java
long id;
String title;
String content;
DateTime updatedAt;
String name;
~~~




- 추가사항 : 날짜 별로 어떻게 할건지