package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.validation.ValidateCoachName;
import menu.validation.ValidateHateMenu;

public class InputView {
    private static final String INPUT_COACHES_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String INPUT_HATE_MENU_MESSAGE = "(이)가 못 먹는 메뉴를 입력해 주세요.";


    public String[] getCoachesName() {
        System.out.println(INPUT_COACHES_NAME_MESSAGE);
        ValidateCoachName validateCoachName = new ValidateCoachName();
        String input;
        while (true) {
            input = Console.readLine();
            try {
                validateCoachName.validate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input.split(",");
    }

    public String[] getHateMenus(String coachName) {
        System.out.println(coachName+INPUT_HATE_MENU_MESSAGE);
        ValidateHateMenu validateHateMenu = new ValidateHateMenu();
        String input;
        while (true) {
            input = Console.readLine();
            try {
                validateHateMenu.validate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input.split(",");
    }
}
