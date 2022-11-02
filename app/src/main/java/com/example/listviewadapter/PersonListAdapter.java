package com.example.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<Person> {
    private static final String TAG = "PersonListAdapter";
    private Context mContext;
    int mResource;

    public PersonListAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the persons information
        String name = getItem(position).getName();
        String birthday = getItem(position).getDob();
        String gender = getItem(position).getGender();

        // Create the person object with the information
        Person person = new Person(name, birthday, gender);

        LayoutInflater  inflater = LayoutInflater.from(mContext);

        // not the best practice to inflate layout like this
        convertView = inflater.inflate(mResource, parent, false);

        // Declare Text views
        TextView tvName = (TextView) convertView.findViewById(R.id.tv_name);
        TextView tvBirth = (TextView) convertView.findViewById(R.id.tv_dob);
        TextView tvGender = (TextView) convertView.findViewById(R.id.tv_gender);

        tvName.setText(name);
        tvBirth.setText(birthday);
        tvGender.setText(gender);

        return convertView;
    }
}
