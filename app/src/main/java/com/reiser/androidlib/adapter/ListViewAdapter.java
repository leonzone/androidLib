package com.reiser.androidlib.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reiser.androidlib.R;
import com.reiser.androidlib.entry.Fruit;

import java.util.List;

/**
 * Created by sunsharp on 16/9/13.
 */
public class ListViewAdapter extends ArrayAdapter<Fruit> {
    public ListViewAdapter(Context context, int resource,
                           List<Fruit> objects) {
        super(context, resource, objects);
        // TODO Auto-generated constructor stub
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewholder;
        Fruit fruit = getItem(position);
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.fruitcellist, null);
            viewholder = new ViewHolder();
            viewholder.imageview = (ImageView) view.findViewById(R.id.img_main);
            viewholder.textview = (TextView) view.findViewById(R.id.tv_main);
            view.setTag(viewholder);
        } else {
            view = convertView;
            viewholder = (ViewHolder) view.getTag();
        }

        viewholder.textview.setText(fruit.getFruitName());
        viewholder.imageview.setImageResource(fruit.getImageResoure());

        return view;
    }

    class ViewHolder {
        TextView textview;
        ImageView imageview;
    }
}
