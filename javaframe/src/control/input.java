/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaframe.gamepanel;
import javaframe.jpaneltl;
import javaframe.viewtop;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import loadfile.SoundPlayer;

/**
 *
 * @author Admin
 */
public class input {

    int check=0;
    gamepanel gamepl;
  ArrayList<Integer> dsused;
    ArrayList<String>dstop;
    public input(gamepanel gpl)
    {
       this.gamepl=gpl;
     
    
    }

    public void setmouseclick(int vitri) throws IOException
    {
        switch(vitri)
        {
            case 0:
                gamepanel.startgame=1;
                gamepl.newgame();
                new loadfile.loaddata().xoaall();
                gamepl.demtg=0;
              gamepl.havenewgame=true;
                break;
            case 1:
                 gamepanel.startgame = 1;
                int vt = new loadfile.loaddata().docvitri();
                gamepl.setVitri(vt);
                gamepl.newqs=false;
                gamepl.setda();
                char a = (char) docdiem();
                gamepl.setDiem(Integer.parseInt(String.valueOf(a)));
                int phuttmp = new loadfile.loaddata().docphut();
                int giaytmp = new loadfile.loaddata().docgiay();
                char phut = (char) phuttmp;
               
                gamepl.setPhut(Integer.parseInt(String.valueOf(phut)));
                gamepl.setGiay(Integer.parseInt(String.valueOf(giaytmp)));
                dsused= new loadfile.loaddata().dsspused();
                if(!dsused.isEmpty())
                {
                for(int i=0;i<dsused.size();i++)
                {
                      gamepl.btnsp[dsused.get(i)].setHaveclick(true);
                      gamepl.btnsp[dsused.get(i)].setBackgroundcolor(Color.darkGray);
                      
                }
                }
                gamepl.repaint();
                break;
            case 2:
             dstop= new loadfile.loaddata().gettop();
                
              new viewtop(dstop);
                break;
            case 3:
                
            
                gamepl.repaint();
                break;
            case 4:
                int check = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát?", "Chú Ý", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION);
                if (check == JOptionPane.YES_OPTION) {
                    
                    System.exit(0);
                }
                break;
        }
    }
    public int  docdiem() throws IOException
     {
         File file=new File("diem.txt");
        if(!file.exists())
                {
                    file.createNewFile();
                }
        FileInputStream fileInputStream= new FileInputStream(file);
        int c=fileInputStream.read();
         //System.out.println((char)c);
         fileInputStream.close();
        return c;
        
        
        
     }
}
