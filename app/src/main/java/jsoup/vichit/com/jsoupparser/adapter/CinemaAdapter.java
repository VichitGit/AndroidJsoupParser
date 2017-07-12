package jsoup.vichit.com.jsoupparser.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import jsoup.vichit.com.jsoupparser.R;
import jsoup.vichit.com.jsoupparser.listener.OnClickListener;
import jsoup.vichit.com.jsoupparser.model.CinemaModel;

/**
 * Created by VichitDeveloper on 7/11/17.
 */

public class CinemaAdapter extends RecyclerView.Adapter<CinemaAdapter.CinemaViewHolder> {
    List<CinemaModel> cinemaModelLists;
    Context context;
    CinemaModel cinemaModel;
    OnClickListener onClickListener;

    public CinemaAdapter(Context context, List<CinemaModel> cinemaModelList) {
        this.cinemaModelLists = cinemaModelList;
        this.context = context;
    }

    @Override
    public CinemaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cinema_layout, parent, false);
        return new CinemaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CinemaViewHolder holder, int position) {
        cinemaModel = cinemaModelLists.get(position);

        holder.tvTitle.setText(cinemaModel.getTitle());
//        holder.tvLink.setText(cinemaModel.getLink());

        Picasso.with(context)
                .load("http://" + cinemaModel.getImageUrl().substring(cinemaModel.getImageUrl().indexOf('w')))
                .into(holder.ivImage);
        Log.e("ppppp_title", cinemaModel.getTitle());
        Log.e("ppppp_picasso", cinemaModel.getImageUrl().substring(cinemaModel.getImageUrl().indexOf('w')));
        Log.e("ppppp", "Picasso");
    }

    @Override
    public int getItemCount() {
        return cinemaModelLists.size();
    }

    public void setOnClickListenerInAdapter(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    class CinemaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvTitle;
        ImageView ivImage;

        public CinemaViewHolder(View itemView) {
            super(itemView);

            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
//            tvLink = (TextView) itemView.findViewById(R.id.tvLink);
            ivImage = (ImageView) itemView.findViewById(R.id.ivImage);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onClickListener.onClick(getAdapterPosition());


        }
    }
}
