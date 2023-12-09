package menu.domain;

import java.time.DayOfWeek;
import java.util.Map;

public record RecommendResult(
    Map<DayOfWeek, MenuResult> recommends
) {
}
