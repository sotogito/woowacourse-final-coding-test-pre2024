- 2호선: 교대역 - 강남역 - 역삼역
- 3호선: 교대역 - 남부터미널역 - 양재역 - 매봉역
- 신분당선: 강남역 - 양재역 - 양재시민의숲역

---

- Station
- Line

- StationRepository
    - List<Station>
    - 존재하는 역인지
- LineRepository
    - List<Line>
    - 존재하는 노선인지

- SubwayLine
    - Line
    - List<Station>
- SubwayMap
    - List<SubwayLine>

### Service

- StationService
    - Stations
        - have
        - add
        - delete

- LineService : 노선
    - SubwayMap
        - 라인 삭제
        - 라인 추가 add newLine
    - Stations
        - have~ 존재하는 역인지
    - Lines
        - have
        - add
        - delete

- SectionService : 구간
    - SubwayMap
        - 구간 추가
        - 구간 삭제
    - Stations : 역이 존재만하고 노선에 들어가있지 않는 경우도 있음
        - have~ 존재하는 역인지
    - Lines
        - 존재하는 라인인지

- SubwayPrintService

---

1. 역등록