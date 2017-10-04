package vdt.test.haha;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class Adapre extends RecyclerView.Adapter<Adapre.Viewhoder> {
    ArrayList<item> list;
            Context context;

    public Adapre(ArrayList<item> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Viewhoder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.itemq,parent,false);

        return new Viewhoder(view);
    }

    @Override
    public void onBindViewHolder(Viewhoder holder, int position) {
holder.ten.setText(list.get(position).getTen());
    }

    @Override
    public int getItemCount() {
        return list
                .size();
    }

    public class Viewhoder extends RecyclerView.ViewHolder{
        TextView ten;
    public Viewhoder(View itemView) {
        super(itemView);
        ten=itemView.findViewById(R.id.txtten);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,ten.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}


}