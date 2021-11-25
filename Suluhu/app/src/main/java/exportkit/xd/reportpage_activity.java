
	 
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

public class reportpage_activity extends Activity {


	private View _bg__reportpage_ek2;
	private ImageView vector_ek34;
	private ImageView vector_ek35;
	private ImageView vector_ek36;
	private TextView _10_50_ek4;
	private TextView welcome__ek3;
	private View ellipse_1_ek4;
	private View ellipse_2_ek4;
	private View emergency_ek2;
	private View rectangle_2_ek2;
	private View rectangle_3_ek2;
	private Button take_a_pic;
	private TextView add_media_evidence;
	private View rectangle_1_ek4;
	private TextView send;
	private TextView briefly_explain_the_emergency;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.reportpage);
		take_a_pic = (Button) findViewById(R.id.take_a_pic);
		send = (TextView) findViewById(R.id.send);

		//Take a pic button to open camera activity
		take_a_pic.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				openCameraActivity();
			}
		});

	}

	// take a pic button intent
	private void openCameraActivity() {
		Intent intent = new Intent(this, Camera.class);
		startActivity(intent);
	}
}
	
	