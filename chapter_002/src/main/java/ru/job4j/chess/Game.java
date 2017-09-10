package ru.job4j.chess;

/**
 * class Game.
 * @author Evgeniy lanov (komrad1812@yandex.ru).
 * @version $Id$
 * @since 0.1
 */
public class Game {
	/** board.*/
	private Board board;
	/** input.*/
	private Input input;
	/** player 1.*/
	private Player white = new Player(1);
	/** player 2.*/
	private Player black = new Player(2);
	/** playerTurn.*/
	private Player playerTurn = white;
	/** Cells.*/
	private Cell[][] cells;
	/** massive for keep Figures. */
	private Figure[] figures;
	/**
	 * constructor.
	 * @param input - input.
	 */
	public Game(Input input) {
		this.input = input;
		this.cells = new Cell[8][8];
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				cells[x][y] = new Cell(x, y);
			}
		}
		board = new Board(cells);
		this.figures = new Figure[32];
		figures[0] = new Tura(cells[0][0]);
		figures[1] = new Horse(cells[1][0]);
		figures[2] = new Slon(cells[2][0]);
		figures[3] = new King(cells[3][0]);
		figures[4] = new Queen(cells[4][0]);
		figures[5] = new Slon(cells[5][0]);
		figures[6] = new Horse(cells[6][0]);
		figures[7] = new Tura(cells[7][0]);
		for (int i = 8; i < 16; i++) {
			figures[i] = new Pawn(cells[i - 8][1], false);
		}
		for (int i = 0; i < 16; i++) {
			figures[i].setPlayer(white);
		}
		figures[16] = new Tura(cells[0][7]);
		figures[17] = new Horse(cells[1][7]);
		figures[18] = new Slon(cells[2][7]);
		figures[19] = new King(cells[3][7]);
		figures[20] = new Queen(cells[4][7]);
		figures[21] = new Slon(cells[5][7]);
		figures[22] = new Horse(cells[6][7]);
		figures[23] = new Tura(cells[7][7]);
		for (int i = 24; i < 32; i++) {
			figures[i] = new Pawn(cells[i - 24][6], true);
		}
		for (int i = 16; i < 32; i++) {
			figures[i].setPlayer(black);
		}
	}
	/**
	 * start metod.
	 */
	public void start() {
		boolean valide = false;
		do {
			System.out.println(board.showBoard());
			try {
				if (getPlayerTurn().getColor() == "w") {
					System.out.println("Player white turn");
				} else {
					System.out.println("Player black turn");
				}
				int xSourse = input.ask("Sourse Cell x");
				int ySourse = input.ask("Sourse Cell y");
				Cell sourse = board.getCell(xSourse, ySourse);
				if (sourse.getFigure().getPlayer() != getPlayerTurn()) {
					throw new WrongPlayerFigure("  ");
				}
				valide = board.move(sourse,
							board.getCell(input.ask("Dest Cell x"), input.ask("Dest Cell y")));
				changePlayerTurn();
			} catch (FigureNotFoundException fnfe) {
				System.out.println("Sourse Cell is empty, please enter correct Cell");
			} catch (ArrayIndexOutOfBoundsException aiobe) {
				System.out.println("Wrong Cell destanation");
			} catch (ImpossibleMoveException ime) {
				System.out.println("Wrong Turn.");
			} catch (OccupiedWayException owe) {
				System.out.println("The way is blocked.");
			} catch (WrongPlayerFigure wpf) {
				System.out.println("Figure is not belong to player.");
			}
		} while (!valide);
		System.out.println(board.showBoard());
	}

	/**
	 * metod getPlayerTurn.
	 * @return Player.
	 */
	public Player getPlayerTurn() {
		return playerTurn;
	}

	/**
	 * metod changePlayerTurn.
	 */
	public void changePlayerTurn() {
		if (playerTurn == white) {
			playerTurn = black;
		} else {
			playerTurn = white;
		}
	}
}