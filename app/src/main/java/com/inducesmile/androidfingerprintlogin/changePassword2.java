package com.inducesmile.androidfingerprintlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class changePassword2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password2);

        final String userBio = getIntent().getExtras().getString("USER_BIO");
        final Gson gson = ((CustomApplication)getApplication()).getGsonObject();
        final UserObject mUserObject = gson.fromJson(userBio, UserObject.class);

        final EditText newpass1;
        newpass1 = (EditText)findViewById(R.id.editText2);

        final EditText newpass2;
        newpass2 = (EditText)findViewById(R.id.editText4);

        Button proceedButton = (Button)findViewById(R.id.button7);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newp1 = newpass1.getText().toString();
                String newp2 = newpass2.getText().toString();

                if(!newp1.equals(newp2))
                {
                    Toast.makeText(changePassword2.this, "Please enter same value in both fields", Toast.LENGTH_LONG).show();
                }
                else
                {
                    UserObject userData = new UserObject(mUserObject.getUsername(), mUserObject.getEmail(), newp1, mUserObject.getAddress(), mUserObject.getPhone(), mUserObject.isLoginOption(), mUserObject.getBalance());
                    String userDataString = gson.toJson(userData);
                    CustomSharedPreference pref = ((CustomApplication)getApplication()).getShared();
                    pref.setUserData(userDataString);

                    Intent intentnew = new Intent(changePassword2.this, thankYou.class);
                    intentnew.putExtra("USER_BIO", userBio);
                    startActivity(intentnew);
                }
            }
        });
    }
}
