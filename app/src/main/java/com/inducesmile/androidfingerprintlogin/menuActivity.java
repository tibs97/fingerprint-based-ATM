package com.inducesmile.androidfingerprintlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final String userBio = getIntent().getExtras().getString("USER_BIO");

        Button cashWithdrawl1 = (Button)findViewById(R.id.cashW);
        cashWithdrawl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cashW = new Intent(menuActivity.this, cashWithdrawl1.class);
                cashW.putExtra("USER_BIO", userBio);
                startActivity(cashW);
            }
        });

        Button viewBalance = (Button)findViewById(R.id.viewB);
        viewBalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewB = new Intent(menuActivity.this, UserProfileActivity.class);
                viewB.putExtra("USER_BIO", userBio);
                startActivity(viewB);
            }
        });

        Button changePassword = (Button)findViewById(R.id.changeP);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeP = new Intent(menuActivity.this, changePassword.class);
                changeP.putExtra("USER_BIO", userBio);
                startActivity(changeP);
            }
        });

        Button addrf = (Button)findViewById(R.id.addRF);
        addrf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addremove = new Intent(menuActivity.this, addRemoveFingerprint.class);
                addremove.putExtra("USER_BIO", userBio);
                startActivity(addremove);
            }
        });
    }
}
