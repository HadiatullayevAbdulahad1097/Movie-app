package developer.abdulahad.homework221

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import developer.abdulahad.homework221.Models.MyDbHelper
import developer.abdulahad.homework221.Models.User
import developer.abdulahad.homework221.Utils.Constant
import developer.abdulahad.homework221.databinding.FragmentEditBinding
import developer.abdulahad.homework221.databinding.FragmentMoviesBinding


@Suppress("CAST_NEVER_SUCCEEDS")
class EditFragment : Fragment() {
    lateinit var binding: FragmentEditBinding
    lateinit var myDbHelper: MyDbHelper
    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditBinding.inflate(layoutInflater)
        myDbHelper = MyDbHelper(binding.root.context)
        var list = myDbHelper.getUsers()
        binding.apply {

            edtName.setText(list[Constant.position].name)
            edtAuthors.setText(list[Constant.position].authors)
            edtAbout.setText(list[Constant.position].about)
            edtDate.setText(list[Constant.position].date)

            btnSave.setOnClickListener {
                val name = edtName.text.toString()
                val author = edtAuthors.text.toString()
                val about = edtAbout.text.toString()
                val date = edtDate.text.toString()
                if (name.isNotEmpty() && author.isNotEmpty() && about.isNotEmpty() && date.isNotEmpty()) {
                    val user = list[Constant.position]
                    user.name = name
                    user.authors = author
                    user.about = about
                    user.date = date
                    myDbHelper.upDateUser(user)
                    findNavController().popBackStack()
                } else {
                    Toast.makeText(root.context, "isEmpty", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
}