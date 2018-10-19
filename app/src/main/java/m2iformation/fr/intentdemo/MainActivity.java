package m2iformation.fr.intentdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button btDemo1;
    private EditText etDomain;
    final Integer REQUEST_CODE_LOGIN = 1;
    private TextView connect;
    private Button photo;
    final Integer REQUEST_CODE_PHOTO = 2;
    private ImageView ivPhoto;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btDemo1 = findViewById(R.id.btDemo1);
        etDomain = findViewById(R.id.etDomain);
        connect = findViewById(R.id.tvLogin);
        photo = findViewById(R.id.btDemo3);
        ivPhoto = findViewById(R.id.ivPhoto);

    }

    public void btnDemo1(View view) {
        Intent i = new Intent(this, Activity_login.class);
        String domaine = etDomain.getText().toString();
        i.putExtra("Domaine", domaine);
        startActivity(i);
    }

    public void btnDemo2(View view) {
        Intent i = new Intent(this, Activity_login.class);
        i.putExtra("Domaine", etDomain.getText().toString());
        startActivityForResult(i, REQUEST_CODE_LOGIN);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_LOGIN) {
            if (resultCode == RESULT_OK) {
                connect.setText(data.getStringExtra("Login"));
            }
        }
        if (requestCode == REQUEST_CODE_PHOTO) {
            if (resultCode == RESULT_OK) {
                Bitmap picture = (Bitmap) data.getExtras().get("data");
                ivPhoto.setImageBitmap(picture);
            }
        }

    }


    public void btnDemo3(View view) {
        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, REQUEST_CODE_PHOTO);
    }

    public void btnSms(View view) {
        Uri text = Uri.parse("smsto:0679805345");
        Intent i = new Intent(Intent.ACTION_SENDTO, text);
        i.putExtra("sms_body", "Hello Chris");
        startActivity(i);

    }
}
