package com.badrit_learn.rxjavaandretrofit.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.badrit_learn.rxjavaandretrofit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ahmed-osama on 10/09/17.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.user_email)
    public TextView email;

    @BindView(R.id.user_phone)
    public TextView number;

    @BindView(R.id.user_name)
    public TextView name;

    @BindView(R.id.user_gender)
    public TextView gender;

    @BindView(R.id.user_image)
    public ImageView image;


    public ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
