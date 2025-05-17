package entity;
//import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.*;

public class Player extends Entity{
    GamePanel g;
    KeyMovm keys;

    public Player(GamePanel g, KeyMovm keys){
        this.g=g;
        this.keys=keys;

        setDefaultValues();
        getPlayerImagine();
    }

    public void setDefaultValues(){
        x=100;
        y=100;
        speed=2;
        direction="stand";
    }

    public void getPlayerImagine(){ //non legge le immagini per problemi di link
        try {
            up1=ImageIO.read(getClass().getResourceAsStream("/imgCat/up_1.png"));
            up2=ImageIO.read(getClass().getResourceAsStream("/imgCat/up_2.png"));
            down1=ImageIO.read(getClass().getResourceAsStream("/imgCat/down_1.png"));
            down2=ImageIO.read(getClass().getResourceAsStream("/imgCat/down_2.png"));
            left1=ImageIO.read(getClass().getResourceAsStream("/imgCat/left_1.png"));
            left2=ImageIO.read(getClass().getResourceAsStream("/imgCat/left_2.png"));
            right1=ImageIO.read(getClass().getResourceAsStream("/imgCat/right_1.png"));
            right2=ImageIO.read(getClass().getResourceAsStream("/imgCat/right_2.png"));
            stand1=ImageIO.read(getClass().getResourceAsStream("/imgCat/stand_1.png"));
            stand2=ImageIO.read(getClass().getResourceAsStream("/imgCat/stand_2.png"));
            sit0=ImageIO.read(getClass().getResourceAsStream("/imgCat/sit_0.png"));
            sit1=ImageIO.read(getClass().getResourceAsStream("/imgCat/sit_1.png"));
            sit21=ImageIO.read(getClass().getResourceAsStream("/imgCat/sit_21.png"));
            sit22=ImageIO.read(getClass().getResourceAsStream("/imgCat/sit_22.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(){
        if(keys.up==true){
            direction="up";
            y-=speed;
        }
        if(keys.down==true){
            direction="down";
            y+=speed;
        }
        if(keys.right==true){
            direction="right";
            x+=speed;
        }
        if(keys.left==true){
            direction="left";
            x-=speed;
        }
        /*if(keys.space==true){
            direction="sit";
            x-=speed;
        }*/

        spriteCounter++;
        if(spriteCounter > 30){
            spriteNumb = (spriteNumb == 1) ? 2 : 1;
            spriteCounter = 0;
        }

    }
    public void draw(Graphics2D g2){
        //g2.setColor(Color.BLACK);
        //g2.fillRect(x, y, g.tileSize, g.tileSize);//rettangolo

        BufferedImage image=null;
        image=stand1;

        switch(direction){
            case "up":
                if(spriteNumb==1){
                    image=up1;
                }
                if(spriteNumb==2){
                    image=up2;
                }
                break;
            case "down":
                if(spriteNumb==1){
                    image=down1;
                }
                if(spriteNumb==2){
                    image=down2;
                }
                break;
            case "right":
                if(spriteNumb==1){
                    image=right1;
                }
                if(spriteNumb==2){
                    image=right2;
                }
                break;
            case "left":
                if(spriteNumb==1){
                    image=left1;
                }
                if(spriteNumb==2){
                    image=left2;
                }
                break;
        }
        g2.drawImage(image,x, y, g.tileSize, g.tileSize, null);
    }
}
