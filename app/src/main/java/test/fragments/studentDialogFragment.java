package test.fragments;

import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import test.practice.R;
import test.practice.student;

public class studentDialogFragment extends android.app.DialogFragment implements View.OnClickListener {

    private EditText enrolNo;
    private EditText name;
    private EditText phoneNo;
    private Button saveButton;
    private DBSQLiteHelper db;

    public void setdb(DBSQLiteHelper db) {

        this.db = db;

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle
            savedInstanceState) {

        //
        View rootView = inflater.inflate(R.layout.fragment_student_dialog,container,false);

        enrolNo= rootView.findViewById(R.id.enrolInput);
        name=rootView.findViewById(R.id.nameInput);
        phoneNo=rootView.findViewById(R.id.phoneNumber);
        saveButton= rootView.findViewById(R.id.saveButton);


        saveButton.setOnClickListener(this);

        getDialog().setTitle("add students");

        //Log.i("yay!!!",enrolNo.getText().toString());

        return rootView;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.saveButton:

                Log.i("yay!!!",enrolNo.getText().toString());
                Log.i("yay!!!",name.getText().toString());
                Log.i("yay!!!",phoneNo.getText().toString());

                int int_enrolNo=Integer.parseInt(enrolNo.getText().toString());

                db.addNewStudent(new student(int_enrolNo,name.getText().toString(),phoneNo.getText().toString()));


                //To used toast on dialog fragment , you must use getActivity instead of
                // getApplicationContext(which is use with appCompatActivity inheritance
                Toast.makeText(getActivity(),"\nNo :" + enrolNo.getText().toString() + "\nName: " + name.getText().toString() +
                        "\nPhone" + " No:" + phoneNo.getText().toString(),Toast.LENGTH_LONG).show();


                break;


        }

       //Log.i("yay!!!","in save method");
       // Button saveIt= (Button)getActivity().findViewById(R.id.saveButton);
        //this.finish();
    }

}
