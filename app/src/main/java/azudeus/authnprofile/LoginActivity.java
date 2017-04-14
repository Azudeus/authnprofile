package azudeus.authnprofile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

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

        JSONObject responsejson = null;
        try {
            responsejson = new PostAsync().execute(username,password).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        if(responsejson!=null){
            Toast.makeText(this,"Login Success",Toast.LENGTH_SHORT).show();
            Intent toProfile = new Intent(this, ProfileActivity.class);
            Bundle param = new Bundle();
            param.putString("userinfo",responsejson.toString());
            toProfile.putExtras(param);
            startActivity(toProfile);
            finish();
        }else{
            Toast.makeText(this,"Error response",Toast.LENGTH_SHORT).show();
        }
    }


}
