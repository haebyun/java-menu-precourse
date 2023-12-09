package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<Menu> forbiddenMenus;

    private Coach(String name, List<Menu> forbiddenMenus) {
        validateMenuSize(forbiddenMenus);
        this.name = name;
        this.forbiddenMenus = forbiddenMenus;
    }

    private void validateMenuSize(List<Menu> menus) {
        if(menus.size() < 0 || menus.size() > 2) {
            throw new IllegalArgumentException(
                    "[ERROR] 메뉴의 개수를 0개 이상, 2개 이하로 입력해주세요."
            );
        }
    }

    public static Coach from(String name, List<Menu> forbiddenMenus) {
        return new Coach(name, forbiddenMenus);
    }

    public boolean canEat(Menu menu) {
        return !forbiddenMenus.contains(menu);
    }

    public String getName() {
        return this.name;
    }
}
