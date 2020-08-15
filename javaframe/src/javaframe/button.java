/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

/**
 *
 * @author Admin
 */
public class button {
    
    int posX,posY,width,height,w,h;
    String name;
    Color colorbackgroud;
    Color colortext;
    Color movecolor;
    Color dragcolor;
    Color colortmp;
    boolean Enlable=true;

    public boolean isEnlable() {
        return Enlable;
    }

    public void setEnlable(boolean Enlable) {
        this.Enlable = Enlable;
    }
    public Color getColortmp() {
        return colortmp;
    }

    public void setColortmp(Color colortmp) {
        this.colortmp = colortmp;
    }
    public Color getMovecolor() {
        return movecolor;
    }

    public void setMovecolor(Color movecolor) {
        this.movecolor = movecolor;
    }

    public Color getDragcolor() {
        return dragcolor;
    }

    public void setDragcolor(Color dragcolor) {
        this.dragcolor = dragcolor;
    }

    public button(int posX, int posY, int width, int height, String name,int widthname,int heightname, Color colorbackgroud, Color colortext) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.name = name;
        this.colorbackgroud = colorbackgroud;
        this.colortext = colortext;
        this.w=widthname;
        this.h=heightname;
        this.colortmp=colorbackgroud;
    }
public void draw(Graphics2D g2)
{
    g2.setColor(Color.RED);
    g2.setFont(new Font("Arial", Font.BOLD, 15));
    g2.drawRect(posX-1, posY-1, width+1, height+1);
    g2.setColor(colorbackgroud);
    g2.fillRect(posX, posY, width, height);
    g2.setColor(colortext);
    g2.drawString(name,(posX+w), posY+h);
}
protected  boolean check(MouseEvent e)
{
    if(e.getX()>=getPosX()&& e.getX()<=getPosX()+getHeight()+62 && e.getY()>=getPosY()+30&& e.getY()<=getPosY()+getHeight()+30)
    {
        
        return true;
    }
    return false;
    
}
protected  void  resetcolorbutton()
{
    setColorbackgroud(getColortmp());
}
public void trans(int values,MouseEvent e)
{
   
    if(values==0)
    {
        
            setColorbackgroud(getDragcolor());
        
    }
    else if(values==1)
    {
       setColorbackgroud(getMovecolor());
    }
}
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColorbackgroud() {
        return colorbackgroud;
    }

    public void setColorbackgroud(Color colorbackgroud) {
        this.colorbackgroud = colorbackgroud;
    }

    public Color getColortext() {
        return colortext;
    }

    public void setColortext(Color colortext) {
        this.colortext = colortext;
    }
   
    
}
