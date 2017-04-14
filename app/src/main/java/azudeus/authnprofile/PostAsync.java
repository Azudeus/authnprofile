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

public class PostAsync extends AsyncTask<String, String, JSONObject> {
    private static final String LOGIN_URL = "https://dev.prelo.id/api/auth/login";
    private ProgressDialog pDialog;
    HttpsURLConnection conn;
    StringBuilder result;
    JSONObject jObj = null;
    OutputStream os;

    @Override
    protected JSONObject doInBackground(String... args){
        try {
            URL url = new URL(LOGIN_URL);
            conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);

            ContentValues values = new ContentValues();
            values.put("username_or_email",args[0]);
            values.put("password",args[1]);

            conn.connect();
            os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(getQuery(values));
            writer.flush();
            writer.close();
            os.close();

            Log.d("Status",Integer.toString(conn.getResponseCode()));
            if(conn.getResponseCode()==200) {
                InputStream in = new BufferedInputStream(conn.getInputStream());
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                result = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }
                Log.d("Result", result.toString());

                conn.disconnect();
                jObj = new JSONObject(result.toString());
                return jObj;
            }else{
                return null;
            }
        } catch (IOException | JSONException e ){
            e.printStackTrace();
        }
        return null;
    }
    private String getQuery(ContentValues values) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (Map.Entry<String, Object> entry : values.valueSet()) {
            if (first)
                first = false;
            else
                result.append("&");
            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
        }

        //Log.i("Result", result.toString() + " " + String.valueOf(response));
        System.out.println(result.toString());
        return result.toString();
    }
}

