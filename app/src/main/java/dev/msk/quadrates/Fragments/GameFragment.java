package dev.msk.quadrates.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.msk.quadrates.CustomViews.ExitDialog;
import dev.msk.quadrates.Listeners.BlockX1TouchListener;
import dev.msk.quadrates.Listeners.PreviewTouchListener;
import dev.msk.quadrates.Models.Level;
import dev.msk.quadrates.R;

import static dev.msk.quadrates.Helper.drawBlocks;
import static dev.msk.quadrates.Helper.getMultiplerImage;
import static dev.msk.quadrates.Helper.readLevelFromMemory;
import static dev.msk.quadrates.Helper.setBlockImage;
import static dev.msk.quadrates.Helper.setTouchListener;
import static dev.msk.quadrates.Helper.showBlocks;
import static dev.msk.quadrates.MainActivity.listOfLevels;

public class GameFragment extends Fragment {

    @BindView(R.id.text_level) TextView textLevel;
    @BindView(R.id.text_two_stars) TextView textTwoStars;
    @BindView(R.id.text_three_stars) TextView textThreeStars;
    @BindView(R.id.text_bonus) TextView textBonus;
    @BindView(R.id.img_star_one) ImageView imgStarOne;
    @BindView(R.id.img_star_two) ImageView imgStarTwo;
    @BindView(R.id.img_star_three) ImageView imgStarThree;
    @BindView(R.id.img_bonus) ImageView imgBonus;
    @BindView(R.id.img_multipler) ImageView imgMultipler;
    @BindView(R.id.img_preview) ImageView imgPreview;

    @BindViews({R.id.row0, R.id.row1, R.id.row2, R.id.row3, R.id.row4, R.id.row5, R.id.row6, R.id.row7, R.id.row8}) List<View> listOfRows;
    @BindViews({R.id.row_0_col_0, R.id.row_0_col_1, R.id.row_0_col_2, R.id.row_0_col_3, R.id.row_0_col_4, R.id.row_0_col_5, R.id.row_0_col_6, R.id.row_0_col_7, R.id.row_0_col_8}) List<ImageView> listOfImagesRow0;
    @BindViews({R.id.row_1_col_0, R.id.row_1_col_1, R.id.row_1_col_2, R.id.row_1_col_3, R.id.row_1_col_4, R.id.row_1_col_5, R.id.row_1_col_6, R.id.row_1_col_7, R.id.row_1_col_8}) List<ImageView> listOfImagesRow1;
    @BindViews({R.id.row_2_col_0, R.id.row_2_col_1, R.id.row_2_col_2, R.id.row_2_col_3, R.id.row_2_col_4, R.id.row_2_col_5, R.id.row_2_col_6, R.id.row_2_col_7, R.id.row_2_col_8}) List<ImageView> listOfImagesRow2;
    @BindViews({R.id.row_3_col_0, R.id.row_3_col_1, R.id.row_3_col_2, R.id.row_3_col_3, R.id.row_3_col_4, R.id.row_3_col_5, R.id.row_3_col_6, R.id.row_3_col_7, R.id.row_3_col_8}) List<ImageView> listOfImagesRow3;
    @BindViews({R.id.row_4_col_0, R.id.row_4_col_1, R.id.row_4_col_2, R.id.row_4_col_3, R.id.row_4_col_4, R.id.row_4_col_5, R.id.row_4_col_6, R.id.row_4_col_7, R.id.row_4_col_8}) List<ImageView> listOfImagesRow4;
    @BindViews({R.id.row_5_col_0, R.id.row_5_col_1, R.id.row_5_col_2, R.id.row_5_col_3, R.id.row_5_col_4, R.id.row_5_col_5, R.id.row_5_col_6, R.id.row_5_col_7, R.id.row_5_col_8}) List<ImageView> listOfImagesRow5;
    @BindViews({R.id.row_6_col_0, R.id.row_6_col_1, R.id.row_6_col_2, R.id.row_6_col_3, R.id.row_6_col_4, R.id.row_6_col_5, R.id.row_6_col_6, R.id.row_6_col_7, R.id.row_6_col_8}) List<ImageView> listOfImagesRow6;
    @BindViews({R.id.row_7_col_0, R.id.row_7_col_1, R.id.row_7_col_2, R.id.row_7_col_3, R.id.row_7_col_4, R.id.row_7_col_5, R.id.row_7_col_6, R.id.row_7_col_7, R.id.row_7_col_8}) List<ImageView> listOfImagesRow7;
    @BindViews({R.id.row_8_col_0, R.id.row_8_col_1, R.id.row_8_col_2, R.id.row_8_col_3, R.id.row_8_col_4, R.id.row_8_col_5, R.id.row_8_col_6, R.id.row_8_col_7, R.id.row_8_col_8}) List<ImageView> listOfImagesRow8;
    List<List<ImageView>> listOfImages = new ArrayList<List<ImageView>>();

    private Level level;
    private Animation anim_star_rotation;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        level = listOfLevels.get(readLevelFromMemory(getContext()));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, view);

        listOfImages.add(listOfImagesRow0);
        listOfImages.add(listOfImagesRow1);
        listOfImages.add(listOfImagesRow2);
        listOfImages.add(listOfImagesRow3);
        listOfImages.add(listOfImagesRow4);
        listOfImages.add(listOfImagesRow5);
        listOfImages.add(listOfImagesRow6);
        listOfImages.add(listOfImagesRow7);
        listOfImages.add(listOfImagesRow8);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (!level.isBonus()) {
            imgBonus.setVisibility(View.INVISIBLE);
            textBonus.setVisibility(View.INVISIBLE);
        }

        textTwoStars.setText(level.getTwoStarsCount() + "");
        textThreeStars.setText(level.getThreeStarsCount() + "");

        textLevel.setText(getResources().getString(R.string.LEVEL) + " " + level.getLevelNumber());

        anim_star_rotation = AnimationUtils.loadAnimation(getContext(), R.anim.anim_star_rotation);
        imgStarOne.startAnimation(anim_star_rotation);
        imgStarTwo.startAnimation(anim_star_rotation);
        imgStarThree.startAnimation(anim_star_rotation);

        imgMultipler.setImageResource(getMultiplerImage(level.getMultipler()));

        imgPreview.setOnTouchListener(new PreviewTouchListener(level.getGameBoard(), level.getResultBoard(), listOfImages));

        showBlocks(level.getGameBoard(), listOfImages, listOfRows);
        drawBlocks(level.getGameBoard(), listOfImages);
        setTouchListener(level.getMultipler(), listOfImages, level);
    }

    @OnClick(R.id.img_close)
    public void exit() {
        ExitDialog exitDialog = new ExitDialog(getContext());
        exitDialog.show();
    }
}