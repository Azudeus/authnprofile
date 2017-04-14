package azudeus.authnprofile;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static azudeus.authnprofile.R.id.recycler_view;

/**
 * Created by Personal on 4/14/2017.
 */

public class ProfileActivity extends AppCompatActivity {
    private TextView profile_name;
    private TextView profile_username;
    private TextView profile_email;
    private TextView profile_location;

    private RecyclerView recycler_view;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle param = getIntent().getExtras();
        token = param.getString("token");
        Log.d("Token : ",token);

        JSONObject responsejson = null;
        try {
            responsejson = new GetProfileAsync().execute(token).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        profile_name = (TextView) findViewById(R.id.profile_name);
        profile_name.setTypeface(null, Typeface.BOLD);
        profile_username = (TextView) findViewById(R.id.profile_username);
        profile_email = (TextView) findViewById(R.id.profile_email);
        profile_location = (TextView) findViewById(R.id.profile_location);

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(mLayoutManager);

        ArrayList<CardElement> dataset = new ArrayList<CardElement>();
        dataset.add(new CardElement("Satu-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Dua-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Tiga-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Empat-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Satu-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Dua-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Tiga-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Empat-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Satu-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Dua-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Tiga-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Empat-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Satu-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Dua-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Tiga-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Empat-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Satu-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Dua-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Tiga-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));
        dataset.add(new CardElement("Empat-satu","https://image.flaticon.com/teams/new/1-freepik.jpg",12000));

        mAdapter = new AlAdapter(dataset);
        recycler_view.setAdapter(mAdapter);


    }
}