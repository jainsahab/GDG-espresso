package gdg.espresso.com.gdg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import gdg.espresso.com.gdg.presenter.LoginPresenter;
import gdg.espresso.com.gdg.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private AutoCompleteTextView emailView;
    private EditText passwordView;
    private TextView loginResult;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailView = (AutoCompleteTextView) findViewById(R.id.email);
        passwordView = (EditText) findViewById(R.id.password);
        loginResult = (TextView) findViewById(R.id.login_result);
        loginPresenter = new LoginPresenter(this);
        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {
        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();
        loginPresenter.login(email, password);
    }

    @Override
    public void notifyLoginSuccessful() {
        loginResult.setText(R.string.login_successful);
        loginResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
    }

    @Override
    public void notifyLoginFailure() {
        loginResult.setText(R.string.login_failed);
        loginResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
    }
}

