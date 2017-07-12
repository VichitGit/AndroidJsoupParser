package jsoup.vichit.com.jsoupparser.listener;

import java.util.List;

import jsoup.vichit.com.jsoupparser.model.CinemaModel;

/**
 * Created by VichitDeveloper on 7/11/17.
 */

public interface Callback {

    void onPreExcute();
    void onPostExcute(List<CinemaModel> cinemaModelList);
    void onError();


}
