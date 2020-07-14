package com.example.dmsassignment.view.Fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import kotlinx.android.synthetic.main.fragment_first_register.view.*
import splitties.toast.toast


class FirstRegisterFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        checkId()

        val view =inflater.inflate(R.layout.fragment_first_register, container, false)
        view.confirm_button.setOnClickListener {
            if(view.input_id_editText.text==null)
                toast("GitHUB ID를 입력하세요")
            else
                showSubmitDialog(view.input_id_editText.text.toString())

        }
        return view
    }
    fun checkId(){
        if(UtilClass.getId(requireActivity().applicationContext)!="default"){
            Log.d("dasf","asdfasd")
            val transaction =requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_layout,UserFragment())
            transaction.commit()
        }

    }
    fun showSubmitDialog(userId: String) {

        val dialog =
            SubmitDialogFragment(userId)
        dialog.show(requireActivity().supportFragmentManager, "SubmitDialogFragment")

    }



}