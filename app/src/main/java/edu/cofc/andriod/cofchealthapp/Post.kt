package edu.cofc.andriod.cofchealthapp

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.text.SimpleDateFormat
import java.util.Date
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import edu.cofc.andriod.cofchealthapp.databinding.FragmentPostBinding



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

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
        binding = FragmentPostBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SimpleDateFormat")
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
            val dateFormat = SimpleDateFormat("MM/dd/yyyy") // specify the date format you want
            val currentDate = Date() // get the current date
            val dateString = dateFormat.format(currentDate)
            val timeFormat = SimpleDateFormat("HH:mm:ss") // specify the time format you want
            val currentTime = Date() // get the current time
            val timeString = timeFormat.format(currentTime)
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
            // Calculate total
            val total = ((q1score.toFloat() + q2score.toFloat() + q3score.toFloat() + q4score.toFloat() + q5score.toFloat() + q6score.toFloat()) / 6)
            val formatTotal = String.format("%.1f", total)
            val message = "Daily Score: $formatTotal/4.0" // Create a message to show in the Toast
            val duration = Toast.LENGTH_LONG// Set the duration of the Toast
            Toast.makeText(requireContext(), message, duration).show()
            // Send to Database
            val user = hashMapOf(
                "score" to formatTotal,
                "date" to dateString,
                "time" to timeString
            )
            // Add a new document with a generated ID
            db.collection("usersScore")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }
    companion object {
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