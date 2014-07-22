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

    public Tiles(ArrayList<Tile> tiles){
        this.tiles = tiles;
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

    public int getPosOfTileId(int id) {
        for (int i=0; i<tiles.size(); i++){
            if (tiles.get(i).id == id)
                return i;
        }
        throw new IllegalArgumentException();
    }

    public boolean isOrdered(){
        for (int i=0; i<tiles.size(); i++){
            if (tiles.get(i).id != i)
                return false;
        }
        return true;
    }
}
