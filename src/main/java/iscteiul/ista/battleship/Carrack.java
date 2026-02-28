/**
 * Represents a Carrack ship in the Battleship game.
 * <p>
 * A Carrack is a ship of fixed size 3 that occupies three consecutive
 * positions on the board. Its placement depends on its bearing
 * (orientation), which determines whether it is positioned vertically
 * or horizontally.
 * There are 2 carracks that will be placed at construction time.
 * </p>
 *
 * <p>
 * Depending on its {@link Compass}:
 * <ul>
 *   <li>{@code NORTH} or {@code SOUTH} — the ship is placed vertically</li>
 *   <li>{@code EAST} or {@code WEST} — the ship is placed horizontally</li>
 * </ul>
 * </p>
 *
 * @see Ship
 */
package iscteiul.ista.battleship;

public class Carrack extends Ship {

    /**
     * The fixed size of the Carrack.
     */
    private static final Integer SIZE = 3;

    /**
     * The default name of the Carrack.
     */
    private static final String NAME = "Nau";

    /**
     * Constructs a new Carrack with the specified bearing and initial position.
     * <p>
     * The initial position represents the reference point from which
     * the remaining ship positions are calculated according to the
     * given bearing.
     * </p>
     *
     * @param bearing the direction in which the Carrack is oriented
     * @param pos the initial reference position of the Carrack
     *
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);
        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the carrack");
        }
    }

    /**
     * Returns the size of the Carrack.
     *
     * @return the size of the Carrack (always 3)
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }

}
