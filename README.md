# 사용자 관리 API 프로젝트

이 프로젝트는 Spring Boot를 사용하여 사용자 관리 기능을 구현한 CRUD API 예제입니다. JPA Custom Repository와 QueryDSL을 활용하여 복잡한 조회 로직을 구현했으며, Postman을 사용하여 API 테스트를 진행했습니다.

## 프로젝트 개요

- **언어 및 프레임워크**: Java, Spring Boot
- **빌드 도구**: Maven
- **데이터베이스**: MySQL
- **기술 스택**: Spring Data JPA, QueryDSL, Lombok, Postman

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
    "name": "홍길동",
    "email": "hong@example.com",
    "address": "서울",
    "membership": 1,
    "status": 1
  }
