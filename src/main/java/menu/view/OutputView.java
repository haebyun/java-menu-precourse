package menu.view;

import menu.domain.MenuResult;
import menu.domain.RecommendResult;

import java.time.DayOfWeek;
import java.util.Map;

public class OutputView {
    public void start() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
    }

    public void printRecommendResult(RecommendResult result) {
        for(Map.Entry<DayOfWeek, MenuResult> entry : result.recommends().entrySet()) { {

        }

        }
    }
}
