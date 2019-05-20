/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author orhan
 */
public class ZamanKontrol {
    
    public static JLabel  saat,dakika,saniye,puan;
    public static Timer zamanlayici;

    public ZamanKontrol() {
    }
    
    
   

    public ZamanKontrol(JLabel saat,JLabel dakika,JLabel saniye,JLabel puan) {
        this.saat=saat;
        this.dakika=dakika;
        this.saniye=saniye;
        this.puan=puan;
        
    }
    
    public void zamaniBaslat()
    {
         zamanlayici=new Timer(1000,new ActionListener() {
             
             
             
             @Override
             public void actionPerformed(ActionEvent e) {
                 int saatdeger=Integer.parseInt(saat.getText());
                 int saniyedeger=Integer.parseInt(saniye.getText());
                 int dakikadeger=Integer.parseInt(dakika.getText());
                 if(saniyedeger<59)
                     saniyedeger++;
                 else
                 {
                     saniyedeger=0;
                     if(dakikadeger<59)
                        dakikadeger++;
                     else
                     {
                         dakikadeger=0;
                         saatdeger++;
                     }
                 }
                 NumberFormat nf=new DecimalFormat("00");
                 saat.setText(nf.format(saatdeger));
                 dakika.setText(nf.format(dakikadeger));
                 saniye.setText(nf.format(saniyedeger));
                 
                 
                 
                 
             }
             
             
         });
         
         zamanlayici.start();
    }
    
    public static void zamaniDurdur()
    {
        zamanlayici.stop();
        puan.setText(Integer.toString(Oyun.skor));
    
    
    
    }
    
}
