package developer.abdulahad.homework221

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import developer.abdulahad.homework221.Models.MyDbHelper
import developer.abdulahad.homework221.Utils.Constant
import developer.abdulahad.homework221.databinding.FragmentShowBinding

class ShowFragment : Fragment() {
   lateinit var binding: FragmentShowBinding
   lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentShowBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)

        var list = myDbHelper.getUsers()

        binding.tvName.text = list[Constant.position].name
        binding.tvAuthors.text = list[Constant.position].authors
        binding.tvAbout.text = list[Constant.position].about
        binding.tvDate.text = list[Constant.position].date

        binding.cancelButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }
}