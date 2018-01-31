package com.rayworks.archcomponentplayground.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by Sean on 1/27/18.
 */

public class ScoreViewModel extends ViewModel {
    // Tracks the score for Team A
    public int scoreTeamA = 0;

    // Tracks the score for Team B
    public int scoreTeamB = 0;

    private final Context context;

    public ScoreViewModel(Context context) {
        this.context = context;
    }

    @Override
    protected void onCleared() {
        System.out.println(">>> VM cleared now");
    }

    // Dummy Factory to test injection
    public static class ScoreFactory extends ViewModelProvider.NewInstanceFactory {

        private final Context context;

        public ScoreFactory(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new ScoreViewModel(context.getApplicationContext());
        }
    }
}
