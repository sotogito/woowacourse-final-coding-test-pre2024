package subway.domain.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import subway.domain.Line;

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
        hasDuplicates(lines(), line);
        baselines.add(line);
    }

    public void addLine(Line line) {
        hasDuplicates(lines(), line);
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public Optional<Line> findLineByName(String name) {
        for (Line line : lines()) {
            if (line.isSameName(name)) {
                return Optional.of(line);
            }
        }
        return Optional.empty();
    }

    public void hasDuplicates(List<Line> lines, Line newStation) {
        if (lines.contains(newStation)) {
            throw new IllegalArgumentException("이미 존재하는 노선입니다.");
        }
    }

}
