package Views.SoundPanelElements;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;


/**
 *A class which is the "+" button in the SoundPanel grid shown in the design.
 * @author IgIz
 */
public class AddSoundButton extends JLabel{
    private Image icon;
    
    public AddSoundButton(Image icon){
        this.icon = icon;
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(icon, 0, 0 ,this.getWidth(), this.getHeight(), this);
    }
}
   