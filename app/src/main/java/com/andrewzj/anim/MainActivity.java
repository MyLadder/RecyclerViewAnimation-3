package com.andrewzj.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.andrewzj.recyclerviewanimation.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Integer> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initViews();

    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewAdapter = new RecyclerViewAdapter(this,data);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int index = ((LinearLayoutManager)layoutManager).findFirstVisibleItemPosition();
                int lastIndex = ((LinearLayoutManager)layoutManager).findLastVisibleItemPosition();
                Log.d("offset","index:"+index+"  lastIndex:"+lastIndex);
                for (int i = index; i <= lastIndex; i++){
                    RecyclerView.ViewHolder holder = recyclerView.findViewHolderForLayoutPosition(i);
                    Log.d("offset","viewHolder:"+holder.itemView.toString());
                    if (holder != null){
                        View view = holder.itemView;
                        if (view != null && view instanceof RecyclerItemView){
                            ((RecyclerItemView)view).updateImageTop();
                        }
                    }
                }
            }
        });

    }

    private void initData() {
        data = new ArrayList<>();
        data.add(R.drawable.pic1);
        data.add(R.drawable.pic2);
        data.add(R.drawable.pic3);
        data.add(R.drawable.pic4);
        data.add(R.drawable.pic5);
        data.add(R.drawable.pic6);
        data.add(R.drawable.pic7);
        data.add(R.drawable.pic8);
        data.add(R.drawable.pic9);
        data.add(R.drawable.pic1);
        data.add(R.drawable.pic2);
        data.add(R.drawable.pic3);
        data.add(R.drawable.pic4);
        data.add(R.drawable.pic5);
        data.add(R.drawable.pic6);
        data.add(R.drawable.pic8);
        data.add(R.drawable.pic9);
        data.add(R.drawable.pic1);
        data.add(R.drawable.pic2);
        data.add(R.drawable.pic3);
        data.add(R.drawable.pic4);
        data.add(R.drawable.pic5);
        data.add(R.drawable.pic6);
        data.add(R.drawable.pic1);
        data.add(R.drawable.pic2);
        data.add(R.drawable.pic3);
        data.add(R.drawable.pic4);
        data.add(R.drawable.pic5);
        data.add(R.drawable.pic6);
        data.add(R.drawable.pic1);
        data.add(R.drawable.pic2);
        data.add(R.drawable.pic3);
        data.add(R.drawable.pic4);
        data.add(R.drawable.pic5);
        data.add(R.drawable.pic6);

    }


}
