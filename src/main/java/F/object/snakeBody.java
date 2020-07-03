package F.object;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public  class snakeBody extends gameBody {
    private static int sspeed = 5;
    private static int llength = 0;
    private static int ddire = 0;

    public snakeBody(int body_w, int body_h, int x, int y, int speed, int llength) {
        super(body_w, body_h, x, y);
        this.sspeed = speed;
        this.llength = llength;
    }

    public snakeBody() {
        new snake_move();
    }

    public static int getSpeed() {
        return sspeed;
    }

    public static void setSpeed(int speed) {
        sspeed = speed;
    }

    public static int getLlength() {
        return llength;
    }

    public static void setLlength(int length) {
        llength = length;
    }

    public static int getDdire() {
        return ddire;
    }

    public static void setDdire(int dire) {
        ddire = dire;
    }

}
