package jsoup.vichit.com.jsoupparser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import jsoup.vichit.com.jsoupparser.movies.CinemaParser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //new SabayParser().execute();

        new CinemaParser().execute();


    }
}
