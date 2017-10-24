package com.ddpl.cipot;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 24/10/2017.
 */

public class SiswaAdapter extends RecyclerView.Adapter<SiswaAdapter.CardViewHolder> {

    String[] textSiswa = new String[]{"Siswa A", "Siswa B", "Siswa C", "Siswa D"};

    @Override
    public SiswaAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_siswa, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        holder.tvNamaSiswa.setText(textSiswa[position]);
    }

    @Override
    public int getItemCount() {
        return textSiswa.length;
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgSiswa;
        TextView tvNamaSiswa;

        public CardViewHolder(View v) {
            super(v);
            imgSiswa = (ImageView) v.findViewById(R.id.iv_fotoSiswa);
            tvNamaSiswa = (TextView) v.findViewById(R.id.tv_namaSiswa);
        }
    }
}
