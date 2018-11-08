package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs2340.binarybros.buzztracker.Models.Donation;

import java.util.ArrayList;
import java.util.List;


public class InventoryListAdapter extends ArrayAdapter<Donation> implements Filterable {
    private final Context listContext;
    int mResource;

    private final List<Donation> donations;


    static class ViewHolder {
        TextView title;
        TextView category;
        TextView location;
        TextView price;
        //ImageView icon;

    }

    public InventoryListAdapter(Context listContext, int resource, List<Donation> objects) {
        super(listContext, resource, objects);
        this.listContext = listContext;
        mResource = resource;
        donations = objects;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View convertView1 = convertView;
        String title = getItem(position).getTitle();
        String category = getItem(position).getCategory();
        String location = getItem(position).getLocation();
        String price = getItem(position).getPrice();

        //Create the donation object with the information
        Donation donation = new Donation(title, category, location, price);


        ViewHolder holder;

        if(convertView1 == null) {
            LayoutInflater inflater = LayoutInflater.from(listContext);
            convertView1 = inflater.inflate(mResource, parent, false);

            holder = new ViewHolder();
            // holder.icon = (ImageView) convertView.findViewById(R.id.listitem_image);
            holder.title = (TextView) convertView1.findViewById(R.id.donation_title);
            holder.category = (TextView) convertView1.findViewById(R.id.category_label);
            holder.location = (TextView) convertView1.findViewById(R.id.location_label);
            holder.price = (TextView) convertView1.findViewById(R.id.price_label);

            convertView1.setTag(holder);
        } else {
            holder = (ViewHolder) convertView1.getTag();
        }

        holder.title.setText(title);
        holder.category.setText(category);
        holder.location.setText(location);
        holder.price.setText("$" + price);

        return convertView1;
    }
}
