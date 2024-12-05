package menu.controller;

import menu.domain.Coach;
import menu.domain.Coachs;
import menu.domain.WeekMenuScheduler;
import menu.domain.parser.CoachParser;
import menu.domain.parser.HateMenuParser;
import menu.service.CoachHateMenuService;
import menu.service.MenuScheduleService;
import menu.view.Input;
import menu.view.Output;

public class MainController {
    private CoachHateMenuService coachHateMenuService;
    private MenuScheduleService menuScheduleService;

    public void run() {
        System.out.println("점심 메뉴 추천을 시작합니다.");
        coachHateMenuService = new CoachHateMenuService();
        menuScheduleService = new MenuScheduleService();
        Coachs coachs = createCoachs();
        updateHateMenu(coachs);

        WeekMenuScheduler schedule = menuScheduleService.schedule(coachs);

        Output.printOneWeekMenuSchedule(schedule, coachs);
    }

    private void updateHateMenu(Coachs coachs) {
        for (Coach coach : coachs.getCoachs()) {

            while (true) {
                try {
                    coachHateMenuService.updateHateMenuByCoach(coach,
                            HateMenuParser.parse(Input.inputHateMenuByCoach(coach)));
                    break;
                } catch (IllegalArgumentException e) {
                    Output.printError(e.getMessage());
                }
            }
        }
    }

    public Coachs createCoachs() {
        while (true) {
            try {
                return coachHateMenuService.createCoachs(CoachParser.parse(Input.inputCoachNames()));
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

}
