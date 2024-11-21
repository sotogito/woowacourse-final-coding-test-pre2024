# java-calculator-precourse

### 주요 기능
- 쉼표, 콜론을 구분자로하여 문자열 숫자를 더한다.
- 커스텀 구분자를 지정할 경우 커스텀 구분자를 구분자로하여 문자열 숫자를 더한다.
### 세부 기능
- 공백인지 확인한다.
  - trim()을 사용하여 공백일 경우 0을 출력한다.
- 커스텀 구분자를 사용했는지 확인한다.
  - X : 기본 구분자를 기준으로 파싱한다.
  - O : 커스텀 구분자를 기준으로 파싱한다.
- 정수 리스트를 만든다.
- 리스트 값을 sum한다.

### 플로우
1. 식을 입력받는다.
2. 공백인지 확인한다 -> 0출력
3. 커스텀 구분자를 사용했는지 확인한다. + 유효검사
4. 정규식 캡쳐를 사용하여 구분자와 숫자를 분리한다.
5. 숫자를 더한다.

### 주의할 점
- "" 을 입력할 경우 0을 반환한다.
- 메타문자 문자에 주의한다. 이스케이프 문자를 하나 더 추가한다.
  - . ^ $ * + ? { } [ ] \ | ( )
- 정규식 캡쳐를 사용한다.
- 커스텀 구분자의 양식을 지켰다면 여러개 새용 가능하다. -" //;\n//*\n1;2;3
```java
String value = "//(.)\\\\n";
String input = Console.readLine();
Pattern pattern = Pattern.compile(value);
Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
      System.out.println(matcher.group(1));
}
```
### 유효검사
- 식
  - 정수 숫자인지
  - 양수인지
  - 지정한 구분자만 사용했는지
- 기본 구분자
  - 기본 구분자 외에 다른 구분자가 존재하는지
- 커스텀 구분자
  - 문자인지 - 문자열X
  - 양식을 잘 사용했는지
---
- BasicDelimiter(E)
- ~~CustomDelimiter - List<Char>~~

- ValueMatcher(커멘드) : 기본인지 커스텀인지
  - Parser
  - CalculateValue : 바로 저장한다.
    - List<Integer>

- Parser(i)
  - BasicDelimiterParser(impl)
  - CustomDelimiterParser(impl)


- Calculator(i)
  - AddCalculator(impl)
  


