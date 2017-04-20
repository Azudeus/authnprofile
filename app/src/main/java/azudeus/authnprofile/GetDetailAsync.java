package azudeus.authnprofile;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import static android.R.attr.password;
import static android.icu.lang.UCharacter.LineBreak.LINE_FEED;
import static java.lang.System.in;

/**
 * Created by Personal on 4/14/2017.
 */

public class GetDetailAsync extends AsyncTask<String,String, JSONObject> {
    private static final String LIST_URL = "https://dev.prelo.id/api/product";
    HttpURLConnection conn;
    StringBuilder result;
    JSONObject jObj = null;

    @Override
    protected JSONObject doInBackground(String... args){
        try {
            URL url = new URL(LIST_URL+args[0]);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            Log.d("Status", Integer.toString(conn.getResponseCode()));
            if (conn.getResponseCode() == 200) {
                InputStreamReader isr;
                isr = new InputStreamReader(conn.getInputStream());
                BufferedReader in = new BufferedReader(isr);
                result = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    result.append(line).append("\n");
                }

                String jsonstring = result.toString();
                jObj = new JSONObject(jsonstring);
                Log.d("Result", jsonstring);
            }
        }catch (IOException | JSONException e){
            e.printStackTrace();
        }
        return jObj;
    }
}

