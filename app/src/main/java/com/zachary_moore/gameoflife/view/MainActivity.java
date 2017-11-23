package com.zachary_moore.gameoflife.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;

import com.zachary_moore.gameoflife.databinding.MainActivityBinding;
import com.zachary_moore.gameoflife.model.core.GameOfLife;
import com.zachary_moore.gameoflife.R;
import com.zachary_moore.gameoflife.model.util.bundle.BundleHelper;

import processing.android.PFragment;

public class MainActivity extends FragmentActivity {

    // GameOfLife to hold onto
    private GameOfLife gameOfLife;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // Create our GameOfLife and add it to our layout as a PFragment
        final LinearLayout gameContainer = this.findViewById(R.id.game_container);

        // Check our bundle for our saved instance
        if (savedInstanceState != null) {
            gameOfLife = BundleHelper.restore(savedInstanceState);
        } else if (gameOfLife == null) {
            gameOfLife = new GameOfLife();
        }
        PFragment pFragment = new PFragment(gameOfLife);
        pFragment.setView(gameContainer, this);

        //Add game of life to our binding
        MainActivityBinding mainActivityBinding = DataBindingUtil.setContentView(this,
                R.layout.main_activity);
        mainActivityBinding.setGameOfLife(gameOfLife);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        if (gameOfLife != null) {
            gameOfLife.onRequestPermissionsResult(
                    requestCode, permissions, grantResults);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        if (gameOfLife != null) {
            gameOfLife.onNewIntent(intent);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);
        if (gameOfLife != null) {
            BundleHelper.setBundle(state, gameOfLife);
        }
    }
}
