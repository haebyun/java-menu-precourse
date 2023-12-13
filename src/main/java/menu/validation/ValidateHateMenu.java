package menu.validation;

import menu.exception.InvalidCoachNameException;
import menu.exception.InvalidHateMenuException;

public class ValidateHateMenu {
    public void validate(String input) {
        if (!isEmpty(input)) {
            String[] splitInput = validateFormat(input);
            valiateHateMenusSize(splitInput);
        }
    }

    private boolean isEmpty(String input) {
        return input.isBlank();
    }

    private String[] validateFormat(String input) {
        String[] splitInput = input.split(",");
        if (splitInput.length > 0) {
            return splitInput;
        }
        throw new InvalidHateMenuException();
    }

    private void valiateHateMenusSize(String[] input) {
        if (input.length > 2) {
            throw new InvalidCoachNameException();
        }
    }

}
