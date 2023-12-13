package menu;

import java.util.ArrayList;
import java.util.List;

public class Category {
    public enum Categories{
        JAPANESE("일식"), KOREAN("한식"), CHINESE("중식"), ASIAN("아시안"), WESTERN("양식");

        private static Categories[] list = Categories.values();
        private String name;
        Categories(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static String getNameByIndex(int index) {
            return list[index-1].getName();
        }
    }

    private final List<String> weekCategories;

    public Category() {
        this.weekCategories = new ArrayList<>();
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
