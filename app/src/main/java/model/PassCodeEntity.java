package model;

import com.google.gson.annotations.Expose;

/**
 * Created on 02/02/2016.
 */
public class PassCodeEntity {
    @Expose
    private String passCode;

    public String getPassCode() {
        return passCode;
    }

    public void setPassCode(String passCode) {
        this.passCode = passCode;
    }
}
