#### 메뉴 -> 싱글톤

- 카테고리 - Enum
    - Menu
- Restaurant - Enum 싱글톤 - EnumMap

- Category
- DecemberEvent(E) : 이벤트 종류 정의
- DayOfTheWeek(E) : 요일 : 주말, 평일을 정의한다.
- PlannerPrintPolicy(E) : <주문메뉴> 등등


- EventPlanner
    - 주문 메뉴
        - Cart
            - EnumMap<Category,List<Menu>>
    - total(E)
        - Wallet
            - total
            - totalDiscount
    - 혜택 내역 Map<Event,Integer>
    - 총 혜택 금액
    - 할인 후 예상 결제 금액
    - 12월 이벤트 배지

- Wallet
    - total
    - discount
- Cart
    - EnumMap<Category,List<Menu>>

#### 여기서부터

- DiscountCalculator(i)
- EventPolicy(i)
    - Event(impl)  : 꼭 상태가 같을 필요는 없잖아?
        - calculate
        - validate
- DiscountFinder

#### Service

- OrderService
    - Restaurant
    - Cart, Wallet, Calender 객체 생성
    - EventPlanner 반환

- DiscountService
    - EventPlanner 주입받음
    - DiscountFinder

#### 할인들의 공통 상태 - 행동x - Enum으로 정의 가능성

- 이름
- 시작일!끝일
- 할인 금액