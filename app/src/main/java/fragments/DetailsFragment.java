package fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.softwaricacoventry.R;
import com.example.softwaricacoventry.ViewPagerActivity;

import helper.MyHelper;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private EditText fuName,fAge,fAddress;
    private Button btnSave;
    private RadioGroup rgGroup;
    private RadioButton btnRadio;
    private String Gender;


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_details, container, false);
        fuName = view.findViewById(R.id.fuName);
        fAge = view.findViewById(R.id.fAge);
        fAddress = view.findViewById(R.id.fAddress);
        rgGroup = view.findViewById(R.id.rgGroup);


        btnSave = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer gender = rgGroup.getCheckedRadioButtonId();
                btnRadio = view.findViewById(gender);

            studentSave();

            }
        });

        return view;
    }
    private void studentSave(){
        String name = fuName.getText().toString();
        String age = fAge.getText().toString();
        String address = fAddress.getText().toString();
        String gender = btnRadio.getText().toString();

        if (name.isEmpty()) {
            fuName.setError("Please enter full name");
        }else if(age.isEmpty()) {
            fAge.setError("Please enter age");
        }else if(address.isEmpty()) {
            fAddress.setError("Please Enter address");
        }else {


            final MyHelper myHelper = new MyHelper(this.getActivity());
            final SQLiteDatabase sqLiteDatabase = myHelper.getWritableDatabase();

            boolean status = myHelper.InsertData(name, age, address, gender,sqLiteDatabase);


            if (status){
                Toast.makeText(this.getActivity(), "Successfully Added Student", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this.getContext(), ViewPagerActivity.class);
                startActivity(intent);
            }
          else {
                Toast.makeText(this.getActivity(), "Please Select gender", Toast.LENGTH_LONG).show();
            }

        }


    }
}
