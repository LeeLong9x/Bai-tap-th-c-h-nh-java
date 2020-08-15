/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Admin
 */
public class buttonimg extends imgkhung{

    public buttonimg(int postx, int posty, int width, int height, BufferedImage image) {
        super(postx, posty, width, height, image);
    }
   

    @Override
    public boolean check(MouseEvent e)
{
    if(e.getX()>=getPostx()&& e.getX()<=getPostx()+getWidth()+10 && e.getY()>=getPosty()+10&& e.getY()<=getPosty()+getHeight()+20)
    {
        
        return true;
    }
    return false;
    
}

   @Override
    public void draw(Graphics2D g)
    {
        g.drawImage(image,postx,posty,width,height,null);
       
    }
    
}
