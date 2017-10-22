package co.paulburke.android.itemtouchhelperdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.Arrays;

import co.paulburke.android.itemtouchhelperdemo.R;
import co.paulburke.android.itemtouchhelperdemo.adapter.RecyclerListAdapter;
import co.paulburke.android.itemtouchhelperdemo.helper.SimpleItemTouchHelperCallback;

public class RecyclerActivity extends AppCompatActivity {

    private ItemTouchHelper itemTouchHelper;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        RecyclerListAdapter adapter = new RecyclerListAdapter(this, Arrays.asList(getResources().getStringArray(R.array.activity_items)));

        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);

        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);    //將ItemTouchHelper 附著於 RecyclerView





    }
}
