package com.example.projectdit2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Home extends AppCompatActivity {

    CardView button1,button2,button3,button4,button5,button6;
    ImageSlider main_slider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //button hooks
        button1=findViewById(R.id.buttonId1);
        button2=findViewById(R.id.buttonId2);
        button3=findViewById(R.id.buttonId3);
        button4=findViewById(R.id.buttonId4);
        button5=findViewById(R.id.buttonId5);
        button6=findViewById(R.id.buttonId6);

        //slider Hooks
        main_slider=findViewById(R.id.image_slider);

        final List<SlideModel> remote_images=new ArrayList<>();

        //CallFirebase
        FirebaseDatabase.getInstance().getReference().child("Slider")
                .addListenerForSingleValueEvent(new ValueEventListener()


                {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot data:snapshot.getChildren())
                            remote_images.add(new SlideModel(Objects.requireNonNull(data.child("url").getValue()).toString(), ScaleTypes.FIT));

                        //data.child("title").getValue().toString(),
                        // (IF need title with slider just put this line into before line after first comma)

                        main_slider.setImageList(remote_images,ScaleTypes.FIT);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Newsfeed.class);
                startActivity(intent);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,SignIn.class);
                startActivity(intent);

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Helpline.class);
                startActivity(intent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,Vaccine.class);
                startActivity(intent);

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Home.this,AboutMain.class);
                startActivity(intent);

            }
        });



    }
}