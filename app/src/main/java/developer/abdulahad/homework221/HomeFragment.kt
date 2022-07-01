package developer.abdulahad.homework221

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulahad.homework221.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.btnAdd.setOnClickListener {
            findNavController().navigate(R.id.addFragment)
        }
        binding.btnMovies.setOnClickListener {
            findNavController().navigate(R.id.moviesFragment)
        }

        return binding.root
    }
}

object codial{
    var position = 0
}