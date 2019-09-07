package dev.msk.quadrates.Listeners;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import dev.msk.quadrates.Models.Level;

import static dev.msk.quadrates.Helper.drawBlocks;

public class BlockX1TouchListener implements View.OnTouchListener {
    private Level level;
    private List<List<ImageView>> listOfImages;

    private float x1 = 0, x2 = 0, y1 = 0, y2 = 0;
    private short SLIDE_LENGTH = 150;

    public BlockX1TouchListener(Level level, List<List<ImageView>> listOfImages) {
        this.level = level;
        this.listOfImages = listOfImages;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        String name = v.getContext().getResources().getResourceName(v.getId());
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                y1 = event.getY();
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                y2 = event.getY();
                if ((x2 - x1) > SLIDE_LENGTH) { //RIGHT
                    if (name.contains("row_0")) {
                        turnRight((byte) 0);
                    } else if (name.contains("row_1")) {
                        turnRight((byte) 1);
                    } else if (name.contains("row_2")) {
                        turnRight((byte) 2);
                    } else if (name.contains("row_3")) {
                        turnRight((byte) 3);
                    } else if (name.contains("row_4")) {
                        turnRight((byte) 4);
                    } else if (name.contains("row_5")) {
                        turnRight((byte) 5);
                    } else if (name.contains("row_6")) {
                        turnRight((byte) 6);
                    } else if (name.contains("row_7")) {
                        turnRight((byte) 7);
                    } else if (name.contains("row_8")) {
                        turnRight((byte) 8);
                    } else if (name.contains("row_9")) {
                        turnRight((byte) 9);
                    } else if (name.contains("row_10")) {
                        turnRight((byte) 10);
                    } else if (name.contains("row_11")) {
                        turnRight((byte) 11);
                    }
                } else if ((x1 - x2) > SLIDE_LENGTH) { //LEFT
                    if (name.contains("row_0")) {
                        turnLeft((byte) 0);
                    } else if (name.contains("row_1")) {
                        turnLeft((byte) 1);
                    } else if (name.contains("row_2")) {
                        turnLeft((byte) 2);
                    } else if (name.contains("row_3")) {
                        turnLeft((byte) 3);
                    } else if (name.contains("row_4")) {
                        turnLeft((byte) 4);
                    } else if (name.contains("row_5")) {
                        turnLeft((byte) 5);
                    } else if (name.contains("row_6")) {
                        turnLeft((byte) 6);
                    } else if (name.contains("row_7")) {
                        turnLeft((byte) 7);
                    } else if (name.contains("row_8")) {
                        turnLeft((byte) 8);
                    } else if (name.contains("row_9")) {
                        turnLeft((byte) 9);
                    } else if (name.contains("row_10")) {
                        turnLeft((byte) 10);
                    } else if (name.contains("row_11")) {
                        turnLeft((byte) 11);
                    }
                } else if ((y1 - y2) > SLIDE_LENGTH) { //UP
                    if (name.contains("col_0")) {
                        turnUp((byte) 0);
                    } else if (name.contains("col_1")) {
                        turnUp((byte) 1);
                    } else if (name.contains("col_2")) {
                        turnUp((byte) 2);
                    } else if (name.contains("col_3")) {
                        turnUp((byte) 3);
                    } else if (name.contains("col_4")) {
                        turnUp((byte) 4);
                    } else if (name.contains("col_5")) {
                        turnUp((byte) 5);
                    } else if (name.contains("col_6")) {
                        turnUp((byte) 6);
                    } else if (name.contains("col_7")) {
                        turnUp((byte) 7);
                    } else if (name.contains("col_8")) {
                        turnUp((byte) 8);
                    } else if (name.contains("col_9")) {
                        turnUp((byte) 9);
                    } else if (name.contains("col_10")) {
                        turnUp((byte) 10);
                    } else if (name.contains("col_11")) {
                        turnUp((byte) 11);
                    }
                } else if ((y2 - y1) > SLIDE_LENGTH) { //DOWN
                    if (name.contains("col_0")) {
                        turnDown((byte) 0);
                    } else if (name.contains("col_1")) {
                        turnDown((byte) 1);
                    } else if (name.contains("col_2")) {
                        turnDown((byte) 2);
                    } else if (name.contains("col_3")) {
                        turnDown((byte) 3);
                    } else if (name.contains("col_4")) {
                        turnDown((byte) 4);
                    } else if (name.contains("col_5")) {
                        turnDown((byte) 5);
                    } else if (name.contains("col_6")) {
                        turnDown((byte) 6);
                    } else if (name.contains("col_7")) {
                        turnDown((byte) 7);
                    } else if (name.contains("col_8")) {
                        turnDown((byte) 8);
                    } else if (name.contains("col_9")) {
                        turnDown((byte) 9);
                    } else if (name.contains("col_10")) {
                        turnDown((byte) 10);
                    } else if (name.contains("col_11")) {
                        turnDown((byte) 11);
                    }
                }
        }
        return true;
    }

    public void turnRight(byte row) {
        byte[][] gameBoard = level.getGameBoard();
        byte bufor = gameBoard[row][gameBoard[row].length - 1];
        for (int i = gameBoard[row].length - 2; i >= 0; i--) {
            gameBoard[row][i + 1] = gameBoard[row][i];
        }
        gameBoard[row][0] = bufor;
        level.setGameBoard(gameBoard);
        drawBlocks(gameBoard, listOfImages);
    }

    public void turnLeft(byte row) {
        byte[][] gameBoard = level.getGameBoard();
        byte bufor = gameBoard[row][0];
        for (int i = 0; i < gameBoard[row].length - 1; i++) {
            gameBoard[row][i] = gameBoard[row][i + 1];
        }
        gameBoard[row][gameBoard[row].length - 1] = bufor;
        level.setGameBoard(gameBoard);
        drawBlocks(gameBoard, listOfImages);
    }

    public void turnUp(byte column) {
        byte[][] gameBoard = level.getGameBoard();
        byte bufor = gameBoard[0][column];
        for (int i = 0; i < gameBoard.length - 1; i++) {
            gameBoard[i][column] = gameBoard[i + 1][column];
        }
        gameBoard[gameBoard.length - 1][column] = bufor;
        level.setGameBoard(gameBoard);
        drawBlocks(gameBoard, listOfImages);
    }

    public void turnDown(byte column) {
        byte[][] gameBoard = level.getGameBoard();
        byte bufor = gameBoard[gameBoard.length - 1][column];
        for (int i = gameBoard.length - 2; i >= 0; i--) {
            gameBoard[i + 1][column] = gameBoard[i][column];
        }
        gameBoard[0][column] = bufor;
        level.setGameBoard(gameBoard);
        drawBlocks(gameBoard, listOfImages);
    }
}