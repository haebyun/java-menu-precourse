package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Category {


    private final List<String> weekCategories;

    public Category() {
        this.weekCategories = new ArrayList<>();
    }

    public List<String> getWeekCategories() {
        return weekCategories;
    }

    public void setWeekCategories(String category) {
        if (weekCategories.size() < 5) {
            if (!isOverThreeTimes(category)) {
                weekCategories.add(category);
            }
        }
    }

    private Boolean isOverThreeTimes(String category) {
        long count = weekCategories.stream()
                .filter(origin -> origin.equals(category))
                .count();
        return count >= 2;
    }
}
