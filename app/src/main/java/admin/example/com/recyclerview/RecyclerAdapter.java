package admin.example.com.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.List;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder> {
    Context context;
    List<String> list;

    public RecyclerAdapter(Context context,List<String> list){
        this.context = context;
        this.list = list;
    }

    //更新的方法
    public void update(List<String> list){
        this.list = list;
        notifyDataSetChanged();
    }


    /**
     * 这个方法用于创建viewholder的
     * 就是引入xml传送给viewholder的
     */
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_demo_item,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }


    //在这个方法里面写一些对item的操作
    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        String item = list.get(position);
        holder.textView.setText(item);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "你点击了" + list.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "你点击了第" + (position + 1) + "项", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //这个方法就是获取list的大小
    @Override
    public int getItemCount() {
        return list.size();
    }

    //用于初始化控件
    class MyHolder extends RecyclerView.ViewHolder {

        TextView textView;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
        }
    }
}
