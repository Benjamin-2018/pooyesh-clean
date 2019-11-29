package com.android.pooyeshclean.remote;

import com.android.pooyeshclean.remote.entity.LoginResponse;
import com.android.pooyeshclean.remote.entity.ResendResponse;
import com.android.pooyeshclean.remote.entity.VerifyResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * Created by Hossein Gheisary on 07/11/2019.
 */
public interface AuthenticationService {

    @POST
    Single<LoginResponse> sendPhoneNumber(@Url String url);

    @POST
    Single<VerifyResponse> verify(@Url String url);

    @POST
    Single<ResendResponse> resend(@Url String url);
}
