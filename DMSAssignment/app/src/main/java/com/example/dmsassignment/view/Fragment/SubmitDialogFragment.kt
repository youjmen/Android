package com.example.dmsassignment.view

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import kotlinx.android.synthetic.main.activity_main.*
import splitties.toast.toast


class SubmitDialogFragment(var userId : String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog{
        return activity?.let {
            // Use the Builder class for convenient dialog construction

            val builder = AlertDialog.Builder(it)
            builder.setTitle("제출 확인").setMessage("이 ID가 맞습니까?")
                .setPositiveButton(R.string.dialog_yes,
                    DialogInterface.OnClickListener { dialog, id ->
                        val intent = Intent(requireActivity(),UserActivity::class.java)
                        UtilClass.saveId(requireActivity().applicationContext,userId)
                        intent.putExtra("username", userId)
                        startActivity(intent)
                        requireActivity().finish()
                        toast("등록 완료")

                    })
                .setNegativeButton(R.string.dialog_no,
                    DialogInterface.OnClickListener { dialog, id ->
                        toast("다시 입력해주세요")

                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }

}
