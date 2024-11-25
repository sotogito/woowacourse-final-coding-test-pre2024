- VendingMachine
    - EnumMap<Coin,Integer> : 잔돈 스스로 생성

- RandomCoinMaker : 랜덤 동전을 생성한다.
- ReturnChangeMachine : 잔돈을 계산한다.

- vendingMachine
- Wallet

- Products
    - Product

- ProductParser

---

- Product
    - name
    - price
    - quantity

- ProductParser

- VendingMachineService :
    - vendingMachine(DI)
        - Wallet
        - EnumMap<Coin,Integer>
        - Products
    - RandomCoinMaker


- OrderService : 구매 서비스
    - vendingMachine
    - Cart
    - Wallet
    - 컨트롤러에서 Wallet 만들어서 넘기기
    - 컨트롤러에서 orderParser로 List<Order>만들어서 넘기기
- returnChangeService
    - vendingMachine
    - Wallet

---