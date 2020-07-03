package com.zzzyuan;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import F.object.snakeBody;
import F.object.snake_food;

public class SnakePanel extends JPanel {
    ImageIcon background = new ImageIcon("src/imgs/background.jpg");
    ImageIcon food = new ImageIcon("src/imgs/food.png");
    ImageIcon e_head = new ImageIcon("src/imgs/e_head.png");
    ImageIcon s_head = new ImageIcon("src/imgs/s_head.png");
    ImageIcon n_head = new ImageIcon("src/imgs/n_head.png");
    ImageIcon w_head = new ImageIcon("src/imgs/w_head.png");
    ImageIcon snake_body = new ImageIcon("src/imgs/snake_body.png");


    public static int[] snake_x = new int[750];
    public static int[] snake_y = new int[750];

    snakeBody snakeBody;
    snake_food snake_food;


    public SnakePanel() {
        beg_life();
        snakeBody =  new snakeBody();
        snake_food = new snake_food();
        new Thread(new repaintSnake()).start();
        new Thread(new chans()).start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);
        g.drawImage(background.getImage(),15,60,870,600,null);
        food.paintIcon(this,g,snake_food.getX(),snake_food.getY());
    //    System.out.println(snake_food.getX()+ " " + snake_food.getY());
        if (snakeBody.getDdire()!=0){
            for (int i = 1; i <= snakeBody.getLlength(); i++) {
                snake_body.paintIcon(this,g,snake_x[i],snake_y[i]);
            }
        }else {
             g.drawString("--请按空格开始游戏或者暂停游戏--",350,300);
             g.setFont(new Font("楷体",1,40));
             g.setColor(Color.red);
        }

        switch (snakeBody.getDdire()) {
            case 1:
                n_head.paintIcon(this,g,snake_x[0],snake_y[0]);
                break;
            case 2:
                e_head.paintIcon(this,g,snake_x[0],snake_y[0]);
                break;
            case 3:
                s_head.paintIcon(this,g,snake_x[0],snake_y[0]);
                break;
            case 4:
                w_head.paintIcon(this,g,snake_x[0],snake_y[0]);
                break;
            case 0:
                n_head.paintIcon(this,g,300,300);
                break;

        }

    }

    private void beg_life(){
        snake_x[0] = 300;
        snake_y[0] = 300;
    }
    public void relife(){
        snake_x = new int[750];
        snake_y = new int[750];
        snake_x[0] = 300;
        snake_y[0] = 300;
        snakeBody.setLlength(0);
    }
    class repaintSnake implements Runnable{
        @Override
        public void run() {
            int x,y;

            while (true){
                repaint();
                if (snakeBody.getDdire() != 0)
                for (int i = snakeBody.getLlength();i >= 1;i--){

                    snake_x[i] = snake_x[i-1];
                    snake_y[i] = snake_y[i-1];

                }
                switch (snakeBody.getDdire()){
                    case 1:snake_y[0] -= snakeBody.getSpeed() * 4;
                        break;
                    case 2:snake_x[0] += snakeBody.getSpeed() * 4;
                        break;
                    case 3:snake_y[0] += snakeBody.getSpeed() * 4;
                        break;
                    case 4:snake_x[0] -= snakeBody.getSpeed() * 4;
                        break;
                    case 0:
                        break;
                }
                for (int i = 1;i<=snakeBody.getLlength();i++){
                    if (snake_x[0] == snake_x[i] && snake_y[0] == snake_y[i]){
                        snakeBody.setDdire(0);
                        relife();
                    }
                }
                snakeBody.setX(snake_x[0]);
                snakeBody.setY(snake_y[0]);
                try {
                    Thread.sleep(120);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class chans implements Runnable{
        @Override
        public void run() {
            while (true){
                if (snakeBody.getRectangle().intersects(snake_food.getRectangle())){
                         System.out.println("---888-------");
                          snake_food.Ran_food();
                          snakeBody.setLlength(snakeBody.getLlength()+1);
                }
//                else{
////                    System.out.println("89898----------");
//                }
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
