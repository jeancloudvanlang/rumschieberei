package logic;

import gui.Tile;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.*;

public class TilesTest {

    private Tiles tilesOrderedAsc = new Tiles();
    private final int numTiles = 10;

    @Before
    public void setUp() throws Exception {
        for (int i=0; i<numTiles; i++){
            tilesOrderedAsc.add(new Tile(i));
        }
    }

    @Test
    public void testGetPosOfTileId() throws Exception {
        assertEquals(tilesOrderedAsc.getPosOfTileId(0), 0);
        assertEquals(tilesOrderedAsc.getPosOfTileId(9),9);

        Collections.reverse(tilesOrderedAsc.tiles);

        assertNotEquals(tilesOrderedAsc.getPosOfTileId(0), 0);
        assertNotEquals(tilesOrderedAsc.getPosOfTileId(9), 9);

        assertEquals(tilesOrderedAsc.getPosOfTileId(0), numTiles-1);
        assertEquals(tilesOrderedAsc.getPosOfTileId(numTiles-1),0);

    }

    @Test
    public void testIsOrdered() throws Exception {
        assertTrue(tilesOrderedAsc.isOrdered());

        Collections.reverse(tilesOrderedAsc.tiles);

        assertFalse(tilesOrderedAsc.isOrdered());
    }
}