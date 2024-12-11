package domain;

import java.util.Objects;

public class Table {
    private final int number;

    public Table(final int number) {
        this.number = number;
    }

    public boolean isSame(int number) {
        return this.number == number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Table table = (Table) o;
        return Objects.equals(number, table.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
