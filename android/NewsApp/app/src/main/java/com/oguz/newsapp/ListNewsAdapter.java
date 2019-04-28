package com.oguz.newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
public class ListNewsAdapter extends BaseAdapter {

    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    public ListNewsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data = d;
    }

    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ListNewsViewHolder holder = null;
        if (convertView == null) {
            holder = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(R.layout.list_row, parent, false);
            holder.galleryImage = (ImageView) convertView.findViewById(R.id.galleryImage);
            holder.category = (TextView) convertView.findViewById(R.id.category);
            holder.header = (TextView) convertView.findViewById(R.id.header);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.date = (TextView) convertView.findViewById(R.id.date);
            holder.likes = (TextView) convertView.findViewById(R.id.likes);
            holder.dislikes = (TextView) convertView.findViewById(R.id.dislikes);
            holder.views = (TextView) convertView.findViewById(R.id.views);
            convertView.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) convertView.getTag();
        }
        holder.galleryImage.setId(position);
        holder.category.setId(position);
        holder.header.setId(position);
        holder.content.setId(position);
        holder.date.setId(position);
        holder.likes.setId(position);
        holder.dislikes.setId(position);
        holder.views.setId(position);

        HashMap<String, String> song = new HashMap<String, String>();
        song = data.get(position);

        try {
            holder.category.setText(song.get(MainActivity.KEY_CATEGORY));
            holder.header.setText(song.get(MainActivity.KEY_HEADER));
            holder.date.setText(song.get(MainActivity.KEY_PUBLISHDATE));
            holder.content.setText(song.get(MainActivity.KEY_CONTENT));
            holder.likes.setText(song.get(MainActivity.KEY_LIKES));
            holder.dislikes.setText(song.get(MainActivity.KEY_DISLIKES));
            holder.views.setText(song.get(MainActivity.KEY_VIEWS));

            if (song.get(MainActivity.KEY_IMAGEURL).toString().length() < 5) {
                holder.galleryImage.setVisibility(View.GONE);
            } else {
                Picasso.with(activity)
                        .load(song.get(MainActivity.KEY_IMAGEURL).toString())
                        .resize(300, 200)
                        .into(holder.galleryImage);
            }
        } catch (Exception e) {}
        return convertView;
    }
}

class ListNewsViewHolder {
    ImageView galleryImage;
    TextView category, header, content, date, likes, dislikes, views;
}
