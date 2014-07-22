package gui;

import javax.swing.*;

/**
 * Created by VP on 11.07.14.
 */
public class Tile extends JButton {

    public final int id;

    public Tile(int id, ImageIcon icon) {
        this.id = id;
        setIcon(icon);
    }

    public Tile(int id) {
        this.id = id;
        setBorder(BorderFactory.createEmptyBorder());
    }

    public boolean isNeighbourOf(Tile gap){

        if (
                (getX() + getWidth() == gap.getX() ||
                        getX() - getWidth() == gap.getX()
                ) &&
                getY() == gap.getY())
            return true;

        if (
                (getY()+getHeight() == gap.getY() ||
                        getY() - getHeight() == gap.getY()
                ) &&
                        getX() == gap.getX())
            return true;

        return false;
    }
}
