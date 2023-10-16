package com.lge.dynamicunity3d;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.unity3d.player.UnityPlayer;

public class DynamicActivity extends AppCompatActivity {
    protected UnityPlayer mUnityPlayer;
    FrameLayout frameLayoutForUnity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.dynamic_activity);
        ActionBar ab = getSupportActionBar();
        ab.setTitle("Dynamic Feature Activity");
        attachUnity();
    }

    private void attachUnity() {
        mUnityPlayer = new UnityPlayer(this);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        frameLayoutForUnity = findViewById(R.id.frameLayout_for_unity);
        frameLayoutForUnity.addView(mUnityPlayer.getRootView(), FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        mUnityPlayer.requestFocus();
        mUnityPlayer.windowFocusChanged(true);
    }

    @Override
    public void onDestroy() {
        if (mUnityPlayer != null) {
            mUnityPlayer.destroy();
        }
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mUnityPlayer != null) {
            mUnityPlayer.pause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mUnityPlayer != null) {
            mUnityPlayer.resume();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mUnityPlayer != null) {
            mUnityPlayer.pause();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mUnityPlayer != null) {
            mUnityPlayer.resume();
        }
    }
}
