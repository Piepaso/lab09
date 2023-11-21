package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberTerminalView implements DrawNumberView{

    private DrawNumberController controller;
    private static final String NEW_GAME = ": a new game starts!";

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
    }

    @Override
    public void result(DrawResult res) {
         switch (res) {
            case YOURS_HIGH, YOURS_LOW -> {
                System.out.println(res.getDescription());
                return;
            }case YOU_WON, YOU_LOST -> {
                System.out.println(res.getDescription() + NEW_GAME);
            }
            default -> throw new IllegalStateException("Unknown game state");  
        }
        controller.resetGame();
    }
}
