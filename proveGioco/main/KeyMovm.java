package main;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyMovm implements KeyListener{

    public boolean up, down, right, left, sit;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode(); //prende il numero del pulsante

        if(code== KeyEvent.VK_W){
            up=true;
        }
        if(code== KeyEvent.VK_A){
            left=true;
        }
        if(code== KeyEvent.VK_D){
            right=true;
        }
        if(code== KeyEvent.VK_S){
            down=true;
        }
        /*if(code== KeyEvent.VK_SPACE){
            sit=true;
        }*/

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code= e.getKeyCode();
        if(code== KeyEvent.VK_W){
            up=false;
        }
        if(code== KeyEvent.VK_A){
            left=false;
        }
        if(code== KeyEvent.VK_D){
            right=false;
        }
        if(code== KeyEvent.VK_S){
            down=false;
        }
    }
    
}
