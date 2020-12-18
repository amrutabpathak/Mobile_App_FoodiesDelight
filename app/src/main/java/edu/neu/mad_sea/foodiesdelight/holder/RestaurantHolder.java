package edu.neu.mad_sea.foodiesdelight.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import edu.neu.mad_sea.foodiesdelight.R;
import edu.neu.mad_sea.foodiesdelight.beans.Restaurant;
import edu.neu.mad_sea.foodiesdelight.interfaces.ClickListerner;

public class RestaurantHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener {

    private ImageButton restImage;
    private TextView restTitle;
    private TextView restDesc;
    private TextView location;
    private ClickListerner itemClickListener;
    private Context c;

    public ImageButton getRestImage() {
        return restImage;
    }

    public TextView getRestTitle() {
        return restTitle;
    }

    public TextView getRestDesc() {
        return restDesc;
    }

    public TextView getLocation() {
        return location;
    }

    public void setRestImage(ImageButton restImage) {
        this.restImage = restImage;
    }

    public void setRestTitle(TextView restTitle) {
        this.restTitle = restTitle;
    }

    public void setRestDesc(TextView restDesc) {
        this.restDesc = restDesc;
    }

    public void setLocation(TextView location) {
        this.location = location;
    }

    public RestaurantHolder( @NonNull View itemView) {
        super(itemView);
        restImage = itemView.findViewById(R.id.restImg);
        restDesc = itemView.findViewById(R.id.restDesc);
        restTitle = itemView.findViewById(R.id.restTitle);
        location = itemView.findViewById(R.id.restLocation);
        restImage.setOnClickListener(this);
        restDesc.setOnClickListener(this);
        restTitle.setOnClickListener(this);

        itemView.setOnClickListener(this);

    }

    public void setItemClickListener(ClickListerner itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v, getAdapterPosition());
    }



}
