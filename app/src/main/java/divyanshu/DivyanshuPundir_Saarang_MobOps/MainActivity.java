package divyanshu.DivyanshuPundir_Saarang_MobOps;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

//Control now comes to the MainActivity from the Splash_Screen
public class MainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);/*Setting the screen on activity_main which contains
        the recyclerView the layout of which is defined in item_layout*/

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);//Creating a variable to access recyclerView in the MainActivity

        Toolbar my_toolbar=(Toolbar)findViewById(R.id.home_toolbar);//Setting up the Toolbar
        my_toolbar.setTitleTextColor(getResources().getColor(R.color.colorText));//Setting the text colour
        my_toolbar.setTitle("Events");//Setting the title

        ItemData itemsData[] = {
                new ItemData("Acappella"),
                new ItemData("Decibles"),
                new ItemData("Street Play"),
                new ItemData("Choreo Nite"),
                new ItemData("Alankar"),
        };//itemsData is used to send data from MainActivity to MyAdapter


        //Setting up the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter mAdapter = new MyAdapter(itemsData);//mAdapter object of MyAdapter is created and itemsData is provided to it
        recyclerView.setAdapter(mAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


}