package gdg.espresso.com.gdg.presenter;

import gdg.espresso.com.gdg.view.ILoginView;

public class LoginPresenter {
    private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    public void login(String email, String password) {
        if (areCredentialsValid(email, password)) {
            loginView.notifyLoginSuccessful();
        } else {
            loginView.notifyLoginFailure();
        }
    }

    private boolean areCredentialsValid(String email, String password) {
        return "user@gmail.com".equals(email) && "Hello123".equals(password);
    }

}
