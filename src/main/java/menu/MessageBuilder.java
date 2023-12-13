package menu;

import java.util.List;
import java.util.Map;

public class MessageBuilder {

    private static final String TOP_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String DISTINCT_MESSAGE = " | ";

    public String buildTopMessage(List<String> result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ 카테고리");
        result.forEach(category -> stringBuilder.append(DISTINCT_MESSAGE).append(category));
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
    public String buildResult(Map<String, List<String>> result) {
        StringBuilder stringBuilder = new StringBuilder();
        result.forEach((key, value) -> stringBuilder.append("[ ")
                .append(setMenu(key, value))
                .append("\n"));
        return stringBuilder.toString();
    }

    private String setMenu(String name, List<String> menus) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder menuBuilder = new StringBuilder();
        stringBuilder.append(name);
        for (String menu : menus) {
            menuBuilder.append(DISTINCT_MESSAGE)
                    .append(menu);
        }
        stringBuilder.append(menuBuilder.toString());
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }
}
