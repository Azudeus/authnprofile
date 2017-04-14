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
    public String getImageURL(){
        try {
            return userdata.getJSONObject("profile").getString("pict");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getUsername(){
        try {
            return userdata.getString("username");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getEmail(){
        try {
            return userdata.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getFullname(){
        try {
            return userdata.getString("fullname");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getAddress(){
        try {
            JSONObject default_address = userdata.getJSONObject("default_address");
            return default_address.getString("subdistrict_name")+","+
                    default_address.getString("region_name")+","+default_address.getString("province_name");
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

}
