package azudeus.authnprofile;

import android.content.Context;
import android.graphics.Typeface;
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
    protected Context context;

    public ListHolder(Context context, View v){
        super(v);
        this.context = context;
        vName = (TextView)v.findViewById(R.id.info_text);
        vName.setTypeface(null, Typeface.BOLD);
        vImage = (ImageView)v.findViewById(R.id.info_image);
        vPrice = (TextView)v.findViewById(R.id.info_price);
    }

    public void setGlideImage(String url){
        Glide.with(context).load(url).into(vImage);
    }
}
