package tenproject.tencongty.tenminh.quanlyhethongsinhvien.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tenproject.tencongty.tenminh.quanlyhethongsinhvien.R;
import tenproject.tencongty.tenminh.quanlyhethongsinhvien.model.Student;


public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.ViewHolder> {
    private ArrayList<Student> datas;
    private Context context;

    public AdapterStudent(ArrayList<Student> datas, Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(this.context);
        View v = inflater.inflate(R.layout.custum_item_liststudent,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Student st = datas.get(position);
        holder.txtName.setText(st.getName());
        holder.txtBirthday.setText(st.getBirthday());
        holder.txtMsv.setText(position+1+"");

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtName,txtBirthday,txtMsv;
        public ViewHolder(View itemView) {
            super(itemView);
            txtMsv =(TextView)itemView.findViewById(R.id.txtMSV);
            txtBirthday =(TextView)itemView.findViewById(R.id.txtbirthday);
            txtName =(TextView)itemView.findViewById(R.id.txtName);
        }
    }
}
