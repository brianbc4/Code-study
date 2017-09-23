package inducesmile.com.androidrecyclerviewgridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import inducesmile.com.androidrecyclerviewgridview.adapter.RecyclerViewAdapter;


public class MainActivity extends AppCompatActivity {

    private GridLayoutManager gridLayout;
    private LinearLayoutManager linearLayout;
    private StaggeredGridLayoutManager staggeredGridLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rView = (RecyclerView)findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);

        List<ItemObject> rowListItem = getAllItemList();

        gridLayout = new GridLayoutManager(MainActivity.this, 2);
        linearLayout =new LinearLayoutManager(this);
        staggeredGridLayout = new StaggeredGridLayoutManager(7,0);    //orientation => Horizontal:0 Vertical:1



        rView.setLayoutManager(gridLayout);
//        rView.setLayoutManager(linearLayout);
//        rView.setLayoutManager(staggeredGridLayout);


        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(this, rowListItem);
        rView.setAdapter(rcAdapter);
    }


    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("United States", R.drawable.one,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("Canada", R.drawable.two,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("United Kingdom", R.drawable.three,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("Germany", R.drawable.four,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("Sweden", R.drawable.five,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("United Kingdom", R.drawable.six,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("Germany", R.drawable.seven,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("Sweden", R.drawable.eight,ItemObject.TYPE_ONE));
        allItems.add(new ItemObject("United States", R.drawable.one,ItemObject.TYPE_TWO));
        allItems.add(new ItemObject("Canada", R.drawable.two,ItemObject.TYPE_TWO));
        allItems.add(new ItemObject("United Kingdom", R.drawable.three,ItemObject.TYPE_TWO));
        allItems.add(new ItemObject("Germany", R.drawable.four,ItemObject.TYPE_TWO));
        allItems.add(new ItemObject("Sweden", R.drawable.five,ItemObject.TYPE_TWO));
        allItems.add(new ItemObject("United Kingdom", R.drawable.six,ItemObject.TYPE_TWO));
        allItems.add(new ItemObject("Germany", R.drawable.seven,ItemObject.TYPE_TWO));
        allItems.add(new ItemObject("Sweden", R.drawable.eight,ItemObject.TYPE_TWO));

        return allItems;
    }
}
