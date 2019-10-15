package admin.example.com.recyclerview;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    RecyclerAdapter adapter;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        list.add("第一项");
        list.add("第二项");
        list.add("第三项");
        list.add("第四项");
        list.add("第五项");
        list.add("第六项");
        adapter = new RecyclerAdapter(this,list);

        /**
         * recyclerview 的花样全部在这里，纵向横向，各式花样布局，都是从这里来的，
         * 下面就是简单的纵向列表，根据自己需要选择不同的layoutManager
         */
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);

        //配置adapter
        mRecyclerView.setAdapter(adapter);
        //如果列表数据有更新，传入新的list就可以了
        //adapter.update(list);


    }
}
