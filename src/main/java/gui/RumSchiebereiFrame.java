package gui;

import logic.Tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by VP on 11.07.14.
 */
public class RumSchiebereiFrame extends JFrame implements Observer, ActionListener {

    private static final String gameName = "rumschieberei";

    private static int fieldSizeX = 4;

    private static int fieldSizeY = 4;

    private static int tileOffset = 3;

    private RumSchiebereiPanel rumSchiebereiPanel;

    private Tiles tiles;

    public RumSchiebereiFrame() {
        super(gameName);

        add(Box.createRigidArea(new Dimension(0, 5)), BorderLayout.NORTH); //?

        tiles = new Tiles();
        rumSchiebereiPanel = new RumSchiebereiPanel(this, fieldSizeX, fieldSizeY, tiles);

        add(rumSchiebereiPanel, BorderLayout.CENTER);

        tiles.addObserver(this);

        setSize(rumSchiebereiPanel.getIconSizeX() + tileOffset * fieldSizeX, rumSchiebereiPanel.getIconSizeY() + tileOffset * fieldSizeY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Tile) {
            Tile tile = (Tile) e.getSource();

            // move tile if possible
            if (tile.isNeighbourOf(tiles.getTheGap())) {
                //switch tile with gap
                tiles.swapTiles(tiles.getPosOfTileId(tile.id), tiles.getPosOfTileId(tiles.getTheGap().id));

                if (tiles.isOrdered()) {
                    JDialog yeahYeah = new JDialog(this, "Yeah", true);
                    yeahYeah.add(new JLabel("YEAH, yeah, yeah!"));
                    yeahYeah.setLocation(this.getLocation().x + this.getWidth() / 2, this.getLocation().y + this.getHeight() / 2);
                    yeahYeah.pack();
                    yeahYeah.setVisible(true);
                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        rumSchiebereiPanel.updateTiles(tiles);
        rumSchiebereiPanel.validate();
    }
}
