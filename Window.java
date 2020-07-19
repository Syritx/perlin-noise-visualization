import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.event.*;

public class Window extends JFrame implements ActionListener {
    int TILE_SIZE = 5;

    /* MAIN VARIABLES FOR GENERATION */
    int LENGTH = 150;       // length of the area
    float INTENSITY = 3f;   // Smoothness of the terrain
    int LAYERS = 120;       // layers of the terrain
    /* END */

    Tile[] TILES;
    int TILE_INDEX;

    int WINDOW_SCALE;
    Timer timer = new Timer(1,this);

    public Window() {
        // creating window
        TILES = new Tile[LENGTH*LENGTH];
        WINDOW_SCALE = TILE_SIZE*LENGTH;
        setSize(WINDOW_SCALE,WINDOW_SCALE);
        setTitle("Noise visualisation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        timer.start();

        content();
    }

    void content() {
        JPanel background = new JPanel();
        background.setBounds(0,0,WINDOW_SCALE,WINDOW_SCALE);
        background.setLayout(null);

        // creating and rendering tiles
        float[] heightMaps = Noise.GenerateHeightMaps(LAYERS, LENGTH, INTENSITY, -5, 5);
        for (int x = 0; x < LENGTH; x++) {
            for (int y = 0; y < LENGTH; y++) {
                float perlinIndex = heightMaps[TILE_INDEX];
                TILES[TILE_INDEX] = new Tile(x, y, TILE_SIZE, perlinIndex);
                background.add(TILES[TILE_INDEX]);
                TILE_INDEX++;
            }
        }

        add(background);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}