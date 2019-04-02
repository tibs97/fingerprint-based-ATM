package com.inducesmile.androidfingerprintlogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

public class UserProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        setTitle("Profile Page");

        String userBio = getIntent().getExtras().getString("USER_BIO");
        Gson gson = ((CustomApplication)getApplication()).getGsonObject();
        UserObject mUserObject = gson.fromJson(userBio, UserObject.class);

        String username = mUserObject.getUsername();
        String email = mUserObject.getEmail();
        String phone = mUserObject.getPhone();
        String address = mUserObject.getAddress();
        String password = mUserObject.getPassword();
        double balance = mUserObject.getBalance();

        TextView userTextValue13 = (TextView)findViewById(R.id.textView13);
        userTextValue13.setText(username);

        TextView userTextValue14 = (TextView)findViewById(R.id.textView14);
        userTextValue14.setText(email);

        TextView userTextValue15 = (TextView)findViewById(R.id.textView15);
        userTextValue15.setText(password);

        TextView userTextValue16 = (TextView)findViewById(R.id.textView16);
        userTextValue16.setText(phone);

        TextView userTextValue17 = (TextView)findViewById(R.id.textView17);
        userTextValue17.setText(address);

        TextView userTextValue18 = (TextView)findViewById(R.id.textView18);
        userTextValue18.setText(Double.toString(balance));
    }
}
