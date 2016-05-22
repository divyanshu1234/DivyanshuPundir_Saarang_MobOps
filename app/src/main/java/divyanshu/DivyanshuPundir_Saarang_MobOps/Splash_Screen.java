package divyanshu.DivyanshuPundir_Saarang_MobOps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

//This is the first class to run in the program. The MainActivity runs 2 seconds after the app starts
//Splash_Screen class is for the splash screen shown for 2 seconds before the list is presented
public class Splash_Screen extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);//Setting the screen on the Splash Screen that is the Saarang logo

        Thread welcomeThread = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    sleep(2000);  //Delay of 2 seconds
                } catch (Exception e) {

                } finally {

                    Intent intent = new Intent(Splash_Screen.this,
                            MainActivity.class);
                    startActivity(intent);//Changing the activity to the main screen that is the recyclerView
                    finish();
                }
            }
        };
        welcomeThread.start();
    }
}
