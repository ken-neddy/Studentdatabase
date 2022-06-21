package exportkit.xd;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import androidx.appcompat.app.AppCompatActivity;

public class Databasetrial extends AppCompatActivity {

    private Button buttondatabasetrial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databasetrial);
        buttondatabasetrial = findViewById(R.id.buttondatabasetrial);

        buttondatabasetrial.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ParseObject Senddata = new ParseObject(
                                "Senddata"
                        );
                        Senddata.put(
                                "names" , "Neddy"
                        );
                        Senddata.put(
                                "Age" , "24"
                        );
                        Senddata.saveInBackground(new SaveCallback() {
                            @Override
                            public void done(ParseException e) {

                            }
                        });
                    }
                }
        );
    }
}