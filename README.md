# 사용자 관리 API 프로젝트

이 프로젝트는 Spring Boot를 사용하여 사용자 관리 기능을 구현한 CRUD API 예제입니다. JPA Custom Repository와 QueryDSL을 활용하여 조회 로직을 구현했으며, Postman을 사용하여 API 테스트를 진행했습니다.

## 프로젝트 개요

- **언어 및 프레임워크**: Java, Spring Boot
- **빌드 도구**: Maven
- **데이터베이스**: MySQL
- **기술 스택**: Spring Data JPA, JPA Custom Repository, QueryDSL, Lombok, Postman

---

## 주요 기능

1. **사용자 추가**: 새로운 사용자를 생성합니다.
2. **사용자 조회**:
   - ID를 기준으로 사용자 상세 조회
   - 모든 사용자 목록 조회
   - QueryDSL을 사용하여 조건별 사용자 조회
3. **사용자 수정**: 사용자 정보를 업데이트합니다.
4. **사용자 삭제**: 특정 사용자를 삭제합니다.

---

## API 명세서

### 사용자 추가
- **URL**: `POST /api/users`
- **Request Body**:
  ```json
  {
    "name": "홍길동",           // 필수, 1~50자 이내
    "email": "hong@example.com", // 필수, 유효한 이메일 형식
    "address": "서울",           // 선택, 1~100자 이내
    "membership": 1,             // 필수, 1(일반유저) 또는 2(멤버쉽)
    "status": 1                  // 필수, 1(정상), 2(휴면), 3(밴)
  }
  ```

#### 성공 응답:
```json
{
  "id": 1,
  "name": "홍길동",
  "email": "hong@example.com",
  "address": "서울",
  "membership": 1,
  "status": 1,
  "createdAt": "2025-01-02T12:34:56"
}
```

#### 실패 응답:
```json
{
  "timestamp": "2025-01-02T12:35:00",
  "status": 400,
  "error": "Bad Request",
  "message": "name은 필수 항목입니다.",
  "path": "/api/users"
}
```

---

### 추가 고려 사항

#### 1. **Validation 규칙 명시**
- `name`: 1~50자 이내, 공백 불가
- `email`: 이메일 형식이어야 함
- `membership`: 1 또는 2만 허용
- `status`: 1~3만 허용

#### 2. **추가 가능한 Request Body 필드**
필요 시 추가적인 정보도 처리할 수 있습니다. 예를 들어:

```json
{
  "phoneNumber": "010-1234-5678", // 선택, 10~13자 이내
  "birthDate": "1990-01-01"       // 선택, yyyy-MM-dd 형식
}
```

#### 3. **상태 코드**
| 상태 코드 | 설명                           |
|-----------|--------------------------------|
| 201       | 생성 성공                      |
| 400       | 유효성 검증 실패               |
| 401       | 인증 실패                      |
| 404       | 리소스 찾을 수 없음            |
| 500       | 서버 내부 오류                 |

---

위와 같은 사항을 추가로 고려하여 API를 설계 및 구현하면 명확하고 실용적인 문서가 완성됩니다.

