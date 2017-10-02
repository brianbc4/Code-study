package com.example.user1.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = (Toolbar)findViewById(R.id.toolbar);
        onCreateMenu(toolBar);


    }

    public void onCreateMenu(Toolbar toolbar) {
        setSupportActionBar(toolbar);

//        toolbar.setLogo(R.drawable.bell);  //設定標題圖片
        setTitle("My Title");      //設定標題內容  #如果ToolBar內有內容則不顯示
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        if(id == R.id.action_refresh){
            Toast.makeText(MainActivity.this, "Refresh App", Toast.LENGTH_LONG).show();
        }
        if(id == R.id.action_add){
            Toast.makeText(MainActivity.this, "Create Text", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

}
