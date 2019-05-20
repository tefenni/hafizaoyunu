
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import controller.Oyun;
import model.Kart;

/**
 *
 * @author orhan
 */
public class ButtonListener implements ActionListener {
    
    private ArrayList kartlar;

    public ButtonListener() {
        
        
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Kart k=null;
       
        for(int i=0; i<getKartlar().size(); i++)
        {   
            k=(Kart)getKartlar().get(i);
            
            if(k.getActionCommand().equalsIgnoreCase(e.getActionCommand()))
            {
                
                 break;
            }
               
        }
       //System.out.println(k.getDeger());
        Oyun.karsilastir(k);
        Oyun.OyunBitti(kartlar);
    }

    /**
     * @return the kartlar
     */
    public ArrayList getKartlar() {
        return kartlar;
    }

   
    public void setKartlar(ArrayList kartlar) {
        this.kartlar = kartlar;
    }

    
    
    
    
}
