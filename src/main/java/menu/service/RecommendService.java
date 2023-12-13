package menu.service;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Recommend;

import java.util.*;

public class RecommendService {

    private List<Coach> coaches;
    private Recommend recommend;
    private Category categories;

    public RecommendService() {
        this.coaches = new ArrayList<>();
        this.recommend = new Recommend();
        this.categories = new Category();
    }
    public Map<String, List<String>> getCoaches() {
        Map<String, List<String>> coachesInfo = new LinkedHashMap<>();
        for (Coach coach : coaches) {
            coachesInfo.put(coach.getName(),coach.getWeekMenus());
        }
        return coachesInfo;
    }
    public List<String> getCategories() {
        return categories.getWeekCategories();
    }

    public void setCoaches(String name, String[] hateMenu) {
        coaches.add(new Coach(name, hateMenu));
    }

    public void setCategories() {
        while (categories.getWeekCategories().size() < 5) {
            categories.setWeekCategories(recommend.recommendCategory());
        }
    }
    public void setCoachesMenus() {
        for (int index = 0; index < categories.getWeekCategories().size(); index++) {
            String category = categories.getWeekCategories().get(index);
            List<String> menus = Menu.getMenusByCategoryName(category);
            setWeekDayMenu(menus, index);
        }
    }

    private void setWeekDayMenu(List<String> menus, int index) {
        for (Coach coach : coaches) {
            while (coach.getWeekMenus().size() < index+1) {
                coach.setWeekMenus(recommend.recommendMenu(menus));
            }
        }
    }
}
