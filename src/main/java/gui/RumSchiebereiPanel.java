package gui;

import logic.Tiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;

/**
 * Created by VP on 11.07.14.
 */
public class RumSchiebereiPanel extends JPanel {


    private static final String imagePath = "../unicornRainbow.jpg";

    private Image image;

    private int iconSizeX;

    private int iconSizeY;

    private int tilesX;

    private int tilesY;


    public RumSchiebereiPanel(ActionListener listener, int tilesX, int tilesY, Tiles tiles) {
        this.tilesX = tilesX;
        this.tilesY = tilesY;

        setLayout(new GridLayout(tilesX, tilesY, 0, 0));

        loadImage(listener, tiles);

        addShuffledTiles(tiles);

    }

    public int getIconSizeX() {
        return iconSizeX;
    }

    public int getIconSizeY() {
        return iconSizeY;
    }

    private void loadImage(ActionListener listener, Tiles tiles) {
        ImageIcon iIcon = new ImageIcon(RumSchiebereiPanel.class.getResource(imagePath));

        image = iIcon.getImage();

        iconSizeX = iIcon.getIconWidth();
        iconSizeY = iIcon.getIconHeight();

        int tileSizeX = iconSizeX / tilesX;
        int tileSizeY = iconSizeY / tilesY;

        // add the missing tile at first position.
        Tile gapTile = new Tile(0);
        tiles.add(gapTile);

        // add all the other tiles.
        for (int line = 0; line < tilesX; line++) {
            for (int column = 0; column < tilesY; column++) {
                if (!(column == 0 && line == 0)) {
                    Tile tile = new Tile(line * tilesX + column, new ImageIcon(createImage(new FilteredImageSource(
                            image.getSource(),
                            new CropImageFilter(
                                    column * tileSizeX,
                                    line * tileSizeY,
                                    tileSizeX + 1,
                                    tileSizeY)
                    ))));

                    tile.addActionListener(listener);
                    tiles.add(tile);
                }
            }
        }
    }

    private void addShuffledTiles(Tiles tiles) {
        //Collections.shuffle(tiles.tiles);
        for (Tile tmpTile : tiles)
            add(tmpTile);
    }

    public void updateTiles(Tiles tiles) {
        removeAll();
        for (Tile tmpTile : tiles)
            add(tmpTile);
    }
}
