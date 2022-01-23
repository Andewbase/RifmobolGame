package z.nova.rifmobolgame.Model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import z.nova.rifmobolgame.R;

public class LevelAdapter extends RecyclerView.Adapter<LevelAdapter.ViewHolder> {
    final private ListItemClickListener mOnClickListener;

    private final LayoutInflater inflater;
    private final List<TextLevel> textLevels;


    public LevelAdapter(Context context, List<TextLevel> textLevels, ListItemClickListener listener){
        this.textLevels = textLevels;
        this.inflater = LayoutInflater.from(context);
        mOnClickListener = listener;
    }


    @NonNull
    @Override
    public LevelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelAdapter.ViewHolder holder, int position) {
        TextLevel textLevel = textLevels.get(position);
        holder.nameView.setText(textLevel.getName());
    }

    @Override
    public int getItemCount() {
        return textLevels.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickItemIndex);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameView;

        public ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.textView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAbsoluteAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }
}
