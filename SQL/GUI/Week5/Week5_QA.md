# Week5_QA: 실시간 질문 & 해설 정리 (상세 버전)

---

### ✅ Q1. `if(rating <> 'Not given', rating, null)`에서 `<>`는 뭐예요?
- `<>`는 SQL에서 '같지 않다'는 비교 연산자입니다. (`!=`와 동일한 의미)
- 즉, `rating`이 `'Not given'`이 **아닌 경우에만** 해당 값을 그대로 사용하고, 그렇지 않으면 `null`로 처리하여 평균에서 제외합니다.
```sql
avg(if(rating <> 'Not given', rating, null))
```

---

### ✅ Q2. `coalesce(b.age, 20)`는 어떤 용도인가요?
- `COALESCE()` 함수는 **NULL 값을 다른 기본값으로 대체**해주는 함수입니다.
- 위 예시에서는 `b.age`가 NULL이면 20으로 대체합니다.
```sql
coalesce(b.age, 20) AS "null 제거"
```
- 실무에서는 평균 계산이나 필터링 시 NULL로 인한 왜곡을 방지하기 위해 자주 사용합니다.

---

### ✅ Q3. `IF`와 `CASE WHEN`은 어떻게 다르나요?
- `IF(조건, 참일 때, 거짓일 때)`는 MySQL 전용의 간단한 조건문입니다.
- `CASE WHEN`은 SQL 표준 문법이며, 여러 조건을 처리할 수 있어 범용성과 가독성이 좋습니다.

예시 비교:
```sql
-- IF
IF(age >= 20, '성인', '미성년')

-- CASE WHEN
CASE 
  WHEN age < 13 THEN '어린이'
  WHEN age < 20 THEN '청소년'
  ELSE '성인'
END
```

---

### ✅ Q4. `count(1)`은 정확히 어떤 걸 세나요?
- `count(1)`은 해당 그룹에 **존재하는 모든 행의 개수**를 셉니다.
- `1`은 그냥 고정 상수로, 실제 어떤 컬럼 값을 세는 건 아닙니다.
- `count(*)`와 거의 동일하지만, `count(column)`과는 다릅니다 (`NULL` 제외 여부 차이).

---

### ✅ Q5. `GROUP BY`를 지우면 왜 1행만 나올까요?
- `GROUP BY`를 하지 않으면 모든 데이터가 하나의 그룹으로 간주됩니다.
- 따라서 `COUNT()` 같은 집계함수는 전체 행을 대상으로 한 번만 계산되어 **1행만 출력**됩니다.

---

### ✅ Q6. `MAX(IF(...))`에서 `MAX`는 왜 필요한가요?
- `IF(age = 10, cnt, 0)`은 해당 조건을 만족하는 값만 남깁니다.
- 하지만 `GROUP BY cuisine_type` 후에도 `age` 값이 여러 개 존재할 수 있으므로,
  - 조건에 맞는 **값 1개만 출력하려면 반드시 집계함수 `MAX()`를 감싸야** 합니다.
- 이 구조는 **Pivot View를 만들 때 표준처럼 사용**됩니다.

---

### ✅ Q7. `count(1)`이 셀렉트문에서 어떤 역할을 하나요?
- `GROUP BY gender, age_group`으로 그룹이 나뉘었을 때,
- `count(1)`은 **그 그룹에 속한 모든 행의 수**를 세는 것입니다.
- `1`은 그냥 "행 존재"를 의미하며, 컬럼 값을 직접 세는 게 아닙니다.

---

### ✅ Q8. `GROUP BY`와 `COUNT()`는 항상 같이 써야 하나요?
- `GROUP BY` 없이도 `COUNT()`는 사용할 수 있습니다.
```sql
SELECT COUNT(*) FROM orders;
```
- 이건 전체 행 수를 집계하며 1행만 나옵니다.
- 반대로 그룹별로 집계하려면 반드시 `GROUP BY`가 필요합니다.

---

### ✅ Q9. Pivot 쿼리 해석: `MAX(IF(gender = 'male', cnt_order, 0))`는 무슨 의미인가요?
- "현재 그룹 안에서 gender가 'male'이면 cnt_order 값을 가져오고, 아니면 0으로 대체한 다음,
  해당 값들 중 **최댓값 하나만 출력하라**는 의미입니다."
- 피벗 테이블에서 **행을 열로 변환**할 때 자주 사용하는 구문입니다.

---

### ✅ Q10. 음식 타입 × 연령대 Pivot View는 어떻게 만드나요?
- 내부 쿼리에서 `cuisine_type + age`로 주문건수를 집계하고,
- 외부 쿼리에서 각 age 구간별로 `IF(age = 10, cnt, 0)` 조건으로 나누고 `MAX()`로 열로 펼칩니다.

핵심 구조:
```sql
SELECT cuisine_type,
  MAX(IF(age=10, cnt, 0)) AS "10대",
  MAX(IF(age=20, cnt, 0)) AS "20대",
  ...
FROM (SELECT ...) t
GROUP BY cuisine_type
```

---

### ✅ Q11. 숙제 쿼리에서 `MAX`는 정확히 왜 필요한가요?
- `GROUP BY cuisine_type` 이후에도 내부적으로는 여러 `age` 값이 존재함
- `IF(age=10, cnt, 0)`은 조건에 해당하는 행을 여러 개 만들 수 있음
- **그래서 `MAX()`로 해당 그룹 내 값 중 하나만 가져와 열(Column)에 고정하는 것**

---

이상으로 Week5 실시간 Q&A 상세 정리를 마칩니다.
