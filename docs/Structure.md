#### Service

- OrderService 재고 관리 - 아직 차감하지는 않는다.
- PromotionService : 프로모션 할인 : 여부를 입력받고 처리한다.

이쯤에서 재고 차감 OrderService로 다시

- DiscountService : 멤버십 할인
- ReceiptService : 영수증 출력

#### Enum

- ProductType : 일반, 프로모션
- PromotionType : 그냥 종류만 선언
- Answer

---

#### 입력 객체

- Cart
    - EnumMap<ProductType,List<Product>>
        - Order
            - Product
            - Quantity

#### 필요(생성)객체

- Product
- Promotion

---

#### Result 객체

- Receipt
    - Cart
    - Map<Product,Integer> 증정 상품 내역

    - totalPurchaseAmount
    - eventDiscountAmount
    - membershipDiscountAmount
    - finalAmount

#### History 객체

❌

---

#### Parser

- OrderParser - List<메뉴-수량>

#### Dto

- InputOrderDto : 메뉴-수량

---

#### Singleton

- Storeroom
    - EnumMap<ProductType,List<Product>>

#### Helper

- PromotionProductFinder(i)
    - NotApplicableProductFinder : 프로모션 적용 상품을 찾아냄 -> List<Order> 반환
    - AddableProductFinder : 프로모션 상품 추가 가능 상품을 찾아냄

#### Policy 객체

- Promotion
    - name(E)

---

#### Reader

#### Factory