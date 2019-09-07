package dev.msk.quadrates.Fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.msk.quadrates.R;

import static dev.msk.quadrates.MainActivity.setFragment;

public class MenuFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




    }

    @OnClick({R.id.buttonPlay, R.id.buttonModes})
    public void changeScene(View view) {
        switch (view.getId()) {
            case R.id.buttonPlay:
                setFragment(new GameFragment());
                break;
            case R.id.buttonModes:
                setFragment(new MenuFragment());
                break;
        }
    }
}
