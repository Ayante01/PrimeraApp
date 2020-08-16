package cr.ac.ucr.primeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    // esta clase extiende  de AppCompartActivity lo que nos permitira usar metodo como los R., intent o finish
    private EditText etEmail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_goto_register:
                gotoRegister();
                break;
            default:
                break;
        }
    }

    private void login() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(email.isEmpty()){
            etEmail.setError(getString(R.string.error_email));
            return;
        }
        if(password.isEmpty()){
            etPassword.setError(getString(R.string.error_password));
            return;
        }

        // Todo: Se tiene que sustituir con la logica de autentificacion de la aplicacion (web service ideal)

        if(email.equalsIgnoreCase("test@gmail.com") && "123".equalsIgnoreCase(password)){

            //Todo : enviarlo al main activity
            //Todo : almacenar en el storage el usuario

            Toast.makeText(this, R.string.logged_in, Toast.LENGTH_SHORT).show();

            //primer paramentro contexto, segundo parametro destino
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else{
            Toast.makeText(this, R.string.no_match, Toast.LENGTH_SHORT).show();
        }
    }

    private void gotoRegister() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}