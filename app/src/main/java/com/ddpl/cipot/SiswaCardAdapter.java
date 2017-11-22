package com.ddpl.cipot;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SiswaCardAdapter extends RecyclerView.Adapter<SiswaCardAdapter.CardViewHolder> {

    String[] text = new String[]{"Siswa Aasdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Siswa B", "Siswa C", "Siswa D", "Siswa E", "Siswa F", "Siswa G", "Siswa H", "Siswa I"};

    @Override
    public SiswaCardAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_siswa, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        holder.tvNamaSiswa.setText(text[position]);
    }

    @Override
    public int getItemCount() {
        return text.length;
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
