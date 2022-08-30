package com.example.a02180201041_finalproject

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [colorsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class colorsFragment : Fragment() {
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
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_colors, container, false)

        var textcolor = view.findViewById<Spinner>(R.id.textcolor)
        var backgroundcolor = view.findViewById<Spinner>(R.id.backgroundcolor)
        var fragmentcolor = view.findViewById<Spinner>(R.id.fragmentcolor)

        var colors = arrayOf(
            "Renk Seçiniz",
            "Beyaz",
            "Uzay Grisi",
            "Nane Yesili",
            "Yesil",
            "Alev Kirmizisi"
        )

        var adapter = ArrayAdapter(view.context, android.R.layout.simple_dropdown_item_1line, colors)

        textcolor.adapter = adapter
        backgroundcolor.adapter = adapter
        fragmentcolor.adapter = adapter

        var mainFragment = view.findViewById<FrameLayout>(R.id.mainFragment)
        var name_number_textview = view.findViewById<TextView>(R.id.name_number_textview)

        textcolor.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1) {
                    name_number_textview.setTextColor(Color.parseColor("#ffffff"))
                }
                if (position == 2) {
                    name_number_textview.setTextColor(Color.parseColor("#65737e"))
                }
                if (position == 3) {
                    name_number_textview.setTextColor(Color.parseColor("#98FF98"))
                }
                if (position == 4) {
                    name_number_textview.setTextColor(Color.parseColor("#00FF00"))
                }
                if (position == 5) {
                    name_number_textview.setTextColor(Color.parseColor("#FF4D00"))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        backgroundcolor.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1) {
                    name_number_textview.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                if (position == 2) {
                    name_number_textview.setBackgroundColor(Color.parseColor("#65737e"))
                }
                if (position == 3) {
                    name_number_textview.setBackgroundColor(Color.parseColor("#98FF98"))
                }
                if (position == 4) {
                    name_number_textview.setBackgroundColor(Color.parseColor("#00FF00"))
                }
                if (position == 5) {
                    name_number_textview.setBackgroundColor(Color.parseColor("#FF4D00"))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        fragmentcolor.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            @SuppressLint("ResourceAsColor")
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 1) {
                    mainFragment.setBackgroundColor(Color.parseColor("#ffffff"))
                }
                if (position == 2) {
                    mainFragment.setBackgroundColor(Color.parseColor("#65737e"))
                }
                if (position == 3) {
                    mainFragment.setBackgroundColor(Color.parseColor("#98FF98"))
                }
                if (position == 4) {
                    mainFragment.setBackgroundColor(Color.parseColor("#00FF00"))
                }
                if (position == 5) {
                    mainFragment.setBackgroundColor(Color.parseColor("#FF4D00"))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

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
         * @return A new instance of fragment colorsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            colorsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}