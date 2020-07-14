package com.example.dmsassignment.view

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.dmsassignment.R
import com.example.dmsassignment.UtilClass
import kotlinx.android.synthetic.main.dialog_change_github_id.*


class ChangeUsernameDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val inflater = requireActivity().layoutInflater
            val builder = AlertDialog.Builder(it)
            builder.setView(inflater.inflate(R.layout.dialog_change_github_id,null))
                .setPositiveButton(R.string.dialog_yes,
                    DialogInterface.OnClickListener { dialog, id ->


                        UtilClass.changeId(requireActivity().applicationContext,getDialog()!!.change_username_editText.text.toString())
                        val intent = Intent(requireActivity(),UserActivity::class.java)
                        startActivity(intent)
                        requireActivity().finish()



                    })
                .setNegativeButton(R.string.dialog_no
                ) { dialog, id ->
                    getDialog()!!.cancel()

                }
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")

    }
}
