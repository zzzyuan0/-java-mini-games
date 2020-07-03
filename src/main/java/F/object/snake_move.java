package F.object;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static F.object.snakeBody.setDdire;

public class snake_move extends KeyAdapter {
    boolean beg = false;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
      //  System.out.println("----------1");
        if (e.getKeyCode() == KeyEvent.VK_SPACE && beg == false) {
            System.out.println("beg----------------");
            beg = true;
            setDdire(2);
        }else   if (e.getKeyCode() == KeyEvent.VK_SPACE && beg == true){
            System.out.println("end----------------");
            beg = false;
            setDdire(0);
        }
      //  System.out.println("----------2");
        if (beg){
            if (e.getKeyCode() == KeyEvent.VK_A && snakeBody.getDdire() != 2) {
                setDdire(4);
            }else  if (e.getKeyCode() == KeyEvent.VK_S && snakeBody.getDdire() != 1) {
                setDdire(3);
            }else  if (e.getKeyCode() == KeyEvent.VK_D && snakeBody.getDdire() != 4) {
                setDdire(2);
            }else  if (e.getKeyCode() == KeyEvent.VK_W && snakeBody.getDdire() != 3) {
                setDdire(1);
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}