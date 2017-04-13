package azudeus.authnprofile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText field_username;
    private EditText field_password;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        field_username = (EditText) findViewById(R.id.field_username);
        field_password = (EditText) findViewById(R.id.field_password);
        submit = (Button) findViewById(R.id.button_login);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if (v == submit){
            login();
        }
    }

    private void login(){
        String username = field_username.getText().toString().trim();
        String password = field_password.getText().toString().trim();

        //Validation
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this,username, Toast.LENGTH_SHORT).show();

    }
}
