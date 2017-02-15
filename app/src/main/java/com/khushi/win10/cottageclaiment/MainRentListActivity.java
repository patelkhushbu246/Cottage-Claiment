package com.khushi.win10.cottageclaiment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainRentListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rent_list);

        CustomRentAdapter adapter=new CustomRentAdapter(this,R.layout.activity_main_rent_list);
    }
}
