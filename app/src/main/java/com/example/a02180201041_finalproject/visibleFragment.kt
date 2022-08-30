package com.example.a02180201041_finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [visibleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class visibleFragment : Fragment() {
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
        var view = inflater.inflate(R.layout.fragment_visible, container, false)
        var btn1 = view.findViewById<Button>(R.id.btn1)
        var btn2 = view.findViewById<Button>(R.id.btn2)
        var tv1 = view.findViewById<TextView>(R.id.tv1)
        var tv2 = view.findViewById<TextView>(R.id.tv2)
        var rb1 = view.findViewById<RadioButton>(R.id.rb1)
        var rb2 = view.findViewById<RadioButton>(R.id.rb2)
        var cb1 = view.findViewById<CheckBox>(R.id.cb1)
        var cb2 = view.findViewById<CheckBox>(R.id.cb2)

        btn1.setOnClickListener {
            if(btn2.visibility == View.INVISIBLE){
                btn2.visibility = View.VISIBLE
            } else{
                btn2.visibility = View.INVISIBLE
            }
        }

        btn2.setOnClickListener {
            if(btn1.visibility == View.INVISIBLE){
                btn1.visibility = View.VISIBLE
            } else{
                btn1.visibility = View.INVISIBLE
            }
        }

        tv1.setOnClickListener{
            if(tv2.visibility == View.INVISIBLE){
                tv2.visibility = View.VISIBLE
            }else{
                tv2.visibility = View.INVISIBLE
            }
        }

        tv2.setOnClickListener{
            if(tv1.visibility == View.INVISIBLE){
                tv1.visibility = View.VISIBLE
            }else{
                tv1.visibility = View.INVISIBLE
            }
        }

        rb1.setOnClickListener{
            if(rb2.visibility == View.INVISIBLE){
                rb2.visibility = View.VISIBLE
            }else{
                rb2.visibility = View.INVISIBLE
            }
        }

        rb2.setOnClickListener{
            if(rb1.visibility == View.INVISIBLE){
                rb1.visibility = View.VISIBLE
            }else{
                rb1.visibility = View.INVISIBLE
            }
        }

        cb1.setOnClickListener{
            if(cb2.visibility == View.INVISIBLE){
                cb2.visibility = View.VISIBLE
            }else{
                cb2.visibility = View.INVISIBLE
            }
        }

        cb2.setOnClickListener{
            if(cb1.visibility == View.INVISIBLE){
                cb1.visibility = View.VISIBLE
            }else{
                cb1.visibility = View.INVISIBLE
            }
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment visibleFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            visibleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}