package divyanshu.DivyanshuPundir_Saarang_MobOps;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Calendar;
import static divyanshu.DivyanshuPundir_Saarang_MobOps.MyAdapter.pos;//pos with the position of the list element imported

public class Details_Activity extends Activity implements View.OnClickListener {

    public static int[] imageID= {
            R.drawable.img0,
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4};//This imageID stores the higher resolution photos of the list elements

    //Setting the date, begin time and end time of the respective events for the 'add to calendar' function
    public static int[] date={6, 6, 7, 7, 8};
    public static int[] begin_time={16,13,13,18,14};
    public static int[] end_time={19,17,16,23,17};

    /*2D String to store the event data required
    {Event info,
            Time and Date,
            Venue,
            Prize Money,
            Contact Name and Phone Number,
            Contact e-mail ID,
            Latitude of the Venue,
            Longitude of the Venue,
            Event Name}
    */
    public static String[][] data =
            {
                    {"Woo the crowd with the magic of pure vocals at our very own Acappella singing event. Who needs instruments when you've got the power of your mellifluous vocals? Harmonize, sing out loud, clap and snap. Saarang's Acappella singing event is for all those college Acappella groups who have been awaiting their chance to show off their skills. Saarang's Acappella has seen kickass groups from around the country battle it out on the stage with their voices. Don't miss your turn!",
                            "Time and Date:\n4:00 PM, 6th January, 2017",
                            "Venue:\nStudent Activity Center",
                            "Prize Money:\nRs 5,000",
                            "Contact:\nSrikanth Musti: +91 9790 46 4090",
                            "srikanth_musti@gmail.com",
                            "12.989281",
                            "80.237782",
                            "Acapella"},
                    {"Think it’s time for your band to be launched into the limelight? Think you have what it takes to compete against some of the best bands in the country? Then waste no time and sign your band up for Saarang Decibels 2016, one of India’s premier competitions for semi-professional bands to make your claim to fame.",
                            "Time and Date:\n1:00 PM, 6th January, 2017",
                            "Venue:\nIn front of Student Activity Center",
                            "Prize Money:\nRs 5,000",
                            "Contact:\nArjun Kumar: +91 7601 99 9798",
                            "arjun_kumar@gmail.com",
                            "12.989001",
                            "80.2371743",
                            "Decibles"},
                    {"Want to vent out those contained emotions? Want to voice out your opinions against the social order? Saarang gives you an enormous floating crowd while you display magnitudes of energy in order to make a change. Start a wave. Come do a street play at Saarang.",
                            "Time and Date:\n1:00 PM, 7th January, 2017",
                            "Venue:\nHimalaya Gardens",
                            "Prize Money:\nRs 5,000",
                            "Atul Shreyas: +91 7893 66 7584",
                            "atul_shreyas@gmail.com",
                            "12.986772",
                            "80.235958",
                            "Street Play"},
                    {"Dance is the hidden language of the soul. Watch as every team lets their story unfold on stage to the beats. The biggest cultural fest of south India brings to you the ultimate war of dance on the very first day itself. Every team puts in all for the title as they perform on stage. So join the night, feel the waves of energy and ecstasy as dance comes alive like never before, at Saarang Choreo Nite.",
                            "Time and Date:\n6:00 PM, 7th January, 2017",
                            "Venue:\nOpen Air Theatre",
                            "Prize Money:\nRs 20,000",
                            "Contact:\nTilak Naik: +91 9176 76 2683",
                            "tilak_naik@gmail.com",
                            "12.989111",
                            "80.233656",
                            "Choreo Nite"},
                    {"So, you think you can go it alone onstage, be that one person army ( don't want to sound sexist there) and bring the roof down with your vocal prowess? Looking for a spotlight that would shine on you and only you? Stop right there because now you knowwhere you ought to be. Introducing our one and only light music solo singing competition, Alankar, where you can battle it out with over a hundred vocalists while being judged by the best singing talents out there. And then there is always the cash prize and other awesome goodies to look forward to...",
                            "Time and Date:\n2:00 PM, 8th January, 2017",
                            "Venue:\nStudent Activity Center",
                            "Prize Money:\nRs 4000",
                            "Contact:\nKarun Kumar: +91 8939 23 3166",
                            "karun_kumar@gmail.com",
                            "12.989281",
                            "80.237782",
                            "Alankar"}
            };

    //Empty constructor
    public Details_Activity(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);//Setting the view on the details screen

        Toolbar details_toolbar=(Toolbar)findViewById(R.id.details_toolbar);
        details_toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));//Setting text colour to white
        details_toolbar.setNavigationIcon(R.drawable.ic_action_back);//Setting back button
        details_toolbar.setTitle("Event Details: "+data[pos][8]);//Setting the title

        //Setting up click listener for back button
        details_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//Activity is finished when back button is clicked
            }
        });

        //Setting the data for the elements of the page
        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(imageID[pos]);

        TextView txt0=(TextView)findViewById(R.id.txt0);
        txt0.setText(data[pos][0]);

        TextView txt1=(TextView)findViewById(R.id.txt1);
        txt1.setText(data[pos][1]);

        TextView txt2=(TextView)findViewById(R.id.txt2);
        txt2.setText(data[pos][2]);

        TextView txt3=(TextView)findViewById(R.id.txt3);
        txt3.setText(data[pos][3]);

        TextView txt4=(TextView)findViewById(R.id.txt4);
        txt4.setText(data[pos][4]);

        TextView txt5=(TextView)findViewById(R.id.txt5);
        txt5.setText(data[pos][5]);

        //Adding the 'call' functionality using Intent class
        ImageButton btn_call = (ImageButton) findViewById(R.id.call);
        btn_call.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + data[pos][4].substring(data[pos][4].indexOf('+'))));//Setting the parameters, i.e, respective phone numbers
                v1.getContext().startActivity(intent);
            }
        });



        //Adding the 'mail' functionality using the Intent calss
        ImageButton btn_mail = (ImageButton) findViewById(R.id.mail);
        btn_mail.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v1) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{data[pos][5]});//Setting the parameters, i.e., respective e-mail IDs
                intent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");//Setting the mailing app to Gmail
                intent.setType("text/plain");
                v1.getContext().startActivity(intent);
            }
        });


        //Adding the 'show on maps' functionality using Intent class
        ImageButton map = (ImageButton) findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v1) {
                //Providing the latitudes and longitudes of the respective venues
                String label = data[pos][2].substring(data[pos][2].indexOf('\n')+1);
                String uriBegin = "geo:"+data[pos][6]+","+data[pos][7];
                String query = data[pos][6]+","+data[pos][7]+"(" + label + ")";
                String encodedQuery = Uri.encode( query  );
                String uriString = uriBegin + "?q=" + encodedQuery;
                Uri uri = Uri.parse( uriString );
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                v1.getContext().startActivity(intent);
            }
        });

        //Adding the 'add to calendar' functionality using Intent class
        Button calendar=(Button)findViewById(R.id.calendar);
        calendar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                //Setting the begin time and end time of the respective events
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2017, 0, date[pos], begin_time[pos], 00);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2017, 0, date[pos], end_time[pos], 00);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, data[pos][8])
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, data[pos][2].substring(data[pos][2].indexOf('\n')+1));
                startActivity(intent);
            }
        });


        //Checking if register button is pressed
        Button reg=(Button)findViewById(R.id.reg);
        reg.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                //Changing the activity
                Intent nextScreen;
                nextScreen = new Intent(v1.getContext(), Register_Activity.class);
                v1.getContext().startActivity(nextScreen);
            }
        });

    }

    @Override
    public void onClick(View v) {

    }
}
