/**
 * Represents a Barge ship in the Battleship game.
 * <p>
 * A Barge is the smallest type of ship in the game, occupying only
 * one position on the board. Its size is fixed and it does not extend
 * beyond its initial placement position, regardless of its bearing.
 * There are 4 barges that will be placed at construction time.
 * </p>
 *
 * <p>
 * The Barge has:
 * <ul>
 *   <li>A fixed size of 1 position</li>
 *   <li>A predefined name ("Barca")</li>
 *   <li>A single board position defined at construction time</li>
 * </ul>
 * </p>
 *
 * @see Ship
 */
package iscteiul.ista.battleship;

public class Barge extends Ship {

    /**
     * The fixed size of the Barge.
     */
    private static final Integer SIZE = 1;

    /**
     * The default name of the Barge.
     */
    private static final String NAME = "Barca";

    /**
     * Constructs a new Barge with a specified bearing and initial position.
     * <p>
     * Since the Barge occupies only one position, its bearing does not
     * affect additional positions on the board.
     * </p>
     *
     * @param bearing the orientation of the barge on the board
     * @param pos the upper-left (and only) position of the barge
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Returns the size of the Barge.
     *
     * @return the size of the barge (always 1)
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }

}
