package z.nova.rifmobolgame.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import z.nova.rifmobolgame.R

internal class LevelAdapter(
    context: Context?,
    private val textLevels: List<TextLevel>,
    listener: ListItemClickListener
) : RecyclerView.Adapter<LevelAdapter.ViewHolder>() {
    private val mOnClickListener: ListItemClickListener
    private val inflater: LayoutInflater
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textLevel = textLevels[position]
        holder.nameView.text = textLevel.name
    }

    override fun getItemCount(): Int {
        return textLevels.size
    }

    interface ListItemClickListener {
        fun onListItemClick(clickItemIndex: Int)
    }

    internal inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        var nameView: TextView
        override fun onClick(v: View) {
            val clickedPosition = absoluteAdapterPosition
            mOnClickListener.onListItemClick(clickedPosition)
        }

        init {
            nameView = view.findViewById(R.id.textView)
            view.setOnClickListener(this)
        }
    }

    init {
        inflater = LayoutInflater.from(context)
        mOnClickListener = listener
    }
}