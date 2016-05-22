package divyanshu.DivyanshuPundir_Saarang_MobOps;

        import android.content.Intent;
        import android.view.LayoutInflater;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

//This is the class for recyclerViewAdapter
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public static int[] imageID= {
            R.drawable.img00,
            R.drawable.img11,
            R.drawable.img22,
            R.drawable.img33,
            R.drawable.img44};
//imageID is to store the location of the images for the recyclerView elements


    private View itemLayoutView;
    private ItemData[] itemsData;
    public MyAdapter(ItemData[] itemsData) {
        this.itemsData = itemsData;
    }
    public static int pos;/*static global variable to store the position of current element which is
     later used in Detail_Activity class to get the required information from String data[][]*/


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, null);//item_layout used to inflate the data
        ViewHolder viewHolder = new ViewHolder(itemLayoutView);


        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        viewHolder.txtViewTitle.setText(itemsData[position].getTitle());//Title of the event set using txtViewTitle
        viewHolder.imgView.setImageResource(imageID[position]);//Image for the event set in the recyclerView element

        //Setting click listener for the elements of the list
        viewHolder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pos=position;/*pos now stores the index of the list element that is clicked, this
                will be used to get the details of the respective events in the Details_Activity class*/

                Intent nextScreen;
                nextScreen = new Intent(v.getContext(), Details_Activity.class);
                v.getContext().startActivity(nextScreen);//The activity is now changed and control goes to Details_Activity
            }
        });


    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtViewTitle;
        public final View mView;
        public ImageView imgView;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.events);//txtViewTitle points to the events TextView in item_layout
            imgView = (ImageView) itemLayoutView.findViewById(R.id.pic);//imgView points to he pic ImageView in item_layout
            mView = itemLayoutView;

        }
    }

//Counting the number of elements in the list
    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}