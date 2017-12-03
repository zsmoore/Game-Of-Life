package com.zachary_moore.gameoflife.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.zachary_moore.gameoflife.R;
import com.zachary_moore.gameoflife.databinding.MainActivityBinding;
import com.zachary_moore.gameoflife.model.core.GameOfLife;
import com.zachary_moore.gameoflife.model.pattern.PatternCanvas;

import processing.android.PFragment;

public class PatternActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pattern_activity);

        final LinearLayout patternContainer = this.findViewById(R.id.pattern_container);

        GameOfLife gameOfLife = new GameOfLife();

        PFragment pFragment = new PFragment(gameOfLife);
        pFragment.setView(patternContainer, this);

        //Add game of life to our binding
        MainActivityBinding mainActivityBinding = DataBindingUtil.setContentView(this,
                R.layout.main_activity);
        mainActivityBinding.setGameOfLife(gameOfLife);

    }
}
