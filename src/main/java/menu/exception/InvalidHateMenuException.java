package menu.exception;

public class InvalidHateMenuException extends IllegalArgumentException{
    private static final String INVALID_HATE_MENU_FORMAT_MESSAGE = "[ERROR] 싫어하는 음식을 다시 입력하세요.";

    public InvalidHateMenuException() {
        super(INVALID_HATE_MENU_FORMAT_MESSAGE);
    }
}
