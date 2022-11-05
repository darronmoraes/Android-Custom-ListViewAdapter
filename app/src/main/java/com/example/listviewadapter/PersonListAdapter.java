package com.example.listviewadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

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
        ImageView displayImage;
    }

    public PersonListAdapter(Context context, int resource, ArrayList<Person> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Set up the image loader
        setupImageLoader();
        // Get the persons information
        String name = getItem(position).getName();
        String birthday = getItem(position).getDob();
        String gender = getItem(position).getGender();
        String imageUrl = getItem(position).getImageUrl();

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
            //initialize image view
            holder.displayImage = (ImageView) convertView.findViewById(R.id.iv_displayImage);

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

        ImageLoader imageLoader = ImageLoader.getInstance();
        // fallback image initialization
        int defaultImage = mContext.getResources().getIdentifier("@drawable/img_failed", null, mContext.getPackageName());
        DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                .cacheOnDisc(true).resetViewBeforeLoading(true)
                .showImageForEmptyUri(defaultImage)  // fallback/defaultImage is the default image which will load if the image set is taking time to load.
                .showImageOnFail(defaultImage)
                .showImageOnLoading(defaultImage).build();

        imageLoader.displayImage(imageUrl, holder.displayImage, options);  // 3 arguments @ url, imgView, options

        // Since Person object is deleted which was created previously, we remove that and add name, birthday and gender directly.
        holder.name.setText(name);
        holder.birthday.setText(birthday);
        holder.gender.setText(gender);

        return convertView;
    }

    /*
    * Blog post link
    * http://stacktips.com/tutorials/android/universal-image-loader-library-in-android
    *
    * method for ImageLoader using the library
    * */
    private void setupImageLoader() {
        // UNIVERSAL IMAGE LOADER SETUP
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                .cacheOnDisc(true).cacheInMemory(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                mContext)
                .defaultDisplayImageOptions(defaultOptions)
                .memoryCache(new WeakMemoryCache())
                .discCacheSize(100 * 1024 * 1024).build();

        ImageLoader.getInstance().init(config);
        // END - UNIVERSAL IMAGE LOADER SETUP
    }
}
