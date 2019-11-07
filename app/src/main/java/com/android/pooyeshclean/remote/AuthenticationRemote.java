package com.android.pooyeshclean.remote;

import com.android.pooyeshclean.remote.entity.LoginResponse;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by Hossein Gheisary on 07/11/2019.
 */
public class AuthenticationRemote {

    AuthenticationService authenticationService;
    @Inject
    public AuthenticationRemote(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    public Single<LoginResponse> sendPhoneNumber(String phoneNumber) {
        return authenticationService.sendPhoneNumber("http://www.mocky.io/v2/5dc3ccc53000003c003475d1");
    }
}
