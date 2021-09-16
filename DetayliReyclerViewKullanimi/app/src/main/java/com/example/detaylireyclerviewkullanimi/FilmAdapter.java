package com.example.detaylireyclerviewkullanimi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext;
    private List<Films> filmsList;

    public FilmAdapter(Context mContext, List<Films> filmsList) {
        this.mContext = mContext;
        this.filmsList = filmsList;
    }
    public class CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public ImageView imageViewFilmImage;
        public TextView textViewFilmBaslik;
        public TextView textViewFilmPrice;
        public Button buttonSepeteEkle;

        public CardViewTasarimNesneleriniTutucu(@NonNull View itemView) {
            super(itemView);
            imageViewFilmImage=itemView.findViewById(R.id.imageViewFilmImage);
            textViewFilmBaslik=itemView.findViewById(R.id.textViewFilmBaslik);
            textViewFilmPrice=itemView.findViewById(R.id.textViewFilmPrice);
            buttonSepeteEkle=itemView.findViewById(R.id.buttonSepeteEkle);
        }

    }

    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_filmdesign,parent,false);
        return new CardViewTasarimNesneleriniTutucu(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) {
        Films film= filmsList.get(position);

        holder.textViewFilmBaslik.setText(film.getFilm_name());
        holder.textViewFilmPrice.setText(film.getFilm_price()+" TL");
        holder.imageViewFilmImage.setImageResource(mContext.getResources()
                .getIdentifier(film.getFilm_Image_name(),"drawable", mContext.getPackageName()));
        holder.buttonSepeteEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext.getApplicationContext(), film.getFilm_name()+"Sepete eklendi",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return filmsList.size();
    }


}
