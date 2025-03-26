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

- Validation
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
## Github & Blog
[깃헙 Lv.0](https://github.com/YongLeeCode/ScheduleManagerWithSpring/tree/lv.0)  
[블로그 Lv.0](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0)

[깃헙  Lv.1](https://github.com/YongLeeCode/ScheduleManagerWithSpring/tree/lv.1)  
[블로그 Lv.1](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv-1)

[깃헙  Lv.2](https://github.com/YongLeeCode/ScheduleManagerWithSpring/tree/lv.2)  
[블로그 Lv.2](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv-2)

[깃헙  Lv.3](https://github.com/YongLeeCode/ScheduleManagerWithSpring/tree/lv.3)  
[블로그 Lv.3](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv-3)

[깃헙  Lv.4](https://github.com/YongLeeCode/ScheduleManagerWithSpring/tree/lv.4)  
[블로그 Lv.4](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv-4)

[깃헙  Lv.5](https://github.com/YongLeeCode/ScheduleManagerWithSpring/tree/lv.5)  
[블로그 Lv.5](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv-5)

[깃헙  Lv.6](https://github.com/YongLeeCode/ScheduleManagerWithSpring/tree/lv.6)  
[블로그 Lv.6](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0-Lv-6)

***
## Lv 0. API 명세 및 ERD 작성
[ERD는 블로그를 확인해주세요](https://velog.io/@yong-lee/Spring-%EC%9D%BC%EC%A0%95-%EA%B4%80%EB%A6%AC-API-%EB%A7%8C%EB%93%A4%EA%B8%B0)
## API 명세서
자세한 명세서는 [(Spring) 일정 관리 API 만들기 Lv 0](https://velog.io/write?id=3c86f10d-14ab-4a40-8fb4-a46a4ee09fd4)에서 확인해주세요.
### Task domain
| 기능 이름           | Method | URL | Path Variable | Parameter | Request Body | Response | Status |
|-----------------|--------| --- | --- | --- | --- | --- | --- |
| 📅 일정 만들기       | POST   | `/tasks`  |  |  | `TaskRequestDto` | id | `201 Created` (정상 작성) |
| 🔍 모든 일정 보기|  GET   | `/tasks` |  | page |  | `List<TaskResponseDto>`  | `200 OK` (정상 조회) |
| 🔍 특정 일정 보기| GET    | `/tasks/{id}`  | id |  |  | `TaskResponseDto`  | `200 OK` (정상 조회) | 
| 🔨 일정 변경하기 | PATCH  | `/tasks/{id}`  | id | password | `TaskRequestDto` | id | `200 OK` (정상 수정) |
| ❌ 일정 취소하기 | DELETE | `/tasks/{id}`  | id | password |  | id | `200 OK` (정상 삭제) | 

### User domain
| 기능 이름 | Method | URL | Path Variable | Parameter | Request Body | Response | Status |
| --- | --- | --- | --- | --- | --- | --- | --- |
| 📅 가입하기 | POST | `/users`  |  |  | `UserRequestDto` |  | `201 Created` (정상 가입) |
| 🔍 유저 정보 보기 | GET | `/users/{id}` | id |  |  | `UserResponseDto`  | `200 OK` (정상 조회) |
| 🔨 유저 정보 수정 | PATCH | `/users/{id}`  | id | password | `UserRequestDto` | id | `200 OK` (정상 수정) |
| ❌ 회원 탈퇴하기 | DELETE | `/users/{id}`  | id | password |  | id | `200 OK` (정상 삭제) | 

***
## Lv 1. 일정 생성 및 조회

- [ ]  **일정 생성(일정 작성하기)**
   - [ ]  일정 생성 시, 포함되어야할 데이터
      - [ ]  `할 일`, `작성자명`, `비밀번호`, `작성/수정일`을 저장
   - [ ]  `작성/수정일`은 날짜와 시간을 모두 포함한 형태
   - [ ]  각 일정의 고유 식별자(ID)를 자동으로 생성하여 관리
   - [ ]  최초 입력 시, 수정일은 작성일과 동일
  
- [ ]  **전체 일정 조회(등록된 일정 불러오기)**
   - [ ]  다음 **조건**을 바탕으로 등록된 일정 목록을 전부 조회
      - [ ]  `수정일` (형식 : YYYY-MM-DD)
      - [ ]  `작성자명`
   - [ ]  조건 중 한 가지만을 충족하거나, 둘 다 충족을 하지 않을 수도, 두 가지를 모두 충족할 수도 있습니다.
   - [ ]  `수정일` 기준 내림차순으로 정렬하여 조회
  
- [ ]  **선택 일정 조회(선택한 일정 정보 불러오기)**
   - [ ]  선택한 일정 단건의 정보를 조회할 수 있습니다.
   - [ ]  일정의 고유 식별자(ID)를 사용하여 조회합니다.

***
## Lv 2. 일정 수정 및 삭제 

- [ ]  **선택한 일정 수정**
   - [ ]  선택한 일정 내용 중 `할일`, `작성자명` 만 수정 가능
      - [ ]  서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.
      - [ ]  `작성일` 은 변경할 수 없으며, `수정일` 은 수정 완료 시, 수정한 시점으로 변경합니다.
- [ ]  **선택한 일정 삭제**
   - [ ]  선택한 일정을 삭제할 수 있습니다.
      - [ ]  서버에 일정 수정을 요청할 때 `비밀번호`를 함께 전달합니다.

***
## Lv 3. 연관 관계 설정 

- [ ]  **작성자와 일정의 연결**
   - [ ]  설명
      - [ ]  동명이인의 작성자가 있어 어떤 작성자가 등록한 ‘할 일’인지 구별할 수 없음
      - [ ]  작성자를 할 일과 분리해서 관리합니다.
      - [ ]  작성자 테이블을 생성하고 일정 테이블에 FK를 생성해 연관관계를 설정해 봅니다.
   - [ ]  조건
      - [ ]  작성자 테이블은 `이름` 외에 `이메일`, `등록일`, `수정일` 정보를 가지고 있습니다.
         - [ ]  작성자의 정보는 추가로 받을 수 있습니다.(조건만 만족한다면 다른 데이터 추가 가능)
      - [ ]  작성자의 고유 식별자를 통해 일정이 검색이 될 수 있도록 전체 일정 조회 코드 수정.
      - [ ]  작성자의 고유 식별자가 일정 테이블의 외래키가 될 수 있도록 합니다.

***
## Lv 4. 페이지네이션

- [ ]  설명
   - [ ]  많은 양의 데이터를 효율적으로 표시하기 위해 데이터를 여러 페이지로 나눕니다.
      - [ ]  `페이지 번호`와 `페이지 크기`를 쿼리 파라미터로 전달하여 요청하는 항목을 나타냅니다.
      - [ ]  전달받은 페이지 번호와 크기를 기준으로 쿼리를 작성하여 필요한 데이터만을 조회하고 반환
- [ ]  조건
   - [ ]  등록된 일정 목록을 `페이지 번호`와 `크기`를 기준으로 모두 조회
   - [ ]  조회한 일정 목록에는 `작성자 이름`이 포함
   - [ ]  범위를 넘어선 페이지를 요청하는 경우 빈 배열을 반환
   - [ ]  Paging 객체를 활용할 수 있음

***
## Lv 5. 예외 발생 처리

- [ ]  설명
   - [ ]  예외 상황에 대한 처리를 위해 [HTTP 상태 코드](https://developer.mozilla.org/ko/docs/Web/HTTP/Status)와 `에러 메시지`를 포함한 정보를 사용하여 예외를 관리할 수 있습니다.
      1. 필요에 따라 사용자 정의 예외 클래스를 생성하여 예외 처리를 수행할 수 있습니다.
      2. `@ExceptionHandler`를 활용하여 공통 예외 처리를 구현할 수도 있습니다.
      3. 예외가 발생할 경우 적절한 HTTP 상태 코드와 함께 사용자에게 메시지를 전달하여 상황을 관리합니다.

- [ ]  조건
   - [ ]  수정, 삭제 시 요청할 때 보내는 `비밀번호`가 일치하지 않을 때 예외가 발생합니다.
   - [ ]  선택한 일정 정보를 조회할 수 없을 때 예외가 발생합니다.
      1. 잘못된 정보로 조회하려고 할 때
      2. 이미 삭제된 정보를 조회하려고 할 때

***
## Lv 6. null 체크 및 특정 패턴에 대한 검증 수행

- [ ]  설명
   - [ ]  유효성 검사
      1. 잘못된 입력이나 요청을 미리 방지할 수 있습니다.
      2. 데이터의 `무결성을 보장`하고 애플리케이션의 예측 가능성을 높여줍니다.
      3. Spring에서 제공하는 `@Valid` 어노테이션을 이용할 수 있습니다.
- [ ]  조건
   - [ ]  `할일`은 최대 200자 이내로 제한, 필수값 처리
   - [ ]  `비밀번호`는 필수값 처리
   - [ ]  담당자의 `이메일` 정보가 형식에 맞는지 확인
