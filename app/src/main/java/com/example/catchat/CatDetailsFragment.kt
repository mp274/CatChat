package com.example.catchat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class CatDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cat_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val nameView: TextView = view.findViewById(R.id.details_name)
        val statusView: TextView = view.findViewById(R.id.details_status)
        val aboutView: TextView = view.findViewById(R.id.details_about)

        val args = arguments
        if (args != null) {
            nameView.text = args.getString(ARG_NAME)
            statusView.text = args.getString(ARG_STATUS)
            aboutView.text = args.getString(ARG_ABOUT)
        } else {
            nameView.text = ""
            statusView.text = ""
            aboutView.text = ""
        }

        val writeButton: Button = view.findViewById(R.id.details_write)
        writeButton.setOnClickListener {
            findNavController().navigate(R.id.action_catDetailsFragment_to_sentItemsFragment)
        }
    }

    companion object {
        const val ARG_NAME = "cat_name"
        const val ARG_STATUS = "cat_status"
        const val ARG_ABOUT = "cat_about"
    }
}
