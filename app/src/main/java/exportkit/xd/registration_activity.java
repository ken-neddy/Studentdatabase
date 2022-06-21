
	 
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
import android.util.Patterns;
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
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class registration_activity extends AppCompatActivity {

		private TextView already_registered__sign_in;
		private EditText enter_your_email_reg;
		private EditText enter_password_reg;
		private TextView confirm_password;
		private EditText enter_your_username;
		private EditText enter_your_ID_number;
		private Button sign_up;
		private EditText nameEditText;
		private FirebaseAuth mAuth;
		private ProgressBar progressBar;
		private EditText enter_your_phone_number;

		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.registration);
		sign_up = (Button) findViewById(R.id.sign_up);
		already_registered__sign_in = findViewById(R.id.already_registered__sign_in);
		enter_your_username = (EditText) findViewById(R.id.enter_your_username);
		enter_your_ID_number= (EditText) findViewById(R.id.enter_your_ID_number);
		enter_your_email_reg = (EditText) findViewById(R.id.enter_your_email_reg);
		enter_password_reg = (EditText) findViewById(R.id.enter_password_reg);
		enter_your_phone_number = findViewById(R.id.enter_your_phone_number);
		mAuth = FirebaseAuth.getInstance();
		progressBar = (ProgressBar) findViewById(R.id.progressBar);
		sign_up.setOnClickListener (view -> {
			createUser();
		});

		already_registered__sign_in.setOnClickListener(view -> {
			startActivity(new Intent(registration_activity.this, sign_in_activity.class));
		});

	}

	private void createUser(){
		String email=enter_your_email_reg.getText().toString();
		String password = enter_password_reg.getText().toString();
		String username = enter_your_username.getText().toString();
		String userid = enter_your_ID_number.getText().toString();
		String phonenumber = enter_your_phone_number.getText().toString();

		if (username.isEmpty()){
			enter_your_username.setError("required");
			enter_your_username.requestFocus();
			return;
		}

		if (userid.isEmpty()){
			enter_your_ID_number.setError("required");
			enter_your_ID_number.requestFocus();
			return;
		}

		if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
			enter_your_email_reg.setError("provide a valid email");
			enter_your_email_reg.requestFocus();
			return;
		}

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
						String myId = FirebaseAuth.getInstance().getCurrentUser().getUid();
						User user = new User(email,username,userid,phonenumber,myId);

						FirebaseDatabase.getInstance().getReference("Users")
								.child(FirebaseAuth.getInstance().getCurrentUser().getUid())
								.setValue(user)
								.addOnCompleteListener(new OnCompleteListener<Void>() {
									@Override
									public void onComplete(@NonNull Task<Void> task) {
										if (task.isSuccessful()){
											Toast.makeText(registration_activity.this, "Thanks" +"-" + username , Toast.LENGTH_LONG).show();
											progressBar.setVisibility(View.GONE);

										}else {
											Toast.makeText(registration_activity.this, "Error!", Toast.LENGTH_LONG).show();
											progressBar.setVisibility(View.GONE);
										}
									}
								});

						startActivity(new Intent(registration_activity.this,sign_in_activity.class));
					}else {
						Toast.makeText(registration_activity.this, "Error❌" + "-" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
						progressBar.setVisibility(View.GONE);
					}
				}
			});
		}
	}
	}


