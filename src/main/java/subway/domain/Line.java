package subway.domain;

import java.util.Objects;

public class Line implements Comparable<Line> {
    private final String name;

    public Line(String name) {
        validateNameSize(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isSameName(String name) {
        return this.name.equals(name);
    }

    private void validateNameSize(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException("2글자 이상 입력 가능합니다.");
        }
    }


    @Override
    public int compareTo(Line o) {
        return this.name.compareTo(o.name);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
