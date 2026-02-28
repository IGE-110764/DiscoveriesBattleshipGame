/**
 * Defines the contract for a Battleship game.
 *
 * An implementation of this interface is responsible for:
 * <ul>
 *     <li>Handling player shots</li>
 *     <li>Tracking game statistics (hits, invalid shots, repeated shots)</li>
 *     <li>Managing fleet state</li>
 *     <li>Providing game status information</li>
 * </ul>
 *
 * This interface abstracts the core game logic.
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IGame {

    /**
     * Fires a shot at a given position on the board.
     *
     * @param pos the position where the player wants to shoot
     * @return the ship that was hit, or null if no ship occupies the position
     */
    IShip fire(IPosition pos);

    /**
     * Returns the list of all valid shots performed during the game.
     *
     * @return a list of shot positions
     */
    List<IPosition> getShots();

    /**
     * Returns the number of repeated shots.
     *
     * A repeated shot is a shot fired at a position that
     * was already targeted before.
     *
     * @return the number of repeated shots
     */
    int getRepeatedShots();

    /**
     * Returns the number of invalid shots.
     *
     * An invalid shot is a shot fired outside the board limits.
     *
     * @return the number of invalid shots
     */
    int getInvalidShots();

    /**
     * Returns the number of successful hits.
     *
     * @return the number of positions that hit a ship
     */
    int getHits();

    /**
     * Returns the number of ships that have been sunk.
     *
     * @return the number of sunk ships
     */
    int getSunkShips();

    /**
     * Returns the number of ships still floating.
     *
     * @return the number of remaining ships
     */
    int getRemainingShips();

    /**
     * Prints all valid shots performed during the game.
     */
    void printValidShots();

    /**
     * Prints the current state of the fleet.
     */
    void printFleet();
}