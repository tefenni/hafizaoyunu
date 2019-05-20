
package controller;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import model.Kart;



/**
 *
 * @author orhan
 */
      

    public class Oyun {
    public static int skor;
    private static  int secilen=1;
    private static Kart kart1,kart2;
      
    public static void karsilastir(Kart kart)
            
    {
           
       if(secilen==1)
        {
            secilen=2;
            kart.setText(kart.getDeger());
            kart1=kart;
            
            
        }
        else if(secilen==2)
        {
            kart2=kart;
            secilen=1;
            if(kart1.getActionCommand().equalsIgnoreCase(kart2.getActionCommand()))
            {
                kart1.setText("");
                skor=skor-20;
                System.out.println(skor);
            }
            else if(kart1.getDeger().equalsIgnoreCase(kart2.getDeger()))
            {
                kart2.setText(kart2.getDeger());
                kart1.setEnabled(false);
                kart2.setEnabled(false);//Oyunun bittiğini anlıyor.
                skor=skor+50;
               System.out.println(skor);
            }
            else
            {
                kart1.setText("");
                kart1.setSelected(false);
                kart2.setSelected(false);
               skor=skor-20;
               System.out.println(skor);
            }
            
        }
       
        
    }
    
    public static void OyunBitti(ArrayList kartlar)
           
    {
         Kart k=null;
         boolean bul=false;
       
        for(int i=0; i<kartlar.size(); i++)
        {
            k=(Kart)kartlar.get(i);
            if(k.isEnabled())
            bul=true;
            
            
        }
        if(bul==false)
        {   
        
             JOptionPane jop; 
             //skor=skor*kartlar.size();
             ZamanKontrol.zamaniDurdur();
             jop = new JOptionPane("Puanınız: "+skor, JOptionPane.INFORMATION_MESSAGE,JOptionPane.DEFAULT_OPTION);
            JDialog dlg=jop.createDialog("OYUN BİTTİ");
            
            
            dlg.setVisible(true);
        }
            
        
    }

    
}
