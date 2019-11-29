package com.android.pooyeshclean.domain.usecase;

import com.android.pooyeshclean.domain.repository.AuthenticationRepository;
import com.android.pooyeshclean.remote.entity.LoginResponse;
import com.android.pooyeshclean.remote.entity.VerifyResponse;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Hossein Gheisary on 07/11/2019.
 */
public class VerificationUseCase {

    private AuthenticationRepository authenticationRepository;

    @Inject
    public VerificationUseCase(AuthenticationRepository authenticationRepository){
        this.authenticationRepository = authenticationRepository;
    }

    public Single<VerifyResponse> verify(String pin) {
        return authenticationRepository.verify(pin)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
