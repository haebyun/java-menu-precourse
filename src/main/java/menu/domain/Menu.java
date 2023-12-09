package menu.domain;

public enum Menu {
    규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼,

    김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음,

    깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토_달걀볶음, 고추잡채,

    팟타이, 카오_팟, 나시고렝, 파인애플_볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜,

    라자냐, 그라탱, 뇨끼, 끼슈, 프렌치_토스트, 바게트, 스파게티, 피자, 파니니;

    public static Menu from(String target) {
        for (Menu menu : Menu.values()) {
            if (menu.name() == formatMenu(target)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(
                "[ERROR] 해당하는 메뉴가 없습니다."
        );
    }

    private static String formatMenu(String menu) {
        return menu.replace(' ', '_');
    }

    public String getMenu() {
        return replaceUnderBarToSpace(this.name());
    }

    private String replaceUnderBarToSpace(String name) {
        return name.replace('_', ' ');
    }
}