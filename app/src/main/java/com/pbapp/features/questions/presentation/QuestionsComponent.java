package com.pbapp.features.questions.presentation;

import com.pbapp.AppComponent;
import com.pbapp.di.scope.ViewScope;
import com.pbapp.features.questions.usecases.QuestionsUseCaseModule;

import dagger.Component;

@ViewScope
@Component(dependencies = AppComponent.class, modules = {QuestionsModule.class, QuestionsUseCaseModule.class})
public interface QuestionsComponent {

    void inject(QuestionsView view);

}
