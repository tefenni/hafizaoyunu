
package controller;


import listener.ButtonListener;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import model.Kart;

/**
 *
 * @author orhan
 */
public class KartKontrol {
    
    private ButtonListener buttonListener;
    private JPanel panel;
    private ArrayList kartlar=new ArrayList();
    private ArrayList rastgeleSayilar=new ArrayList();
    private int kartSayisi=0;
    private String yerlesimDuzeni;
    
    public KartKontrol(JPanel pnl,String yerlesim) {
    this.panel=pnl;
    this.yerlesimDuzeni=yerlesim;
    buttonListener = new ButtonListener();
         
    }
    
    
    
    public void kartUret(int adet)
    {
       if(adet%2==1)
           adet++;
       this.kartSayisi=adet;
      for(int i=0; i<adet; i++)
          rastgeleSayilar.add(0);
      rastgeleSayilarUret();
      for(int i=0; i<adet; i++)
         // System.out.println(rastgeleSayilar.get(i).toString());
      panel.removeAll();
      panel.repaint();
       panel.setPreferredSize(new Dimension(panel.getWidth(),panel.getHeight()));
       GridLayout gl=new GridLayout(2,adet/2);
       FlowLayout fl=new FlowLayout(1);
       if(yerlesimDuzeni.equalsIgnoreCase("GridLayout"))
           panel.setLayout(gl);
       else if(yerlesimDuzeni.equalsIgnoreCase("FlowLayout"))
            panel.setLayout(fl);      
        for(int i=0; i<adet; i++)
        {
            Kart yenikart;
            yenikart=new Kart(buttonListener,rastgeleSayilar.get(i).toString());
            yenikart.setActionCommand(Integer.toString(i));
            yenikart.setPreferredSize(new Dimension(80,80));
            kartlar.add(yenikart);
            panel.add(yenikart);
       
        }
        buttonListener.setKartlar(kartlar);
        panel.doLayout(); 
        
    }
    
    public void rastgeleSayilarUret()
    {
        Random rastgele=new Random();
        int tutulan;
        Integer j,k;
        for(j=1; j<=(kartSayisi/2); j++)
        {
            for(k=1; k<=2; k++)
            {
                    while(true)
                    {
                        tutulan=rastgele.nextInt(kartSayisi);
                        
                        if(rastgeleSayilar.get(tutulan).equals(0))
                            break;
                            
                    }
                    rastgeleSayilar.set(tutulan,j);
                   
            }
        };
    }
    public void butonlariGizle()
    {
        for(int i=0; i<kartlar.size(); i++)
        {
            ((Kart)(kartlar.get(i))).setText("");
            ((Kart)(kartlar.get(i))).setEnabled(true);
         }
    }
    
}
