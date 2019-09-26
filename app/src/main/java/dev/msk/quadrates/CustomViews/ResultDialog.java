package dev.msk.quadrates.CustomViews;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.msk.quadrates.R;

import static dev.msk.quadrates.Helper.setAnim;

public class ResultDialog extends Dialog {

    @BindView(R.id.img_background_win) ImageView imgBackgroundWin;
    @BindView(R.id.text_level) TextView txtLevelNumber;
    @BindView(R.id.text_result) TextView txtResult;
    @BindView(R.id.text_moves_number) TextView txtMovesCount;

    private short levelNumber;
    private short movesCount;

    public ResultDialog(@NonNull Context context, short levelNumber, short movesCount, byte threeStarsMoves, byte twoStarsMoves) {
        super(context);
        this.levelNumber = levelNumber;
        this.movesCount = movesCount;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        getWindow().getAttributes().windowAnimations = R.style.WinDialogAnimation;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCancelable(false);
        setContentView(R.layout.dialog_result);
        ButterKnife.bind(this);

        setAnim(imgBackgroundWin, R.anim.anim_background_win);
        txtLevelNumber.setText(txtLevelNumber.getText()+" "+levelNumber);
        txtMovesCount.setText(String.valueOf(movesCount));

    }
}
