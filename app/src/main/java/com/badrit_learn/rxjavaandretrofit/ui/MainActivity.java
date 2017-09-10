package com.badrit_learn.rxjavaandretrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.badrit_learn.rxjavaandretrofit.R;
import com.badrit_learn.rxjavaandretrofit.adapter.MyAdapter;
import com.badrit_learn.rxjavaandretrofit.dependencies.DaggerHomeComponent;
import com.badrit_learn.rxjavaandretrofit.dependencies.HomeModule;
import com.badrit_learn.rxjavaandretrofit.models.Result;
import com.badrit_learn.rxjavaandretrofit.presenter.HomePresenter;
import com.badrit_learn.rxjavaandretrofit.view.HomeView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView {

    @Inject
    HomePresenter mPresenter;

    @BindView(R.id.my_recycler_view)
    RecyclerView recyclerView;

    private MyAdapter mAdapter;
    private ArrayList<Result> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        usersList = new ArrayList<>();
        injectComponent();
        createRecycleView();
        mPresenter.getUsersList();

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.getUsersList();
    }

    public void createRecycleView() {
        mAdapter = new MyAdapter(usersList,this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(mAdapter);
    }

    public void injectComponent() {
        DaggerHomeComponent
                .builder()
                .homeModule(new HomeModule(this))
                .build()
                .inJect(this);
    }

    @Override
    public void showLoading() {
        Log.i("Hello", "show Loading bar");
    }

    @Override
    public void hideLoading() {
        Log.i("Hello", "hide Loading bar ");
    }

    @Override
    public void onConnectionError() {
        Log.i("Hello", "No Connection");
    }

    @Override
    public void showMessage(String Message) {
        Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void FillUsersList(ArrayList<Result> users) {
        usersList.clear();
        usersList.addAll(users);
        mAdapter.notifyDataSetChanged();
        for (int i=0;i<usersList.size();i++)
        {
            Log.i("Hello",usersList.get(i).getEmail());
        }
    }
}
