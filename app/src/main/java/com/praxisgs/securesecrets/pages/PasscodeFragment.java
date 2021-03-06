package com.praxisgs.securesecrets.pages;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.praxisgs.securesecrets.R;
import com.praxisgs.securesecrets.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PasscodeFragment extends BaseFragment<PasscodePresenter> implements PasscodePresenter.ViewInterface {
    public static final String TAG = PasscodeFragment.class.getName();
    private LinearLayout enterPassCodeLayout;
    private LinearLayout createPassCodeLayout;


    @Override
    protected PasscodePresenter instantiatePresenter() {
        return PasscodePresenter.newInstance(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_passcode, null);
        bindView(view);
        return view;
    }

    private void bindView(View view) {
        enterPassCodeLayout = (LinearLayout) view.findViewById(R.id.passcode_enterPassCode_layout);
        createPassCodeLayout = (LinearLayout) view.findViewById(R.id.passcode_createPassCode_layout);
        showRequiredLayout();


        final EditText enterPassCode = (EditText) view.findViewById(R.id.passcode_enterPassCode);
        enterPassCode.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER:
                            if (!enterPassCode.getText().toString().isEmpty()) {
                                mPresenter.passCodeEnterOKBtnClicked(enterPassCode.getText().toString());
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        Button enterPassCodeOKBtn = (Button) view.findViewById(R.id.passcode_enterPassCode_okBtn);
        enterPassCodeOKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!enterPassCode.getText().toString().isEmpty())
                    mPresenter.passCodeEnterOKBtnClicked(enterPassCode.getText().toString());
            }
        });

        final EditText createPassCode = (EditText) view.findViewById(R.id.passcode_createPassCode);
        final EditText recreatePassCode = (EditText) view.findViewById(R.id.passcode__re_createPassCode);
        recreatePassCode.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER:
                            if (!(createPassCode.getText().toString().isEmpty() && recreatePassCode.getText().toString().isEmpty())) {
                                mPresenter.createPassCodeBtnClicked(createPassCode.getText().toString(), recreatePassCode.getText().toString());
                            }
                            return true;
                        default:
                            break;
                    }
                }
                return false;
            }
        });
        Button createPassCodeBtn = (Button) view.findViewById(R.id.passcode_enterPassCode_createBtn);
        createPassCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(createPassCode.getText().toString().isEmpty() && recreatePassCode.getText().toString().isEmpty())) {
                    mPresenter.createPassCodeBtnClicked(createPassCode.getText().toString(), recreatePassCode.getText().toString());
                }
            }
        });

    }

    private void showRequiredLayout() {
        if (mPresenter.isPassCodeCreated()) {
            enterPassCodeLayout.setVisibility(View.VISIBLE);
            createPassCodeLayout.setVisibility(View.GONE);
        } else {
            enterPassCodeLayout.setVisibility(View.GONE);
            createPassCodeLayout.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void passCodeCreate() {
        showRequiredLayout();
    }

}
