package ro.ubbcluj.domain;

import javax.persistence.Entity;

/**
 * Created by Cosmin on 19-Jun-17.
 */
public class PasswordChange {

    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

    public PasswordChange() {
    }

    public PasswordChange(String currentPassword, String newPassword, String confirmPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
