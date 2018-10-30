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
    private Context listContext;
    int mResource;

    private DonationFilter donationFilter;
    private ArrayList<Donation> donations;


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
        donations = objects;
    }

    @Override
    public Filter getFilter() {
        if (donationFilter == null) {
            donationFilter = new DonationFilter();
        }
        return donationFilter;
    }
    @Override
    public Donation getItem(int i) {
        return donations.get(i);
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
        holder.price.setText("$" + price);

        return convertView;
    }


    private class DonationFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults results = new FilterResults();
            ArrayList<Donation> allDonations = donations;
            if(charSequence == null || charSequence.length() == 0) {
                results.values = allDonations;
                results.count = allDonations.size();
            } else {
                ArrayList<Donation> filteredDonations = new ArrayList<>();
                for(Donation d: allDonations) {
                    if (d.getTitle().contains(charSequence)){
                        filteredDonations.add(d);
                    }
                }
                results.values = filteredDonations;
                results.count = filteredDonations.size();
            }

            Log.d(results.count);
            Log.d(results.values.toString());
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            if (results.count == 0) {
                notifyDataSetInvalidated();
            } else {
                donations = (ArrayList<Donation>) results.values;
                notifyDataSetChanged();
            }
        }
    }
}
