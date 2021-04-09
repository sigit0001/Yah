package com.example.yah;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btnLogin;

    EditText edemail, edpasswords;

    String nama, password;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(),ActivityDaftar.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
    public int validasiData(){
        String emailActive = "admin@gmail.com";
        String passActive = "123";
        nama = edemail.getText().toString();
        password = edpasswords.getText().toString();

        if(emailActive.equals(nama) && passActive.equals(password)){ // BENAR SEMUA
            return 1;
        }
        else if(emailActive.equals(nama) && !passActive.equals(password)){ // SALAH PASS
            return 2;
        }
        else if(!emailActive.equals(nama) && passActive.equals(password)){ // SALAH EMAIL
            return 3;
        }
        return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = findViewById(R.id.btSignin);

        edemail = findViewById(R.id.edEmail);

        edpasswords = findViewById(R.id.edPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                nama = edemail.getText().toString();

                password = edpasswords.getText().toString();

                if(nama.isEmpty() || password.isEmpty()){
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email / Password tidak terisi !",
                            Toast.LENGTH_LONG);
                    t.show();
                }else{
                    if(validasiData() == 1){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Sukses !",
                                Toast.LENGTH_LONG);
                        t.show();
                        Bundle b = new Bundle();
                        b.putString("email",nama.trim());
                        b.putString("pass",password.trim());

                        Intent i = new Intent(getApplicationContext(),HomeActivity.class);
                        i.putExtras(b);
                        startActivity(i);
                    }else if(validasiData() == 0){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email dan Password anda Salah !\n Silahkan Coba lagi",
                                Toast.LENGTH_LONG);
                        t.show();
                    }else if(validasiData() == 2){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Password anda Salah !\n Silahkan Coba lagi",
                                Toast.LENGTH_LONG);
                        t.show();
                    }else if(validasiData() == 3) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email anda Salah !\n Silahkan Coba lagi",
                                Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }}