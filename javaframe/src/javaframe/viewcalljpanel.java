/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaframe;

import control.khungcall;
import data.cauhoi;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class viewcalljpanel extends JPanel implements MouseListener{
    khungcall []human;
    BufferedImage phanlinh,nguyenminh,linhhuong,vanchien,vannhat,xuananh,bgr;
    Integer []pt;
    ArrayList<cauhoi>dschview;
    int vitri;
    BufferedImage imgtmp;
    Graphics2D gtmp;
    viewcall vc;
    public viewcalljpanel(ArrayList<cauhoi>dsch,int vitri,viewcall vc)
    {
        this.dschview=dsch;
        this.vitri=vitri;
        this.vc= vc;
        human= new khungcall[6];
        pt= new Integer[4];
        try {
            sethuman();
        } catch (IOException ex) {
            Logger.getLogger(viewcalljpanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
public void sethuman() throws IOException
{
    phanlinh = ImageIO.read(viewcalljpanel.class.getResource("/images/phanlinh.jpg"));
    nguyenminh = ImageIO.read(viewcalljpanel.class.getResource("/images/nguyenminh.jpg"));
    linhhuong = ImageIO.read(viewcalljpanel.class.getResource("/images/linhhuong.jpg"));
    vanchien = ImageIO.read(viewcalljpanel.class.getResource("/images/phamchien.jpg"));
    vannhat = ImageIO.read(viewcalljpanel.class.getResource("/images/vannhat.jpg"));
    xuananh = ImageIO.read(viewcalljpanel.class.getResource("/images/xuananh.jpg"));
    bgr= ImageIO.read(viewcalljpanel.class.getResource("/images/bgr.jpg"));
    human[0] = new khungcall("Phan Linh",20, 60, 180, 180, phanlinh);
    human[1] = new khungcall("Nguyễn Minh",278, 60, 180, 180, nguyenminh);
    human[2] = new khungcall("Linh Hương",540, 60, 180, 180, linhhuong);
    human[3] = new khungcall("Văn Chiến",20, 300, 180, 180, vanchien);
    human[4] = new khungcall("Văn Nhật",278, 300, 180, 180, vannhat);
    human[5] = new khungcall("Xuân Anh",540, 300, 180, 180, xuananh);
}
    @Override
    public void paint(Graphics g) {
       velai();
      g.drawImage(imgtmp,0,0,viewcall.SCREEN_WIDTH,viewcall.SCREEN_HEIGHT, this);
        
    }
    public void velai()
    {
        if(imgtmp==null)
        {
            imgtmp=new BufferedImage(viewcall.SCREEN_WIDTH, viewcall.SCREEN_HEIGHT,BufferedImage.TYPE_INT_ARGB);
            
        }
        if(imgtmp!=null)
            
        {
            gtmp= (Graphics2D) imgtmp.getGraphics();
             gtmp.drawImage(bgr, 0,0,viewcall.SCREEN_WIDTH,viewcall.SCREEN_HEIGHT, this);
        for(khungcall h:human)
        {
            h.draw(gtmp);
        }
        }
    }
    public int trasdatonuber(String da)
    {
        switch(da)
        {
            case "A":
                return 0;
            case "B":
                return 1;
            case "C":
                return 2;
            case "D":
                return 3;
        }
        return 0;
    }
public int randommaxmin(int min,int max)
    {
        int value= (int)(((Math.random())*(max-min))+min);
        return value;
    }
    public void chiapt()
    {
     int tmp=0,tmp2=0,tmp3=0;
        for(int i=0;i<pt.length;i++)
        {
            if(trasdatonuber(dschview.get(vitri).getDa())==i)
            {
                pt[i]=randommaxmin(30, 101);
                tmp=i;
                 System.out.println("da "+i+" "+pt[i]);
                break;
            }
        }
       for(int i=0;i<pt.length;i++)
       {
           if(i!=tmp)
           {
               pt[i]=randommaxmin(0,(100-pt[tmp])+1);
               tmp2=i;
                System.out.println("da "+i+" "+pt[i]);
               break;
           }
       }
        for(int i=0;i<pt.length;i++)
       {
           if(i!=tmp &&i!=tmp2)
           {
               pt[i]=randommaxmin(0,(100-(pt[tmp]+pt[tmp2]))+1);
               tmp3=i;
                System.out.println("pt "+i+" "+pt[i]);
               break;
           }
       }
        for(int i=0;i<pt.length;i++)
       {
           if(i!=tmp&& i!=tmp2&&i!=tmp3)
           {
               pt[i]=100-(pt[tmp]+pt[tmp2]+pt[tmp3]);
               System.out.println("pt "+i+" "+pt[i]);
               break;
           }
       }
        
    }
    
    public int timmax()
    {
        chiapt();
        int max=pt[0];
        for(int i=0;i<pt.length;i++)
        {
            if(max<pt[i]) 
            {
                max= pt[i];
                
            }
        }
        return max;
    }
    public int phantumax()
    {
        int max= timmax();
        int i;
        for( i=0;i<pt.length;i++)
        {
            if(max==pt[i])
            {
                break;
                
            }
        } 
        return  i;
    }
    public String ketqua(int vt)
    {
        switch (vt) {
            case 0:
                return "A";
            case 1:
                return "B";
            case 2:
                return "C";
            case 3:
                return "D";

        }
        return " ";
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       int ptm= phantumax();
        for(int i=0;i<human.length;i++)
            {
                if(human[i].check(e))
                {                  
                    vc.setVisible(false);
                    JOptionPane.showMessageDialog(this,human[i].getName()+" Khuyên Bạn nên chọn "+ketqua(ptm),"Trả lời",JOptionPane.INFORMATION_MESSAGE);

                    break;
                }
            }
            
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("pr");    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("");    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("");    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("");    }
    
}
