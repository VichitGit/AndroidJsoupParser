package jsoup.vichit.com.jsoupparser;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import jsoup.vichit.com.jsoupparser.adapter.CinemaAdapter;
import jsoup.vichit.com.jsoupparser.listener.Callback;
import jsoup.vichit.com.jsoupparser.listener.OnClickListener;
import jsoup.vichit.com.jsoupparser.model.CinemaModel;
import jsoup.vichit.com.jsoupparser.movies.CinemaParser;

public class MainActivity extends AppCompatActivity implements Callback, OnClickListener {
    private ProgressDialog dialog;
    RecyclerView rvCinema;
    List<CinemaModel> cinemaModelList;
    CinemaAdapter adapter;

    OnClickListener onClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new SabayParser().execute();

        callLayoutManager();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...!");

        new CinemaParser(this).execute();

        adapter.setOnClickListenerInAdapter(this);


    }

    @Override
    public void onPreExcute() {
        dialog.show();
        Log.e("pppppp", "MainActivity OnPreExecute");

    }

    @Override
    public void onPostExcute(List<CinemaModel> cinemaModelList) {
        this.cinemaModelList.addAll(cinemaModelList);
        adapter.notifyDataSetChanged();
        dialog.dismiss();
        Log.e("pppppp", "MainActivity OnPostExecute");

    }

    @Override
    public void onError() {
        dialog.dismiss();
        Log.e("pppppp", "MainActivity Error");

    }


    private void callLayoutManager() {


        rvCinema = (RecyclerView) findViewById(R.id.rvCinema);

//        rvCinema.setLayoutManager(new GridLayoutManager(this,
//                GridLayoutManager.VERTICAL, false));

        RecyclerView.LayoutManager layoutManager;
        layoutManager = new GridLayoutManager(this, 2);
        rvCinema.setLayoutManager(layoutManager);


        cinemaModelList = new ArrayList<>();
        adapter = new CinemaAdapter(MainActivity.this, cinemaModelList);
        rvCinema.setAdapter(adapter);


    }

    @Override
    public void onClick(int postion) {

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cinemaModelList.get(postion).getLink()));
        startActivity(intent);

    }

//    @Override
//    public void onClick(int postion) {
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(cinemaModelList.get(postion) + ""));
//        startActivity(intent);
//
//
//    }


}
