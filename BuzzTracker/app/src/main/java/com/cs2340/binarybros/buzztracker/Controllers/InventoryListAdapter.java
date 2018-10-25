package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cs2340.binarybros.buzztracker.Models.Donation;

import java.util.ArrayList;


public class InventoryListAdapter extends ArrayAdapter<Donation> {
    private Context listContext;
    int mResource;

    static class ViewHolder {
        TextView title;
        TextView category;
        TextView location;
        TextView price;
        //ImageView icon;

    }

    public InventoryListAdapter(Context listContext, int resource, ArrayList<Donation> objects) {
        super(listContext, resource, objects);
        this.listContext = listContext;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String title = getItem(position).getTitle();
        String category = getItem(position).getCategory();
        String location = getItem(position).getLocation();
        String price = getItem(position).getPrice();

        //Create the donation object with the information
        Donation donation = new Donation(title, category, location, price);


        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(listContext);
            convertView = inflater.inflate(mResource, parent, false);

            holder = new ViewHolder();
            // holder.icon = (ImageView) convertView.findViewById(R.id.listitem_image);
            holder.title = (TextView) convertView.findViewById(R.id.donation_title);
            holder.category = (TextView) convertView.findViewById(R.id.category_label);
            holder.location = (TextView) convertView.findViewById(R.id.location_label);
            holder.price = (TextView) convertView.findViewById(R.id.price_label);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title.setText(title);
        holder.category.setText(category);
        holder.location.setText(location);
        holder.price.setText(price);

        return convertView;
    }
}
