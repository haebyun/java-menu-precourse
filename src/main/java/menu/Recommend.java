package menu;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Recommend {
    public String recommendCategory() {
        int number = Randoms.pickNumberInRange(1,5);
        return Category.Categories.getNameByIndex(number);
    }

    public String recommendMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }
}
