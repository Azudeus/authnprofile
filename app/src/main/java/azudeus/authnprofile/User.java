package azudeus.authnprofile;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Personal on 4/14/2017.
 */

public class User {
    JSONObject userdata;
    JSONObject lovelist;

    public User(){
        userdata = null;
    }

    public User(JSONObject responsejson){
        try {
            userdata = responsejson.getJSONObject("_data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void addLoveList(JSONObject responsejson){
        lovelist = responsejson;
    }
    public String getToken(){
        try {
            return userdata.getString("token");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


}
