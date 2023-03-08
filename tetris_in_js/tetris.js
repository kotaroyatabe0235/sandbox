const gameBoard = document.getElementById("game-board");
const cellWidth = 24;
const numRows = 20;
const numCols = 10;
const boardWidth = cellWidth * numCols;
const boardHeight = cellWidth * numRows;
gameBoard.style.width = `${boardWidth}px`;
gameBoard.style.height = `${boardHeight}px`;
const board = [];
for (let i = 0; i < numRows; i++) {
	board[i] = [];
	for (let j = 0; j < numCols; j++) {
		board[i][j] = 0;
		const cell = document.createElement("div");
		cell.style.width = `${cellWidth}px`;
		cell.style.height = `${cellWidth}px`;
		cell.style.border = "1px solid black";
		cell.style.float = "left";
		gameBoard.appendChild(cell);
	}
}

const currentPiece = {
	x: 0,
	y: 0,
	shape: [[1, 1], [1, 1]]
}

function draw() {
	for (let i = 0; i < numRows; i++) {
		for (let j = 0; j < numCols; j++) {
			const cell = gameBoard.children[i * numCols + j];
			cell.style.backgroundColor = board[i][j] ? "gray" : "white";
		}
	}
}

function update() {
	currentPiece.y++;
	if (currentPiece.y >= numRows || board[currentPiece.y][currentPiece.x]) {
		currentPiece.y--;
		for (let i = 0; i < currentPiece.shape.length; i++) {
			for (let j = 0; j < currentPiece.shape[i].length; j++) {
				if (currentPiece.shape[i][j]) {
					board[currentPiece.y + i][currentPiece.x + j] = 1;
				}
			}
		}
		currentPiece.x = 0;
		currentPiece.y = 0;
		currentPiece.shape = [[1, 1], [1, 1]];
	}
}

function gameLoop() {
	update();
	draw();
}

setInterval(gameLoop, 1000);

