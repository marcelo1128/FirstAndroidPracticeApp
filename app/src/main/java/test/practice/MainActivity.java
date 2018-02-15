package test.practice;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import test.fragments.DBSQLiteHelper;
import test.fragments.deleteStudentFragment;
import test.fragments.studentDialogFragment;
import test.restful.restfulConsumerHandler;


public class  MainActivity extends AppCompatActivity {


    protected static DBSQLiteHelper db;
    private Button changeTextButton;
    private TextView message;
    final String[] a = {"one", "two", "three"};
    private int count = 0;
    private List<student> dbData = new ArrayList();
//    public static final java.util.logging.Logger log = (java.util.logging.Logger) LoggerFactory.getLogger(countriesTemplateRestful.class);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Activity one", "we in here dawg");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //sets up the SQLite database.(reqs:DBSQLiteHelper.java , student object class(to store
        // database values)
        db = new DBSQLiteHelper(this);


        //prints out all the data within the SQLite database.
        dbData = db.getAllStudentList();
        for (int i = 0; i < dbData.size(); i++) {
            student a = dbData.get(i);

            Log.i(i + "fsdf:", "\n" + "Enroll No: " + a.get_enroll_no() + "\n" + "Name: " + a.get_name() +
                    "\n" + "Phone No: " + a.get_phone_number());

        }


//creates the mail intent.opens a dialog where user can pick a provider to send mail.
//        String subject="killing it";
//        String bodyText="we found a bug and now we need to kill it";
//        String mailto = "mailto:bob@example.org" +
//                "?cc=" + "alice@example.com" +
//                "&subject=" + Uri.encode(subject) +
//                "&body=" + Uri.encode(bodyText);
//
//        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
//        emailIntent.setData(Uri.parse(mailto));
//
//        try {
//            startActivity(emailIntent);
//        } catch (ActivityNotFoundException e) {
//
//        }
    }


    public void showDetails(View view) {

        String display = "";
        TextView message = findViewById(R.id.showChart);
        message.setMovementMethod(new ScrollingMovementMethod());


        dbData = db.getAllStudentList();


        if (!dbData.isEmpty()) {
            for (int i = 0; i < dbData.size(); i++) {

                student a = dbData.get(i);
                display = display + "\n" + "Enroll No: " + a.get_enroll_no() + "\n" + "Name: " + a.get_name() +
                        "\n" + "Phone No: " + a.get_phone_number() + "\n";


            }

            Log.i("fsdf:", display);

            message.setText(display);
        } else {
            message.setText(null);
            Toast.makeText(getApplication(), "Database is empty", Toast.LENGTH_LONG).show();

        }

    }

    protected void clickToShowStudentFragment(View view) {
        final FragmentManager fm = getFragmentManager();
        final studentDialogFragment n = new studentDialogFragment();
        n.setdb(db);

        n.show(fm, "add student fragment");

    }

    protected void clickToDeleteFragment(View view) {
        final FragmentManager fm = getFragmentManager();
        final deleteStudentFragment n = new deleteStudentFragment();
        n.setdb(db);

        n.show(fm, "delete student fragment");

    }

    protected void clickToShowChart2(View view) {
        startActivity(new Intent(getApplicationContext(), showChartActivity.class));

    }

    protected void showChart(View view) {

        message = findViewById(R.id.showChart);
        changeTextButton = findViewById(R.id.addStudent);
        changeTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                message.setText(a[count]);
                count++;
                if (count > 2) {
                    count = 0;
                }
            }
        });
    }
    //restful getting stuff
    @Override
    protected void onStart() {

        super.onStart();
        //new HttpRequestTask().execute();
        new restfulConsumerHandler().execute();
    }


}