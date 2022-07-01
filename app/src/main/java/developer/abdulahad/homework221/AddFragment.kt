package developer.abdulahad.homework221

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import developer.abdulahad.homework221.Models.MyDbHelper
import developer.abdulahad.homework221.Models.User
import developer.abdulahad.homework221.Utils.Constant
import developer.abdulahad.homework221.databinding.FragmentAddBinding

class AddFragment : Fragment() {
    lateinit var binding: FragmentAddBinding
    lateinit var myDbHelper: MyDbHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddBinding.inflate(layoutInflater)

        myDbHelper = MyDbHelper(binding.root.context)
        val list = myDbHelper.getUsers()

        binding.btnSave.setOnClickListener {
            if (binding.edtName.text.isNotEmpty() && binding.edtAuthors.text.isNotEmpty() &&
                binding.edtAbout.text.isNotEmpty() && binding.edtDate.text.isNotEmpty()
            ) {
                val user = User(
                    binding.edtName.text.toString(),
                    binding.edtAuthors.text.toString(),
                    binding.edtAbout.text.toString(),
                    binding.edtDate.text.toString()
                )
                list.add(user)
                myDbHelper.addUser(user)
                Toast.makeText(context, "Save", Toast.LENGTH_SHORT).show()
                findNavController().popBackStack()
            } else {
                Toast.makeText(context, "IsEmpty", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }
}