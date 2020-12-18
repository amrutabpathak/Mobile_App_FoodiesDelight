package edu.neu.mad_sea.foodiesdelight.holder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import edu.neu.mad_sea.foodiesdelight.R;
import edu.neu.mad_sea.foodiesdelight.interfaces.ClickListerner;

public class RestMenuHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener{

    private ImageButton menuImage;
    private TextView menuName;
    private TextView menuDesc;
    private TextView price;
    private ClickListerner itemClickListener;


    public TextView getPrice() {
        return price;
    }

    public void setPrice(TextView price) {
        this.price = price;
    }

    public ImageButton getMenuImage() {
        return menuImage;
    }

    public TextView getMenuName() {
        return menuName;
    }

    public TextView getMenuDesc() {
        return menuDesc;
    }

    public void setMenuImage(ImageButton menuImage) {
        this.menuImage = menuImage;
    }

    public void setMenuName(TextView menuName) {
        this.menuName = menuName;
    }

    public void setMenuDesc(TextView menuDesc) {
        this.menuDesc = menuDesc;
    }

    public RestMenuHolder(@NonNull View itemView) {
        super(itemView);

        menuImage = itemView.findViewById(R.id.menuImg);
        menuName = itemView.findViewById(R.id.menuName);
        menuDesc = itemView.findViewById(R.id.menuDesc);
        price = itemView.findViewById(R.id.price);
        itemView.setOnClickListener(this);
        menuImage.setOnClickListener(this);
        menuName.setOnClickListener(this);
        menuDesc.setOnClickListener(this);
        price.setOnClickListener(this);


    }

    public void setItemClickListener(ClickListerner itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v, getAdapterPosition());
    }
}
