package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;

public class GamePanel extends JPanel implements Runnable{
    //setting carachter
    final int originalTileSize= 16; //16x16 lxl
    final int scale=3;

    public final int tileSize= originalTileSize*scale; //48x48

    //setting game
    final int maxScreenCol= 16;
    final int maxScreenRow=12;
    final int ScreenWidth= tileSize*maxScreenCol;
    final int ScreenHeight= tileSize*maxScreenRow;

    KeyMovm keymov= new KeyMovm();
    Thread gameThread;
    Player player= new Player(this, keymov);

    //fps
    int FPS=60;

    //set Player def pos
    int playerX=100;
    int playerY=100;
    int playerSpeed= 4;

    public GamePanel(){
        setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        setBackground(Color.PINK);
        setDoubleBuffered(true); //better rendering performace
        addKeyListener(keymov);
        this.setFocusable(true);
    }

    public void StartGameThread(){
        gameThread= new Thread(this);
        gameThread.start();
    }

    /*@Override
    //core of the game
    public void run(){
        double drawInterval= 1000000000/FPS;
        double delta=0;
        long lastTime= System.nanoTime();
        long currentTime;

        while(gameThread != null){
            
            currentTime= System.nanoTime();
            delta +=(currentTime - lastTime)/drawInterval;
            lastTime=currentTime;
            if(delta>=1){
                //1- update information position
                update();
                //2- draw in new position
                repaint();
                delta--;
            }
            
        }
        
    }*/


    @Override
    //core of the game
    public void run(){
        
        double drawInterval= 1000000000/FPS;
        double nextDrawTime= System.nanoTime()+ drawInterval;
        while(gameThread != null){
            //long currentTime= System.nanoTime();

            //1- update information position
            update();
            //2- draw in new position
            repaint();
            try{
                double remainingTime= nextDrawTime-System.nanoTime();
                remainingTime= remainingTime/1000000;

                if(remainingTime<0){
                    remainingTime=0;
                }

                Thread.sleep((long)remainingTime);

                nextDrawTime+=drawInterval;
            }catch( InterruptedException e){
                e.printStackTrace();
            }
            
        }
        
    }

    public void update(){
        player.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2= (Graphics2D)g;
        player.draw(g2);
        g2.dispose(); //tipo il sout
    }

    
    
}
