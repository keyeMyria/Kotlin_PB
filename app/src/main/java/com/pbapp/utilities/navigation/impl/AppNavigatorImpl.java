package com.pbapp.utilities.navigation.impl;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.pbapp.R;
import com.pbapp.utilities.navigation.AppNavigator;

import java.util.Stack;

import javax.inject.Inject;


public final class AppNavigatorImpl implements AppNavigator {

    private final FragmentManager fragmentManager;
    private final Stack<AppNavigator.ViewTag> viewHistoryStack = new Stack<>();


    @Inject
    public AppNavigatorImpl(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public int getViewStackSize() {
        return viewHistoryStack.size();
    }

    @Override
    public ViewTag getTopView() {
        return viewHistoryStack.peek();
    }

    @Override
    public ViewTag removeTopView() {
        return viewHistoryStack.pop();
    }

    @Override
    public void addDrawer() {
        addToStack(ViewTag.NAVIGATION_DRAWER);
    }

    @Override
    public void removeDrawer() {
        removeViewTagIfExists(ViewTag.NAVIGATION_DRAWER);
    }

    @Override
    public void addView(@NonNull Fragment fragment, @NonNull ViewTag viewTag) {
        addToStack(viewTag);
        fragmentManager
                .beginTransaction()
                .add(R.id.v_container, fragment, viewTag.tag)
                .addToBackStack(viewTag.tag)
                .commit();

    }

    @Override
    public void goBack() {
        if (viewHistoryStack.size() > 1) {
            fragmentManager.popBackStack();
            viewHistoryStack.pop();
        }

    }

    private void addToStack(ViewTag viewTag) {
        removeViewTagIfExists(viewTag);
        viewHistoryStack.add(viewTag);
    }

    private void removeViewTagIfExists(ViewTag viewTag) {
        if (viewHistoryStack.contains(viewTag)) {
            viewHistoryStack.remove(viewTag);
        }
    }

}
