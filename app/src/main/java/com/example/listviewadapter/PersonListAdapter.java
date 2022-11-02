package com.example.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<Person> {
    private static final String TAG = "PersonListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;


    /*
    * Holds variables in a view
     */
    static class ViewHolder {
        TextView name;
        TextView birthday;
        TextView gender;
    }

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

        // Create the view result for showing the animation
        final View result;

        // ViewHolder object
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater  inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.tv_name);
            holder.birthday = (TextView) convertView.findViewById(R.id.tv_dob);
            holder.gender = (TextView) convertView.findViewById(R.id.tv_gender);

            result = convertView;
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }



        // Creating animation
        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition) ? R.anim.load_down_animation : R.anim.load_up_animation);
        result.startAnimation(animation);
        lastPosition = position;

        holder.name.setText(person.getName());
        holder.birthday.setText(person.getDob());
        holder.gender.setText(person.getGender());

        return convertView;
    }
}
