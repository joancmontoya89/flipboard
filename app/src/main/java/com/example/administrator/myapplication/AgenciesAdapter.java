package com.example.administrator.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by joancolom on 15/11/16.
 */

public class AgenciesAdapter extends ArrayAdapter {

    /*
     * private variables of hte class
     */
    private Context context;
    private ArrayList data;

    public AgenciesAdapter(Context context, ArrayList data) {
        super(context, R.layout.lv_agency_item, data);
        this.context = context;
        this.data = (ArrayList<ListModelAgency>)data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.lv_agency_item, null);
        }

        // set values of the item
        TextView agencyName = (TextView)convertView.findViewById(R.id.tvAgency);
        ListModelAgency agency = (ListModelAgency) data.get(position);
        String name = agency.getName();
        agencyName.setText(name);
        Boolean subscribed = agency.getSubscribed();
        CheckBox agencySubsribed = (CheckBox)convertView.findViewById(R.id.cbSubscribedAgency);
        agencySubsribed.setChecked(subscribed);

        return convertView;
    }
}
