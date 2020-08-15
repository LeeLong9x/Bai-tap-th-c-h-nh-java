/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Admin
 */
public abstract class khung {

    public khung(int posX, int posY, int width, int height, int w, int h, String name, Color backgroundcolor, Color textcolor) {
        this.posX = posX;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.w = w;
        this.h = h;
        this.name = name;
        this.backgroundcolor = backgroundcolor;
        this.textcolor = textcolor;
    }
    int posX,posY,width,height,w,h;
    String name;
    Color backgroundcolor,textcolor;

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

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getBackgroundcolor() {
        return backgroundcolor;
    }

    public void setBackgroundcolor(Color backgroundcolor) {
        this.backgroundcolor = backgroundcolor;
    }

    public Color getTextcolor() {
        return textcolor;
    }

    public void setTextcolor(Color textcolor) {
        this.textcolor = textcolor;
    }
    public abstract void draw(Graphics2D g);
}
