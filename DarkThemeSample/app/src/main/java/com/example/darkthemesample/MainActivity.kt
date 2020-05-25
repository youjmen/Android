package com.example.darkthemesample

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        set_darkmode.setOnClickListener {
            // build alert dialog
            val dialogBuilder = AlertDialog.Builder(this)

            // set message of alert dialog
            dialogBuilder.setMessage("Do you want to close this application ?")
                    // if the dialog is cancelable
                    .setCancelable(false)
                    // positive button text and action
                    .setPositiveButton("Proceed", DialogInterface.OnClickListener {
                        dialog, id -> finish()
                    })
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                        dialog, id -> dialog.cancel()
                    })

            // create dialog box
            val alert = dialogBuilder.create()
            // set title for alert dialog box
            alert.setTitle("AlertDialogExample")
            // show alert dialog
            alert.show()
        }


    }

}
