package com.example.unity3d.dfm;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.play.core.splitcompat.SplitCompat;
import com.google.android.play.core.splitinstall.SplitInstallManager;
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory;
import com.google.android.play.core.splitinstall.SplitInstallRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        installRegistrationModule();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        SplitCompat.install(this);
    }

    SplitInstallManager splitInstallManager;
    private void installRegistrationModule() {
        splitInstallManager = SplitInstallManagerFactory.create(getApplicationContext());
        SplitInstallRequest request = SplitInstallRequest.newBuilder()
                .addModule("dynamicfeature")
                .build();

        splitInstallManager.startInstall(request)
                .addOnSuccessListener(integer -> {
                    Log.d("KKS", "install success");
                    Toast.makeText(MainActivity.this, "Download Complete", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> Log.e("KKS", "install Fail" + e.getStackTrace()));
    }
}
