package menu.controller;

import menu.service.RecommendService;
import menu.view.InputView;
import menu.view.OutputView;

public class RecommendMenuController {

    InputView inputView;
    OutputView outputView;
    RecommendService recommendService;

    public RecommendMenuController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.recommendService = new RecommendService();
    }

    public void start() {
        outputView.readStartMessage();
        String[] coaches = inputView.getCoachesName();
        for (String coach : coaches) {
            recommendService.setCoaches(coach, inputView.getHateMenus(coach));
        }
        recommendService.setCategories();
        recommendService.setCoachesMenus();
        outputView.readResult(recommendService.getCategories(),recommendService.getCoaches());
    }
}
