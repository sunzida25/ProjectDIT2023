package com.example.projectdit2023;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class myAdapter4 extends FirebaseRecyclerAdapter<model4,myAdapter4.myviewholder4> {
    private Context context;

    public myAdapter4(@NonNull FirebaseRecyclerOptions<model4> options, Context context) {
        super(options);
        this.context = context;

    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder4 holder, int position, @NonNull model4 model4) {
        holder.name.setText(model4.getName());
        holder.blood.setText(model4.getBloodGroup());
        holder.address.setText(model4.getDistrict()+","+model4.getUpozila());
        holder.phone.setText(model4.getPhone());
        holder.donorCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String phonee = "tel:"+(model4.getPhone());
                intent.setData(Uri.parse(phonee));
                context.startActivity(intent);
            }
        });

    }


    @NonNull
    @Override
    public myviewholder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.designforbloodbank,parent,false);
        return new myviewholder4(view);
    }

    public class myviewholder4 extends RecyclerView.ViewHolder {

        TextView name,address,blood,phone;
        Button donorCall;

        public myviewholder4(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.donor_name);
            address = itemView.findViewById(R.id.addressId);
            blood = itemView.findViewById(R.id.bloodGroupId);
            phone=itemView.findViewById(R.id.phoneId);
            donorCall=itemView.findViewById(R.id.donorCallBtn);


        }
    }
}
