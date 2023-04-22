package edu.cofc.andriod.cofchealthapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import edu.cofc.andriod.cofchealthapp.databinding.FragmentSearchBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Search : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentSearchBinding
    lateinit var programmingLanguagesLV: ListView
    lateinit var listAdapter: ArrayAdapter<String>
    lateinit var programmingLanguagesList: ArrayList<String>;
    lateinit var searchView: SearchView
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
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        programmingLanguagesLV = binding.Resources
        searchView = binding.idR
        programmingLanguagesList = ArrayList()
        programmingLanguagesList.add("Student Health Services")
        programmingLanguagesList.add("Financial Aid Office")
        programmingLanguagesList.add("Student Affairs")
        programmingLanguagesList.add("Career Center")
        programmingLanguagesList.add("Mental Stability")
        programmingLanguagesList.add("Time Management")
        programmingLanguagesList.add("Managing Stress")
        programmingLanguagesList.add("Friendship Guide")

        listAdapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_list_item_1,
            programmingLanguagesList
        )

        programmingLanguagesLV.adapter = listAdapter

        programmingLanguagesLV.setOnItemClickListener { adapterView, view, position, id ->
            when (val selectedItem = adapterView.getItemAtPosition(position) as String) {
                "Student Health Services" -> {
                    (activity as? MainActivity)?.apply {
                        output = "(843) 953-5668"
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:$output")
                        startActivity(intent)
                    }
                }
                "Financial Aid Office" -> {
                    (activity as? MainActivity)?.apply {
                        output = "(843) 953-5540"
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:$output")
                        startActivity(intent)
                    }
                }
                "Student Affairs" -> {
                    (activity as? MainActivity)?.apply {
                        output = "(843) 953-5522"
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:$output")
                        startActivity(intent)
                    }
                }
                "Career Center" -> {
                    (activity as? MainActivity)?.apply {
                        output = "(843) 953-5692"
                        val intent = Intent(Intent.ACTION_DIAL)
                        intent.data = Uri.parse("tel:$output")
                        startActivity(intent)
                    }
                }
                "Mental Stability" -> {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://www.helpguide.org/articles/mental-health/building-better-mental-health.htm")
                    startActivity(openURL)
                }
                "Time Management" -> {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://hbr.org/2020/01/time-management-is-about-more-than-life-hacks")
                    startActivity(openURL)
                }
                "Managing Stress" -> {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://www.webmd.com/balance/stress-management/stress-management")
                    startActivity(openURL)
                }
                "Friendship Guide" -> {
                    val openURL = Intent(Intent.ACTION_VIEW)
                    openURL.data = Uri.parse("https://www.sonderwellness.com/blog/2022/08/22/healthy-friendships/")
                    startActivity(openURL)
                }

                else -> {
                    Toast.makeText(requireContext(), "Clicked $selectedItem", Toast.LENGTH_SHORT).show()
                }
            }
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (programmingLanguagesList.contains(query)) {

                    listAdapter.filter.filter(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listAdapter.filter.filter(newText)
                return false
            }

        })

    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Search().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}