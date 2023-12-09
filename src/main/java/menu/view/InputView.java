package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Menu;

import java.util.List;

public class InputView {

    public List<String> enterCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        List<String> names = validateCoachNames(Console.readLine());
    }

    private List<String> validateCoachNames(String message) {
        validateBlankInput(message);
        validateUnsupportedSeparators();
        validateDuplicated();
    }

    private void validateBlankInput(String message) {
        if(message.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열이 입력되었습니다.");
        }
    }

    public List<Menu> enterForbiddenMenus() {



    }
}
