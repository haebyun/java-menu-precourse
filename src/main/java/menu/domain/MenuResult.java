package menu.domain;

import java.util.Map;

public record MenuResult(
        Map<Coach, Menu> menus
) {
}
