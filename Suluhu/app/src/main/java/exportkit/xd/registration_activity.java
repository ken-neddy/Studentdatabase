
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		suluhu
	 *	@date 		1635510692890
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package exportkit.xd;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class registration_activity extends AppCompatActivity {

		private Button already_registered__sign_in;
		private EditText enter_your_email_reg;
		private EditText enter_password_reg;
		private TextView confirm_password;
		private Button sign_up;
		private EditText nameEditText;
		private Button Already_registered__sign_in;
		private FirebaseAuth mAuth;
		private ProgressBar progressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		sign_up = (Button) findViewById(R.id.sign_up);
		already_registered__sign_in = (Button) findViewById(R.id.already_registered__sign_in);
		enter_your_email_reg = (EditText) findViewById(R.id.enter_your_email_reg);
		enter_password_reg = (EditText) findViewById(R.id.enter_password_reg);
		mAuth = FirebaseAuth.getInstance();
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		sign_up.setOnClickListener (view -> {
			createUser();
		});

		already_registered__sign_in.setOnClickListener(view -> {
			startActivity(new Intent(registration_activity.this, sign_in_activity.class));
		});
//		already_registered__sign_in.setOnClickListener(new View.OnClickListener() {

//	@Override
//	public void onClick(View v) {openSignUpActivity();}
//});

	}
//	private void openSignUpActivity(){
//		Intent intent = new Intent(this, registration_activity.class);
//		startActivity(intent);
//	}

//		private void create() {
//			String email = enter_your_email.getText().toString().trim();
//			String password = enter_password_ek1.getText().toString().trim();
//
//			if ((email.isEmpty())) {
//				enter_your_email.setError("Email is required");
//				enter_your_email.requestFocus();
//				return;
//			}
//			if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//				enter_your_email.setError("Invalid email");
//				enter_your_email.requestFocus();
//				return;
//			}
//			if (password.isEmpty()) {
//				enter_password_ek1.setError("Password is required");
//				enter_password_ek1.requestFocus();
//				return;
//			}
//			if (password.length() < 6) {
//				enter_password_ek1.setError("Six characters required");
//				enter_password_ek1.requestFocus();
//			}
//
//			progressBar.setVisibility(View.GONE);
//			mAuth.createUserWithEmailAndPassword(email, password)
//			.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//				@Override
//				public void onComplete(@NonNull Task<AuthResult> task) {
//
//					if (task.isSuccessful()){
//						User user = new User(email);
//
//						FirebaseDatabase.getInstance().getReference("Users")
//								.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
//								.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
//							@Override
//							public void onComplete(@NonNull Task<Void> task) {
//								if (task.isSuccessful()){
//									Toast.makeText(registration_activity.this, "successful", Toast.LENGTH_SHORT).show();
//									progressBar.setVisibility(View.GONE);
//								}else {
//									Toast.makeText(registration_activity.this, "Failed", Toast.LENGTH_SHORT).show();
//									progressBar.setVisibility(View.GONE);
//								}
//							}
//						});
//					}
//				}
//			});
//		}
	private void createUser(){
		String email=enter_your_email_reg.getText().toString();
		String password = enter_password_reg.getText().toString();

		if(TextUtils.isEmpty(email)){
			enter_your_email_reg.setError("email required");
			enter_your_email_reg.requestFocus();
		}else if (TextUtils.isEmpty(password)){
			enter_password_reg.setError("password required");
			enter_password_reg.requestFocus();
		}else {
			mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
				@Override
				public void onComplete(@NonNull Task<AuthResult> task) {
					if (task.isSuccessful()){
						Toast.makeText(registration_activity.this, "Success✔", Toast.LENGTH_LONG).show();
						progressBar.setVisibility(View.VISIBLE);
						startActivity(new Intent(registration_activity.this,sign_in_activity.class));
					}else {
						Toast.makeText(registration_activity.this, "Error❌:"+ task.getException().getMessage(), Toast.LENGTH_LONG).show();
						progressBar.setVisibility(View.GONE);
					}
				}
			});
		}
	}
	}


