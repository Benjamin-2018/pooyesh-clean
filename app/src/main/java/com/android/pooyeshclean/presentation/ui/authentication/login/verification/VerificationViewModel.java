package com.android.pooyeshclean.presentation.ui.authentication.login.verification;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.android.pooyeshclean.domain.usecase.ResendUseCase;
import com.android.pooyeshclean.domain.usecase.VerificationUseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class VerificationViewModel extends ViewModel {

    Observable<Long> counterObservable;
    MutableLiveData<Long> counter = new MutableLiveData<>();
    VerificationUseCase verificationUseCase;
    ResendUseCase resendUseCase;
    MutableLiveData<String> showError = new MutableLiveData<>();

    public VerificationViewModel(VerificationUseCase verificationUseCase, ResendUseCase resendUseCase){
        this.verificationUseCase = verificationUseCase;
        this.resendUseCase = resendUseCase;
        init();
    }

    private void init() {
        counterObservable = Observable.interval(1, TimeUnit.SECONDS);
        counterObservable.subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(Disposable d) {}
            @Override
            public void onNext(Long _counter) {
                counter.setValue(60 - _counter);
            }

            @Override
            public void onError(Throwable e) {}

            @Override
                public void onComplete() {}
        });
    }

    @SuppressLint("CheckResult")
    public void verify(String pin) {
        verificationUseCase.verify(pin)
                .subscribe(response -> {
                            if(response.succeed){
                            }
                        },
                        error -> {
                            showError.setValue(error.getMessage());
                        });
    }

    public void resend() {
        resendUseCase.resend().subscribe();
    }
}
