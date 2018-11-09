package com.cs2340.binarybros.buzztracker.Controllers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import com.cs2340.binarybros.buzztracker.Models.Donation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class InventoryListAdapter extends ArrayAdapter<Donation> {
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
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View convertView1 = convertView;
        String title = Objects.requireNonNull(getItem(position)).getTitle();
        String category = Objects.requireNonNull(getItem(position)).getCategory();
        String location = Objects.requireNonNull(getItem(position)).getLocation();
        String price = Objects.requireNonNull(getItem(position)).getPrice();

        //Create the donation object with the information
        Donation donation = new Donation(title, category, location, price);


        ViewHolder holder;

        if(convertView1 == null) {
            LayoutInflater inflater = LayoutInflater.from(listContext);
            convertView1 = inflater.inflate(mResource, parent, false);

            holder = new ViewHolder();
            // holder.icon = (ImageView) convertView.findViewById(R.id.listItem_image);
            holder.title = convertView1.findViewById(R.id.donation_title);
            holder.category = convertView1.findViewById(R.id.category_label);
            holder.location = convertView1.findViewById(R.id.location_label);
            holder.price = convertView1.findViewById(R.id.price_label);

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
