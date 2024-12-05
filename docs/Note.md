##### 1. Service

- CoachHateMenuService 코치 못 먹는 음식 저장 + 코치 생성
- MenuScheduleService 메뉴 추천

##### 2. Enum

- Category
- Week - EnumMap<Week,List<Menu>> ??

---

##### 3. 입력 객체

- Coach
    - name
    - List<String> hateMenu : 서비스에 List<Coach> 보내고 하나씩 받아 저장하기
    - EnumMap<Week,MenuItem(메뉴)> :

- Coachs - List<Coach>

##### 4. 필요(생성) 객체

---

##### 5. Result 객체

- WeekMenuCategoryResult
    - EnumMap<Week,Category> : 한 주의 카테고리 선별
    - Map<Coach,List<MenuItem>>?????

##### 6. History 객체

❌
---

##### 7. Parser

- CoachParser
- HateMenuParser

##### 8. DTO

- CoachDto
- HateMenuDto

---

##### 9. Singleton

- Restaurant - EnumMap<Category,List<MenuItem>>

---

##### 10. Helper

---

##### 11. Policy 객체 (로직 객체)

- MenuItem
    - Category
    - name

---

- Reader
- Factory