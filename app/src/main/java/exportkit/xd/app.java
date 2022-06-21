package exportkit.xd;

import android.app.Application;

import com.parse.Parse;

public class app extends Application {


    //keys to access the parse server
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("0zx85nGowT8jvtOGXpEtsT7wCjWYhdFIYliKtNme")
                .clientKey("ljVq2EJgKVVXW3stmtdQmLjuslmSrWFb84OOYN7E")
                .server("https://parseapi.back4app.com/")
                .build());


    }
}