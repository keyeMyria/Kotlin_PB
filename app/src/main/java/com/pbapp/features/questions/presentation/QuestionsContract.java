package com.pbapp.features.questions.presentation;


public interface QuestionsContract {

    interface View {

    }

    interface Presenter {

        void onAttached();

        void onDetached();
    }
}
