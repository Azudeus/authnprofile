package azudeus.authnprofile;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import static android.R.attr.start;

/**
 * Created by Personal on 4/14/2017.
 */

public class ListHolder extends RecyclerView.ViewHolder {
    protected TextView vName;
    protected ImageView vImage;
    protected TextView vPrice;
    protected Context context;
    public String id;

    public ListHolder(Context context, View v){
        super(v);
        this.context = context;
        vName = (TextView)v.findViewById(R.id.info_text);
        vName.setTypeface(null, Typeface.BOLD);
        vImage = (ImageView)v.findViewById(R.id.info_image);
        vPrice = (TextView)v.findViewById(R.id.info_price);

        v.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent toDetail = new Intent(v.getContext(),DetailActivity.class);
                Bundle param = new Bundle();
                param.putString("detail_id",id);
                toDetail.putExtras(param);
                v.getContext().startActivity(toDetail);
            }
        });
    }

    public void setGlideImage(String url){
        Glide.with(context).load(url).into(vImage);
    }

}
