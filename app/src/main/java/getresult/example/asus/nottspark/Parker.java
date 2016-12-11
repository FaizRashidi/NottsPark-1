package getresult.example.asus.nottspark;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Parker extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parker);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button mLeaverButton = (Button) findViewById(R.id.btnSearchLeaver);
        mLeaverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchLeaver(view);
            }
        });
    }


    public void searchLeaver(View v) {
        Intent intent = new Intent(this, LeaverFound.class);
        startActivity(intent);
    }
}

