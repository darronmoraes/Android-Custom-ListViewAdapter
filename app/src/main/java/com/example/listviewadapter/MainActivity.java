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
        Person darron = new Person("Darron Moraes", "14-12-1996", "Male");
        Person gavin = new Person("Gavin Gomes", "14-12-1996", "Male");
        Person pearl = new Person("Pearl Rodrigues", "12-11-2000", "Female");
        Person welkin = new Person("Welkin Moraes", "14-12-1996", "Male");
        Person mayron = new Person("Mayron Gomes", "14-12-1996", "Male");
        Person chrisene = new Person("Chrisene Oliveira", "12-11-2000", "Female");

        // Create ArrayList<People>
        ArrayList<Person> peopleList = new ArrayList<>();
        peopleList.add(darron);
        peopleList.add(gavin);
        peopleList.add(pearl);
        peopleList.add(welkin);
        peopleList.add(mayron);
        peopleList.add(chrisene);

        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.adapter_list_view, peopleList);
        peopleListView.setAdapter(adapter);
    }
}