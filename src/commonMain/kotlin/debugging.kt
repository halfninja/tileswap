
fun Board.consolePrint() {
    this.grid.cells.forEach { row ->
        row.forEach { square ->
            print(square.toConsole())
        }
        println()
    }
}

fun Square.toConsole() = when(this.piece) {
    null -> " "
    is RedPiece -> "R"
    is BluePiece -> "B"
    is GreenPiece -> "G"
}