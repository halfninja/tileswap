import kotlin.math.*

data class Coord(val x: Int, val y: Int)

class Game(val board: Board) {
    fun canSwap(from: Coord, to: Coord): Boolean = when {
        from.x == to.x -> (from.y - to.y).absoluteValue == 1
        from.y == to.y -> (from.x - to.x).absoluteValue == 1
        else -> false
    }
}

class Board(val width: Int, val height: Int) {
    val grid = Grid(width, height) { Square(null) }

    fun swap(from: Coord, to: Coord) {
        val fromCell = grid.get(from)!!
        val toCell = grid.get(to)!!
        val fromPiece = fromCell.piece
        val toPiece = toCell.piece
        fromCell.piece = toPiece
        toCell.piece = fromPiece
    }
}

/** 2D grid of something */
class Grid<T>(val width: Int, val height: Int, makeCell: () -> T) {
    val cells: List<List<T>> = (0 until height).map { _ ->
        (0 until width).map { _ ->
            makeCell()
        }
    }

    fun get(x: Int, y: Int): T? = cells.getOrNull(y)?.getOrNull(x)
    fun get(xy: Coord): T? = get(xy.x, xy.y)
}

class Square(
    var piece: Piece?
)

sealed class Piece
class RedPiece : Piece()
class BluePiece : Piece()
class GreenPiece : Piece()