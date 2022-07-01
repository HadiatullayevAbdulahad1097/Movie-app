package developer.abdulahad.homework221

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.animation.AnimationUtils
import developer.abdulahad.homework221.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {
   lateinit var binding: FragmentSplashBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(layoutInflater)

        var anim = android.view.animation.AnimationUtils.loadAnimation(container!!.context,R.anim.my_anim)
        binding.cardImage.startAnimation(anim)

        Handler().postDelayed({

            findNavController().popBackStack()
           findNavController().navigate(R.id.homeFragment)
        }, 2300)

        return binding.root
    }
}