package Interface;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class OKeyListener implements KeyListener {

    private MainFrame frame;
    private MyGlassPanel glass;


    protected OKeyListener(MainFrame frame, MyGlassPanel glass)
    {
        this.frame = frame;
        this.glass = glass;
    }

    public void keyTyped(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        System.out.println("Typed " + key);
    }
    public void keyPressed(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        System.out.println("Pressed " + key);
    }
    public void keyReleased(KeyEvent e) {
        String key = KeyEvent.getKeyText(e.getKeyCode());
        System.out.println("Released " + key);
        if(frame.gameP.isVisible)
        {
            if(key.equals("Escape"))
            {
                if (!glass.isVisible)
                {
                    frame.gameP.h = 0;
                    glass.add(glass.pauzaL);
                    glass.add(glass.loadB);
                    glass.add(glass.resetB);
                    glass.add(glass.newB);
                    glass.add(glass.optionsB);
                    glass.add(glass.exitB);
                    glass.isVisible = true;
                    glass.setVisible(true);
                }
                else
                {
                    frame.gameP.h = 0.1;
                    glass.remove(glass.pauzaL);
                    glass.remove(glass.loadB);
                    glass.remove(glass.resetB);
                    glass.remove(glass.newB);
                    glass.remove(glass.optionsB);
                    glass.remove(glass.exitB);
                    glass.isVisible = false;
                    glass.setVisible(false);
                }
            }
            else if(key.equals("Up")){
                frame.gameP.mapCSS.rocket.setVx(frame.gameP.mapCSS.rocket.getVx()
                        + frame.gameP.mapCSS.rocket.getdV()*Math.cos(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
                frame.gameP.mapCSS.rocket.setVy(frame.gameP.mapCSS.rocket.getVy()
                        - frame.gameP.mapCSS.rocket.getdV()*Math.sin(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
            }
            else if(key.equals("Down")){
                frame.gameP.mapCSS.rocket.setVx(frame.gameP.mapCSS.rocket.getVx()
                        - frame.gameP.mapCSS.rocket.getdV()*Math.cos(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
                frame.gameP.mapCSS.rocket.setVy(frame.gameP.mapCSS.rocket.getVy()
                        + frame.gameP.mapCSS.rocket.getdV()*Math.sin(Math.toRadians(frame.gameP.mapCSS.rocket.getAngle())));
            }
            else if(key.equals("Left")){
                frame.gameP.mapCSS.rocket.setvAngle(frame.gameP.mapCSS.rocket.getvAngle() + frame.gameP.mapCSS.rocket.getdVAngle());
            }
            else if(key.equals("Right")) {
                frame.gameP.mapCSS.rocket.setvAngle(frame.gameP.mapCSS.rocket.getvAngle() - frame.gameP.mapCSS.rocket.getdVAngle());
            }

        }

    }

}
