package dev.msk.quadrates;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import dev.msk.quadrates.Listeners.BlockX1TouchListener;
import dev.msk.quadrates.Listeners.BlockX2TouchListener;
import dev.msk.quadrates.Listeners.BlockX3TouchListener;
import dev.msk.quadrates.Models.Level;

import static android.view.View.VISIBLE;

public class Helper {

    // READ CURRENT LEVELNUMBER FROM MEMO
    public static int readLevelFromMemory(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("QUADRATES_MEMO", Context.MODE_PRIVATE);
        return sharedPreferences.getInt("levelNumber", 0);
    }

    // GET MULTIPLER IMAGE
    public static int getMultiplerImage(byte multipler) {
        switch (multipler) {
            case 1:
                return R.drawable.img_multipler_x1;
            case 2:
                return R.drawable.img_multipler_x2;
            case 3:
                return R.drawable.img_multipler_x3;
            default:
                return 0;
        }
    }

    // LOAD LEVELS
    public static List<Level> loadLevels(Context context) {
        Resources res = context.getResources();
        InputStream is = res.openRawResource(R.raw.json_levels);
        Scanner scanner = new Scanner(is);
        StringBuilder stringBuilder = new StringBuilder();
        Gson gson = new Gson();
        TypeToken<List<Level>> typeToken = new TypeToken<List<Level>>() {
        };

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }

        return gson.fromJson(stringBuilder.toString(), typeToken.getType());
    }

    // SAVE LEVELS
    public static void saveLevels(Context context, List<Level> levels) {

    }

    // SHOW CURRENT LAYOUT
    public static void showCurrentLayout(List<View> layouts, short currentLayout) {
        View view = layouts.get(currentLayout);
        view.setVisibility(VISIBLE);
    }

    // GENERATE LEVELS
    public static List<Level> generateLevels(List<Level> listOfLevels) {
        byte[][] gameBoard = new byte[4][3];
        gameBoard[0][0] = 1; gameBoard[0][1] = 2; gameBoard[0][2] = 3;
        gameBoard[1][0] = 2; gameBoard[1][1] = 3; gameBoard[1][2] = 1;
        gameBoard[2][0] = 3; gameBoard[2][1] = 1; gameBoard[2][2] = 2;
        gameBoard[3][0] = 3; gameBoard[3][1] = 1; gameBoard[3][2] = 2;

        byte[][] resultBoard = new byte[4][3];
        resultBoard[0][0] = 1; resultBoard[0][1] = 2; resultBoard[0][2] = 3;
        resultBoard[1][0] = 1; resultBoard[1][1] = 2; resultBoard[1][2] = 3;
        resultBoard[2][0] = 1; resultBoard[2][1] = 2; resultBoard[2][2] = 3;
        resultBoard[3][0] = 1; resultBoard[3][1] = 2; resultBoard[3][2] = 3;

        listOfLevels.add(new Level((short) 1, (short) 0, gameBoard, resultBoard, (byte) 25, (byte) 15, (byte) 1, false));

        return listOfLevels;
    }

    //SHOW BLOCKS
    public static void showBlocks(byte[][] board, List<List<ImageView>> listOfimages, List<View> listOfRows) {
        View row;
        View image;
        for (byte x=0; x<board.length; x++) {
            row = listOfRows.get(x);
            row.setVisibility(VISIBLE);
            List<ImageView> list = listOfimages.get(x);
            for (byte y=0; y<board[x].length; y++) {
                image = list.get(y);
                image.setVisibility(VISIBLE);
            }
        }
    }

    //DRAW BLOCKS
    public static void drawBlocks(byte[][] board, List<List<ImageView>> listOfimages) {
        for (byte x=0; x<board.length; x++) {
            List<ImageView> list = listOfimages.get(x);
            for (byte y=0; y<board[x].length; y++) {
                setBlockImage(board[x][y], list.get(y));
            }
        }
    }

    //SET BLOCK IMAGE
    public static void setBlockImage(byte blockNumber, ImageView imageView) {
        switch (blockNumber) {
            case 0:
                imageView.setImageResource(R.drawable.img_block_empty);
                break;
            case 1:
                imageView.setImageResource(R.drawable.img_block_orange);
                break;
            case 2:
                imageView.setImageResource(R.drawable.img_block_brown);
                break;
            case 3:
                imageView.setImageResource(R.drawable.img_block_gray);
                break;
            case 4:
                imageView.setImageResource(R.drawable.img_block_blue_light);
                break;
            case 5:
                imageView.setImageResource(R.drawable.img_block_yellow);
                break;
            case 6:
                imageView.setImageResource(R.drawable.img_block_blue);
                break;
            case 7:
                imageView.setImageResource(R.drawable.img_block_purple);
                break;
            case 8:
                imageView.setImageResource(R.drawable.img_block_green);
                break;
            case 9:
                imageView.setImageResource(R.drawable.img_block_turkis);
                break;
            case 10:
                imageView.setImageResource(R.drawable.img_block_pink);
                break;
            case 11:
                imageView.setImageResource(R.drawable.img_block_blue_dark);
                break;
            case 12:
                imageView.setImageResource(R.drawable.img_block_pink_light);
                break;
        }
    }

    //SET TOUCH LISTENER
    public static void setTouchListener(byte multipler, List<List<ImageView>> listOfImages, Level level) {
        for (List<ImageView> row : listOfImages) {
            for (ImageView imageView : row) {
                switch (multipler) {
                    case 1: imageView.setOnTouchListener(new BlockX1TouchListener(level, listOfImages));
                        break;
                    case 2: imageView.setOnTouchListener(new BlockX2TouchListener());
                        break;
                    case 3: imageView.setOnTouchListener(new BlockX3TouchListener());
                        break;
                }
            }
        }
    }
}
