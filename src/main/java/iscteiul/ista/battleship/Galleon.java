/**
 * Represents a Galleon ship in the Battleship game.
 *
 * A Galleon is a ship with a fixed size of 5 positions and
 * has a non-linear shape depending on its orientation.
 *
 * This class extends {@link Ship} and defines the specific
 * geometric configuration of a Galleon for each possible bearing.
 */
package iscteiul.ista.battleship;

public class Galleon extends Ship {

    /**
     * The fixed size of a Galleon.
     */
    private static final Integer SIZE = 5;

    /**
     * The name/category of this ship.
     */
    private static final String NAME = "Galeao";

    /**
     * Constructs a Galleon with a given bearing and starting position.
     *
     * The ship’s shape depends on its orientation (bearing).
     * Each orientation generates a specific configuration of positions.
     *
     * @param bearing the orientation of the ship (NORTH, SOUTH, EAST, WEST)
     * @param pos the reference starting position of the ship
     *
     * @throws NullPointerException if the bearing is null
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;

            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Returns the size of the Galleon.
     *
     * @return the fixed size (5)
     */
    @Override
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Fills the ship positions when oriented NORTH.
     *
     * @param pos the reference starting position
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Fills the ship positions when oriented SOUTH.
     *
     * @param pos the reference starting position
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Fills the ship positions when oriented EAST.
     *
     * @param pos the reference starting position
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Fills the ship positions when oriented WEST.
     *
     * @param pos the reference starting position
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }
}