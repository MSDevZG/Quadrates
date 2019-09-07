package dev.msk.quadrates.Listeners;

import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

import static dev.msk.quadrates.Helper.drawBlocks;

public class PreviewTouchListener implements View.OnTouchListener {
    byte[][] gameBoard, resultBoard;
    List<List<ImageView>> listOfImages;

    public PreviewTouchListener(byte[][] gameBoard, byte[][] resultBoard, List<List<ImageView>> listOfImages) {
        this.gameBoard = gameBoard;
        this.resultBoard = resultBoard;
        this.listOfImages = listOfImages;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            drawBlocks(resultBoard, listOfImages);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            drawBlocks(gameBoard, listOfImages);
        }
        return true;
    }
}
