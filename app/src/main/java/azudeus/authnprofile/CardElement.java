package azudeus.authnprofile;

import static android.R.attr.name;

/**
 * Created by Personal on 4/14/2017.
 */

public class CardElement {
    public String url;
    public String name;
    public int price;
    public String id;

    public CardElement(String name, String url, int price,String id){
        this.url = url;
        this.name = name;
        this.price = price;
        this.id = id;
    }
}
