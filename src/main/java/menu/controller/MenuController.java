package menu.controller;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.Menu;
import menu.view.InputView;
import menu.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuController(InputView _inputView, OutputView _outputView) {
        this.inputView = _inputView;
        this.outputView = _outputView;
        outputView.start();
    }

    public void run() {
        Coaches coaches = generateCoaches();

    }

    private Coaches generateCoaches() {
        List<Coach> coaches = new ArrayList<>();
        List<String> names = inputView.enterCoachNames();

        for (String name : names) {
            List<Menu> forbiddenMenus = inputView.enterForbiddenMenus(name);
            coaches.add(Coach.from(name, forbiddenMenus));
        }
        return Coaches.from(coaches);
    }
}
