package com.megoapp.features.questions.presentation;

import com.megoapp.AppComponent;
import com.megoapp.di.scope.ViewScope;
import com.megoapp.features.questions.usecases.QuestionsUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {QuestionsModule.class, QuestionsUseCaseModule.class})
public interface QuestionsComponent {

    void inject(QuestionsView view);

}
