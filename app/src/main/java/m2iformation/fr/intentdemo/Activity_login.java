package m2iformation.fr.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity_login extends AppCompatActivity {
    private EditText etDomain;
    private Button btOk;
    private Button btAnnuler;
    private EditText etLogin;
    private EditText etMdp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btOk = findViewById(R.id.btOk);
        btAnnuler = findViewById(R.id.btCancel);
        etLogin = findViewById(R.id.etLogin);
        etMdp = findViewById(R.id.etPwd);

        etDomain = findViewById(R.id.etDomain);
        etDomain.setText(getIntent().getStringExtra("Domaine"));

    }

    public void btOk(View view) {
        Intent forOk = new Intent(this, MainActivity.class);
        String saisieLog = etLogin.getText().toString();
        String saisieMdp = etMdp.getText().toString();

        if (saisieLog.equals(saisieMdp) && saisieLog.length() >0){
            setResult(RESULT_OK, forOk);
            forOk.putExtra("Login", saisieLog);
        }else{
            setResult(RESULT_CANCELED, forOk);
        }
        finish();
    }

    public void btCancel(View view) {
        //Intent forCancel = new Intent(this, MainActivity.class); // On peut se passer de l'intent car ne sert à rien
        setResult(RESULT_CANCELED);
        finish();
    }
}
