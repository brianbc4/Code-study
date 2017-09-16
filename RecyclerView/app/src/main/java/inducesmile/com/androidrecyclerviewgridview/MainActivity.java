package inducesmile.com.androidrecyclerviewgridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

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


        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }


    private List<ItemObject> getAllItemList(){

        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("United States", R.drawable.one));
        allItems.add(new ItemObject("Canada", R.drawable.two));
        allItems.add(new ItemObject("United Kingdom", R.drawable.three));
        allItems.add(new ItemObject("Germany", R.drawable.four));
        allItems.add(new ItemObject("Sweden", R.drawable.five));
        allItems.add(new ItemObject("United Kingdom", R.drawable.six));
        allItems.add(new ItemObject("Germany", R.drawable.seven));
        allItems.add(new ItemObject("Sweden", R.drawable.eight));
        allItems.add(new ItemObject("United States", R.drawable.one));
        allItems.add(new ItemObject("Canada", R.drawable.two));
        allItems.add(new ItemObject("United Kingdom", R.drawable.three));
        allItems.add(new ItemObject("Germany", R.drawable.four));
        allItems.add(new ItemObject("Sweden", R.drawable.five));
        allItems.add(new ItemObject("United Kingdom", R.drawable.six));
        allItems.add(new ItemObject("Germany", R.drawable.seven));
        allItems.add(new ItemObject("Sweden", R.drawable.eight));

        return allItems;
    }
}
