package vistula.mn.nowa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText nameEditText;
    EditText surnameEditText;
    EditText ageEditText;
    EditText passwordEditText;
    Button buttonLogIn;
    Button generateButton;
    TextView generatedTextView;
    Button saveButton;
    Button wczytajButton;
    TextView printOutTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        nameEditText = findViewById(R.id.nameEditText);
        surnameEditText = findViewById(R.id.surnameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        generatedTextView = findViewById(R.id.generatedTextView);
        printOutTextView = findViewById(R.id.printOutTextView);

    }
    public void afterLogin(View view) {
        EditText editTextPassword = passwordEditText;
        TextView textViewPassword = findViewById(R.id.generatedTextView);
        if(nameEditText.getText().toString().isEmpty() || surnameEditText.getText().toString().isEmpty() || ageEditText.getText().toString().isEmpty() || passwordEditText.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, R.string.error_not, Toast.LENGTH_SHORT).show();
        }else {

            if (editTextPassword.getText().toString().equals(textViewPassword.getText().toString())) {
                Intent myIntent = new Intent(this, Menu_MN_46481.class);
                myIntent.putExtra("name", nameEditText.getText().toString());
                myIntent.putExtra("surname", surnameEditText.getText().toString());
                myIntent.putExtra("password", passwordEditText.getText().toString());
                myIntent.putExtra("age", ageEditText.getText().toString());


                startActivity(myIntent);

            } else {
                TextView wrongPassword = findViewById(R.id.generatedTextView);
                wrongPassword.setVisibility(View.VISIBLE);
                Toast error = Toast.makeText(
                        getApplicationContext(),
                        R.string.wrong_password,
                        Toast.LENGTH_SHORT);
                error.show();

            }
        }


    }

    public void generatePassword(View view){
        final String chars="qwertyuiopasdfghjklzxcvbnm1234567890";
        int len=4;
        char[]text=new char[len];
        Random r=new Random();
        for(int i=0;i<len;i++){
            text[i]=chars.charAt(r.nextInt(chars.length()));
        }
        TextView textViewPassword = findViewById(R.id.generatedTextView);
        textViewPassword.setText(new String(text));
        Toast.makeText(MainActivity.this, R.string.generated, Toast.LENGTH_SHORT).show();
    }

    public void saveIn(View view){
        if(nameEditText.getText().toString().isEmpty() || surnameEditText.getText().toString().isEmpty() || ageEditText.getText().toString().isEmpty()){
            Toast error = Toast.makeText(
                    getApplicationContext(),
                    R.string.error_not,
                    Toast.LENGTH_SHORT);
            error.show();

        }else {
            EditText editTextName = nameEditText;
            EditText editTextSurname = surnameEditText;
            EditText editTextAge = ageEditText;
            Toast.makeText(MainActivity.this,  R.string.data_saved, Toast.LENGTH_SHORT).show();

            String string = "";
            string += " " + editTextName.getText() + " ";
            string += "\n " + editTextSurname.getText() + " ";
            string += "\n " + editTextAge.getText() + " ";



            try {
                FileOutputStream fOut = openFileOutput("memory.txt", MODE_PRIVATE);
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
    public void loadOut(View view){
        try {
            int readBlockSize = 100;
            FileInputStream fin = openFileInput("memory.txt");
            InputStreamReader isr = new InputStreamReader(fin);
            char[] inputBuffer = new char[readBlockSize];
            String str = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                str += readString;
                inputBuffer = new char[readBlockSize];
            }
            TextView textViewOut=(TextView)findViewById(R.id.printOutTextView);
            textViewOut.setText(str);
            Toast.makeText(MainActivity.this, R.string.data_loaded, Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(getBaseContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


}
