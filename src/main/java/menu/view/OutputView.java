package menu.view;

import menu.MessageBuilder;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String RECOMMEND_MENU_START_MESSAGE ="점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMEND_MENU_RESULT_MESSAGE = "메뉴 추천 결과입니다.";
    private static final String TOP_MESSAGE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String RESULT_END_MESSAGE = "추천을 완료했습니다.";

    public void readStartMessage() {
        System.out.println(RECOMMEND_MENU_START_MESSAGE);
    }

    public void readResult(List<String> category, Map<String, List<String>> coachInfo) {
        System.out.println(RECOMMEND_MENU_RESULT_MESSAGE);
        System.out.println(TOP_MESSAGE);
        MessageBuilder messageBuilder = new MessageBuilder();
        System.out.println(messageBuilder.buildTopMessage(category));
        System.out.println(messageBuilder.buildResult(coachInfo));
        System.out.println(RESULT_END_MESSAGE);
    }


}
