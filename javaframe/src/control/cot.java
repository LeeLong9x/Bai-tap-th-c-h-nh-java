/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author Admin
 */
public class cot {
    int Posx, PosY, width, height, stop, check = 0, sizetext = 0,xname,yname;

    public int getXname() {
        return xname;
    }

    public void setXname(int xname) {
        this.xname = xname;
    }

    public int getYname() {
        return yname;
    }

    public void setYname(int yname) {
        this.yname = yname;
    }
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSizetext() {
        return sizetext;
    }

    public void setSizetext(int sizetext) {
        this.sizetext = sizetext;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }
    Color backgroudcoColor;
boolean havestop=false,vept=false;

    public boolean isVept() {
        return vept;
    }

    public void setVept(boolean vept) {
        this.vept = vept;
    }

    public boolean isHavestop() {
        return havestop;
    }

    public void setHavestop(boolean havestop) {
        this.havestop = havestop;
    }
    public int getPosx() {
        return Posx;
    }

    public void setPosx(int Posx) {
        this.Posx = Posx;
    }

    public int getPosY() {
        return PosY;
    }

    public void setPosY(int PosY) {
        this.PosY = PosY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getBackgroudcoColor() {
        return backgroudcoColor;
    }

    public void setBackgroudcoColor(Color backgroudcoColor) {
        this.backgroudcoColor = backgroudcoColor;
    }

    public cot(String name,int xname,int yname,int Posx, int PosY, int width, int height, Color backgroudcoColor,int stop) {
        this.Posx = Posx;
        this.PosY = PosY;
        this.width = width;
        this.height = height;
        this.backgroudcoColor = backgroudcoColor;
        this.stop=stop;
        this.name=name;
        this.xname=xname;
        this.yname=yname;
    }

    public int getStop() {
        return stop;
    }

    public void setStop(int stop) {
        this.stop = stop;
    }

    public void draw(Graphics2D g)
    {
        g.setColor(Color.red);
        g.drawRect(getPosx()-1,getPosY()-1, getWidth()+1,getHeight()+1);
        g.setColor(backgroudcoColor);
        g.fillRect(getPosx(), getPosY(), getWidth(), getHeight());
        g.setColor(Color.BLACK);
         g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(getName(), getXname(), getYname());
      if(isVept()==true)
      {
          g.setFont(new Font("Arial", Font.BOLD, getSizetext()));
          g.setColor(Color.RED);
          g.drawString(String.valueOf(getStop()/(7/2))+" %", getPosx()+10 , 375-(getStop())-10);
          check=1;
      }
    }
}
