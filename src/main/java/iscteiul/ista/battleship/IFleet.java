/**
 * Represents a fleet of ships in the Battleship game.
 * <p>
 * A fleet is responsible for managing a collection of ships placed
 * on a game board of fixed size. It provides operations for adding ships,
 * querying ships by category, determining which ships are still afloat,
 * and locating ships at specific board positions.
 * </p>
 *
 * <p>
 * The fleet operates on a square board with a predefined size and
 * enforces a maximum number of ships allowed.
 * </p>
 */
package iscteiul.ista.battleship;

import java.util.List;

public interface IFleet {

    /**
     * The size of the game board (10x10).
     */
    Integer BOARD_SIZE = 10;

    /**
     * The maximum number of ships allowed in the fleet.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Returns the list of all ships in the fleet.
     *
     * @return a list containing all ships
     */
    List<IShip> getShips();

    /**
     * Adds a ship to the fleet.
     *
     * @param s the ship to be added
     * @return {@code true} if the ship was successfully added,
     *         {@code false} otherwise (e.g., fleet full or invalid placement)
     */
    boolean addShip(IShip s);

    /**
     * Returns a list of ships matching the specified category.
     * <p>
     * The category may represent a ship type (e.g., Barge, Caravel, Carrack).
     * </p>
     *
     * @param category the category or type of ship to filter by
     * @return a list of ships matching the given category
     */
    List<IShip> getShipsLike(String category);

    /**
     * Returns a list of ships that are still afloat (not sunk).
     *
     * @return a list of ships that have not been completely destroyed
     */
    List<IShip> getFloatingShips();

    /**
     * Returns the ship occupying the specified position on the board.
     *
     * @param pos the position to be checked
     * @return the ship at the given position, or {@code null} if no ship occupies it
     */
    IShip shipAt(IPosition pos);

    /**
     * Prints the current status of the fleet.
     * <p>
     * This may include information such as ship types, positions,
     * and whether each ship is afloat or sunk.
     * </p>
     */
    void printStatus();
}
