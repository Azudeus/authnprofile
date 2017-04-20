package azudeus.authnprofile;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import de.hdodenhof.circleimageview.CircleImageView;

import static azudeus.authnprofile.R.id.recycler_view;

/**
 * Created by Personal on 4/14/2017.
 */

public class ProfileActivity extends AppCompatActivity {
    private TextView profile_name;
    private TextView profile_username;
    private TextView profile_email;
    private TextView profile_location;
    private CircleImageView profile_image;

    private RecyclerView recycler_view;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Bundle param = getIntent().getExtras();
        String userinfo = param.getString("userinfo");
        try {
            user = new User(new JSONObject(userinfo));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject responsejson = null;
        try {
            responsejson = new GetProfileAsync().execute(user.getToken()).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        user.addLoveList(responsejson);

        profile_image = (CircleImageView)findViewById(R.id.profile_image);
        Glide.with(this).load(user.getImageURL()).into(profile_image);

        profile_name = (TextView) findViewById(R.id.profile_name);
        profile_name.setText(user.getFullname());
        profile_name.setTypeface(null, Typeface.BOLD);
        profile_username = (TextView) findViewById(R.id.profile_username);
        profile_username.setText(user.getUsername());
        profile_email = (TextView) findViewById(R.id.profile_email);
        profile_email.setText(user.getEmail());
        profile_location = (TextView) findViewById(R.id.profile_location);
        profile_location.setText(user.getAddress());

        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(mLayoutManager);

        ArrayList<CardElement> dataset = new ArrayList<CardElement>();
        for(int i=0;i<user.countLoveList();i++){
            dataset.add(new CardElement(user.getItemName(i),
                    user.getItemImage(i),Integer.parseInt(user.getItemPrice(i)),user.getItemId(i)));
        }
        mAdapter = new AlAdapter(getApplicationContext(),dataset);
        recycler_view.setAdapter(mAdapter);


    }
}