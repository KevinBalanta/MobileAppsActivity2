package appmoviles.com.clase2jueves;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SigninActivity extends AppCompatActivity {

    private EditText siginEmailEt,siginPasslEt,siginRepassEt;
    private Button siginSigninBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        siginEmailEt = findViewById(R.id.signin_email_et);
        siginPasslEt = findViewById(R.id.signin_pass_et);
        siginRepassEt = findViewById(R.id.signin_repass_et);
        siginSigninBtn = findViewById(R.id.signin_signin_et);

        String email = getIntent().getExtras().getString("email");
        siginEmailEt.setText(email);



        siginSigninBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(siginEmailEt.getText().toString().isEmpty()
                        || siginPasslEt.getText().toString().isEmpty()
                        || siginRepassEt.getText().toString().isEmpty()){
                    Toast.makeText(SigninActivity.this, "Uno de los campos esta vacio", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(! siginPasslEt.getText().toString().equals(siginRepassEt.getText().toString())){
                    Toast.makeText(SigninActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent i = new Intent();
                i.putExtra("resultado", "Registro exitoso!");
                setResult(RESULT_OK, i);
                finish();

            }

        });

    }
}
