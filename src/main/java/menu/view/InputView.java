package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Menu;

import java.util.ArrayList;
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
        validateNamesLength(names);
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

    private void validateNamesLength(List<String> names) {
        for(String name : names) {
            validateNameLength(name);
        }
    }

    private void validateNameLength(String name) {
        if(name.length() < 2 || name.length() > 4) {
            throw new IllegalArgumentException(
                    "[ERROR] 코치의 이름을 2글자 이상, 4글자 이하로 입력해주세요."
            );
        }
    }

    /**
     * 코치가 먹지 못하는 메뉴를 입력받는 메서드
     * @param name 코치 이름
     * @return 먹지 못하는 메뉴의 리스트
     */
    public List<Menu> enterForbiddenMenus(String name) {
        System.out.println();
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        List<String> names = validateForbiddenMenus(Console.readLine());
        return names.stream()
                .map(menu -> Menu.from(menu))
                .toList();
    }


    private List<String> validateForbiddenMenus(String message) {
        if(message.isBlank()) {
            return new ArrayList<>();
        }
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
