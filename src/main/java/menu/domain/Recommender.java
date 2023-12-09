package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.time.DayOfWeek;
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
        for(DayOfWeek day : DAYS) {
            MenuCategory menuCategory = selectCategory();
            result.put(
                    day,
                    recommendMenu(menuCategory)
            );
        }
        return new RecommendResult(result);
    }

    private MenuCategory selectCategory() {
        return MenuCategory.findByNumber(
            Randoms.pickNumberInRange(1, 5)
        );
    }

    private MenuResult recommendMenu(MenuCategory menuCategory) {
        Map<Coach, Menu> menus = new HashMap<>();
        for(Coach coach : coaches.getCoaches()) {
            menus.put(
                    coach,
                    selectRandomMenu(menuCategory.getMenusToStringList())
            );
        }
        return new MenuResult(menus);
    }

    private Menu selectRandomMenu(List<String> menus) {
        String menu = Randoms.shuffle(menus).get(0);
    }
}
