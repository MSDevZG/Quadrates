package dev.msk.quadrates.Models;

public class Level {
    private short levelNumber;
    private short layoutNumber;
    private byte[][] gameBoard;
    private byte[][] resultBoard;
    private byte twoStarsCount;
    private byte threeStarsCount;
    private byte multipler;
    private boolean bonus;

    public Level(short levelNumber, short layoutNumber, byte[][] gameBoard, byte[][] resultBoard, byte twoStarsCount, byte threeStarsCount, byte multipler, boolean bonus) {
        this.levelNumber = levelNumber;
        this.layoutNumber = layoutNumber;
        this.gameBoard = gameBoard;
        this.resultBoard = resultBoard;
        this.twoStarsCount = twoStarsCount;
        this.threeStarsCount = threeStarsCount;
        this.multipler = multipler;
        this.bonus = bonus;
    }

    public short getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(short levelNumber) {
        this.levelNumber = levelNumber;
    }

    public short getLayoutNumber() {
        return layoutNumber;
    }

    public void setLayoutNumber(short layoutNumber) {
        this.layoutNumber = layoutNumber;
    }

    public byte[][] getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(byte[][] gameBoard) {
        this.gameBoard = gameBoard;
    }

    public byte[][] getResultBoard() {
        return resultBoard;
    }

    public void setResultBoard(byte[][] resultBoard) {
        this.resultBoard = resultBoard;
    }

    public byte getTwoStarsCount() {
        return twoStarsCount;
    }

    public void setTwoStarsCount(byte twoStarsCount) {
        this.twoStarsCount = twoStarsCount;
    }

    public byte getThreeStarsCount() {
        return threeStarsCount;
    }

    public void setThreeStarsCount(byte threeStarsCount) {
        this.threeStarsCount = threeStarsCount;
    }

    public byte getMultipler() {
        return multipler;
    }

    public void setMultipler(byte multipler) {
        this.multipler = multipler;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }
}
