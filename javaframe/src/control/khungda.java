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
import java.awt.event.MouseEvent;

/**
 *
 * @author Admin
 */
public class khungda extends khung{
 Color movecolor;
    Color dragcolor;
    Color colortmp;
    public khungda(int posX, int posY, int width, int height, int w, int h, String name, Color backgroundcolor, Color textcolor) {
        super(posX, posY, width, height, w, h, name, backgroundcolor, textcolor);
        this.colortmp=backgroundcolor;
    }
public boolean check(MouseEvent e)
{
    if(e.getX()>=getPosX()&& e.getX()<=getPosX()+getHeight()+272 && e.getY()>=getPosY()+30&& e.getY()<=getPosY()+getHeight()+32)
    {
        
        return true;
    }
    return false;
    
}
public void trans(int values,MouseEvent e)
{
   
    if(values==0)
    {
        
            setBackgroundcolor(getDragcolor());
        
    }
    else if(values==1)
    {
       setBackgroundcolor(getMovecolor());
    }
}


public  void  resetcolorbutton()
{
    setBackgroundcolor(getColortmp());
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

    public Color getColortmp() {
        return colortmp;
    }

    public void setColortmp(Color colortmp) {
        this.colortmp = colortmp;
    }
    @Override
    public void draw(Graphics2D g) {
    g.setColor(Color.RED);
    g.setFont(new Font("Arial", Font.BOLD, 15));
    g.drawRect(posX-1, posY-1, width+1, height+1);
    g.setColor(backgroundcolor);
    g.fillRect(posX, posY, width, height);
    g.setColor(textcolor);
    g.drawString(name,(posX+w), posY+h);   

    }
    
}
