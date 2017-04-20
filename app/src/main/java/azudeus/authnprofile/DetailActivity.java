package azudeus.authnprofile;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.concurrent.ExecutionException;

/**
 * Created by Personal on 4/20/2017.
 */

public class DetailActivity extends AppCompatActivity {
    private ImageView detail_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle param = getIntent().getExtras();
        String itemid = param.getString("detail_id");

        JSONObject responsejson = null;
        try {
            responsejson = new GetDetailAsync().execute(itemid).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        detail_image = (ImageView) findViewById(R.id.detail_id);
        
    }

}
