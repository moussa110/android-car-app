package com.example.carapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.carapp.R;
import com.example.carapp.pojo.CarItem;

import java.util.List;

public class CarRecyclerAdapter extends RecyclerView.Adapter<CarRecyclerAdapter.ViewHolder> {
    private List<CarItem> data = null;

    public void changeData(List<CarItem> data){
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_car,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull CarRecyclerAdapter.ViewHolder holder, int position) {
        CarItem car = data.get(position);

        holder.brandTv.setText(car.getBrand());
        holder.constructionYearTv.setText(car.getConstractionYear());
        if (car.isIsUsed()) holder.typeTv.setText("Used");
        else holder.typeTv.setText("New");


        Glide.with(holder.itemView)
                .load(car.getImageUrl())
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .error(R.drawable.errorimage)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if (data!=null) return data.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView brandTv;
        TextView typeTv;
        TextView constructionYearTv;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            typeTv = itemView.findViewById(R.id.car_type_tv);
            constructionYearTv = itemView.findViewById(R.id.construction_year_tv);
            brandTv = itemView.findViewById(R.id.brand_tv);
        }
    }
}
