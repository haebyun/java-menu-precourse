package menu.exception;

public class InvalidCoachNameException extends IllegalArgumentException{
    private static final String INVALID_COACH_NAME_FORMAT_MESSAGE = "[ERROR] 코치 이름을 올바르게 입력하세요.";

    public InvalidCoachNameException() {
        super(INVALID_COACH_NAME_FORMAT_MESSAGE);
    }
}
