package menu.controller;

import menu.domain.*;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView _inputView, OutputView _outputView) {
        this.inputView = _inputView;
        this.outputView = _outputView;
        outputView.start();
    }

    public void run() {
        // 코치 생성
        Coaches coaches = generateCoaches();

        // 메뉴 추천 기능
        Recommender recommender = Recommender.from(coaches);
        RecommendResult result = recommender.recommend();
        outputView.printRecommendResult(result);
    }

    private Coaches generateCoaches() {
        List<Coach> coaches = new ArrayList<>();
        List<String> names = retry(() -> {
            return inputView.enterCoachNames();
        });

        for (String name : names) {
            retry(() -> {
                List<Menu> forbiddenMenus = inputView.enterForbiddenMenus(name);
                return coaches.add(Coach.from(name, forbiddenMenus)); // return을 사용해도 되는지?
            });
        }
        return Coaches.from(coaches);
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
