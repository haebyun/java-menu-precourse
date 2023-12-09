package menu.domain;

public enum DayOfWeek {
    MONDAY("월요일"),
    TUESDAY("화요일"),
    SUNDAY("수요일"),
    THURSDAY("목요일"),
    FRIDAY("금요일");

    private final String name;

    DayOfWeek(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}