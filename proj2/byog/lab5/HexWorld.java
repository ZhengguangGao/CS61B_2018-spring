package byog.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;

import byog.TileEngine.TETile;

import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final int WIDTH = 50;

    private static final int HEIGHT = 50;

    private static final long SEED = 28733;

    private static final Random RANDOM = new Random(SEED);

    public static void addHexagon(TETile[][] tiles, int size, int x, int y, TETile tetile ) {



        for (int j = y; j < y + 1 * size; j += 1) {
            for (int i = x-(j-y); i < x + (j-y) +size; i += 1) {
                tiles[i][j] = tetile;
            }
        }
        for (int j = y + size; j < y + 2 * size; j += 1) {
            for (int i = x-(y+2*size-1-j); i < x + (y+2*size-1-j) +size; i += 1) {
                tiles[i][j] = tetile;
            }
        }


    }

    private static TETile randomTile() {
        int tileNum = RANDOM.nextInt(3);
        switch (tileNum) {
            case 0: return Tileset.WALL;
            case 1: return Tileset.FLOWER;
            case 2: return Tileset.TREE;
            default: return Tileset.MOUNTAIN;
        }
    }

    public static void initilize(TETile[][] tiles) {

        int height = tiles[0].length;

        int width = tiles.length;

        for (int i = 0; i < width; i += 1) {

            for (int j = 0; j < height; j += 1) {

                tiles[i][j] = Tileset.NOTHING;
            }
        }

    }

    public static void main(String[] args) {

        TERenderer ter = new TERenderer();

        ter.initialize(WIDTH, HEIGHT);

        TETile[][] randomTiles = new TETile[WIDTH][HEIGHT];

        initilize(randomTiles);


        addHexagon(randomTiles,3, 22,5,randomTile());

        addHexagon(randomTiles,3, 17,8,randomTile());
        addHexagon(randomTiles,3, 27,8,randomTile());

        addHexagon(randomTiles,3, 12,11,randomTile());
        addHexagon(randomTiles,3, 22,11,randomTile());
        addHexagon(randomTiles,3, 32,11,randomTile());

        addHexagon(randomTiles,3, 17,14,randomTile());
        addHexagon(randomTiles,3, 27,14,randomTile());

        addHexagon(randomTiles,3, 12,17,randomTile());
        addHexagon(randomTiles,3, 22,17,randomTile());
        addHexagon(randomTiles,3, 32,17,randomTile());

        addHexagon(randomTiles,3, 17,20,randomTile());
        addHexagon(randomTiles,3, 27,20,randomTile());

        addHexagon(randomTiles,3, 12,23,randomTile());
        addHexagon(randomTiles,3, 22,23,randomTile());
        addHexagon(randomTiles,3, 32,23,randomTile());

        addHexagon(randomTiles,3, 17,26,randomTile());
        addHexagon(randomTiles,3, 27,26,randomTile());

        addHexagon(randomTiles,3, 22,29,randomTile());




        ter.renderFrame(randomTiles);
    }
}