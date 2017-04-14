package azudeus.authnprofile;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Personal on 4/14/2017.
 */

public class AlAdapter extends RecyclerView.Adapter<ListHolder>{
    private ArrayList<CardElement> list;

    public AlAdapter(ArrayList<CardElement> list){
        this.list = list;
    }

    @Override
    public int getItemCount(){
        return list.size();
    }

    @Override
    public void onBindViewHolder(ListHolder listholder, int i){
        String name = list.get(i).name;
        String url = list.get(i).url;
        int price = list.get(i).price;
        listholder.vName.setText(name);
        listholder.vPrice.setText(Integer.toString(price));
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup viewgroup, int i){
        View itemView = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.activity_card,viewgroup,false);
        return new ListHolder(itemView);
    }

}
