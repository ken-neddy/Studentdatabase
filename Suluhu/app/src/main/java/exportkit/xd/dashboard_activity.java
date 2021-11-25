
	 
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

public class dashboard_activity extends Activity {

	
	private View _bg__dashboard_ek2;
	private ImageView vector_ek31;
	private ImageView vector_ek32;
	private ImageView vector_ek33;
	private TextView _10_50_ek3;
	private TextView welcome__ek2;
	private View ellipse_1_ek3;
	private View ellipse_2_ek3;
	private View emergency;
	private View emergency_ek1;
	private Button what_s_your_emergency_;
	private TextView generate_automatic_report;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.dashboard);
		what_s_your_emergency_ = findViewById(R.id.whats_your_emergency);

		what_s_your_emergency_.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				openReportpageaccount();
			}
		});

	
	}
	private void openReportpageaccount() {
		Intent intent = new Intent(this, Reportpageaccount.class);
		startActivity(intent);
	}
}
	
	