package com.praxisgs.securesecrets.base;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.praxisgs.securesecrets.R;

import drive.SecureSecretsDrive;

public class BaseActivity extends AppCompatActivity {

    private Fragment newInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case SecureSecretsDrive.REQUEST_CODE_RESOLUTION:
                if (resultCode == RESULT_OK) {
                    SecureSecretsDrive.getInstance().connectToGoogleDrive();
                }
                break;
        }
    }

    public void showFragment(String fragmentTag, Bundle bundle, String title) {

        if (newInstance != null && newInstance.getTag() != null && newInstance.getTag().equals(fragmentTag)) {
            return;
        }

        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        newInstance = Fragment.instantiate(this, fragmentTag, bundle);
        ft.replace(R.id.fragment_container, newInstance);
        ft.commit();
    }
}
