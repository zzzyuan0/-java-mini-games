package com.zzzyuan;


import F.object.snakeBody;
import F.object.snake_move;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class App
{
    static JLabel title = null;
    public static void main( String[] args )
    {
        JFrame main_frame = new JFrame();
        main_frame.setLayout(null);
        main_frame.setBounds(400,200,900,720);
        main_frame.setResizable(false);
        main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_frame.setVisible(true);

        SnakePanel snakePanel = new SnakePanel();
        snakePanel.setBounds(0,0,900,720);
        main_frame.setContentPane(snakePanel);
        title = new JLabel("sore:" + snakeBody.getLlength() * 10 + "        ||      " + "length:" + snakeBody.getLlength() );
        title.setFont(new Font("楷体",1,20));
        title.setBackground(Color.white);
        title.setBounds(300,5,350,30);
        main_frame.add(title);

        new Thread(new reTitle()).start();

        main_frame.addKeyListener(new snake_move());


    }
    static class reTitle implements Runnable{

        @Override
        public void run() {

            while (true){
                title.setText( "sore:" + snakeBody.getLlength() * 10 + "        ||      " + "length:" + snakeBody.getLlength() );
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
