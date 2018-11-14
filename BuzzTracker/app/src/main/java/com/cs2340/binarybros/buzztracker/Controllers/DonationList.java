package com.cs2340.binarybros.buzztracker.Controllers;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import com.cs2340.binarybros.buzztracker.Models.Donation;

public class DonationList extends ArrayAdapter {
    private Activity context;
    private List<Donation> donationList;

    public DonationList(Activity context, List<Donation> donationList) {
        super(context, R.layout.inventory_list_adapterview, donationList);
        this.context = context;
        this.donationList = donationList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.inventory_list_adapterview, null, true);

        TextView textViewTitle = (TextView) listViewItem.findViewById(R.id.donation_title);
        TextView textViewCategory = (TextView) listViewItem.findViewById(R.id.category_label);
        TextView textViewLocation = (TextView) listViewItem.findViewById(R.id.location_label);
        TextView textViewPrice = (TextView) listViewItem.findViewById(R.id.price_label);

        Donation donation = donationList.get(position);

        textViewTitle.setText(donation.getTitle());
        textViewCategory.setText(donation.getCategory());
        textViewLocation.setText(donation.getLocation());
        textViewPrice.setText(donation.getPrice());

        return listViewItem;
    }
}
