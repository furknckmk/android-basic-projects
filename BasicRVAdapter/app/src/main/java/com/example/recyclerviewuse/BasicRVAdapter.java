package com.example.recyclerviewuse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BasicRVAdapter extends RecyclerView.Adapter<BasicRVAdapter.CardViewTasarimNesneleriniTutucu> {
    private Context mContext; // adapter icin bir context ve bir veri kumesi olusturup constructor tanimlayacagiz satir :20
    private List<String> ulkelerDisaridanGelenList;

    public BasicRVAdapter(Context mContext, List<String> ulkelerDisaridanGelenList) {
        this.mContext = mContext;
        this.ulkelerDisaridanGelenList = ulkelerDisaridanGelenList;
    }
    //Card tasariminin icerisindeki gorsel nesneleri tanimlamak icin bir sinif olusturacagiz
    //Bu sinifi ana sinifa baglayacagiz (extends edececgiz)
    public  class  CardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder{
        public TextView satirYazi;
        public CardView satirCardView;
        public ImageView noktaResim;

        public CardViewTasarimNesneleriniTutucu(View view){
            super(view);
            satirYazi=view.findViewById(R.id.satirYazi);
            satirCardView=view.findViewById(R.id.satirCardView);
            noktaResim=view.findViewById(R.id.noktaResim);
        }
    }
    // siniflari extends ettikten sonra 3 farkli assagidaki methodlar gelecek
    // onCreateViewHolder Methodu bizden yukaridaki nesnelerin hangi tasarimda oldugunu sorar
    // return icerisine erismek istedigimiz nesnelerin sinifini gireriz
    @NonNull
    @Override
    public CardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.card_design,parent,false);
        return new CardViewTasarimNesneleriniTutucu(itemView);
    }

    //Positiondan verinin indexlerini aliriz
    // holder ile gorsel nesnelere erisiyoruz.
    @Override
    public void onBindViewHolder(@NonNull CardViewTasarimNesneleriniTutucu holder, int position) {
   final String ulke = ulkelerDisaridanGelenList.get(position);
    holder.satirYazi.setText(ulke);

    holder.satirCardView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(mContext,"Sectiginiz ulke : "+ulke,Toast.LENGTH_SHORT).show();
        }

    });
        holder.noktaResim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(mContext,"Resim : "+ulke,Toast.LENGTH_SHORT).show();

                PopupMenu popupMenu =new PopupMenu(mContext,view);
                popupMenu.getMenuInflater().inflate(R.menu.card_menu,popupMenu.getMenu());
                popupMenu.show();

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.action_delete:
                                Toast.makeText(mContext,"Delete Selected ",Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.action_edit:
                                Toast.makeText(mContext,"Edit Selected "+ulke,Toast.LENGTH_SHORT).show();
                                return true;
                            default:
                        }

                        return false;
                    }
                });
            }

        });
    }
    //burada bulunan buyukluk kadar onBindViewHolder methodu calisir.
    // yani veri deposundaki veri buyuklugu kadar donderir.
    @Override
    public int getItemCount() {
        return ulkelerDisaridanGelenList.size();
    }


}
