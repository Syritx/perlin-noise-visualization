import javax.swing.JPanel;
import java.awt.Color;

public class Tile extends JPanel {
    public Tile(int x, int y, int scale, float perlinIndex) {
        int worldX = x*scale;
        int worldY = y*scale;

        int rgb = (int)perlinIndex*10;
        if (rgb > 255) rgb = 255;
        if (rgb < 0) rgb = 0;

        rgb = 255 - rgb;

        Color color = new Color(rgb,rgb,rgb);

        setBounds(worldX,worldY,scale,scale);
        setBackground(color);
    }
}