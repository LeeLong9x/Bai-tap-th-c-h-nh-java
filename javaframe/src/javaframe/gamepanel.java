
package javaframe;

import control.butonsuport;
import control.input;
import control.khungch;
import control.khungda;
import data.cauhoi;
import data.loaddata;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.w3c.dom.events.MouseEvent;
import control.buttonimg;
import control.khungcall;
import control.runcorrect;
import java.awt.List;
import java.io.File;
import javax.swing.JOptionPane;
import loadfile.SoundPlayer;

/**
 *
 * @author Admin
 */
public class gamepanel extends JPanel implements MouseListener,MouseMotionListener,Runnable{
    
    BufferedImage icon, backgroud;
    button[] Button;
    input ip;
    gameplay playgame;
    public khungch chp;
    public khungda[] kda;
    public static int startgame = 0;
    private Thread thread;
    runcorrect correctthread;
public ArrayList<cauhoi> dsch= new loaddata().data();
    boolean haveclick = false;
    int phut = 1;
    int giay = 30, diem = 0;
    Random rd;
    int vitri;
    String dachon;
    buttonimg []reset;
    public butonsuport []btnsp;
    BufferedImage trogiup,back,sp1,sp2,sp3,sp4,correct;
    Integer []pt;
    public BufferedImage imgtmp;
    public Graphics2D drawtmp;
    private int jfx,jfy;
     File  pathbgr,fdung,fsai,fnen,cd;
    SoundPlayer nhacbgr,dung,sai,nen,chiapt;
    khungcall iconconrect;
    boolean showiconcorrect=false;
    public boolean  havesave=false;
    public boolean havenewgame=false;
    public  boolean  newqs=true;
  
    public gamepanel(int jfx,int jfy) throws IOException
    {
        this.jfx=jfx;
        this.jfy=jfy;
        icon=ImageIO.read(gamepanel.class.getResource("/images/altp.png"));
        backgroud=ImageIO.read(getClass().getResource("/images/backgroud.jpg"));
        back= ImageIO.read(gameplay.class.getResource("/images/back.png"));
        correct=ImageIO.read(gameplay.class.getResource("/images/correct.png"));
        iconconrect=new khungcall("",Javaframe.SCREEN_WIDTH/2+50,Javaframe.SCREEN_HEIGHT/2-60,10, 10, correct);
        Button= new button[5];
        kda= new khungda[4];
        pt= new Integer[4];
        reset= new buttonimg[1];
        btnsp= new butonsuport[4];
        
        Button[0] = new button(450, 300, 100, 40, "New Game", 15, 22, Color.GREEN, Color.RED);
        Button[0].setMovecolor(Color.yellow);
        Button[0].setDragcolor(Color.BLUE);
        Button[1] = new button(450, 350, 100, 40, "Tiếp Tục", 18, 22, Color.GREEN, Color.RED);
        Button[1].setMovecolor(Color.yellow);
        Button[1].setDragcolor(Color.BLUE);
        if(new loadfile.loaddata().check()==false)
        {
        Button[1].setEnlable(false);
        Button[1].setColorbackgroud(Color.darkGray);
        }
        Button[2] = new button(450, 400, 100, 40, "Top", 33, 22, Color.GREEN, Color.RED);
        Button[2].setMovecolor(Color.yellow);
        Button[2].setDragcolor(Color.BLUE);
        Button[3] = new button(450, 450, 100, 40, "Hướng Dẫn", 10, 22, Color.GREEN, Color.RED);
        Button[3].setMovecolor(Color.yellow);
        Button[3].setDragcolor(Color.BLUE);
        Button[4] = new button(450, 500, 100, 40, "Thoát", 25, 22, Color.GREEN, Color.RED);
        Button[4].setMovecolor(Color.yellow);
        Button[4].setDragcolor(Color.BLUE);
        trogiup= ImageIO.read(gamepanel.class.getResource("/images/reset.png"));       
        reset[0]= new buttonimg(20,15, 60, 60,back);
        ip = new input(this);
        playgame = new gameplay();
        rd = new Random();
    
       
        setda();
        setbtnsp();
        pathbgr = new File("altp.wav");
        cd = new File("50.wav");
        chiapt = new SoundPlayer(cd);
        nhacbgr = new SoundPlayer(pathbgr);
        nhacbgr.play();
        chaynhacnen();
    }

    public khungch getChp() {
        return chp;
    }

    public void setChp(khungch chp) {
        this.chp = chp;
    }
    public void setbtnsp()throws IOException
    {
        sp1 = ImageIO.read(gameplay.class.getResource("/images/trogiup1.png"));
        sp2 = ImageIO.read(gameplay.class.getResource("/images/trogiup2.png"));
        sp3 = ImageIO.read(gameplay.class.getResource("/images/khangia.png"));
        sp4 = ImageIO.read(gameplay.class.getResource("/images/reset.png"));
        btnsp[0] = new butonsuport(302,37,260, 10, 40, 40, sp1,Color.GREEN,Color.yellow,Color.BLUE);
        btnsp[1] = new butonsuport(401,35,360, 10, 40, 40, sp2,Color.GREEN,Color.yellow,Color.BLUE);
        btnsp[2] = new butonsuport(501,38,460, 10, 40, 40, sp3,Color.GREEN,Color.yellow,Color.BLUE);
        btnsp[3] = new butonsuport(602,39,560, 10, 40, 40, sp4,Color.GREEN,Color.yellow,Color.BLUE);

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
            if(trasdatonuber(dsch.get(vitri).getDa())==i)
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
    public void setda() 
    {   
       
        if(newqs==true)
        {
        vitri=rd.nextInt(dsch.size());
        } 
        
        chp = new khungch(100, 140, 800, 150, 100, 65, "Câu "+cau+": "+ dsch.get(vitri).getCh(), Color.PINK, Color.yellow);
        chp.checksizename();
        kda[0] = new khungda(80, 350, 330, 60, 20, 30, dsch.get(vitri).getDaA(), Color.BLUE, Color.WHITE);
        kda[0].setDragcolor(Color.GREEN);
        kda[0].setMovecolor(Color.yellow);
        kda[1] = new khungda(550, 350, 330, 60, 20, 30, dsch.get(vitri).getDaB(), Color.BLUE, Color.WHITE);
        kda[1].setDragcolor(Color.GREEN);
        kda[1].setMovecolor(Color.yellow);
        kda[2] = new khungda(80, 450, 330, 60, 20, 30, dsch.get(vitri).getDaC(), Color.BLUE, Color.WHITE);
        kda[2].setDragcolor(Color.GREEN);
        kda[2].setMovecolor(Color.yellow);
        kda[3] = new khungda(550, 450, 330, 60, 20, 30, dsch.get(vitri).getDaD(), Color.BLUE, Color.WHITE);
        kda[3].setDragcolor(Color.GREEN);
        kda[3].setMovecolor(Color.yellow);
    }
@Override
    public void paint(Graphics g)
    {
        if(startgame==0)
        {
        g.drawImage(backgroud,0,0,Javaframe.SCREEN_WIDTH,javaframe.Javaframe.SCREEN_HEIGHT, null);
        g.drawImage(icon,Javaframe.SCREEN_WIDTH/2-100,60,200,200, null);
      
       for(button btn: Button)
       {
           btn.draw((Graphics2D)g);
       }
        }
        else if(startgame==1)
        {
            drawtmp();
            g.drawImage(imgtmp, 0, 0,Javaframe.SCREEN_WIDTH,Javaframe.SCREEN_HEIGHT,this);
            if(showiconcorrect==true)
            {
                iconconrect.draw((Graphics2D) g);
            }
           
          
        }
      
    }
    public void drawtmp()
    {
        if(imgtmp==null)
        {
            imgtmp= new BufferedImage(Javaframe.SCREEN_WIDTH, Javaframe.SCREEN_HEIGHT, BufferedImage.TYPE_INT_ARGB);
        }
        if(imgtmp!=null)
        {
            drawtmp= (Graphics2D) imgtmp.getGraphics();
        }
        if(drawtmp!=null)
        {
             playgame.draw(drawtmp,chp,kda,phut,giay,diem,reset,btnsp);
        }
    }
    public void newgame()
    {
          vitri = rd.nextInt(dsch.size());
        cau = 1;
        chp = new khungch(100, 140, 800, 150, 100, 65, "Câu " + cau + ": " + dsch.get(vitri).getCh(), Color.PINK, Color.yellow);
        chp.checksizename();
        setda();
        resettime();
        haveclick = false;
        btnsp[0].setHaveclick(false);
        btnsp[0].setBackgroundcolor(btnsp[0].getBackgroundcolor());
        btnsp[1].setHaveclick(false);
        btnsp[1].setBackgroundcolor(btnsp[0].getBackgroundcolor());
        btnsp[2].setHaveclick(false);
        btnsp[3].setBackgroundcolor(btnsp[0].getBackgroundcolor());
        btnsp[3].setHaveclick(false);
        btnsp[3].setBackgroundcolor(btnsp[0].getBackgroundcolor());
        repaint();
            
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
public void xulyimgbutonclick(int btn) throws IOException
{
   
    
    switch(btn)
    {
       
        case 0:
            startgame = 0;
      
            haveclick = false;
            new loadfile.loaddata().xoaall2();
            new loadfile.loaddata().ghivitri(vitri);
            new loadfile.loaddata().ghidiem(diem);
            new loadfile.loaddata().ghitime(getPhut(), getGiay());
            Button[1].setEnlable(true);
            havesave=true;
            repaint();
            break;
    }
}

    public int getVitri() {
        return vitri;
    }

    public void setVitri(int vitri) {
        this.vitri = vitri;
    }

    public int getPhut() {
        return phut;
    }

    public void setPhut(int phut) {
        this.phut = phut;
    }

    public int getGiay() {
        return giay;
    }

    public void setGiay(int giay) {
        this.giay = giay;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
public void xulybtnsplclick(int btn) throws IOException
{
     String da=dsch.get(vitri).getDa();
    int tmp=trasdatonuber(da);
    int sp1=rd.nextInt(4);
    int sp2=rd.nextInt(4);
    while (sp1==tmp|| sp2==tmp || sp1==sp2) {
        
        sp1=rd.nextInt(4);
        sp2=rd.nextInt(4);
    }
    switch(btn)
    {
        
        case 0:
            if(btnsp[0].isHaveclick()==false)
            {
                chiapt.play();
            kda[sp1].setName("");
            kda[sp2].setName("");
            btnsp[0].setHaveclick(true);
            btnsp[0].setBackgroundcolor(Color.darkGray);
            new loadfile.loaddata().ghitrogiup(0);
            repaint();
            }
            break;
        case 1:
             if(btnsp[1].isHaveclick()==false)
            {
           
                 btnsp[1].setHaveclick(true);
                 btnsp[1].setBackgroundcolor(Color.darkGray);
                 new viewcall(dsch,vitri);
                 new loadfile.loaddata().ghitrogiup(1);
                repaint();
            }
            break;
        case 2:
            if(btnsp[2].isHaveclick()==false)
            {
                chiapt();
            new Jframebieudo(pt[0]*(7/2),pt[1]*(7/2),pt[2]*(7/2),pt[3]*(7/2),jfx+1020,jfy+60);
                btnsp[2].setHaveclick(true);
                btnsp[2].setBackgroundcolor(Color.darkGray);
                 new loadfile.loaddata().ghitrogiup(2);
                repaint();
            }
            break;
        case 3:
             if(btnsp[3].isHaveclick()==false)
             {
            vitri= rd.nextInt(dsch.size());
            chp = new khungch(100, 140, 800, 150, 100, 65, "Câu "+cau+": " + dsch.get(vitri).getCh(), Color.PINK, Color.yellow);
            chp.checksizename();
            setda();
            resettime();
            haveclick = false;
            btnsp[3].setHaveclick(true);
            btnsp[3].setBackgroundcolor(Color.darkGray);
             new loadfile.loaddata().ghitrogiup(3);
            repaint();
             }
            break;
                    
    }
}
  public void chaynhacdung()
  {
      if(cau<=4)
      {
       fdung= new File("dung14.wav");
      }
      else if(cau==5)
      {
          fdung= new File("dung5.wav");
      }
      else if(cau>5 && cau<=15)
      {
          fdung= new File("611.wav");
      }
        dung= new SoundPlayer(fdung);
         dung.play();
        
  }
   public void chaynhacsai()
  {
      if(cau<=5)
      {
       fsai= new File("sai15.wav");
      }
      else if(cau==6)
      {
          fsai= new File("sai6.wav");
      }
      else if(cau>6 && cau<=15)
      {
          fsai= new File("sai8.wav");
      }
        sai= new SoundPlayer(fsai);
         sai.play();
        
  }
   public void chaynhacnen()
   {if(cau<=6)
   {
       fnen= new File("5.wav");
   }
   else if(cau>6)

   {
       fnen= new File("6.wav");
   }       
   nen= new SoundPlayer(fnen);
 
   }

    public int getCau() {
        return cau;
    }

    public void setCau(int cau) {
        this.cau = cau;
    }
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
       
       
    for(int i=0;i<Button.length;i++)
      {
          if(Button[i].check(e) && Button[i].isEnlable()==true)
          {
              try {
                  ip.setmouseclick(i);
              } catch (IOException ex) {
                  Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
              }
              repaint();
              break;
          }
      }
      for(int i=0;i<kda.length;i++)
      {
          if(kda[i].check(e))
          {
                haveclick=true;
                dachon=kda[i].getName();
                kda[i].setBackgroundcolor(Color.darkGray);
                repaint();
                break;
          }
      }
      for(int i=0;i<reset.length;i++)
      {
          if(reset[i].check(e))
          {
              try {
                  xulyimgbutonclick(i);
              } catch (IOException ex) {
                  Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
              }
             repaint();
          }
      }
      
      for(int i=0;i<btnsp.length;i++)
      {
          if(btnsp[i].check(e))
          {
              try {
                  xulybtnsplclick(i);
              } catch (IOException ex) {
                  Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
              }
              
          }
      }
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        System.out.println("");    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        System.out.println("");    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        System.out.println("");    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
       
  
    
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {

        for(button btn: Button)
        {
            if(btn.check(e)&& btn.isEnlable()==true)
            {
                btn.trans(0, e);
                repaint();
            }
        }
        if(haveclick==false)
        {
        for(khungda d:kda)
        {
            if(d.check(e))
            {
                d.trans(0, e);
                repaint();
            }
        }
        }
        for(int i=0;i<btnsp.length;i++)
 {
     if(btnsp[i].check(e) && btnsp[i].haveclick==false)
     {
         btnsp[i].trans(0, e);
         repaint();
     }
     else
          if(btnsp[i].check(e)==false && btnsp[i].haveclick==false)
          {
             btnsp[i].resetcolorbutton();
              repaint();
          }
 }
    }
    public void showcorrect()
    {
       
        correctthread = new runcorrect(iconconrect, this);
        correctthread.start();

    }
    public  void resetcorrect()
    {
        iconconrect.setPostx(Javaframe.SCREEN_WIDTH/2+50);
        iconconrect.setPosty(Javaframe.SCREEN_HEIGHT/2-60);
        iconconrect.setWidth(10);
        iconconrect.setHeight(10);
    }
int i=0;
    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {

 for(int i=0;i<Button.length;i++)
        {
            if(Button[i].check(e) && Button[i].isEnlable()==true)
            {
               Button[i].trans(1, e);
                repaint();
            }
            else
          if(Button[i].check(e)==false && Button[i].isEnlable()==true )
          {
              Button[i].resetcolorbutton();
              repaint();
          }
        }
 if(haveclick==false)
 {
  for(int i=0;i<kda.length;i++)
        {
            if(kda[i].check(e))
            {
               kda[i].trans(1, e);
                repaint();
            }
            else
          if(kda[i].check(e)==false)
          {
              kda[i].resetcolorbutton();
              repaint();
          }
        }
 }

 for(int i=0;i<btnsp.length;i++)
 {
     if(btnsp[i].check(e)&& btnsp[i].haveclick==false)
     {
         btnsp[i].trans(1, e);
         repaint();
     }
     else
          if(btnsp[i].check(e)==false&& btnsp[i].haveclick==false )
          {
             btnsp[i].resetcolorbutton();
              repaint();
          }
 }
    }
      public void startgame()
      {
          if(thread==null)
          {
              thread= new Thread(this);
          }
          if(thread!=null)
          {
              thread.start();
          }
      }
      public void resettime()
      {
          phut = 1;
          giay = 30;
      }
      public void xulytime() throws IOException
      {
         
           giay--;
          if (giay == 0) {
              if (phut == 0) {
                  Button[1].setEnlable(false);
                  Button[1].setColorbackgroud(Color.darkGray);
                   try {
                         new loadfile.loaddata().xoaall();
                     } catch (IOException ex) {
                         Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
                     }
                  nen.stop();
                  chaynhacsai();
                  String name = JOptionPane.showInputDialog(this, "Tên của bạn", "Game over", JOptionPane.OK_CANCEL_OPTION);
                  startgame = 0;
                  haveclick = false;
                  new loadfile.loaddata().xoaall();
                  repaint();
                  resettime();
                  cau = 1;
                  diem = 0;
                  demtg=0;
              } else {
                  phut--;
                  giay = 60;
              }
             }
            
             if(phut<=0)
             {
                 phut=0;
             }
      }
      int cau=1;
      public  void resetgame()
      {
                    startgame=0;
                    haveclick=false;
                    cau=1;
                    diem=0;
      }
        public  void resetgame2()
      {
                    startgame=0;
                    haveclick=false;
                    cau=1;
                 
      }
    public int demtg=0;
     
      
    @Override
    public void run() {
        
        while (true) {            
            
           if(nhacbgr.getClip().isRunning()==false && startgame==0)
           {
               nhacbgr.stop();
               nhacbgr.play();
           }
           else if(startgame==1)
           {
               nhacbgr.stop();
              
               nen.stop();
               nen.play();
             
               
           }
             if(haveclick)
             {
                
                 if (chp.checkda(dachon, dsch.get(vitri))) {
                     showiconcorrect=true;
                     
                     showcorrect();
                    chaynhacdung();
                     try {
                         Thread.sleep(3500);
                     } catch (InterruptedException ex) {
                         Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     showiconcorrect=false;
                     resetcorrect();
                      cau++;
                      dsch.remove(vitri);
                     vitri = rd.nextInt(dsch.size());
                     chp = new khungch(100, 140, 800, 150, 100, 65,"Câu "+cau+": "+dsch.get(vitri).getCh(), Color.PINK, Color.yellow);
                     chp.checksizename();
                      setda();
                      resettime();
                      haveclick=false;
                     
                      diem++;
                      if(cau==16) 
                      {
                          resetgame();
                          System.out.println("victory");
                          
                     try {
                         new loadfile.loaddata().xoaall();
                     } catch (IOException ex) {
                         Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      }
                      
                      repaint();
                }
                else  if(chp.checkda(dachon, dsch.get(vitri))==false)
                {
                   
                    resetgame2();
                    nen.stop();
                    chaynhacsai();
                    nhacbgr.play();
                    String name= JOptionPane.showInputDialog(this, "Tên của bạn", "Game over", JOptionPane.OK_CANCEL_OPTION);
                    if(name!=null)
                    {
                     try {
                         new loadfile.loaddata().ghitop(name,diem,demtg);
                     } catch (IOException ex) {
                         Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    }
                     
                    Button[1].setEnlable(false);
                    Button[1].setColorbackgroud(Color.darkGray);
                   
                     try {
                         new loadfile.loaddata().xoaall();
                     } catch (IOException ex) {
                         Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
                     }
                    diem=0;
                    demtg=0;
                    repaint();
                }
                
             }
               if(startgame==1)
               {
               try {
                   xulytime();
               } catch (IOException ex) {
                   Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
               }
               demtg++;
               }
               
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(gamepanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            repaint();
            
            
        }
        
    }
    
    
}
