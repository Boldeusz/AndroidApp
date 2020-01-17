package vistula.mn.nowa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Oblicz_MN_46481 extends AppCompatActivity {

    Button buttonObliczBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oblicz__mn_46481);

        buttonObliczBack = findViewById(R.id.buttonObliczBack);
        buttonObliczBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

    }
}
