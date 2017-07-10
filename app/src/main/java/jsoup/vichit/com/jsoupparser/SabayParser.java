package jsoup.vichit.com.jsoupparser;

import android.os.AsyncTask;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by VichitDeveloper on 7/10/17.
 */

public class SabayParser extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... strings) {
        //url that want to connect
        String url = "http://news.sabay.com.kh/article/950601#utm_campaign=onpage";

        try {
            Document doc = Jsoup.connect(url).get();
            Log.d("pppppp", doc + "");

            //find title by tage name "title" and get title that it first in html page.
            Log.e("pppppp_title", doc.getElementsByTag("title").first().text());

            //get element by selector.
            Elements images = doc.select("div.content-grp-img img");
            //get image that it first in html page
            Log.e("ppppp_ImageIndex",images.first().attr("src"));
            for (Element element : images) {
                Log.e("pppppp_image", element.attr("src"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
