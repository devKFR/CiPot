package com.ddpl.cipot;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SiswaCardAdapter extends RecyclerView.Adapter<SiswaCardAdapter.CardViewHolder> {

    String[] text = new String[]{"Fardhan"};
    private Context context;

    SiswaCardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public SiswaCardAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_siswa, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        holder.cardViewSiswa.setUseCompatPadding(false);
        holder.tvNamaSiswa.setText(text[position]);
        String fontPath = LoginMainActivity.fontPath;
        Typeface tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        holder.tvNamaSiswa.setTypeface(tf);
        if (position == getItemCount() - 1) {
            holder.cardSiswa.setBackgroundResource(R.drawable.tombol_bawah);
        }

    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSiswa;
        TextView tvNamaSiswa;
        RelativeLayout cardSiswa;
        CardView cardViewSiswa;

        CardViewHolder(View v) {
            super(v);
            imgSiswa = (ImageView) v.findViewById(R.id.iv_fotoSiswa);
            tvNamaSiswa = (TextView) v.findViewById(R.id.tv_namaSiswaUpdate);
            cardSiswa = (RelativeLayout) v.findViewById(R.id.card_siswa);
            cardViewSiswa = (CardView) v.findViewById(R.id.cardSiswa);
            cardViewSiswa.setFocusable(false);
        }
    }
}
