package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Recommend {
    public String recommendCategory() {
        int number = Randoms.pickNumberInRange(1,5);
        return Menu.getCategoryNameByIndex(number);
    }

    public String recommendMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
