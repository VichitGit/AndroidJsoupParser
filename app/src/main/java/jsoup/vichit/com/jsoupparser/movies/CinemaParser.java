package jsoup.vichit.com.jsoupparser.movies;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by VichitDeveloper on 7/11/17.
 */

public class CinemaParser extends AsyncTask<Void, Void, Void> {
    @Override
    protected Void doInBackground(Void... voids) {
        String baseUrl = "https://www.legend.com.kh";
        String url = baseUrl + "/Browsing/Movies/NowShowing";
        try {

            Document document = Jsoup.connect(url).get();
            Elements movies = document.select("article#movies-list div.list-item.movie");
            //Log.e("ppppp", movies.size() + "");

            for (Element movie : movies) {
                String postUrl = movie.select("div.image-outer img").first().attr("src");
                //Log.e("ppppp", postUrl.substring(postUrl.indexOf('w')));

                String title = movie.select("div.item-details h3.item-title").first().text();
                //Log.e("ppppp", title);

                String link = baseUrl + movie.select("div.image-outer a").first().attr("href");
                Log.e("ppppp", link);


            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
