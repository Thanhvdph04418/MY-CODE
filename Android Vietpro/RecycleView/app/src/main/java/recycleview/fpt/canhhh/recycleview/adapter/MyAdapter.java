package recycleview.fpt.canhhh.recycleview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import recycleview.fpt.canhhh.recycleview.R;
import recycleview.fpt.canhhh.recycleview.model.Student;

/**
 * Created by canhh on 6/29/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Student> data;

    public MyAdapter(Context context, ArrayList<Student> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custum_item,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Student st = data.get(position);
        holder.txtName.setText(st.getName());
        holder.txtAge.setText(""+st.getAge());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtName;
        public TextView txtAge;
        public ViewHolder(View itemView) {
            super(itemView);
            txtName = (TextView)itemView.findViewById(R.id.txtName);
            txtAge = (TextView)itemView.findViewById(R.id.txtAge);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            data.remove(position);
            notifyItemRemoved(position);

        }
    }
}
