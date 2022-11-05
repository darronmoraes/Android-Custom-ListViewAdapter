package com.example.listviewadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");

        ListView  peopleListView = (ListView) findViewById(R.id.lv_showDetails);

        // Create Person objects
        Person darron = new Person("Darron Moraes", "14-12-1996", "Male", "drawable://" + R.drawable.developer);
        Person gavin = new Person("Gavin Gomes", "14-12-1996", "Male",  "drawable://" + R.drawable.developer);
        Person pearl = new Person("Pearl Rodrigues", "12-11-2000", "Female",  "drawable://" + R.drawable.boss);
        Person welkin = new Person("Welkin Moraes", "14-12-1996", "Male",  "drawable://" + R.drawable.hr);
        Person mayron = new Person("Mayron Gomes", "14-12-1996", "Male",  "drawable://" + R.drawable.boss);
        Person chrisene = new Person("Chrisene Oliveira", "12-11-2000", "Female",  "drawable://" + R.drawable.developer);
        Person allister = new Person("Allister Lopes", "14-12-1996", "Male",  "drawable://" + R.drawable.hr);
        Person girish = new Person("Girish Suroji", "14-12-1996", "Male",  "drawable://" + R.drawable.designer);
        Person vivek = new Person("Vivek Naik", "12-11-2000", "Female",  "drawable://" + R.drawable.designer);
        Person darshan = new Person("Darshan Dessai", "14-12-1996", "Male",  "drawable://" + R.drawable.developer);
        Person karthik = new Person("Karthik Faldessai", "14-12-1996", "Male",  "drawable://" + R.drawable.hr);
        Person sejal = new Person("Sejal Gawde", "12-11-2000", "Female",  "drawable://" + R.drawable.boss);

        // Create ArrayList<People>
        ArrayList<Person> peopleList = new ArrayList<>();
        peopleList.add(darron);
        peopleList.add(gavin);
        peopleList.add(pearl);
        peopleList.add(welkin);
        peopleList.add(mayron);
        peopleList.add(chrisene);
        peopleList.add(allister);
        peopleList.add(girish);
        peopleList.add(vivek);
        peopleList.add(darshan);
        peopleList.add(karthik);
        peopleList.add(sejal);

        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_list_view, peopleList);
        peopleListView.setAdapter(adapter);
    }
}