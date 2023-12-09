package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Menu;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> enterCoachNames() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return validateCoachNames(Console.readLine());
    }

    private List<String> validateCoachNames(String message) {
        validateBlankInput(message);
        List<String> names = validateUnsupportedSeparators(message);
        validateDuplicated(names);
        return names;
    }

    private void validateBlankInput(String message) {
        if(message.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열이 입력되었습니다.");
        }
    }

    private List<String> validateUnsupportedSeparators(String message) {
        if (message.contains(",".repeat(2))
                || message.startsWith(",") || message.endsWith(",")) {
            throw new IllegalArgumentException("[ERROR] 올바르지 않은 구분자 입력입니다.");
        }
        return parseToList(message);
    }

    private List<String> parseToList(String message) {
        return Arrays.stream(message.split(",")).toList();
    }

    private void validateDuplicated(List<String> inputs) {
        if (isDuplicated(inputs)) {
            throw new IllegalArgumentException("[ERROR] 중복된 입력입니다.")
        }
    }

    private boolean isDuplicated(List<String> names) {
        List<String> distinctNames = names.stream()
                .distinct()
                .toList();

        return names.size() != distinctNames.size();
    }

    public List<Menu> enterForbiddenMenus() {
        System.out.println("토미(이)가 못 먹는 메뉴를 입력해 주세요.");


    }
}
