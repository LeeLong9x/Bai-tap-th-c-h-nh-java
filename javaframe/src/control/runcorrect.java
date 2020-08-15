/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javaframe.gamepanel;

/**
 *
 * @author Admin
 */
public class runcorrect extends Thread{

    khungcall kc;
    int x=0,y=0,h=0,w=0;
    gamepanel pl;
    public  runcorrect(khungcall icon,gamepanel pl)
    {
        this.kc=icon;
        this.x=icon.getPostx();
        this.y=icon.getPosty();
        this.w=icon.getWidth();
        this.h=icon.getHeight();
        this.pl=pl;
    }
    @Override
    public void run() {
        while (true) {            
            
            x--;
            y--;
            w+=2;
            h+=2;
            kc.setPostx(x);
            kc.setPosty(y);
            kc.setWidth(w);
            kc.setHeight(h);
            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(runcorrect.class.getName()).log(Level.SEVERE, null, ex);
            }
            pl.repaint();
            if(kc.getWidth()>=300)
            {
                break;
            }
        }
    }
    
}
