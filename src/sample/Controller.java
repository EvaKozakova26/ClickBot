package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Controller implements KeyListener  {

    @FXML
    private TextField numOfClicks;

    @FXML
    private TextField timeBetweenClicks;

    @FXML
    private TextField clickDuration;

    private AutoClickerBot autoClickerBot = new AutoClickerBot();

    private boolean stop = true;


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_BACK_SPACE:
                stop = false;
            default:
        }
    }

    @FXML
    public void onButtonStart(javafx.event.ActionEvent actionEvent) {
        stop = false;
        autoClickerBot.setDelay(Integer.parseInt(timeBetweenClicks.getText()));
        autoClickerBot.setPressDelay(Integer.parseInt(clickDuration.getText()));

        final ExecutorService exc = Executors.newSingleThreadExecutor();
        final Runnable runnable = new Runnable() {
            int clicks = Integer.parseInt(numOfClicks.getText());
            public void run() {
                // 16 = LMB
                for (int i = 0; i < clicks; ++i ) {
                    autoClickerBot.mouseClick(16);
                    if (stop) {
                        System.out.println("stopped");
                        break;
                    }
                }
                clicks = 0;
                // stop = true;
            }
        };

        if (!stop) {
            exc.submit(runnable);
        }

    }

    @FXML
    public void onButtonStop(javafx.event.ActionEvent actionEvent) {
        stop = true;
        System.out.println("stop");
    }
}
