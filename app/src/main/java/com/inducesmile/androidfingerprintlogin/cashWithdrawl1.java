package com.inducesmile.androidfingerprintlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

public class cashWithdrawl1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cash_withdrawl1);

        final String userBio = getIntent().getExtras().getString("USER_BIO");
        final Gson gson = ((CustomApplication)getApplication()).getGsonObject();
        final UserObject mUserObject = gson.fromJson(userBio, UserObject.class);

        final EditText amount;
        amount = (EditText)findViewById(R.id.editText);

        Button proceedButton = (Button)findViewById(R.id.button);
        proceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amountstr = amount.getText().toString();
                double amountvalue = Double.parseDouble(amountstr);

                double balance = mUserObject.getBalance();

                if( balance < amountvalue)
                {
                    Toast.makeText(cashWithdrawl1.this, "Your Balance in Account is insufficient.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    double newbal = balance - amountvalue;

                    UserObject userData = new UserObject(mUserObject.getUsername(), mUserObject.getEmail(), mUserObject.getPassword(), mUserObject.getAddress(), mUserObject.getPhone(), mUserObject.isLoginOption(), newbal);
                    String userDataString = gson.toJson(userData);
                    CustomSharedPreference pref = ((CustomApplication)getApplication()).getShared();
                    pref.setUserData(userDataString);

                    Intent intentnew = new Intent(cashWithdrawl1.this, thankYou.class);
                    intentnew.putExtra("USER_BIO", userBio);
                    startActivity(intentnew);
                }
            }
        });

    }
}
