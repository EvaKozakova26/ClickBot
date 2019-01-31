package sample;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

class AutoClickerBot {
    private Robot robot;
    private int delay;
    private int pressDelay;

    AutoClickerBot() {
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();

        try {
            this.robot = new Robot();
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    void mouseClick(int button) {
        try {
            this.robot.mousePress(button);
            System.out.println("clicked");
            this.robot.delay(this.delay);
            this.robot.delay(this.pressDelay);
            this.robot.mouseRelease(button);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    void setDelay(int delay) {
        this.delay = delay;
    }

    void setPressDelay(int pressDelay) {
        this.pressDelay = pressDelay;
    }
}
