/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import control.cot;
import control.runsizetex;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class jpanelvebieudo extends JPanel implements Runnable{
    
    cot [] c;
    int y=375,height=5;
    Thread animationbd;
   int stopA,stopB,stopC,stopD;
    BufferedImage background;
    public  jpanelvebieudo(int A,int B,int C,int D) throws IOException
    {
        this.stopA=A;
        this.stopB=B;
        this.stopC=C;
        this.stopD=D;
        c= new cot[4];
        c[0] = new cot("A",31,410,10, this.y, 60, this.height, Color.yellow,stopA);
        c[1] = new cot("B",142,410,120, this.y, 60, this.height, Color.BLUE,stopB);
        c[2] = new cot("C",244,410,220, this.y, 60, this.height, Color.green,stopC);
        c[3] = new cot("D",344,410,320, this.y, 60, this.height, Color.CYAN,stopD);
        background= ImageIO.read(jpanelvebieudo.class.getResource("/images/ribi2.jpg"));
             
    }
    @Override
    public void paint(Graphics g) {
        
       g.drawImage(background, 0, 0,Jframebieudo.SCREEN_WIDTH,Jframebieudo.SCREEN_HEIGHT, this);
      for(cot cc : c)
      {
          cc.draw((Graphics2D) g);
      }
    }
int check=0;
public void runbd()
{
    if(animationbd==null)
    {
        animationbd= new Thread(this);
    }
    if(animationbd!=null)
    {
        animationbd.start();
    }
}
public void reset()
{
    for(int i=0;i<c.length;i++)
    {
        
        c[i].setPosY(y);
        c[i].setHeight(height);
    }
}
public void showpt(int cot)
{
     runsizetex runc= new runsizetex(c, cot,this);
     runc.start();
    
}
public boolean checkendrun()
{
    for(int i=0;i<c.length;i++)
    {
        if(c[i].isHavestop()==false) return false;
    }
    return true;
}
    @Override
    public void run() {
     
        while (true) {            
           
          
            
            if(height<350 && check==0)
            { reset();
                height++;
            }
           if(y>30 && check==0)
            {
                reset();
                y--;
            }
         if(height>=350)
            {
                    check=1;
                     
            }
              if(check==1)
            {
               y++;
              
               height--;
               for(int i=0;i<c.length;i++)
               {
                  if(c[i].getHeight()==c[i].getStop()&& c[i].isHavestop()==false)
                  {
                     
                   c[i].setHavestop(true);
                   c[i].setVept(true);
                    showpt(i);
                      
                  }
                  if(c[i].isHavestop()==false)
                  {
                      c[i].setPosY(y);
                      c[i].setHeight(height);
                  }
               }
            }
             
          repaint();
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(jpanelvebieudo.class.getName()).log(Level.SEVERE, null, ex);
            } 
          
            if(checkendrun())
            {
                break;
            }
            
        }
        
    }
    
    
}
