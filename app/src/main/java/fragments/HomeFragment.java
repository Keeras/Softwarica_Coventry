package fragments;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.softwaricacoventry.R;

import java.util.ArrayList;
import java.util.List;

import adapter.StudentAdapter;
import helper.MyHelper;
import model.Student;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rcView);

        final MyHelper myHelper = new MyHelper(this.getContext());
        final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

        List<Student> studentList = new ArrayList<>();
        studentList = myHelper.GetAllStudent(sqLiteDatabase);

        StudentAdapter studentAdapter = new StudentAdapter(this.getContext(),studentList);
        recyclerView.setAdapter(studentAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext(),LinearLayoutManager.VERTICAL,false));

        return view;
    }

}
