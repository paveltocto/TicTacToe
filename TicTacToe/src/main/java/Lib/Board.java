/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

/**
 *
 * @author Pavel
 */
public class Board
{

    public int[][] aBoard;
    private static int NULO = -1;

    public Board()
    {
        aBoard = new int[3][3];
    }

    public int[][] getaBoard()
    {
        return aBoard;
    }

    public void setaBoard(int[][] aBoard)
    {
        this.aBoard = aBoard;
    }

    public void toPutData(int y, int x, int value)
    {
        if (this.isBlankBox(y, x) == true) {
            aBoard[y][x] = value;
        }
    }

    public boolean isBlankBox(int y, int x)
    {
        if (aBoard[y][x] == NULO) {
            return true;
        }
        return false;
    }

    public boolean isFull()
    {
        for (int i = 0; i < aBoard.length; i++) {
            for (int j = 0; j < aBoard.length; j++) {
                if (aBoard[i][j] == NULO) {
                    return false;
                }
            }
        }
        return true;
    }

    public int winGame()
    {
        if (aBoard[0][0] != NULO && aBoard[0][0] == aBoard[1][1] && aBoard[0][0] == aBoard[2][2]) {
            return aBoard[0][0];
        }
        if (aBoard[0][2] != NULO && aBoard[0][2] == aBoard[1][1] && aBoard[0][2] == aBoard[2][0]) {
            return aBoard[0][2];
        }

        for (int i = 0; i < aBoard.length; i++) {
            if (aBoard[i][0] != NULO && aBoard[i][0] == aBoard[i][1] && aBoard[i][0] == aBoard[i][2]) {
                return aBoard[i][0];
            }

            if (aBoard[0][i] != NULO && aBoard[0][i] == aBoard[1][i] && aBoard[0][i] == aBoard[2][i]) {
                return aBoard[0][i];
            }
        }
        return NULO;
    }

    public void fillBoard()
    {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                aBoard[i][j] = NULO;
            }
        }
    }
}
