package com.eshikhon.project.covid19.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.eshikhon.project.covid19.R;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    public void website(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jahid2811.github.io"));
        startActivity(intent);
    }

    public void phonecall(View view) {
        long number = +8801784263063l;
        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:"+number));
        startActivity(callIntent);
    }

    public void messenger(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/JAHID2811"));
        startActivity(intent);
    }

    public void whatsapp(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/+8801956185620"));
        startActivity(intent);
    }

    public void mail(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","jahid2811official@gmail.com", null));
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

    public void github(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/JAHID2811"));
        startActivity(intent);
    }

    public void facebook(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/JAHID2811"));
        startActivity(intent);
    }

    public void instgram(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/JAHID2811"));
        startActivity(intent);
    }

    public void twitter(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/JAHID2811"));
        startActivity(intent);
    }

    public void linkedin(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/jahid28111"));
        startActivity(intent);
    }
}