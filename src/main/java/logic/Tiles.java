package logic;

import gui.Tile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Observable;

/**
 * Created by VP on 11.07.14.
 */
public class Tiles extends Observable implements Iterable<Tile> {
    public ArrayList<Tile> tiles;

    public Tiles(){
        tiles = new ArrayList<Tile>();
    }

    public void add(Tile tile){
        tiles.add(tile);
    }

    public Tile getTheGap(){
        for (Tile tmpTile: tiles){
            if (tmpTile.id == 0)
                return tmpTile;
        }
        throw new RuntimeException();
    }

    public void swapTiles(int tileIdUno, int tileIdDuo){
        Collections.swap(tiles, tileIdUno, tileIdDuo);
        setChanged();
        notifyObservers(this);
    }

    @Override
    public Iterator<Tile> iterator() {
        return tiles.iterator();
    }

    /**
     * Get the position in the tiles array of a tile with the specific id.
     * @param id The tile id.
     * @return The position.
     */
    public int getPosOfTileId(int id) {
        for (int i=0; i<tiles.size(); i++){
            if (tiles.get(i).id == id)
                return i;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Check if the array is ordered according to the tile id.
     * @return True if the tiles ArrayList is ordered otherwise false.
     */
    public boolean isOrdered(){
        for (int i=0; i<tiles.size(); i++){
            if (tiles.get(i).id != i)
                return false;
        }
        return true;
    }
}
