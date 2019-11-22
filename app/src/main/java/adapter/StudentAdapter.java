package adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.softwaricacoventry.R;

import java.util.List;

import helper.MyHelper;
import model.Student;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentAdapterViewHolder>{

    Context mContext;
    List<Student> studentList;

    public StudentAdapter(Context mContext, List<Student> studentList) {
        this.mContext = mContext;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_details, viewGroup, false);
        return new StudentAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapterViewHolder studentAdapterViewHolder, final int i) {
        final Student student = studentList.get(i);
        studentAdapterViewHolder.name.setText(student.getName());
        studentAdapterViewHolder.age.setText(student.getAge());
        studentAdapterViewHolder.address.setText(student.getAddress());
        studentAdapterViewHolder.gender.setText(student.getGender());

        studentAdapterViewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyHelper myHelper = new MyHelper(mContext);
                final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();
//                Student student1 = new Student(student.getStudentId())
                myHelper.deleteStudent(student);

                Toast.makeText(mContext,"Student Deleted",Toast.LENGTH_LONG).show();
                studentList.remove(i);
                notifyDataSetChanged();
            }
        });


        if (student.getGender().equals("Male"))
        {
            studentAdapterViewHolder.imageView.setImageResource(R.drawable.male);
        }else if (student.getGender().equals("Female"))
            {
            studentAdapterViewHolder.imageView.setImageResource(R.drawable.female);
            }else{
            studentAdapterViewHolder.imageView.setImageResource(R.drawable.others);

        }

    }



    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentAdapterViewHolder extends RecyclerView.ViewHolder{

        TextView name,age,address,gender;
        ImageView imageView;
        ImageButton btnDelete;

        public StudentAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            age = itemView.findViewById(R.id.tvAge);
            address = itemView.findViewById(R.id.tvAddress);
            gender = itemView.findViewById(R.id.tvGender);
            imageView = itemView.findViewById(R.id.imageView);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }

    }
}
