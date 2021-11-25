
	 
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

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class splash_screen_activity extends Activity {


	private View _bg__splash_screen_ek2;
	private View ellipse_1;
	private View ellipse_2;
	private ImageView vector;
	private ImageView vector_ek1;
	private ImageView vector_ek2;
	private TextView _10_50;
	private ImageView vector_ek3;
	private ImageView vector_ek4;
	private ImageView vector_ek5;
	private ImageView vector_ek6;
	private ImageView vector_ek7;
	private ImageView vector_ek8;
	private ImageView vector_ek9;
	private ImageView vector_ek10;
	private ImageView vector_ek11;
	private ImageView vector_ek12;
	private ImageView vector_ek13;
	private ImageView vector_ek14;
	private ImageView vector_ek15;
	private ImageView vector_ek16;
	private ImageView vector_ek17;
	private ImageView vector_ek18;
	private ImageView vector_ek19;
	private ImageView vector_ek20;
	private ImageView vector_ek21;
	private ImageView vector_ek22;
	private ImageView vector_ek23;
	private ImageView vector_ek24;
	private TextView suluhu;
	private TextView security_right_with_you;
	private View rectangle_1;
	private View rectangle_1_ek1;
	private Button sign_in;
	private Button report_emergency;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_screen);


		vector_ek3 = (ImageView) findViewById(R.id.vector_ek3);
		vector_ek4 = (ImageView) findViewById(R.id.vector_ek4);
		vector_ek5 = (ImageView) findViewById(R.id.vector_ek5);
		vector_ek6 = (ImageView) findViewById(R.id.vector_ek6);
		vector_ek7 = (ImageView) findViewById(R.id.vector_ek7);
		vector_ek8 = (ImageView) findViewById(R.id.vector_ek8);
		vector_ek9 = (ImageView) findViewById(R.id.vector_ek9);
		vector_ek10 = (ImageView) findViewById(R.id.vector_ek10);
		vector_ek11 = (ImageView) findViewById(R.id.vector_ek11);
		vector_ek12 = (ImageView) findViewById(R.id.vector_ek12);
		vector_ek13 = (ImageView) findViewById(R.id.vector_ek13);
		vector_ek14 = (ImageView) findViewById(R.id.vector_ek14);
		vector_ek15 = (ImageView) findViewById(R.id.vector_ek15);
		vector_ek16 = (ImageView) findViewById(R.id.vector_ek16);
		vector_ek17 = (ImageView) findViewById(R.id.vector_ek17);
		vector_ek18 = (ImageView) findViewById(R.id.vector_ek18);
		vector_ek19 = (ImageView) findViewById(R.id.vector_ek19);
		vector_ek20 = (ImageView) findViewById(R.id.vector_ek20);
		vector_ek21 = (ImageView) findViewById(R.id.vector_ek21);
		vector_ek22 = (ImageView) findViewById(R.id.vector_ek22);
		vector_ek23 = (ImageView) findViewById(R.id.vector_ek23);
		vector_ek24 = (ImageView) findViewById(R.id.vector_ek24);
		suluhu = (TextView) findViewById(R.id.suluhu);
		security_right_with_you = (TextView) findViewById(R.id.security_right_with_you);
		report_emergency = (Button) findViewById(R.id.report_emergency);
		sign_in = (Button) findViewById(R.id.Sign_in);

		//initializing views
		sign_in = findViewById(R.id.Sign_in);
		report_emergency = findViewById(R.id.report_emergency);


		//Implementation of Sign up button to open sign up activity
		sign_in.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openSignInActivity();
			}
		});
		report_emergency.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				openReportEmergencyInActivity();
			}
		});

	}

	private void openSignInActivity() {
		Intent intent = new Intent(this, sign_in_activity.class);
		startActivity(intent);
	}

	private void openReportEmergencyInActivity() {
		Intent intent = new Intent(this, reportpage_activity.class);
		startActivity(intent);
	}
}



	
	