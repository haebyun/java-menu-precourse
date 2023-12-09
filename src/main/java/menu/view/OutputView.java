package menu.view;

import menu.domain.*;

import java.util.HashMap;
import java.util.Map;

public class OutputView {
    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    private static final String START = "[ %s%s ]";
    private static final String ADDITION = " | %s";
    public void printRecommendResults(RecommendResult result) {
        System.out.println();
        System.out.println("메뉴 추천 결과입니다.");
        printDayOfWeek();
        printRecommendResult(result.recommends());

        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }

    private void printDayOfWeek() {
        String daysMessage = "";
        for(DayOfWeek day : DayOfWeek.values()) {
            daysMessage += toAddition(day.getName());
        }
        System.out.println(String.format(START, "구분", daysMessage));
    }

    private void printRecommendResult(Map<DayOfWeek, MenuResult> recommends) {
        String categories = "";
        Map<String, String> coachMenus = new HashMap<>();

        for(DayOfWeek day : DayOfWeek.values()) {
            MenuResult menuResult = recommends.get(day);
            MenuCategory menuCategory = menuResult.menuCategory();
            Map<String, Menu> menus = menuResult.menus();

            categories += toAddition(menuCategory.name());
            addCoachMenuMessage(coachMenus, menus);
        }

        printCategories(categories);
        printCoachMenus(coachMenus);
    }

    private void printCategories(String categories) {
        System.out.println(String.format(START, "카테고리", categories));
    }

    private void printCoachMenus(Map<String, String> coachMenus) {
        for(Map.Entry<String, String> entry : coachMenus.entrySet()) {
            String coach = entry.getKey();
            String menus = entry.getValue();
            System.out.println(String.format(START, coach, menus));
        }
    }

    private void addCoachMenuMessage(
            Map<String, String> coachMenus,
            Map<String, Menu> menus
    ) {
        for(Map.Entry<String, Menu> entry : menus.entrySet()) {
            String coach = entry.getKey();
            Menu menu = entry.getValue();

            String message = coachMenus.getOrDefault(coach, "");
            message += toAddition(menu.getMenu());
            coachMenus.put(coach, message);
        }
    }

    public String toAddition(String message) {
        return String.format(ADDITION, message);
    }
}
