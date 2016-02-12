package com.praxisgs.securesecrets.controllers;

/**
 * Created on 04/02/2016.
 */
public interface AppNavigationControllerInterface {

    /**
     * Show PassCode Page
     */
    void showPassCodePage();

    /**
     * Show the Categories page
     */

    void showCategoriesPage();

    /**
     * Show the Records page for given Category
     */

    void showRecordsPage(int id);


}
