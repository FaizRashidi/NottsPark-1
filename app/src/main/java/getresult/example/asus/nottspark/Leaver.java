package getresult.example.asus.nottspark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Leaver extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaver);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button mParkerButton = (Button) findViewById(R.id.btnSearchParker);
        mParkerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchParker(view);
            }
        });
    }


    public void searchParker(View v) {
        Intent intent = new Intent(this, ParkerFound.class);
        startActivity(intent);
    }}

