/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Admin
 */
public class viewtop extends JFrame{
    public static int SCREEN_WIDTH=500;
    public static  int SCREEN_HEIGHT=600;
    jpanelviewtop jpnvt;
    ArrayList<String>dstop;
    public viewtop(ArrayList<String>dstop)
    {
        this.dstop=dstop;
        this.setTitle("Danh sách top");
        this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Toolkit toolkit= this.getToolkit();
        Dimension dimension= toolkit.getScreenSize();
        this.setLocation((dimension.width-Javaframe.SCREEN_WIDTH)/2+(Javaframe.SCREEN_WIDTH/4),(dimension.height-Javaframe.SCREEN_HEIGHT)/2);
        this.setVisible(true);
        jpnvt= new jpanelviewtop(this.dstop);
        this.add(jpnvt);
    }
}
