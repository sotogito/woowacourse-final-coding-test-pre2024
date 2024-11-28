package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LineRepository {
    private static final List<Line> baselines = new ArrayList<>();
    private static final List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        List<Line> allLines = new ArrayList<>();
        allLines.addAll(baselines);
        allLines.addAll(lines);
        return Collections.unmodifiableList(allLines);
    }

    public void addBaseline(Line line) {
        hasDuplicates(baselines, line);
        baselines.add(line);
    }

    public void addLine(Line line) {
        hasDuplicates(lines, line);
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public void hasDuplicates(List<Line> lines, Line newStation) {
        Set<Line> set = new HashSet<>(lines);
        if (!set.add(newStation)) {
            throw new IllegalArgumentException("이미 존재하는 노선입니다.");
        }
    }

}
