package menu.domain;

import java.util.Map;

public record MenuResult(
        Map<String, Menu> menus
) {
}
