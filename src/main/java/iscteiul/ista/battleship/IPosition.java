/**
 * Represents a position (cell) on the Battleship board.
 *
 * A position is identified by:
 * <ul>
 *     <li>Row coordinate</li>
 *     <li>Column coordinate</li>
 * </ul>
 *
 * It also maintains state information regarding:
 * <ul>
 *     <li>Whether it is occupied by a ship</li>
 *     <li>Whether it has been hit</li>
 * </ul>
 */
package iscteiul.ista.battleship;

public interface IPosition {

    /**
     * Returns the row coordinate of this position.
     *
     * @return the row index
     */
    int getRow();

    /**
     * Returns the column coordinate of this position.
     *
     * @return the column index
     */
    int getColumn();

    /**
     * Compares this position with another object.
     *
     * Two positions are considered equal if they share
     * the same row and column.
     *
     * @param other the object to compare with
     * @return true if both represent the same board coordinates,
     *         false otherwise
     */
    boolean equals(Object other);

    /**
     * Checks whether this position is adjacent to another position.
     *
     * Adjacency typically includes horizontal, vertical,
     * and possibly diagonal neighboring cells.
     *
     * @param other the position to compare with
     * @return true if the positions are adjacent, false otherwise
     */
    boolean isAdjacentTo(IPosition other);

    /**
     * Marks this position as occupied by a ship.
     */
    void occupy();

    /**
     * Marks this position as having been shot.
     */
    void shoot();

    /**
     * Indicates whether this position is occupied by a ship.
     *
     * @return true if occupied, false otherwise
     */
    boolean isOccupied();

    /**
     * Indicates whether this position has been hit by a shot.
     *
     * @return true if the position was shot, false otherwise
     */
    boolean isHit();
}