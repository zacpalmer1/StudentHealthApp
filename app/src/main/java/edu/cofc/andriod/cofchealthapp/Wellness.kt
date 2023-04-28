package edu.cofc.andriod.cofchealthapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.cofc.andriod.cofchealthapp.databinding.FragmentWellnessBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Wellness : Fragment() {

    private lateinit var binding: FragmentWellnessBinding
    private var param1: String? = null
    private var param2: String? = null


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
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWellnessBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.link1.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.helpguide.org/articles/mental-health/building-better-mental-health.htm")
            startActivity(openURL)
        }
        binding.link2.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://hbr.org/2020/01/time-management-is-about-more-than-life-hacks")
            startActivity(openURL)
        }
        binding.link3.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.webmd.com/balance/stress-management/stress-management")
            startActivity(openURL)
        }
        binding.link4.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.dosomething.org/us/articles/self-care-study-guide")
            startActivity(openURL)
        }
        binding.link5.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse("https://www.sonderwellness.com/blog/2022/08/22/healthy-friendships/")
            startActivity(openURL)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Wellness().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}