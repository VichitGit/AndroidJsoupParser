package jsoup.vichit.com.jsoupparser.movies;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jsoup.vichit.com.jsoupparser.listener.Callback;
import jsoup.vichit.com.jsoupparser.model.CinemaModel;

/**
 * Created by VichitDeveloper on 7/11/17.
 */

public class CinemaParser extends AsyncTask<Void, Void, List<CinemaModel>> {

    List<CinemaModel> cinemaModelList;
    private Callback callBack;


    public CinemaParser(Callback callBack) {
        cinemaModelList = new ArrayList<>();
        this.callBack = callBack;

    }

    //first working
    @Override
    protected void onPreExecute() {
        callBack.onPreExcute();
        Log.e("pppppp","CinemaParser OnPreExecute");
    }

    //after onPreExcute
    @Override
    protected List<CinemaModel> doInBackground(Void... voids) {
        String baseUrl = "https://www.legend.com.kh";
        String url = baseUrl + "/Browsing/Movies/NowShowing";
        try {

            Document document = Jsoup.connect(url).get();
            Elements movies = document.select("article#movies-list div.list-item.movie");
            //Log.e("ppppp", movies.size() + "");

            for (Element movie : movies) {
                String imageUrl = movie.select("div.image-outer img").first().attr("src");
                //Log.e("ppppp", postUrl.substring(postUrl.indexOf('w')));

                String title = movie.select("div.item-details h3.item-title").first().text();
                //Log.e("ppppp", title);

                String link = baseUrl + movie.select("div.image-outer a").first().attr("href");
                //Log.e("ppppp", link);

                CinemaModel cinemaItems = new CinemaModel(title, imageUrl, link);
                cinemaModelList.add(cinemaItems);


            }

        } catch (IOException e) {
            e.printStackTrace();
            callBack.onError();
            Log.e("pppppp","CinemaParser OnError");
        }


        return cinemaModelList;
    }

    //after doInBackground
    @Override
    protected void onPostExecute(List<CinemaModel> cinemaModelLists) {
        callBack.onPostExcute(cinemaModelLists);
        Log.e("pppppp","CinemaParser OnPostExecute");


    }
}
