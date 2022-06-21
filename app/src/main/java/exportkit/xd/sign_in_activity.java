
package exportkit.xd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class sign_in_activity extends Activity {


    private View _bg__sign_in_ek2;
    private View ellipse_1_ek2;
    private View ellipse_2_ek2;
    private ImageView vector_ek28;
    private ImageView vector_ek29;
    private ImageView vector_ek30;
    private TextView _10_50_ek2;
    private TextView welcome__ek1;
    private TextView let_s_get_started_ek1;
    private View rectangle_2_ek1;
    private View rectangle_3_ek1;
    private TextView enter_your_email_login;
    private TextView enter_password_login;
    private View rectangle_1_ek3;
    private TextView sign_in_ek3;
    private Button Sign_in;
    private TextView not_registered_sign_up;
    private TextView forgottext;
    FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        not_registered_sign_up = findViewById(R.id.not_registered_sign_up);
        mAuth = FirebaseAuth.getInstance();
        enter_your_email_login = findViewById(R.id.enter_your_email_login);
        enter_password_login = findViewById(R.id.enter_password_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        forgottext = (TextView) findViewById(R.id.forgot_password);


        forgottext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(sign_in_activity.this,Forgotpassword.class));
            }
        });


        Sign_in = findViewById(R.id.Sign_in);
        Sign_in.setOnClickListener(view -> {
            loginUser();
                });
        not_registered_sign_up.setOnClickListener(view -> {
            startActivity(new Intent(sign_in_activity.this,registration_activity.class));
        });
//        not_registered_sign_up.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {openRegistrationActivity();}
//        });
    }
private void loginUser(){
    String email=enter_your_email_login.getText().toString();
    String password = enter_password_login.getText().toString();

    if(TextUtils.isEmpty(email)){
        enter_your_email_login.setError("email required");
        enter_your_email_login.requestFocus();
    }else if (TextUtils.isEmpty(password)){
        enter_password_login.setError("password required");
        enter_password_login.requestFocus();
    }else {
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(sign_in_activity.this, "success✔", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(sign_in_activity.this, dashboard_activity.class));
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    Toast.makeText(sign_in_activity.this, "Error❌:"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
}



	