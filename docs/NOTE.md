- Lotto
- UserLotto
- ComputerLotto

- LottoNumberParser - String input -> List<Integer>

- Rank(E)

- LottoMachine(i)
    - ComputerLottoMachine(impl)

- Wallet
    - 구매 가격
    - 수익률


- Ticket(i)
    - TicketImpl(impl)
        - count : 1개씩 줄여서 생성

### 서비스

- Wallet
- UserLotto

- LottoStoreService
    - Wallet
    - Ticket
    - ComputerLotto
    - UserLotto

    1. 금액을 입력받고 Wallet을 생성하고 티켓을 객체를 생성한다.
    2. 티켓 개수대로 컴퓨터 랜덤 로또를 생성한다.
    3. 사용자의 로또를 입력받고 UserLotto를 생성한다.
    4. LottoMatcher를 넘겨 ComputerLotto에서 매칭한다.

- MatchingService

