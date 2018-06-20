package Interface;

import sun.applet.Main;

public class Outcomes {


    public static void gameOver(MainFrame frame)
    {
        MyGlassPanel glass = frame.glass;
        frame.gameP.h = 0;
        glass.add(frame.glass.overL);
        glass.add(frame.glass.resetB);
        glass.add(frame.glass.newB);
//        glass.add(frame.glass.optionsB);
        glass.add(frame.glass.exitB);
        glass.isVisible = true;
        glass.setVisible(true);
    }

    public static void gameWon(MainFrame frame)
    {
        MyGlassPanel glass = frame.glass;
        frame.gameP.h = 0;
        glass.add(frame.glass.winL);
        glass.add(frame.glass.resetB);
        glass.add(frame.glass.newB);
//        glass.add(frame.glass.optionsB);
        glass.add(frame.glass.exitB);
        glass.isVisible = true;
        glass.setVisible(true);
    }
}
