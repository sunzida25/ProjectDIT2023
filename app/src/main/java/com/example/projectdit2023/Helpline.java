package com.example.projectdit2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Helpline extends AppCompatActivity {

    RecyclerView recyclerView3;
    myAdapter3 adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpline);

        recyclerView3=findViewById(R.id.recylerView1);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model3> options =
                new FirebaseRecyclerOptions.Builder<model3>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Helpline_num"), model3.class)
                        .build();

        adapter3=new myAdapter3(options,Helpline.this);
        recyclerView3.setAdapter(adapter3);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter3.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter3.stopListening();
    }

    @Override

    //For Search Option
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.searchmenu1,menu);
        MenuItem item=menu.findItem(R.id.search1);
        SearchView searchView=(SearchView)item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processSearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processSearch(s);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void processSearch(String s)

    {



        FirebaseRecyclerOptions<model3> options =
                new FirebaseRecyclerOptions.Builder<model3>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Helpline_num").orderByChild("o_name").startAt(s).endAt(s+"\uf8ff"), model3.class)
                        .build();

        adapter3= new myAdapter3(options, Helpline.this);
        adapter3.startListening();
        recyclerView3.setAdapter(adapter3);
    }
}