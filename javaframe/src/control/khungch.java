/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import data.cauhoi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Admin
 */
public class khungch extends khung{

    String []mangtmp;
    String tmp1=" ",tmp2=" ";
   
    public khungch(int posX, int posY, int width, int height, int w, int h, String name, Color backgroundcolor, Color textcolor) {
        super(posX, posY, width, height, w, h, name, backgroundcolor, textcolor);
        mangtmp= new String[1000];
        
    }
public void checksizename()
{
    mangtmp= getName().split(" ");
   // System.out.println("dodai:"+mangtmp.length);
    if(mangtmp.length>=20)
    {
        for(int i=0;i<mangtmp.length;i++)
        {
            if(i<mangtmp.length/2){
             tmp1+=mangtmp[i]+" ";
            }
            if(i>=mangtmp.length/2)
            {
                tmp2+=mangtmp[i]+" ";
            }
        }
       
    }
    
}
public String  layda(String dachon,cauhoi ch)
{
    
    if (dachon.equals(ch.getDaA())) {
        return "A";
    }
     if (dachon.equals(ch.getDaB())) {
        return "B";
    }
     if (dachon.equals(ch.getDaC())) {
        return "C";
    }
      if (dachon.equals(ch.getDaD())) {
        return "D";
    }
    return " ";
}

public boolean checkda(String dachon,cauhoi ch)
{
    String da = layda(dachon, ch);
  
    if (da.equals(ch.getDa())) {
        return true;
    }
    return false;

    
}
    @Override
    public void draw(Graphics2D g) {
        
        g.setColor(Color.RED);
        g.drawArc(getPosX()-2, getPosY()-1, getWidth()+1, getHeight()+2,0, getWidth()+2);
        g.setColor(backgroundcolor);
        g.fillArc(getPosX(), getPosY(), getWidth(), getHeight(),0, getWidth());
        g.setColor(textcolor);
        g.setFont(new Font("Arial",Font.BOLD,15));
       
        if(mangtmp.length<20)
        {
             g.drawString(getName(), getPosX()+getW(), getPosY()+getH());
        }
        if(mangtmp.length>=20)
        {
           
              g.drawString(tmp1, getPosX()+getW(), getPosY()+getH());
              g.drawString(tmp2, getPosX()+getW(), getPosY()+getH()+20);
              
        }
        
      
        
    }
    
}
