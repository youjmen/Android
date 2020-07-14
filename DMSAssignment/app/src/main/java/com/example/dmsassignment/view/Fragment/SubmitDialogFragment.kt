package com.example.dmsassignment.view.Fragment

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import splitties.toast.toast


class SubmitDialogFragment(var userId : String) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog{
        return activity?.let {
            // Use the Builder class for convenient dialog construction

            val builder = AlertDialog.Builder(it)
            builder.setTitle("제출 확인").setMessage("이 ID가 맞습니까?")
                .setPositiveButton(R.string.dialog_yes,
                    DialogInterface.OnClickListener { dialog, id ->

                        UtilClass.saveId(requireActivity().applicationContext,userId)

                        val transaction =requireActivity().supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.main_layout,UserFragment())
                        transaction.commit()
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
