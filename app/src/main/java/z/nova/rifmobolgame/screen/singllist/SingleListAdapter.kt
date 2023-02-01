package z.nova.rifmobolgame.screen.singllist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import z.nova.rifmobolgame.data.model.TextLevel
import z.nova.rifmobolgame.databinding.ListLevelItemBinding

class SingleListAdapter: ListAdapter<TextLevel, SingleListAdapter.SingleListViewHolder>(DiffUtilCallbackSingeList) {

    private var onItemClick: OnItemClick? = null

    fun setOnItemClick(onItemClick: OnItemClick){
        this.onItemClick = onItemClick
    }

    inner class SingleListViewHolder(private val binding: ListLevelItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(textLevel: TextLevel){
            with(binding){
                textView.text = textLevel.nameLvl.toString()
                binding.root.setOnClickListener { onItemClick?.onItemClick(textLevel) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListLevelItemBinding.inflate(inflater, parent, false)

        return SingleListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SingleListViewHolder, position: Int) {
        val textLevel = getItem(position)

        holder.bind(textLevel)
    }


    interface OnItemClick {
        fun onItemClick(textLevel: TextLevel)
    }

    companion object DiffUtilCallbackSingeList: DiffUtil.ItemCallback<TextLevel>(){

        override fun areItemsTheSame(oldItem: TextLevel, newItem: TextLevel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: TextLevel, newItem: TextLevel): Boolean {
            return oldItem == newItem
        }

    }

}