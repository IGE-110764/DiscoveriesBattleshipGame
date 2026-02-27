/**
 * Represents a Caravel ship in the Battleship game.
 * <p>
 * A Caravel is a ship of fixed size 2 that occupies two consecutive
 * positions on the board. Its placement depends on its bearing
 * (orientation), which determines whether it is positioned vertically
 * or horizontally.
 * There are 3 caravels that will be placed at construction time.
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

public class Caravel extends Ship {

    /**
     * The fixed size of the Caravel.
     */
    private static final Integer SIZE = 2;

    /**
     * The default name of the Caravel.
     */
    private static final String NAME = "Caravela";

    /**
     * Constructs a new Caravel with the specified bearing and initial position.
     * <p>
     * The initial position represents the upper-left reference point
     * from which the remaining ship positions are calculated according
     * to the given bearing.
     * </p>
     *
     * @param bearing the direction in which the Caravel is oriented
     * @param pos the initial reference position of the Caravel
     *
     * @throws NullPointerException if {@code bearing} is {@code null}
     * @throws IllegalArgumentException if the bearing is invalid
     */
    public Caravel(Compass bearing, IPosition pos) throws NullPointerException, IllegalArgumentException {
        super(Caravel.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the caravel");

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
                throw new IllegalArgumentException("ERROR! invalid bearing for the caravel");
        }

    }

    /**
     * Returns the size of the Caravel.
     *
     * @return the size of the Caravel (always 2)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
