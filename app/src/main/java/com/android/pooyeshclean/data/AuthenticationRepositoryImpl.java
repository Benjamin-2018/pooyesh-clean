package com.android.pooyeshclean.data;

import com.android.pooyeshclean.domain.repository.AuthenticationRepository;
import com.android.pooyeshclean.remote.AuthenticationRemote;
import com.android.pooyeshclean.remote.entity.LoginResponse;
import com.android.pooyeshclean.remote.entity.ResendResponse;
import com.android.pooyeshclean.remote.entity.VerifyResponse;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Hossein Gheisary on 07/11/2019.
 */
public class AuthenticationRepositoryImpl implements AuthenticationRepository {

    AuthenticationRemote authenticationRemote;
    @Inject
    public AuthenticationRepositoryImpl(AuthenticationRemote authenticationRemote){
        this.authenticationRemote = authenticationRemote;
    }

    @Override
    public Single<LoginResponse> sendPhoneNumber(String phoneNumber) {
        return authenticationRemote.sendPhoneNumber(phoneNumber);
    }

    @Override
    public Single<VerifyResponse> verify(String phoneNumber) {
        return authenticationRemote.verify(phoneNumber);
    }

    @Override
    public Single<ResendResponse> resend() {
        return authenticationRemote.resend();
    }
}
