/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javaframe.jpanelvebieudo;

/**
 *
 * @author Admin
 */
public class runsizetex extends Thread{
    
    public cot []cc;
    public int cotc;
    public  jpanelvebieudo jpn;
    public runsizetex(cot[] cc, int cotc,jpanelvebieudo jp) {
        this.cc = cc;
        this.cotc = cotc;
        this.jpn=jp;
    }

    @Override
    public void run() {
       
        int tmp=0;
        while (true) {            
            if(tmp==22)
            {
                break;
            }
            cc[cotc].setSizetext(tmp);
            tmp++;
            jpn.repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(runsizetex.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
}
