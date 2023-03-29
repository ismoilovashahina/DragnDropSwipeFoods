package uz.it_teacher.cookpedia.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import uz.it_teacher.cookpedia.R
import uz.it_teacher.cookpedia.databinding.ItemCookpediaBinding
import uz.it_teacher.cookpedia.model.Cook
import uz.it_teacher.cookpedia.util.ItemTouchAdapter
import java.util.Collections

class CookAdapter(val context: Context, val list: MutableList<Cook>) :
    RecyclerView.Adapter<CookAdapter.CookHolder>(), ItemTouchAdapter {

    class CookHolder(itemView: ItemCookpediaBinding) : RecyclerView.ViewHolder(itemView.root) {
        val name = itemView.name
        val recipes = itemView.recipes
        val img = itemView.img

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CookHolder {
        return CookHolder(
            ItemCookpediaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CookHolder, position: Int) {
        val cook = list[position]
        holder.name.text = cook.name
        holder.recipes.text = cook.recipes
        holder.img.setImageResource(cook.img)

        val anim = AnimationUtils.loadAnimation(context, R.anim.item_amin)
        holder.itemView.startAnimation(anim)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if(fromPosition<toPosition){
            for (i in fromPosition until toPosition){
                Collections.swap(list,i , i+1)
            }
        }else{
            for (i in fromPosition downTo  toPosition+1){
                Collections.swap(list,i , i-1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
    }
}