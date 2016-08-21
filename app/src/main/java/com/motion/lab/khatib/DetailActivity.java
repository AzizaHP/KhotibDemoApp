package com.motion.lab.khatib;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.motion.lab.khatib.model.Jadwal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {

    private Jadwal item;

    @BindView(R.id.masjid_text) TextView nameMasjid;
    @BindView(R.id.masjid_address) TextView addressMasjid;
    @BindView(R.id.pengurus_name_text) TextView pegurusName;
    @BindView(R.id.pengurus_email_address) TextView emailMasjid;
    @BindView(R.id.pengurus_phone_address) TextView phoneMasjid;

    @OnClick(R.id.call_button) void clickCall(){
        Intent intentcall = new Intent();
        intentcall.setAction(Intent.ACTION_CALL);
        intentcall.setData(Uri.parse("tel:" + phoneMasjid.getText())); // set the Uri
        startActivity(intentcall);
    }

    @OnClick(R.id.message_button) void clickMessage(){
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms",
                phoneMasjid.getText().toString(), null)));
    }

    @OnClick(R.id.cancel_button) void clickCancel(View view){
        Snackbar.make(view, "Belum berfungsi", Snackbar.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);

        item = (Jadwal) getIntent().getSerializableExtra(MainActivity.DATA_ITEM);

        DateFormat df = new SimpleDateFormat("dd MMM", Locale.US);
        getSupportActionBar().setTitle("Detail Jadwal: "+df.format(item.getDate()));

        nameMasjid.setText(item.getMasjid().getName());
        addressMasjid.setText(item.getMasjid().getAddress());

        pegurusName.setText(item.getMasjid().getOfficerName());
        emailMasjid.setText(item.getMasjid().getOfficerMail());
        phoneMasjid.setText(item.getMasjid().getOfficerPhone());
    }
}
