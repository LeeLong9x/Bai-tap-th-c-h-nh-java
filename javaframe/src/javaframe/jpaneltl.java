/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class jpaneltl {

  
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
     g.fillRect(0, 0,Javaframe.SCREEN_WIDTH, Javaframe.SCREEN_HEIGHT);
     g.setColor(Color.BLUE);
     g.setFont(new Font("Arial", Font.BOLD, 30));
     g.drawString("Lên mạng mà đọc", Javaframe.SCREEN_WIDTH/2-100, Javaframe.SCREEN_HEIGHT/2);


    }
    
}
