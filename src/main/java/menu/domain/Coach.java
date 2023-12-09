package menu.domain;

import java.util.List;

public class Coach {
    private String name;
    private List<Menu> forbiddenMenus;

    private Coach(String name, List<Menu> forbiddenMenus) {
        validateNameLength();
        this.name = name;
        this.forbiddenMenus = forbiddenMenus;
    }

    private void validateNameLength() {
        if(name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(
                    "[ERROR] 코치의 이름을 2글자 이상, 4글자 이하로 입력해주세요."
            );
        }
    }

    public static Coach from(String name, List<Menu> forbiddenMenus) {
        return new Coach(name, forbiddenMenus);
    }

}
