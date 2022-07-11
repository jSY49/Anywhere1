package com.example.whereever.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.whereever.R
import com.example.whereever.listOfareatrip
import com.example.whereever.wheatherIsClean

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
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

        val view = inflater.inflate(com.example.whereever.R.layout.fragment_main, container, false)
        val homegomrTv = view.findViewById<TextView>(com.example.whereever.R.id.txt_HomeGomore)

        homegomrTv?.setOnClickListener(object :View.OnClickListener {
            override fun onClick(v: View?) {

                val intent = Intent(getActivity(), listOfareatrip::class.java)
                startActivity(intent)

            }
        })



        return view


    }
}