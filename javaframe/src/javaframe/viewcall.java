/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import data.cauhoi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.util.ArrayList;
import static javaframe.Javaframe.SCREEN_HEIGHT;
import static javaframe.Javaframe.SCREEN_WIDTH;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import loadfile.SoundPlayer;

/**
 *
 * @author Admin
 */
public class viewcall extends JFrame implements Runnable{
       public static final int SCREEN_WIDTH=800;
    public static final int SCREEN_HEIGHT=600;
    viewcalljpanel view;
    Thread runcall;
     ArrayList<cauhoi>dschview;
    int vitri;
    File file;
    SoundPlayer sound;
    public viewcall(ArrayList<cauhoi>dsch,int vitri)
    {
        
        this.dschview=dsch;
        this.vitri=vitri;
        file= new File("call.wav");
        sound= new SoundPlayer(file);
        sound.play();
         Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setBounds((dimension.width - SCREEN_WIDTH) / 2, (dimension.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH, SCREEN_HEIGHT);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setTitle("ViewCall");
        
        view = new viewcalljpanel(dschview,this.vitri,this);
        startruncall();
        
    }
public void  startruncall()
{
    if(runcall==null)
    {
        runcall= new Thread(this);
    }
    if(runcall!=null)
    {
        runcall.start();
    }
}
    @Override
    public void run() {

        add(view);
        addMouseListener(view);
    }
}
