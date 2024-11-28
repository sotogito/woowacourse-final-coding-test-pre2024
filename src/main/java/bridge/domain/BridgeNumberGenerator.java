package bridge.domain;

@FunctionalInterface //note 인터페이스에 하나의 추상메서드만 가질 수 있음
public interface BridgeNumberGenerator {

    int generate();
}
