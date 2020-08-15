/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Admin
 */
public class khungcall extends imgkhung{
    String name;
    public khungcall(String name,int postx, int posty, int width, int height, BufferedImage image) {
        super(postx, posty, width, height, image);
        this.name=name;
    }

    @Override
    public void draw(Graphics2D g) {
       
        g.drawImage(getImage(),getPostx(),getPosty(),getWidth(),getHeight(),null);
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(getName(), getPostx()+32,getPosty()+155);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean check(MouseEvent e) {
 if(e.getX()>=getPostx()&& e.getX()<=getPostx()+getWidth() && e.getY()>=getPosty()+10&& e.getY()<=getPosty()+getHeight()+30)
    {
        
        return true;
    }
    return false;    }
    
}
