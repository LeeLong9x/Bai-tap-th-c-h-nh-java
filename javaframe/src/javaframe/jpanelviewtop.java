/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class jpanelviewtop extends JPanel{
    ArrayList<String>dstop;
    int x=30,y=40;
    public jpanelviewtop(ArrayList<String>dstop)
    {
        this.dstop=dstop;
        
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, viewtop.SCREEN_WIDTH, viewtop.SCREEN_HEIGHT);
        g.setColor(Color.yellow);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        try {
            
      
        for(int i=0;i<dstop.size();i++)
        {
            if(!dstop.get(i).equals(null))
            {
            g.drawString(dstop.get(i), x, y);
            y+=30;
            }
        }
          } catch (Exception e) {
              System.out.println(e.getMessage());
        }


    }
    
}
