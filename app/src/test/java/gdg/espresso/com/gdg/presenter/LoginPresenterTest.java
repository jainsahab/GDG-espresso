package gdg.espresso.com.gdg.presenter;

import org.junit.Before;
import org.junit.Test;

import gdg.espresso.com.gdg.view.ILoginView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LoginPresenterTest {

    private ILoginView loginView;
    private LoginPresenter loginPresenter;

    @Before
    public void setUp() throws Exception {
        loginView = mock(ILoginView.class);
        loginPresenter = new LoginPresenter(loginView);
    }

    @Test
    public void loginWithValidCredentials() throws Exception {
        loginPresenter.login("user@gmail.com", "Hello123");

        verify(loginView).notifyLoginSuccessful();
    }

    @Test
    public void loginWithInvalidCredentials() throws Exception {
        loginPresenter.login("invalid-mail@gmail.com", "invalid-password");

        verify(loginView).notifyLoginFailure();
    }
}