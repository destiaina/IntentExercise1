package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    private TextView fullname, email, homepage, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        fullname = findViewById(R.id.label_fullname);
        email = findViewById(R.id.label_email);
        homepage = findViewById(R.id.label_homepage);
        about = findViewById(R.id.label_about);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String fullnameText = bundle.getString("FULLNAME_KEY");
            String emailText = bundle.getString("EMAIL_KEY");
            String homepageText = bundle.getString("HOMEPAGE_KEY");
            String aboutText = bundle.getString("ABOUT_KEY");

            fullname.setText(fullnameText);
            email.setText(emailText);
            homepage.setText(homepageText);
            about.setText(aboutText);
        }
    }

    public void handleOpenHomepage(View view) {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String homepageText = bundle.getString("HOMEPAGE_KEY");
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+homepageText));
            startActivity(intent);
        }
    }
}