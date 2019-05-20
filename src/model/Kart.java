
package model;


import listener.ButtonListener;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JToggleButton;
/**
 *
 * @author orhan
 */
public class Kart extends JToggleButton {
    private String deger;
    
       
    public Kart(ButtonListener dd,String deger) {
        this.addActionListener(dd);
        this.setDeger(deger); 
        this.setText(deger);
           
        
    }

   
    
    /**
     * @return the deger
     */
    public String getDeger() {
        return deger;
    }

    /**
     * @param deger the deger to set
     */
    public void setDeger(String deger) {
        this.deger = deger;
    }

   
}
