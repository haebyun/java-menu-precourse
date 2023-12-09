package menu.domain;

import java.util.List;

public class Coaches {
    private List<Coach> coaches;

    private Coaches(List<Coach> coaches) {
        validateCoachNumber(coaches);
        coaches = coaches;
    }

    private void validateCoachNumber(List<Coach> coaches) {
        if(coaches.size() < 2 || coaches.size() > 5) {
            throw new IllegalArgumentException(
                    "[ERROR] 코치를 총 2명 이상, 5명 이하로 입력해주세요."
            );
        }
    }

    public static Coaches from(List<Coach> coaches) {
        return new Coaches(coaches);
    }
}
