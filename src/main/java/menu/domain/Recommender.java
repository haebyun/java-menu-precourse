package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommender {
    private final Coaches coaches;

    private Recommender(Coaches coaches) {
        this.coaches = coaches;
    }

    public static Recommender from(Coaches coaches) {
        return new Recommender(coaches);
    }

    public RecommendResult recommend() {
        Map<DayOfWeek, MenuResult> result = new HashMap<>();
        // cache Collections
        Map<String, List<Menu>> menuHistory = new HashMap<>();
        List<MenuCategory> categoryHistory = new ArrayList<>();
        for(DayOfWeek day : DayOfWeek.values()) {
            MenuCategory menuCategory = selectCategory(categoryHistory);
            result.put(
                    day,
                    recommendMenu(menuCategory, menuHistory)
            );
        }
        return new RecommendResult(result);
    }

    private MenuCategory selectCategory(List<MenuCategory> history) {
        while(true) {
            MenuCategory category = MenuCategory.findByNumber(
                    Randoms.pickNumberInRange(1, 5)
            );
            if(canSelectCategory(history, category)) {
                history.add(category);
                return category;
            }
        }
    }

    private boolean canSelectCategory(
            List<MenuCategory> history,
            MenuCategory target
    ) {
        long count = history.stream()
                .filter(category -> category.equals(target))
                .count();
        return count < 2;
    }

    private MenuResult recommendMenu(
            MenuCategory menuCategory,
            Map<String, List<Menu>> menuHistory
    ) {
        Map<String, Menu> menus = new HashMap<>();
        for(Coach coach : coaches.getCoaches()) {
            menus.put(
                    coach.getName(),
                    selectRandomMenu(
                            coach,
                            menuHistory,
                            menuCategory.getMenusToStringList())
            );
        }
        return new MenuResult(menuCategory, menus);
    }

    private Menu selectRandomMenu(
            Coach coach,
            Map<String, List<Menu>> menuHistory,
            List<String> menus
    ) {
        List<Menu> history = menuHistory.getOrDefault(coach.getName(), new ArrayList<>());
        while(true) {
            Menu menu = Menu.from(Randoms.shuffle(menus).get(0));
            if (coach.canEat(menu) && doesNotContain(history, menu)) {
                history.add(menu);
                menuHistory.put(coach.getName(), history);
                return menu;
            }
        }
    }

    private boolean doesNotContain(List<Menu> history, Menu menu) {
        return !history.contains(menu);
    }
}
