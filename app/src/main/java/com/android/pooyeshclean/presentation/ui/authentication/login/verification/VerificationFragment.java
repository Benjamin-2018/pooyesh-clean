package com.android.pooyeshclean.presentation.ui.authentication.login.verification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.android.pooyeshclean.R;


public class VerificationFragment extends Fragment {

    TextView verificationTimerTextView;

    Button verifyButton;
    Button resend;

    //Inject
    VerificationViewModel verificationViewModel;

    EditText verificationPin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_verification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViews(view);
        setupObservers();
        setupListeners();
    }

    private void setupListeners() {
        verifyButton.setOnClickListener(view -> {
            verificationViewModel.verify(verificationPin.getText().toString());
        });

        resend.setOnClickListener(view -> {
            verificationViewModel.resend();
        });
    }

    private void setupViews(View view) {
        verificationTimerTextView = view.findViewById(R.id.verificationTimerTextView);
        verifyButton = view.findViewById(R.id.verification_apply_button);
        resend = view.findViewById(R.id.verification_resend_button);
        verificationPin = view.findViewById(R.id.verificationPin);
    }

    private void setupObservers() {
        verificationViewModel.counter.observe(this, counter -> {
            verificationTimerTextView.setText(counter.toString());
        });
    }
}
