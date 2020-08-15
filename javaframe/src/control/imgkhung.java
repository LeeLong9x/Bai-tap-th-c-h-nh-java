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
public abstract class imgkhung {
     int postx,posty,width,height;
    BufferedImage image;

    public imgkhung(int postx, int posty, int width, int height, BufferedImage image) {
        this.postx = postx;
        this.posty = posty;
        this.width = width;
        this.height = height;
        this.image = image;
    }

    public int getPostx() {
        return postx;
    }

    public void setPostx(int postx) {
        this.postx = postx;
    }

    public int getPosty() {
        return posty;
    }

    public void setPosty(int posty) {
        this.posty = posty;
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

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public abstract void draw(Graphics2D g);
    public abstract boolean check(MouseEvent e);
}
