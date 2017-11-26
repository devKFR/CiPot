package com.ddpl.cipot;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by user on 18/10/2017.
 */

public class IndikatorCardAdapter extends RecyclerView.Adapter<IndikatorCardAdapter.CardViewHolder> {

    String[] text = new String[]{"Kemampuan A", "Kemampuan B", "Kemampuan C", "Kemampuan D"};

    Context context;

    public IndikatorCardAdapter(Context context) {
        this.context = context;
    }

    @Override
    public IndikatorCardAdapter.CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_indikator, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, int position) {
        String fontPath = LoginMainActivity.fontPath;
        Typeface tf = Typeface.createFromAsset(context.getAssets(), fontPath);
        holder.tvIndikator.setText(text[position]);
        holder.tvIndikator.setTypeface(tf);
    }

    @Override
    public int getItemCount() {
        return text.length;
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgIndikator;
        TextView tvIndikator;

        public CardViewHolder(View v) {
            super(v);
            imgIndikator = (ImageView) v.findViewById(R.id.iv_indikator);
            tvIndikator = (TextView) v.findViewById(R.id.tv_indikator);
        }
    }
}
