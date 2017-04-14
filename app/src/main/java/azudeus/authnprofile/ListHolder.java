package azudeus.authnprofile;

import android.content.Context;
import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

/**
 * Created by Personal on 4/14/2017.
 */

public class ListHolder extends RecyclerView.ViewHolder {
    protected TextView vName;
    protected ImageView vImage;
    protected TextView vPrice;

    public ListHolder(View v){
        super(v);
        vName = (TextView)v.findViewById(R.id.info_text);
        vImage = (ImageView)v.findViewById(R.id.info_image);
        vPrice = (TextView)v.findViewById(R.id.info_price);
    }

    public void setGlideImage(String url){

    }
}
