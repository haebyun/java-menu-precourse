package menu.domain;

import java.util.Map;

public record MenuResult(
        MenuCategory menuCategory,
        Map<String, Menu> menus
) {
}
