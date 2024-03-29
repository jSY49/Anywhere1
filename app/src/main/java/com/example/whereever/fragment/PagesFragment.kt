package com.example.whereever.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.whereever.R
import com.example.whereever.listOfareatrip
import com.example.whereever.wheatherIsClean

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PagesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PagesFragment : Fragment() {
    // TODO: Rename and change types of parameters
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
        val view = inflater.inflate(com.example.whereever.R.layout.fragment_pages, container, false)
        val homegowhtrButton = view.findViewById<Button>(com.example.whereever.R.id.homegowhtr)
        val homegomrButton = view.findViewById<Button>(com.example.whereever.R.id.homegoMore)


        homegowhtrButton?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {

                val intent = Intent(getActivity(), wheatherIsClean::class.java)
                startActivity(intent)

            }
        })

        homegomrButton?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {

                val intent = Intent(getActivity(), listOfareatrip::class.java)
                startActivity(intent)

            }
        })



        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PagesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PagesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}