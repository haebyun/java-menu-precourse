package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Recommender {
    private static final List<DayOfWeek> DAYS = List.of(
                DayOfWeek.MONDAY,
                DayOfWeek.TUESDAY,
                DayOfWeek.SUNDAY,
                DayOfWeek.THURSDAY,
                DayOfWeek.FRIDAY
    );
    private final Coaches coaches;

    private Recommender(Coaches coaches) {
        this.coaches = coaches;
    }

    public static Recommender from(Coaches coaches) {
        return new Recommender(coaches);
    }

    public RecommendResult recommend() {
        Map<DayOfWeek, MenuResult> result = new HashMap<>();
        // cache
        Map<String, List<Menu>> menuHistory = new HashMap<>();
        List<MenuCategory> categories = new ArrayList<>();
        for(DayOfWeek day : DAYS) {
            MenuCategory menuCategory = selectCategory(categories);
            result.put(
                    day,
                    recommendMenu(menuCategory, menuHistory)
            );
        }
        return new RecommendResult(result);
    }

    private MenuCategory selectCategory(List<MenuCategory> categories) {

        while(true) {
            MenuCategory category = MenuCategory.findByNumber(
                    Randoms.pickNumberInRange(1, 5)
            );
            if(canSelectCategory(categories, category)) {
                categories.add(category);
                return category;
            }
        }
    }

    private boolean canSelectCategory(
            List<MenuCategory> categories,
            MenuCategory target
    ) {
        long count = categories.stream()
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
        return new MenuResult(menus);
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
