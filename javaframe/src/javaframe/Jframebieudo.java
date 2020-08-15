/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import loadfile.SoundPlayer;


/**
 *
 * @author Admin
 */
public class Jframebieudo extends JFrame{
    public static final int SCREEN_WIDTH=400;
    public static final int SCREEN_HEIGHT=500;
    jpanelvebieudo bieudo;
  int A,B,C,D,posx,posy;
    SoundPlayer sound;
    File file;
    public Jframebieudo(int A,int B,int C,int D,int posx,int posy) throws IOException
    {
        this.A=A;
        this.B=B;
        this.C=C;
        this.D=D;
        this.posx=posx;
        this.posy=posy;
        file= new File("khangia.wav");
        sound= new SoundPlayer(file);
        sound.play();
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        setLocation(this.posx,this.posy);
        setVisible(true);
        setResizable(false);
        setTitle("Biểu Đồ Thể Hiện Ý kiến khán giả trong trường quay");
        bieudo= new jpanelvebieudo(this.A,this.B,this.C,this.D);
        bieudo.runbd();
        add(bieudo);
        JScrollPane jScrollPane= new JScrollPane(bieudo);
        add(jScrollPane);
        
    }
    
}
