package dev.msk.quadrates.CustomViews;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import androidx.annotation.NonNull;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.msk.quadrates.Fragments.MenuFragment;
import dev.msk.quadrates.R;

import static dev.msk.quadrates.MainActivity.setFragment;

public class ExitDialog extends Dialog {

    public ExitDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_exit);
        setCancelable(true);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.textYes)
    public void clickedYes() {
        setFragment(new MenuFragment());
        dismiss();
    }

    @OnClick(R.id.textNo)
    public void clickedNo() {
        dismiss();
    }
}
