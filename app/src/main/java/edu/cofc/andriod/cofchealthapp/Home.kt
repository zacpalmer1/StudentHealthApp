package edu.cofc.andriod.cofchealthapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import edu.cofc.andriod.cofchealthapp.databinding.FragmentHomeBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding
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
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.studentServices.setOnClickListener {
            (activity as? MainActivity)?.apply {
                output = "(843) 953-5668"
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$output")
                startActivity(intent)
            }
        }
        binding.financialAid.setOnClickListener {
            (activity as? MainActivity)?.apply {
                output = "(843) 953-5540"
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$output")
                startActivity(intent)
            }
        }
        binding.studentAffairs.setOnClickListener {
            (activity as? MainActivity)?.apply {
                output = "(843) 953-5522"
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$output")
                startActivity(intent)
            }
        }
        binding.careerCenter.setOnClickListener {
            (activity as? MainActivity)?.apply {
                output = "(843) 953-5692"
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:$output")
                startActivity(intent)
            }
        }
        }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
