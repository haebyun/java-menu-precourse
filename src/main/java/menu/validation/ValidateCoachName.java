package menu.validation;

import menu.exception.InvalidCoachNameException;

import java.util.Arrays;

public class ValidateCoachName {
    public void validate(String input) {
        String[] splitInput = validateFormat(input);
        validateNameLength(splitInput);
        valiateCoachSize(splitInput);
    }

    private String[] validateFormat(String input) {
        String[] splitInput = input.split(",");
        if (splitInput.length > 0) {
            return splitInput;
        }
        throw new InvalidCoachNameException();
    }

    private void validateNameLength(String[] input) {
        for (String name : input) {
            if (name.length() < 2 || name.length() > 4) {
                throw new InvalidCoachNameException();
            }
        }
    }

    private void valiateCoachSize(String[] input) {
        if (input.length < 2 || input.length > 5) {
            throw new InvalidCoachNameException();
        }
    }

}
