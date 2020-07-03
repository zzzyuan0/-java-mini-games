package F.object;

import java.awt.*;

public class gameBody {
    public int body_w = 30;
    public int body_h = 30;
    public  int x,y;

    public gameBody(int body_w, int body_h, int x, int y) {
        this.body_w = body_w;
        this.body_h = body_h;
        this.x = x;
        this.y = y;
    }

    public gameBody() {
    }

    public Rectangle getRectangle(){
    //    System.out.println("");
        return new Rectangle(x,y,body_w,body_h);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
