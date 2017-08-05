package sg.edu.rp.webservices.pd4;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView welcomeHeader,aboutMeTitle,aboutMeDesc,headerPhoto,headerProg,headerPD;
    private ImageButton btnPhoto, btnProg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeHeader = (TextView) findViewById(R.id.welcomeHeader);
        aboutMeTitle = (TextView) findViewById(R.id.aboutMeTitle);
        aboutMeDesc = (TextView) findViewById(R.id.aboutMeDesc);
        headerPhoto = (TextView) findViewById(R.id.header_photo);
        headerProg = (TextView) findViewById(R.id.header_prog);
        headerPD = (TextView) findViewById(R.id.headerPD);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"font/raleway_thin-webfont.ttf");
        welcomeHeader.setTypeface(typeface);
        aboutMeDesc.setTypeface(typeface);
        aboutMeTitle.setTypeface(typeface);
        headerProg.setTypeface(typeface);
        headerPhoto.setTypeface(typeface);
        headerPD.setTypeface(typeface);

        btnPhoto = (ImageButton) findViewById(R.id.img_photo_pd);
        btnProg = (ImageButton) findViewById(R.id.img_prog_pd);

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PhotoPD.class);
                startActivity(intent);
            }
        });
        btnProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProgPD.class);
                startActivity(intent);
            }
        });


    }
}
