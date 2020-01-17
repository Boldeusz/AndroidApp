package vistula.mn.nowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu_MN_46481 extends AppCompatActivity {

    TextView name2;
    TextView surname2;
    TextView age2;

    Button buttonPopraw;
    Button buttonMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__mn_46481);

        name2 = findViewById(R.id.name2);
        surname2 = findViewById(R.id.surname2);
        age2 = findViewById(R.id.age2);

        buttonPopraw = findViewById(R.id.buttonPopraw);
        buttonPopraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });

        buttonMap = findViewById(R.id.buttonMap);

        buttonMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=pulawska 233, Warsaw, Poland");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        Bundle bundle = getIntent().getExtras();

        String nameNew = bundle.getString("name");
        String surnameNew = bundle.getString("surname");
        String ageNew = bundle.getString("age");

        name2.setText(nameNew);
        surname2.setText(surnameNew);
        age2.setText(ageNew);

    }
    public void goToPhoto(View view){
        Intent intent = new Intent(
                this,
                Photo_MN_46481.class
        );
        startActivity(intent);
    }

    public void goToOblicz(View view){
        Intent intent = new Intent(
                this,
                Oblicz_MN_46481.class
        );
        startActivity(intent);
    }
}
