package com.badrit_learn.rxjavaandretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badrit_learn.rxjavaandretrofit.R;
import com.badrit_learn.rxjavaandretrofit.models.Result;
import com.badrit_learn.rxjavaandretrofit.ui.ViewHolder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by ahmed-osama on 10/09/17.
 */

public class MyAdapter extends RecyclerView.Adapter<ViewHolder>{

    private ArrayList<Result> usersList;
    private Context mcontext;
    public MyAdapter(ArrayList<Result> usersList,Context context) {
        this.usersList = usersList;
        this.mcontext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Result result = usersList.get(position);

        holder.email.setText(result.getEmail());
        holder.number.setText(result.getPhone());
        holder.gender.setText(result.getGender());

        Glide.with(mcontext)
                .load(result.getPicture().getMedium())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(holder.image);
        holder.name.setText(result.getName().getTitle()+"  "+result.getName().getFirst()+"\t"+result.getName().getLast());
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
