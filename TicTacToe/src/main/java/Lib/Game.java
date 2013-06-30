/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

/**
 *
 * @author Pavel
 */
public class Game extends Board
{

    private Player[] players = new Player[2];
    private static int playerOne = 0;
    private static int playerTwo = 1;
    private static int NULO = -1;
    private boolean activa = true;
    private int turn;

    public Game()
    {
        this.turn = playerOne;
        this.fillBoard();
        this.createPlayers();
    }

    private void createPlayers()
    {
        this.players[0] = new Player("Jugador 1", "X", playerOne, this);
        this.players[1] = new Player("Jugador 2", "O", playerTwo, this);
    }

    private void newTurn()
    {
        this.turn = (this.turn == playerOne ? playerTwo : playerOne);
    }

    public void turno()
    {
        int[] coords = this.players[turn].getPosition();
        System.out.println("Turno: " + turn);
        System.out.println("Valor: " + this.players[turn].getValue());
        toPutData(coords[0], coords[1], turn);
        System.out.println("---------------");
    }

    public void printBoard()
    {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.aBoard[i][j] == NULO) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + this.players[this.aBoard[i][j]].getValue() + "]");
                }
            }

            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void endTurn()
    {
        if (winGame() != NULO) {
            System.out.println("Ganador " + this.players[turn].getName());
            printBoard();
            this.activa = false;
        } else {
            if (isFull() == true) {
                System.out.println("Empate");
                printBoard();
                this.activa = false;
            } else {
                this.newTurn();
            }
        }
    }

    public void startGame()
    {
        while (this.activa) {
            turno();
            endTurn();
        }
    }
}
