package main;

import javax.swing.JFrame;

public class MainProva{
    public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("6six Hours");
        
        GamePanel gamePanel= new GamePanel();
        frame.add(gamePanel);
        frame.pack();//to fit the perfect sixes

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        gamePanel.StartGameThread();
    }
}

//javac main/*.java entity/*.java
//java main.MainProva
