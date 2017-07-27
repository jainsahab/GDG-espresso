package gdg.espresso.com.gdg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private AutoCompleteTextView emailView;
    private EditText passwordView;
    private TextView loginResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailView = (AutoCompleteTextView) findViewById(R.id.email);
        passwordView = (EditText) findViewById(R.id.password);
        loginResult = (TextView) findViewById(R.id.login_result);
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
        if (areCredentialsValid(email, password)) {
            loginResult.setText(R.string.login_successful);
            loginResult.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        } else {
            loginResult.setText(R.string.login_failed);
            loginResult.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
        }
    }

    private boolean areCredentialsValid(String email, String password) {
        return "user@gmail.com".equals(email) && "Hello123".equals(password);
    }
}
