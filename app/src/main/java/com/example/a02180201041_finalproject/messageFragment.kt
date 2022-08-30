package com.example.a02180201041_finalproject

import android.os.Bundle
import android.view.Gravity
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
 * Use the [messageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class messageFragment : Fragment() {
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
        var view = inflater.inflate(R.layout.fragment_message, container, false)

        var rbtn1 = view.findViewById<RadioButton>( R.id.rbtn1)
        var rbtn2 = view.findViewById<RadioButton>( R.id.rbtn2)
        var rbtn3 = view.findViewById<RadioButton>( R.id.rbtn3)
        var rbtn4 = view.findViewById<RadioButton>( R.id.rbtn4)

        rbtn1.setOnClickListener{
            if(rbtn1.isChecked){
                rbtn2.isChecked = false;
                rbtn3.isChecked = false;
                rbtn4.isChecked = false;
            }
        }
        rbtn2.setOnClickListener{
            if(rbtn2.isChecked){
                rbtn1.isChecked = false;
                rbtn3.isChecked = false;
                rbtn4.isChecked = false;
            }
        }
        rbtn3.setOnClickListener{
            if(rbtn3.isChecked){
                rbtn2.isChecked = false;
                rbtn1.isChecked = false;
                rbtn4.isChecked = false;
            }
        }
        rbtn4.setOnClickListener{
            if(rbtn4.isChecked){
                rbtn2.isChecked = false;
                rbtn3.isChecked = false;
                rbtn1.isChecked = false;
            }
        }

        var createToastBtn = view.findViewById<Button>(R.id.createToastBtn)
        var name = view.findViewById<EditText>(R.id.nameToast)

        createToastBtn.setOnClickListener {
            var toastMessage = layoutInflater.inflate(R.layout.toast_message, null)
            var toast = Toast(view.context)
            toast.view = toastMessage
            var logo = toastMessage.findViewById<ImageView>(R.id.selectedLogo)
            var text = toastMessage.findViewById<TextView>(R.id.selectedMessage)

            if(rbtn1.isChecked){
                logo.setImageResource(R.drawable.bg1)
            } else if(rbtn2.isChecked){
                logo.setImageResource(R.drawable.bg3)
            }else if(rbtn3.isChecked){
                logo.setImageResource(R.drawable.bg2)
            }else {
                logo.setImageResource(R.drawable.bg4)
            }
            text.text = name.text.toString() + " tarafından oluşturulmuş Toeast mesajı"
            toast.duration = Toast.LENGTH_SHORT
            toast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.CENTER_VERTICAL, 0 , 0)
            toast.show()
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
         * @return A new instance of fragment messageFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            messageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}