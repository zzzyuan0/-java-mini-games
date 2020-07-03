package F.object;

import java.util.Random;

public class snake_food extends gameBody {
    Random random = new Random();
    public snake_food(int body_w, int body_h, int x, int y) {
        super(body_w, body_h, x, y);
    }

    public snake_food() {
        Ran_food();
    }
    public void Ran_food(){
        setX(Math.abs(random.nextInt()%870) + 10);
        setY(Math.abs(random.nextInt()%600) + 30);
    }
}
