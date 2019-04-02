package com.inducesmile.androidfingerprintlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class changePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        final String userBio = getIntent().getExtras().getString("USER_BIO");
        final Gson gson = ((CustomApplication)getApplication()).getGsonObject();
        final UserObject mUserObject = gson.fromJson(userBio, UserObject.class);

        final EditText passwordold;
        passwordold = (EditText)findViewById(R.id.editText3);

        Button proceedButton = (Button)findViewById(R.id.button6);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passwordoldstr = passwordold.getText().toString();

                String passactual = mUserObject.getPassword();

                if(!passactual.equals(passwordoldstr))
                {
                    Toast.makeText(changePassword.this, "Password Mismatch", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent intentnew = new Intent(changePassword.this, changePassword2.class);
                    intentnew.putExtra("USER_BIO", userBio);
                    startActivity(intentnew);
                }
            }
        });
    }
}
