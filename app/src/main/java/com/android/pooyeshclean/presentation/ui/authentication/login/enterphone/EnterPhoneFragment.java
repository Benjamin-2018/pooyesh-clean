package com.android.pooyeshclean.presentation.ui.authentication.login.enterphone;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.android.pooyeshclean.R;

import javax.inject.Inject;

/**
 * Created by Hossein Gheisary on 24/10/2019.
 */
public class EnterPhoneFragment extends Fragment {

    @Inject
    EnterPhoneViewModel enterPhoneViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_enter_phone, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        enterPhoneViewModel.goToNextPage.observe(this, aBoolean -> {
            final NavDirections navDirections = EnterPhoneFragmentDirections.enterPhoneToVerify();
            final NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
            navController.navigate(navDirections);
        });

        enterPhoneViewModel.showError.observe(this, message -> {
            Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        });

        AppCompatButton enterPhoneEditText = view.findViewById(R.id.enterPhoneEditText);
        AppCompatEditText enterPhoneSendNumberButton = view.findViewById(R.id.enterPhoneSendNumberButton);

        enterPhoneEditText.setOnClickListener(view1 -> {
            if (enterPhoneSendNumberButton.getText().length() > 0) {
                enterPhoneViewModel.sendPhoneNumber(enterPhoneSendNumberButton.getText().toString());
            }
        });
    }
}
