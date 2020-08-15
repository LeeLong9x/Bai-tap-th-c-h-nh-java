/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Admin
 */
public class butonsuport extends imgkhung{

    public Color backgroundcolor,dragcolor,movecolor,colortmp;
    public int posxanh,posyanh;
    public boolean haveclick=false;

    public boolean isHaveclick() {
        return haveclick;
    }

    public void setHaveclick(boolean haveclick) {
        this.haveclick = haveclick;
    }
    public int getPosxanh() {
        return posxanh;
    }

    public void setPosxanh(int posxanh) {
        this.posxanh = posxanh;
    }

    public int getPosyanh() {
        return posyanh;
    }

    public void setPosyanh(int posyanh) {
        this.posyanh = posyanh;
    }
    public Color getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(Color backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    public Color getDragcolor() {
        return dragcolor;
    }

    public void setDragcolor(Color dragcolor) {
        this.dragcolor = dragcolor;
    }

    public Color getMovecolor() {
        return movecolor;
    }

    public void setMovecolor(Color movecolor) {
        this.movecolor = movecolor;
    }
 
    public butonsuport(int posxanh,int posyanh,int postx, int posty, int width, int height, BufferedImage image,Color bgrcolor,Color movercolor,Color dragcolor) {
        super(postx, posty, width, height, image);
        this.backgroundcolor=bgrcolor;
        this.movecolor=movercolor;
        this.dragcolor=dragcolor;
        this.posxanh=posxanh;
        this.posyanh=posyanh;
        this.colortmp=bgrcolor;
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
        g.drawArc(getPostx()+30, getPosty()+18, 65, 65,0,360);
        g.setColor(getBackgroundcolor());
        g.fillArc(getPostx()+31, getPosty()+19, 63, 63, 0, 360);
        g.drawImage(getImage(),getPosxanh(),getPosyanh(),getWidth(),getHeight(),null);
    }

    @Override
    public boolean check(MouseEvent e) {
 if(e.getX()>=getPostx()+30&& e.getX()<=getPostx()+getWidth()+58 && e.getY()>=getPosty()+48&& e.getY()<=getPosty()+getHeight()+73)
    {
        
        return true;
    }
    return false;    }
    
    public void  resetcolorbutton()
{
    setBackgroundcolor(getColortmp());
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
}
