/**
 * Represents the core game logic of the Battleship game.
 *
 * The Game class is responsible for:
 * <ul>
 *     <li>Managing player shots</li>
 *     <li>Validating shot positions</li>
 *     <li>Tracking statistics (hits, invalid shots, repeated shots, sunk ships)</li>
 *     <li>Interacting with the fleet</li>
 *     <li>Printing the board state</li>
 * </ul>
 *
 * This class implements the {@link IGame} interface.
 */
package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

public class Game implements IGame {

    /**
     * The fleet used in the game.
     */
    private IFleet fleet;

    /**
     * List of valid shots performed during the game.
     */
    private List<IPosition> shots;

    /**
     * Counter for invalid shots (outside board limits).
     */
    private Integer countInvalidShots;

    /**
     * Counter for repeated shots.
     */
    private Integer countRepeatedShots;

    /**
     * Counter for successful hits.
     */
    private Integer countHits;

    /**
     * Counter for sunk ships.
     */
    private Integer countSinks;

    /**
     * Constructs a new Game with a given fleet.
     *
     * @param fleet the fleet used in the game
     */
    public Game(IFleet fleet) {
        shots = new ArrayList<>();
        countInvalidShots = 0;
        countRepeatedShots = 0;
        countHits = 0;
        countSinks = 0;
        this.fleet = fleet;
    }

    /**
     * Fires a shot at a given position.
     *
     * The method:
     * <ul>
     *     <li>Validates the shot position</li>
     *     <li>Checks for repeated shots</li>
     *     <li>Registers hits</li>
     *     <li>Updates sunk ships count</li>
     * </ul>
     *
     * @param pos the position to fire at
     * @return the ship that was sunk as a result of this shot,
     *         or null if no ship was sunk
     */
    @Override
    public IShip fire(IPosition pos) {

        if (!validShot(pos)) {
            countInvalidShots++;
        } else {
            if (repeatedShot(pos)) {
                countRepeatedShots++;
            } else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);

                if (s != null) {
                    s.shoot(pos);
                    countHits++;

                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Returns the list of valid shots performed.
     *
     * @return list of shot positions
     */
    @Override
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Returns the number of repeated shots.
     *
     * @return number of repeated shots
     */
    @Override
    public int getRepeatedShots() {
        return this.countRepeatedShots;
    }

    /**
     * Returns the number of invalid shots.
     *
     * @return number of invalid shots
     */
    @Override
    public int getInvalidShots() {
        return this.countInvalidShots;
    }

    /**
     * Returns the number of successful hits.
     *
     * @return number of hits
     */
    @Override
    public int getHits() {
        return this.countHits;
    }

    /**
     * Returns the number of sunk ships.
     *
     * @return number of sunk ships
     */
    @Override
    public int getSunkShips() {
        return this.countSinks;
    }

    /**
     * Returns the number of ships still floating.
     *
     * @return number of remaining ships
     */
    @Override
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    /**
     * Validates whether a shot is within the board boundaries.
     *
     * @param pos the position to validate
     * @return true if the shot is inside the board, false otherwise
     */
    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 &&
                pos.getRow() <= Fleet.BOARD_SIZE &&
                pos.getColumn() >= 0 &&
                pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    /**
     * Checks whether a shot was already performed before.
     *
     * @param pos the position to check
     * @return true if the shot is repeated, false otherwise
     */
    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++)
            if (shots.get(i).equals(pos))
                return true;
        return false;
    }

    /**
     * Prints a board representation marking specific positions
     * with a given character.
     *
     * @param positions the positions to mark on the board
     * @param marker the character used to mark the positions
     */
    public void printBoard(List<IPosition> positions, Character marker) {

        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++)
            for (int c = 0; c < Fleet.BOARD_SIZE; c++)
                map[r][c] = '.';

        for (IPosition pos : positions)
            map[pos.getRow()][pos.getColumn()] = marker;

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++)
                System.out.print(map[row][col]);
            System.out.println();
        }
    }

    /**
     * Prints the board showing all valid shots fired.
     *
     * Shot positions are marked with 'X'.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Prints the board showing the fleet positions.
     *
     * Ship positions are marked with '#'.
     */
    public void printFleet() {

        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips())
            shipPositions.addAll(s.getPositions());

        printBoard(shipPositions, '#');
    }
}