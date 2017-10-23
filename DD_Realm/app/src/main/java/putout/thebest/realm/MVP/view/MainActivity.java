package putout.thebest.realm.MVP.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import putout.thebest.realm.RESTfulAPI.NetWorkService;
import putout.thebest.realm.MVP.presenter.Presenter;
import putout.thebest.realm.MVP.view.recyclerview.adapters.RealmUserAdapter;
import putout.thebest.realm.R;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
//MVP
    Presenter presenter;


//UI
    RecyclerView recyclerView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        toolbar = (Toolbar) findViewById(R.id.toolbar);



        initialPresenter();
        initialToolBar(toolbar);
        initialRecyclerView(recyclerView);

    }

    private void initialRecyclerView(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new RealmUserAdapter(this,presenter.getResult(),true));
    }


    private void initialToolBar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);  //取消標題

        findViewById(R.id.search).setOnClickListener(view -> {

            NetWorkService.getInstance().getApiStore().checkDifficulty("umbilicus")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(difficulty -> Log.d("B_test",difficulty.getTen_degree() + "!!"));

        });


    }


    private void initialPresenter(){

        presenter = new Presenter(this);
        presenter.initialRealm();
        presenter.clearData();
        presenter.insertData();
    }




}
