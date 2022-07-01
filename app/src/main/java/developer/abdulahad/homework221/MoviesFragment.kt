package developer.abdulahad.homework221

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import developer.abdulahad.homework221.Models.MyDbHelper
import developer.abdulahad.homework221.Models.User
import developer.abdulahad.homework221.Utils.Constant
import developer.abdulahad.homework221.adapters.Action
import developer.abdulahad.homework221.adapters.RvAdapter
import developer.abdulahad.homework221.databinding.FragmentEditBinding
import developer.abdulahad.homework221.databinding.FragmentMoviesBinding
import developer.abdulahad.homework221.databinding.ItemMovieBinding

class MoviesFragment : Fragment() {
    lateinit var binding: FragmentMoviesBinding
    lateinit var myDbHelper: MyDbHelper
    lateinit var rvAdapter: RvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(binding.root.context)
        val list = myDbHelper.getUsers()
        rvAdapter = RvAdapter(list, object : Action {
            override fun delete(user: User) {
                val index = list.indexOf(user)
                myDbHelper.delete(user)
                list.removeAt(index)
                rvAdapter.notifyItemRemoved(index)
            }

            override fun edit(user: User) {
                val index = list.indexOf(user)
                Constant.position = index
                findNavController().navigate(R.id.editFragment)
            }

            override fun itemAction(position: Int) {
                Constant.position = position
                findNavController().navigate(R.id.showFragment)
            }
        })

        binding.myRv.adapter = rvAdapter

        return binding.root
    }
}