package edu.cofc.andriod.cofchealthapp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import edu.cofc.andriod.cofchealthapp.databinding.FragmentPostBinding
import edu.cofc.andriod.cofchealthapp.databinding.FragmentSearchBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Post.newInstance] factory method to
 * create an instance of this fragment.
 */
class Post : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentPostBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = Firebase.firestore
        var q1score = 0
        var q2score = 0
        var q3score = 0
        var q4score = 0
        var q5score = 0
        var q6score = 0
        binding.postButton.setOnClickListener() {
            // Question 1
            if (binding.q11.isChecked) { q1score = 1 }
            else if (binding.q12.isChecked) { q1score = 2 }
            else if (binding.q13.isChecked) { q1score = 3 }
            else if (binding.q14.isChecked) { q1score = 4 }
            // Question 2
            if (binding.q21.isChecked) { q2score = 1 }
            else if (binding.q22.isChecked) { q2score = 2 }
            else if (binding.q23.isChecked) { q2score = 3 }
            else if (binding.q24.isChecked) { q2score = 4 }
            // Question 3
            if (binding.q31.isChecked) { q3score = 1 }
            else if (binding.q32.isChecked) { q3score = 2 }
            else if (binding.q33.isChecked) { q3score = 3 }
            else if (binding.q34.isChecked) { q3score = 4 }
            // Question 4
            if (binding.q41.isChecked) { q4score = 1 }
            else if (binding.q42.isChecked) { q4score = 2 }
            else if (binding.q43.isChecked) { q4score = 3 }
            else if (binding.q44.isChecked) { q4score = 4 }
            // Question 5
            if (binding.q51.isChecked) { q5score = 1 }
            else if (binding.q52.isChecked) { q5score = 2 }
            else if (binding.q53.isChecked) { q5score = 3 }
            else if (binding.q54.isChecked) { q5score = 4 }
            // Question 6
            if (binding.q61.isChecked) { q6score = 1 }
            else if (binding.q62.isChecked) { q6score = 2 }
            else if (binding.q63.isChecked) { q6score = 3 }
            else if (binding.q64.isChecked) { q6score = 4 }

            val total = ((q1score.toFloat() + q2score.toFloat() + q3score.toFloat() + q4score.toFloat() + q5score.toFloat() + q6score.toFloat()) / 6).toFloat()
            val user = hashMapOf(
                "first" to "Alan",
                "middle" to "Mathison",
                "last" to "Turing",
                "born" to 1912
            )

            // Add a new document with a generated ID
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
            val formatTotal = String.format("%.1f", total)
            val message = "Daily Score: $formatTotal/4.0" // Create a message to show in the Toast
            val duration = Toast.LENGTH_LONG// Set the duration of the Toast
            Toast.makeText(requireContext(), message, duration).show()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PostFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Post().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}