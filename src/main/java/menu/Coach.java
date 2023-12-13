package menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coach {
    private String name;
    private String[] hateMenus;
    private List<String> weekMenus;

    public Coach(String name) {
        this.name  = name;
        this.weekMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getWeekMenus() {
        return weekMenus;
    }

    public void setHateMenus(String[] menus) {
        this.hateMenus = menus;
    }

    public void setWeekMenus(String menu) {
        if (isUnderFive() && !isDuplicatedMenu(menu) && isNotHateFood(menu)) {
            weekMenus.add(menu);
        }
    }

    private Boolean isUnderFive() {
        return weekMenus.size()<5;
    }

    private Boolean isDuplicatedMenu(String menu) {
        return weekMenus.contains(menu);
    }

    private Boolean isNotHateFood(String menu) {
        List<String> hateList = Arrays.stream(hateMenus)
                .filter(hate -> !hate.equals(menu))
                .distinct()
                .toList();
        return hateList.size() == hateMenus.length;
    }
}
