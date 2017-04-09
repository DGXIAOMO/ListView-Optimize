package com.example.miku.listview_youhua_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by miku on 2017/4/8.
 */
public class MyAdapter extends ArrayAdapter<Moule> {
    private int ResourceId;

    public MyAdapter(Context context, int textresource, List<Moule> objects) {
        super(context, textresource, objects);
        ResourceId = textresource;
    }

    private final class ViewHolder {
        private TextView textView;
        private ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Moule moule = getItem(position);
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(ResourceId, parent, false);
            holder.imageView = (ImageView) convertView.findViewById(R.id.image_view);
            holder.textView = (TextView) convertView.findViewById(R.id.text_viwe);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.imageView.setImageResource(moule.getResourceID());
        holder.textView.setText(moule.getData());
        return convertView;
    }
}
