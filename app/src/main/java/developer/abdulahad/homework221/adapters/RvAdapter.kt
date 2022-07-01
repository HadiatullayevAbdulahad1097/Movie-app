package developer.abdulahad.homework221.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import developer.abdulahad.homework221.Models.User
import developer.abdulahad.homework221.databinding.ItemMovieBinding

class RvAdapter(var list: ArrayList<User>, var item: Action) : RecyclerView.Adapter<RvAdapter.Vh>() {
    inner class Vh(var itemMovie: ItemMovieBinding) : RecyclerView.ViewHolder(itemMovie.root){
        fun onBind(user : User, position: Int) {
            itemMovie.txtNameMovie.text = user.name
            itemMovie.txtAuthorsMovie.text = user.authors
            itemMovie.txtDate.text = user.date
            itemMovie.itemDelete.setOnClickListener{
                item.delete(user)
            }
            itemMovie.itemEdit.setOnClickListener {
                item.edit(user)
            }
            itemMovie.item.setOnClickListener{
                item.itemAction(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemMovieBinding.inflate(LayoutInflater.from(parent.context),null,false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size
}

interface Action{
    fun delete(user: User)
    fun edit(user: User)
    fun itemAction(position: Int)
}