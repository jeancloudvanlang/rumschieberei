package gui;

import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TileTest {

    private final int numTiles = 9;

    private Tile[] tiles = new Tile[numTiles];

    private final Point[] locations = new Point[numTiles];

    @Before
    public void setUp() throws Exception {

        locations[0] = new Point(0,0);
        //right neighbours
        locations[1] = new Point(100,0);
        locations[2] = new Point(100,100);
        locations[3] = new Point(100,-100);
        // left neighbours
        locations[4] = new Point(-100,0);
        locations[5] = new Point(-100,100);
        locations[6] = new Point(-100,-100);
        // up and down
        locations[7] = new Point(0,-100);
        locations[8] = new Point(0,100);

        for(int i=0; i<numTiles; i++){
            tiles[i] = new Tile(i);
            tiles[i].setLocation(locations[i]);
            tiles[i].setSize(100, 100);
        }
    }

    @Test
    public void testIsNeighbourOf() throws Exception {
        assertTrue(tiles[0].isNeighbourOf(tiles[1]));
        assertTrue(tiles[0].isNeighbourOf(tiles[4]));
        assertTrue(tiles[0].isNeighbourOf(tiles[7]));
        assertTrue(tiles[0].isNeighbourOf(tiles[8]));

        assertFalse(tiles[0].isNeighbourOf(tiles[2]));
        assertFalse(tiles[0].isNeighbourOf(tiles[3]));
        assertFalse(tiles[0].isNeighbourOf(tiles[5]));
        assertFalse(tiles[0].isNeighbourOf(tiles[6]));
    }
}