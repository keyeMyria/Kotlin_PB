package com.megoapp.features.questions.presentation;


import dagger.Module;
import dagger.Provides;

@Module
public class QuestionsModule {

    private final QuestionsContract.View view;

    public QuestionsModule(QuestionsContract.View view) {
        this.view = view;
    }

    @Provides
    public QuestionsContract.View provideView() {
        return this.view;
    }

    @Provides
    public QuestionsContract.Presenter providePresenter(QuestionsPresenter presenter) {
        return presenter;
    }
}
