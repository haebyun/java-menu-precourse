package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Menu;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> enterCoachNames() {
        System.out.println();
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
            throw new IllegalArgumentException(
                    "[ERROR] 빈 문자열이 입력되었습니다."
            );
        }
    }

    private List<String> parseWithSeparator(String message) {
        return Arrays.stream(message.split(",")).toList();
    }

    public List<Menu> enterForbiddenMenus(String name) {
        System.out.println();
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        List<String> names = validateForbiddenMenus(Console.readLine());
        return names.stream()
                .map(menu -> Menu.from(menu))
                .toList();
    }


    private List<String> validateForbiddenMenus(String message) {
        List<String> names = validateUnsupportedSeparators(message);
        validateDuplicated(names);
        return names;
    }

    private List<String> validateUnsupportedSeparators(String message) {
        if (isInvalidSeparators(message)) {
            throw new IllegalArgumentException(
                    "[ERROR] 올바르지 않은 구분자 입력입니다."
            );
        }
        return parseWithSeparator(message);
    }

    private boolean isInvalidSeparators(String message) {
        return containsDuplicatedSeparators(message)
                || startsWithOrEndsWithSeparator(message);
    }

    private boolean startsWithOrEndsWithSeparator(String message) {
        return message.startsWith(",") || message.endsWith(",");
    }

    private boolean containsDuplicatedSeparators(String message) {
        return message.contains(",".repeat(2));
    }

    private void validateDuplicated(List<String> inputs) {
        if (isDuplicated(inputs)) {
            throw new IllegalArgumentException("[ERROR] 중복된 입력입니다.");
        }
    }

    private boolean isDuplicated(List<String> names) {
        List<String> distinctNames = names.stream()
                .distinct()
                .toList();

        return names.size() != distinctNames.size();
    }
}
