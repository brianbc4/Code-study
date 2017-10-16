package inducesmile.com.androidrecyclerviewgridview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import inducesmile.com.androidrecyclerviewgridview.ItemObject;
import inducesmile.com.androidrecyclerviewgridview.R;
import inducesmile.com.androidrecyclerviewgridview.holder.CardHolder1;
import inducesmile.com.androidrecyclerviewgridview.holder.CardHolder2;
import inducesmile.com.androidrecyclerviewgridview.holder.NormalHolder;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final int NONE=0;
    final int TYPE_ONE=1;
    final int TYPE_TWO=2;
    private final Context context;

    private List<ItemObject> itemList;

    public RecyclerViewAdapter(Context context, List<ItemObject> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(itemList.get(position).getType()!=null) {
            switch (itemList.get(position).getType()) {
                case ItemObject.TYPE_ONE:
                    return TYPE_ONE;
                default:
                    return TYPE_TWO;
            }
        }
        return NONE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (viewType){
            case TYPE_ONE:
                return new CardHolder1(inflater.inflate(R.layout.holder_card_one, null));
            case TYPE_TWO:
                return new CardHolder2(inflater.inflate(R.layout.holder_card_two, null));
            default:
                return new NormalHolder(inflater.inflate(R.layout.holder_normal,null));
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof CardHolder1){
            ((CardHolder1)holder).countryName.setText(itemList.get(position).getName());
            ((CardHolder1)holder).countryPhoto.setImageResource(itemList.get(position).getPhoto());
            ((CardHolder1)holder).itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "Clicked Position = " + position, Toast.LENGTH_SHORT).show();
                }
            });
        }
        if(holder instanceof CardHolder2){
            ((CardHolder2) holder).badge.setText(position+"");
            ((CardHolder2)holder).countryName.setText(itemList.get(position).getName());
            ((CardHolder2)holder).countryPhoto.setImageResource(itemList.get(position).getPhoto());
        }
        if(holder instanceof NormalHolder) {
            ((NormalHolder) holder).countryPhoto.setImageResource(itemList.get(position).getPhoto());
            ((NormalHolder) holder).countryName.setText(itemList.get(position).getName());
        }

    }

}
