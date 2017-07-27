package com.pbapp.features.questions.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pbapp.App;
import com.pbapp.AppComponent;
import com.pbapp.R;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QuestionsView extends Fragment implements QuestionsContract.View {

    @Inject
    QuestionsContract.Presenter presenter;

    private QuestionsComponent scopeGraph;
    private Unbinder unbinder;

    public static QuestionsView getInstance() {
        return new QuestionsView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_questions, container, false);
        setupScopeGraph(App.get(getActivity()).getAppComponent());
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onAttached();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDetached();
        unbinder.unbind();
    }


    private void setupScopeGraph(AppComponent appComponent) {
        scopeGraph = DaggerQuestionsComponent.builder()
                .appComponent(appComponent)
                .questionsModule(new QuestionsModule(this))
                .build();
        scopeGraph.inject(this);
    }
}
