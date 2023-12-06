enum Cell { X = 1, O = 2}

const playfield: Cell[][] = []


function checkIfWon(field: Cell[][]): Cell | number {
    // check rows
    for (let i: number = 0; i < 3; i++) {
        if (field[i][0] === field[i][1] && field[i][1] === field[i][2]) {
            return field[i][0]      // returns the player who won
        }
    }

    // check columns
    for (let i: number = 0; i < 3; i++) {
        if (field[0][i] === field[1][i] && field[1][i] === field[2][i]) {
            return field[0][i]
        }
    }

    // check diagonal top left to bottom right
    if (field[0][0] === field[1][1] && field[1][1] === field[2][2]) {
        return field[0][0]
    }

    // check diagonal bottom left to top right
    if (field[0][2] === field[1][1] && field[1][1] === field[2][0]) {
        return field[0][2]
    }

    return 0   // signals that no player won yet
}

function prettyPrintArray(field: Cell[][]) {
    let line = "\n"
    for (let row of field) {
        for (let cell of row) {
            if (cell == Cell.X) {
                line += "X "
            } else if (cell == Cell.O) {
                line += "O "
            } else {
                line += "_ "
            }
        }
        line += "\n"
    }
    console.log(line)
}


let round: number = 0;
let currentPlayer: number = 0;
let newRound = true
while (true) {
    if (newRound) {
        round++
        currentPlayer = round % 2;
        console.log("Round " + round)

        prettyPrintArray(playfield)
    } else {
        newRound = true
    }


    let cellUserWantsToPlay = prompt("Which cell do you want to play? (Use one digit (0-8) to determine cell or 'q' to quit.)")
    if (cellUserWantsToPlay) {
        if (cellUserWantsToPlay == "q") {
            break
        }
        if (+cellUserWantsToPlay < 0 || +cellUserWantsToPlay > 8) {
            alert("Please enter a valid field.")
            newRound = false
            continue
        }

        let row = Math.floor(+cellUserWantsToPlay / 3)
        let col = +cellUserWantsToPlay % 3

        if (playfield[row][col]) {
            alert("Cell is not empty. Please enter a valid cell position.")
            newRound = false
            continue
        }

        playfield[row][col] = currentPlayer ? Cell.X : Cell.O

        let winner = checkIfWon(playfield)
        if (winner) {
            alert("Player " + winner + " won!")
            break
        }
    }
}
