package divyanshu.DivyanshuPundir_Saarang_MobOps;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static divyanshu.DivyanshuPundir_Saarang_MobOps.MyAdapter.pos;//static import that contains the name of the current event
import static divyanshu.DivyanshuPundir_Saarang_MobOps.Details_Activity.data;//static import that stores the events data

//Register_Activity class for the details screen
public class Register_Activity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);//Changing the view to the register page

        Toolbar register_toolbar=(Toolbar)findViewById(R.id.register_toolbar);//Setting up the Toolbar
        register_toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));//Setting the text colour to white
        register_toolbar.setNavigationIcon(R.drawable.ic_action_back);//Setting up the back button
        register_toolbar.setTitle("Register: "+data[pos][8]);//Setting the title of the page

        //Setting up the click listener for back button
        register_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//Activity is ended when the back button is pressed
            }
        });

        //If cancel button is pressed then the activity is ended
        Button cancel =(Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                finish();
            }
        });


        //Checking if submit button is pressed
        Button submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v1){

                //Setting String to validate the first name entry
                EditText first_name_validate = (EditText)findViewById(R.id.first_name);
                String name = first_name_validate.getText().toString();

                //Setting String to validate the e-mail ID entry
                EditText emailValidate = (EditText)findViewById(R.id.email_id);
                String email = emailValidate.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";//String to check the e-mail pattern

                //Setting String to validate the phone number entry
                EditText phone_num_validate = (EditText)findViewById(R.id.phone_number);
                String phone_num = phone_num_validate.getText().toString();


                if (name.length()==0  || email.length()==0  ||  phone_num.length()==0)//Checking if any one of the compulsory fields is not filled
                    Toast.makeText(getApplicationContext(),"Fill the compulsory fields", Toast.LENGTH_SHORT).show();

                else if (!(email.matches(emailPattern)))//Checking the e-mail pattern
                    Toast.makeText(getApplicationContext(),"Incorrect Email Format", Toast.LENGTH_SHORT).show();

                else if(phone_num.length()!=10)//Checking the phone number length
                    Toast.makeText(getApplicationContext(),"Incorrect Phone Number", Toast.LENGTH_SHORT).show();


                else//If everything is as required then message is displayed showing "Registered for (Name of the Event)"
                {
                    Toast.makeText(getApplicationContext(), "Registered for "+data[pos][8], Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

    }


    @Override
    public void onClick(View v) {

    }
}
