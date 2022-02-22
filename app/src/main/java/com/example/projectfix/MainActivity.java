 package com.example.projectfix;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

 public class MainActivity extends AppCompatActivity {

    List<CatatanModel> dataCatatan = new ArrayList<>();
    RecyclerView recycler;
    RealmHelper realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TambahCatatanActivity.class));
            }
        });

        realm = new RealmHelper(MainActivity.this);
        //membuat layout per item
        //membuat data model
//        CatatanModel catatan1 = new CatatanModel();
//        catatan1.setId("1");
//        catatan1.setJudul("Hutang ke A");
//        catatan1.setJumlahhutang("20000");
//        catatan1.setTanggal("22-02-2022");
//
//        for (int i = 0; i < 20; i++) {
//            dataCatatan.add(catatan1);
//
//        }
        //get data dari realm
        dataCatatan = realm.showData();

        //3adapter
        recycler = findViewById(R.id.recyclerView);
        recycler.setAdapter(new CatatanAdapter(MainActivity.this, dataCatatan));
        //4Layoutmanager
        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recycler.setHasFixedSize(true);
        recycler.addItemDecoration(new DividerItemDecoration(MainActivity.this, 1));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

     @Override
     protected void onResume() {
         super.onResume();
         dataCatatan = realm.showData();
         recycler.setAdapter(new CatatanAdapter(MainActivity.this, dataCatatan));


     }
 }