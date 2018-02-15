package test.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class showChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_chart);
        configureBackToMain();
        toastExample("whats up !");


    }

    protected void toastExample(){
        Toast.makeText(getApplicationContext(), "This is my Toast message!",
                Toast.LENGTH_LONG).show();
    }
    protected void toastExample(String text){
        Toast.makeText(getApplicationContext(),text,
                Toast.LENGTH_SHORT).show();
    }
    //this is another more "simple" way to switch panels
    protected void configureBackToMain2(View view){
        this.finish();

    }

    //this is for the button to show hiiiii!!!
    protected void showChart(View view){
        TextView messageTest= findViewById(R.id.testView);
        messageTest.setText("Hiiiiiiiii!!!!!!!!!");
        //this.finish();
    }

    //this works fine just a few more line off extra codes
    protected void configureBackToMain(){
        Button backButton=findViewById(R.id.bBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
