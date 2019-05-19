package com.example.cardview_gridlayout2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String MOCK_URL = "http://lorempixel.com/800/400/nightlife";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.lsit);
        recyclerView.setHasFixedSize(true);
        final MyRecyclerAdapter adapter;

        recyclerView.setAdapter(adapter = new MyRecyclerAdapter(createMockList(),R.layout.item));

        StaggeredGridLayoutManager mLayoutManager;
        mLayoutManager = new StaggeredGridLayoutManager(2, 1);
        mLayoutManager.setGapStrategy(StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2,Util.convertDpToPx(this,8), true));

        recyclerVIew.setItemAnimator(new DefaultItemAnimator());

        adapter.setOnItemClickLister(new OnRecyclerViewItemClickListener<ViewModel>){
            adapter.remove(viewModel);
        }
    });
}

private List<ViewModel> createMockList() {
    List<ViewModel> items = new ArrayList<ViewModel>();
    for (int i = 0; i < 20; i++) {
        items.add(new ViewModel(i, "Item" + (i + 1), MOCK_URL + (i % 10 + 1)));
    }
    return items;
}
}


