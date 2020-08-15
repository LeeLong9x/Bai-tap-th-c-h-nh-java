/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import control.butonsuport;
import control.buttonimg;
import control.khungch;
import control.khungda;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;


/**
 *
 * @author Admin
 */
public class gameplay {
    
    BufferedImage background,khungcauhoi,back;

    public gameplay()
    {
        try {
            background= ImageIO.read(gameplay.class.getResource("/images/backgroundplaygame.jpg"));
            khungcauhoi= ImageIO.read(gameplay.class.getResource("/images/khungcauhoi.jpg"));
            
           
        } catch (IOException ex) {
            Logger.getLogger(gameplay.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
public void drawtime(Graphics2D g,int phut,int giay)
{
    g.setColor(Color.GREEN);
    g.setFont(new Font("Arial", Font.BOLD,20));
    g.drawString(String.valueOf(phut), 900, 55);
    g.drawString(":" + String.valueOf(giay), 910, 55);
   
}

public void drawpiont(Graphics2D g,int diem)
{
    g.setColor(Color.red);
    g.setFont(new Font("Arial", Font.BOLD,20));
    g.drawString("Điểm: "+String.valueOf(diem), 90, 55);
}

    public void draw( Graphics2D g,khungch ch,khungda[] da,int phut,int giay,int diem,buttonimg []btn,butonsuport []btnsp){
        g.drawImage(background, 0 ,0,Javaframe.SCREEN_WIDTH,Javaframe.SCREEN_HEIGHT,null);

        ch.draw(g);
        drawtime(g, phut, giay);
        drawpiont(g, diem);
           for(butonsuport imgsp:btnsp)
        {
            imgsp.draw(g);
        }
        for(buttonimg img:btn)
        {
            img.draw(g);
        }
     
       for(khungda d: da)
       {
           d.draw(g);
       }
    }
}
