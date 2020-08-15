/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JWindow;

/**
 *
 * @author Admin
 */
public class Javaframe extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static final int SCREEN_WIDTH=1000;
    public static final int SCREEN_HEIGHT=650;
 gamepanel gamepl;
   
    public Javaframe() throws IOException
    {
     
        
        Toolkit toolkit = this.getToolkit();
        Dimension dimension = toolkit.getScreenSize();
       
        setBounds((dimension.width - SCREEN_WIDTH) / 2, (dimension.height - SCREEN_HEIGHT) / 2, SCREEN_WIDTH, SCREEN_HEIGHT);
        setVisible(true);
        setResizable(false);
        setTitle("AI LÀ TRIỆU PHÚ");
     
         gamepl= new gamepanel(this.getX(),this.getY());
         add(gamepl);
         addMouseListener(gamepl);
          addMouseMotionListener(gamepl);
          
          gamepl.startgame();
         
          this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int check= JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát", "Chú Ý",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
               if(check== JOptionPane.YES_OPTION)
               {
                    try {
                        if(gamepl.havesave==false&& gamepl.havenewgame==true)
                        {
                        new loadfile.loaddata().ghivitri(gamepl.vitri);
                        new loadfile.loaddata().ghidiem(gamepl.diem);
                        new loadfile.loaddata().ghitime(gamepl.getPhut(), gamepl.getGiay());
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(Javaframe.class.getName()).log(Level.SEVERE, null, ex);
                    }
          
                   System.exit(0);
                   
               }
               else
               {
                   setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
               }
            }
           
              
});
           
    }
    public static void main(String[] args) throws IOException {
       new Javaframe();
    }
    
}
