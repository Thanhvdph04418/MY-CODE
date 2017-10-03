package poly.kynt284.sqlite.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import poly.kynt284.sqlite.R;
import poly.kynt284.sqlite.database.StudentDao;
import poly.kynt284.sqlite.model.Student;
import poly.kynt284.sqlite.ui.adapter.StudentAdapter;

public class MainActivity extends AppCompatActivity{
    //CÁC BƯỚC TỔNG QUAN
    //1. Tạo 1 lớp model (Tùy mọi người đặt tên) ở đây mình đặt là Student;
    //2. Tạo 1 lớp CreateDatabase có chức năng tạo ra database và kiểm tra sự thay đổi của database;
    //3. Tạo 1 lớp StudentDao (Tùy mọi người đặt tên) lớp này có nhiệm vụ thêm lấy sửa xóa sinh viên;
    //4. Tạo 1 giao diện gồm có 2 Editext, 1 Button và 1 Lisview trong phần activity_main.xml;
    //5. Lớp MainActivity xử lý các nghiệp vụ logic;

    //ở bên xml có những view nào thì khai báo hết ra
    ListView lv;
    Button btnAdd;
    EditText edName, edAge;
    StudentAdapter adapter;
    StudentDao studentDao;
    ArrayList<Student> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //2 dòng dưới mình tự tạo(cứ gõ đi báo đỏ thì gõ alt+enter);
        setUpView();
        attachEvent();
    }

    //hàm này do mình tạo ra để lắng nghe sự kiện;
    private void attachEvent() {
        //lắng nghe sự kiện khi người dùng bấm vào nút thêm sinh viên;
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cho try/catch vào để bắt những lỗi không mong muốn;
                //vd: lỗi chưa validate tuổi (tuổi mà nhập chữ thì ứng dụng sẽ bị bật ra);
                try {
                    //2 dòng dưới lấy ra tên và tuổi khi người dùng nhập vào;
                    String name = edName.getText().toString();
                    int age = Integer.parseInt(edAge.getText().toString());
                    //tạo 1 lớp mới để thêm thông tin sinh viên người dùng nhập vào;
                    Student student = new Student(name, age);
                    //kiểm tra nếu thêm sinh viên thành công thì sẽ làm các công việc bên trong;
                    if (studentDao.addData(student)){
                        //in ra câu thông báo thêm thành công;
                        Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        //lấy dữ liệu để thêm vào ArrayList;
                        datas = studentDao.getData();
                        //lấy dữ liệu xong thì hiển thị ra listview;
                        adapter = new StudentAdapter(MainActivity.this, datas);
                        lv.setAdapter(adapter);
                        //xét text cho 2 ô nhập là rỗng;
                        edName.setText("");
                        edAge.setText("");
                    }else {
                        //kiểm tra nếu sai thì in ra câu thông báo "Thêm không thành công";
                        Toast.makeText(MainActivity.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                    Log.d("err", "Lỗi vào catch");
                }
            }
        });

        //Lắng nghe sự kiện khi người dùng bấm vào 1 dòng nào đó trong lisview;
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //lấy ra vị trí của dữ liệu;
                Student st = datas.get(i);
                //gọi ra phương thức xóa ở bên lớp StudentDao();
                studentDao.deleteData(st.getId());
                //xóa dữ liệu;
                datas.remove(i);
                //cập nhật sự thay đổi của listview khi dữ liệu không còn;
                adapter.notifyDataSetChanged();
            }
        });
    }

    //Hàm này là hàm ánh xạ các view
    private void setUpView() {
        btnAdd = (Button) findViewById(R.id.btnAdd);
        edAge = (EditText) findViewById(R.id.edAge);
        edName = (EditText) findViewById(R.id.edName);
        lv = (ListView) findViewById(R.id.lv);
        studentDao = new StudentDao(MainActivity.this);
        studentDao.open();
    }


}
