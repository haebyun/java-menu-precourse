package menu.domain;

import java.util.Map;

public record RecommendResult(
    Map<DayOfWeek, MenuResult> recommends
) {
}
