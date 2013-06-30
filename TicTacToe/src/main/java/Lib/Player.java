/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

import java.util.Random;

/**
 *
 * @author Pavel
 */
public class Player
{

    private String name;
    private String value;
    private int idPlayer;
    private int[][] board;
    private static int NULO = -1;

    public Player(String name, String value, int idPlayer, Board b)
    {
        this.name = name;
        this.value = value;
        this.idPlayer = idPlayer;
        this.board = b.getaBoard();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public int getIdPlayer()
    {
        return idPlayer;
    }

    public void setIdPlayer(int idPlayer)
    {
        this.idPlayer = idPlayer;
    }

    public int[][] getBoard()
    {
        return board;
    }

    public int[] getPosition()
    {
        int y, x;
        while (true) {
            Random rand = new Random();
            y = rand.nextInt(3);
            x = rand.nextInt(3);
            if (board[y][x] == NULO) {
                break;
            }
        }

        int[] coord = {y, x};
        return coord;
    }
}
