package vistula.mn.nowa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Photo_MN_46481 extends AppCompatActivity {

    Button buttonPhotoBack;
    EditText editPhotoText;
    TextView textPhotoSave;
    TextView textPhotoLoad;

    Button buttonSavePhoto;
    Button buttonLoadPhoto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo__mn_46481);

        textPhotoLoad = findViewById(R.id.textPhotoLoad);

        editPhotoText = findViewById(R.id.editPhotoText);

        buttonPhotoBack = findViewById(R.id.buttonPhotoBack);
        buttonPhotoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                onBackPressed();
            }
        });
    }

    public void savePhotoIn(View view){
        if(editPhotoText.getText().toString().isEmpty()){
        Toast error = Toast.makeText(
                getApplicationContext(),
                R.string.error_empty,
                Toast.LENGTH_SHORT);
        error.show();

    }else {
        EditText editTextName = editPhotoText;
        TextView textPhotoSave = findViewById(R.id.textPhotoSave);


        String string = "";
        string += " " + editTextName.getText() + " ";

            Toast.makeText(Photo_MN_46481.this, R.string.data_saved, Toast.LENGTH_SHORT).show();

            textPhotoSave.setText(string);




        try {
            FileOutputStream fOut = openFileOutput("memories.txt", MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);
            try {
                osw.write(string);
            } catch (IOException e) {
                Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
            }
            osw.flush();
            osw.close();
        } catch (IOException e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    }

    public void loadPhotoOut(View view){
        try {
            int readBlockSize = 100;
            FileInputStream fin = openFileInput("memories.txt");
            InputStreamReader isr = new InputStreamReader(fin);
            char[] inputBuffer = new char[readBlockSize];
            String str = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                str += readString;
                inputBuffer = new char[readBlockSize];
            }

            textPhotoLoad.setText(str);
            Toast.makeText(Photo_MN_46481.this, R.string.data_loaded, Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


}
