package com.daiict.internship.Sahara.UserDashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.daiict.internship.Sahara.R;

import java.util.ArrayList;

public class NgoSelectionofVolunteer extends AppCompatActivity {
    public RecyclerView rview;
    private String fragmentName;
    ArrayList<VolunteerSelectionClass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ngo_selectionof_volunteer);
        fragmentName = getIntent().getStringExtra("Fragment");

        //Hooks added for recyclerview
        rview = findViewById(R.id.recyclerview_data_volunteer_ngo);
        rview.setHasFixedSize(true);
        rview.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<VolunteerSelectionClass>();

        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));
        list.add(new VolunteerSelectionClass("Aakash"));

        AdapterVolunteerSelectionNgo adapter = new AdapterVolunteerSelectionNgo(this,list);
        rview.setAdapter(adapter);




    }
    //recyclerview_data_volunteer_ngo

    public void backBtnAddNgoDataDisplay(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        startActivity(intent);

    }

    public void AllDataProceed(View view) {
        Intent intent = new Intent(this, BottomNavigationUsers.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra("Fragment", fragmentName);
        startActivity(intent);

    }
}