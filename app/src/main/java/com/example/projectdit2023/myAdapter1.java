package com.example.projectdit2023;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter1 extends FirebaseRecyclerAdapter<model1,myAdapter1.myviewholder1> {
    private Context context;

    public myAdapter1(@NonNull FirebaseRecyclerOptions<model1> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder1 holder, int position, @NonNull model1 model1) {
        holder.name_text.setText(model1.getH_name());
        holder.address_text.setText(model1.getH_location());
        holder.phone_text.setText(""+model1.getH_phone());
        holder.vaccine_text.setText(model1.getVaccine_name());

        holder.directionButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent=new Intent(holder.directionButton.getContext(),MapsActivity.class);
                intent.putExtra("Latitude",model1.getLati());
                intent.putExtra("Longitude",model1.getLongi());
                intent.putExtra("Hos_name",model1.getH_name());

                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                holder.directionButton.getContext().startActivity(intent);
            }
        });

    }





    @NonNull
    @Override
    public myviewholder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign,parent,false);
        return new myviewholder1(view);
    }

    public static class myviewholder1 extends RecyclerView.ViewHolder {

        TextView name_text,address_text,phone_text,vaccine_text;
        Button directionButton;

        public myviewholder1(@NonNull View itemView) {
            super(itemView);

            name_text=itemView.findViewById(R.id.name_text);
            address_text=itemView.findViewById(R.id.address_text);
            phone_text=itemView.findViewById(R.id.phone_text);
            vaccine_text=itemView.findViewById(R.id.vaccine_text);
            directionButton=itemView.findViewById(R.id.direction_button);



        }
    }
}
