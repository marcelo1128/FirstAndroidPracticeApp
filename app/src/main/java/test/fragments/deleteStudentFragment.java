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


public class deleteStudentFragment extends android.app.DialogFragment implements View.OnClickListener {
    private EditText enrolNo;
    private Button deleteButton;
    private DBSQLiteHelper db;

    public void setdb(DBSQLiteHelper db)
    {
        this.db = db;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_delete_student,container,false);

        deleteButton= rootView.findViewById(R.id.deleteButton);
        enrolNo=rootView.findViewById(R.id.deleteField);

        deleteButton.setOnClickListener(this);
        getDialog().setTitle("add students");

        return rootView;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.deleteButton:

                Log.i("delete fragment enroll=",enrolNo.getText().toString());


                int int_enrolNo=Integer.parseInt(enrolNo.getText().toString());

                db.deleteStudentByEnrolNo(int_enrolNo);


                //To used toast on dialog fragment , you must use getActivity instead of
                // getApplicationContext(which is use with appCompatActivity inheritance
                Toast.makeText(getActivity(),"\nDELETED No :" + enrolNo.getText().toString(),Toast.LENGTH_LONG).show();


                break;


        }

        //Log.i("yay!!!","in save method");
        // Button saveIt= (Button)getActivity().findViewById(R.id.saveButton);
        //this.finish();
    }
}
