package com.praxisgs.securesecrets.controllers;

import eventbus.AppNavigationEvents;
import eventbus.SecureSecretsEventBus;

/**
 * Created on 04/02/2016.
 */
public class AppNavigationController {

    private final String TAG = AppNavigationController.class.getName();
    private final AppNavigationControllerInterface implementer;

    public AppNavigationController(AppNavigationControllerInterface implementer) {
        this.implementer = implementer;
        SecureSecretsEventBus.register(this);
    }

    public void onEvent(AppNavigationEvents.EventShowCategoriesPage event) {
        implementer.showCategoriesPage();
    }

    public void onEvent(AppNavigationEvents.EventShowPassCodePage event) {
        implementer.showPassCodePage();
    }

    public void destroy() {
        SecureSecretsEventBus.unregister(this);
    }

}
