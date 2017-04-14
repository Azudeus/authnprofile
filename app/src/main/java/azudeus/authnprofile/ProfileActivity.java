package azudeus.authnprofile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListAdapter;
import android.widget.TextView;

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

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_name = (TextView) findViewById(R.id.profile_name);
        profile_username = (TextView) findViewById(R.id.profile_username);
        profile_email = (TextView) findViewById(R.id.profile_email);
        profile_location = (TextView) findViewById(R.id.profile_location);
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);

        recycler_view.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        recycler_view.setLayoutManager(mLayoutManager);

        mAdapter = new ListAdapter();
        recycler_view.setAdapter(mAdapter);
    }
