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

public class myAdapter3 extends FirebaseRecyclerAdapter<model1,myAdapter3.myviewholder3> {

    private Context context;

    public myAdapter3(@NonNull FirebaseRecyclerOptions<model1> options, Context context) {
        super(options);
        this.context = context;

    }
    @Override
    protected void onBindViewHolder(@NonNull myviewholder3 holder, int position, @NonNull model1 model1) {
        holder.name_text1.setText(model1.getO_name());
        holder.phone_text1.setText(""+model1.getPhone());

        holder.call_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                String phonee = "tel:"+String.valueOf(model1.getPhone());
                intent.setData(Uri.parse(phonee));
                context.startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerowdesign3,parent,false);
        return new myviewholder3(view);
    }

    public class myviewholder3 extends RecyclerView.ViewHolder {

        TextView name_text1, phone_text1;
        Button call_button2;

        public myviewholder3(@NonNull View itemView) {
            super(itemView);

            name_text1 = itemView.findViewById(R.id.name_text1);
            phone_text1 = itemView.findViewById(R.id.phone_text1);
            call_button2 = itemView.findViewById(R.id.call_button2);


        }
    }
}
