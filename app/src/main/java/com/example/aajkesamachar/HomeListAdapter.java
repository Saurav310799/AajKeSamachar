package com.example.aajkesamachar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder>{

    Context mContext;
    ArrayList<HashMap<String, String>> mArray;

    public HomeListAdapter(Context cxt, ArrayList<HashMap<String, String>> mArray) {
        this.mContext = cxt;
        this.mArray = mArray;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgBanner;
        TextView txtTitle, txtDescription;

        public ViewHolder(View v) {
            super(v);
            imgBanner =  v.findViewById(R.id.img);
            txtTitle =  v.findViewById(R.id.textTitle);
            txtDescription =  v.findViewById(R.id.textDescription);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HashMap<String, String> map = mArray.get(position);
        Glide.with(mContext).load(map.get("url")).into(holder.imgBanner);
        holder.txtTitle.setText(map.get("title"));
        holder.txtDescription.setText(map.get("detail"));
        MainActivity.description1 = map.get("detail");
    }

    @Override
    public int getItemCount() {
        return mArray.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_content, parent, false);
        ViewHolder vh = new ViewHolder(mRowView);

        return vh;
    }

}

