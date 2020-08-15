/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadfile;

import data.cauhoi;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class loaddata {
    String vitri="vitri.txt";
    String trogiup="trogiup.txt";
    String diem="diem.txt";
    String time="time.txt";
    String top="top.txt";
    public loaddata() throws IOException
    {
        
        
    }
    public  void ghivitri(int vitri) throws IOException
    {
    
        File filevitri= new File(this.vitri);
        if(!filevitri.exists())
        {
            filevitri.createNewFile();
        }
         FileWriter filew= new FileWriter(filevitri);
         filew.write(String.valueOf(vitri));
         System.out.println("viet vao"+vitri);
         filew.close();
    }
    public void ghitop(String ten,int diem,int time) throws IOException
    {
         File filetop= new File(this.top);
        if(!filetop.exists())
        {
            filetop.createNewFile();
        }
         
         FileWriter filew= new FileWriter(filetop,true);
          filew.write("\r\n"+ten+"       "+String.valueOf(diem)+"        "+String.valueOf(time));
           
      
         
        
      
         filew.close();
    }
    public ArrayList<String> gettop() throws FileNotFoundException, IOException
    {
        ArrayList<String> ds= new ArrayList<>();
         File file= new File("top.txt");
          FileInputStream read= new FileInputStream(file);
          DataInputStream input= new DataInputStream(read);
          input.readLine();
          String c= input.readLine();
          ds.add(c);
          while (c!=null) {            
            c=input.readLine();
              ds.add(c);
        }
          input.close();
          read.close();
          return  ds;
        
    }
    public  void ghitrogiup(int trogiup) throws IOException
    {
        
        File filevitri= new File(this.trogiup);
        if(!filevitri.exists())
        {
            filevitri.createNewFile();
        }
         FileWriter filew= new FileWriter(filevitri,true);
         filew.write(String.valueOf(trogiup)+"\r\n");
         filew.close();
    }
    public  void ghidiem(int diem) throws IOException
    {
        
        File filevitri= new File(this.diem);
        if(!filevitri.exists())
        {
            filevitri.createNewFile();
        }
         FileWriter filew= new FileWriter(filevitri);
         filew.write(String.valueOf(diem));
         filew.close();
    }
     public  void ghitime(int phut,int giay) throws IOException
    {
        
        File filevitri = new File(this.time);
        if (!filevitri.exists()) {
            filevitri.createNewFile();
        }
        FileWriter filew = new FileWriter(filevitri,true);
        filew.write(String.valueOf(phut)+"\r\n");
        filew.write(String.valueOf(giay));
        filew.close();
    }
     public int  doccauhoi() throws IOException
     {
         File filevitri = new File(this.vitri);
        if (!filevitri.exists()) {
            filevitri.createNewFile();
        }
         FileReader read= new FileReader(filevitri);
         int c= read.read();
         System.out.println("doc ra:"+c);
         read.close();
         return c;
     }
     public int  docdiem() throws IOException
     {
         File file=new File("diem.txt");
        if(!file.exists())
                {
                    file.createNewFile();
                }
        FileInputStream fileInputStream= new FileInputStream(file);
        int c=fileInputStream.read();
         System.out.println((char)c);
        return c;
        
        
        
     }
      public int  docvitri() throws IOException
     {
         File file=new File(this.vitri);
        if(!file.exists())
                {
                    file.createNewFile();
                }
       
         FileInputStream read= new FileInputStream(file);
          DataInputStream input= new DataInputStream(read);
         String c= input.readLine();
          
            System.out.println("doc ra:"+c);
         return Integer.parseInt(c);
        
        
        
     }
      public int  docphut() throws IOException
     {
         File filevitri = new File(this.time);
        if (!filevitri.exists()) {
            filevitri.createNewFile();
        }
         FileReader read= new FileReader(filevitri);
         int c= read.read();
         read.close();
         System.out.println("phut"+c);
         return c;
         
        
     }
       public int  docgiay() throws IOException
     {
         File filevitri = new File(this.time);
        if (!filevitri.exists()) {
            filevitri.createNewFile();
        }
       
         FileInputStream read= new FileInputStream(filevitri);
          DataInputStream input= new DataInputStream(read);
         String c= input.readLine();
            c=input.readLine();
            System.out.println(c);
         return Integer.parseInt(c);
     }
       public void xoaall() throws IOException
       {
           File filevitri= new File(this.vitri);
           FileWriter writervitri= new FileWriter(filevitri);
           writervitri.write("");
            File filediem= new File(this.diem);
           FileWriter writerdiem= new FileWriter(filediem);
           writerdiem.write("");
            File filetime= new File(this.time);
           FileWriter writertime= new FileWriter(filetime);
           writertime.write("");
            File filetrogiup= new File(this.trogiup);
           FileWriter writertrogiup= new FileWriter(filetrogiup);
           writertrogiup.write("");
           
       }
         public void xoaall2() throws IOException
       {
           File filevitri= new File(this.vitri);
           FileWriter writervitri= new FileWriter(filevitri);
           writervitri.write("");
            File filediem= new File(this.diem);
           FileWriter writerdiem= new FileWriter(filediem);
           writerdiem.write("");
            File filetime= new File(this.time);
           FileWriter writertime= new FileWriter(filetime);
           writertime.write("");
           
           
       }
      public boolean check() throws FileNotFoundException, IOException
      {  try {
          File file= new File(this.vitri);
          FileInputStream read= new FileInputStream(file);
          DataInputStream input= new DataInputStream(read);
          String c= input.readLine();

              if(c.equals("")|| c.equals(" ")||c.equals(null))
     {
         System.out.println("trống");
         return false;
     }
         return true;
          } catch (Exception e) {
          }
     return false;
      }
      public  ArrayList<Integer> dsspused() throws IOException
      {
       String c;
          ArrayList<Integer> ds= new ArrayList<>();
          File file= new File(this.trogiup);
          FileInputStream read= new FileInputStream(file);
          DataInputStream input= new DataInputStream(read);
          try {
              
            c=input.readLine();
            ds.add(Integer.parseInt(c));
            c=input.readLine();
            ds.add(Integer.parseInt(c));
            c=input.readLine();
            ds.add(Integer.parseInt(c));
            c=input.readLine();
            ds.add(Integer.parseInt(c));
          } catch (Exception e) {
              System.out.println(e.getMessage());
          }
            
       read.close();
        input.close();
        return  ds;
      }
}
