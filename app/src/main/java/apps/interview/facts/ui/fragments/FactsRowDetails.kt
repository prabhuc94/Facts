package apps.interview.facts.ui.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import apps.interview.facts.R
import apps.interview.facts.data.Row
import apps.interview.facts.databinding.FragmentFactsDetailsBottomdialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FactsRowDetails (val rowData : Row) : BottomSheetDialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(BottomSheetDialogFragment.STYLE_NORMAL, theme)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        dialog.setOnShowListener { setupBottomShett(it) }
        return dialog
    }

    private fun setupBottomShett(dialogInterface: DialogInterface){
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        val bottomSheet = bottomSheetDialog.findViewById<View>(
            com.google.android.material.R.id.design_bottom_sheet)
            ?: return
        bottomSheet.setBackgroundColor(Color.TRANSPARENT)
    }

    @SuppressLint("RestrictedApi")
    @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    override fun setupDialog(dialog: Dialog, style: Int) {
        super.setupDialog(dialog, style)
        val view = DataBindingUtil.inflate<FragmentFactsDetailsBottomdialogBinding>(LayoutInflater.from(requireContext()),
            R.layout.fragment_facts_details_bottomdialog,null,false)
        dialog.setCancelable(false)
        dialog.setCanceledOnTouchOutside(true) // Disable the cancel if user click outside of the popup/dialog
        dialog.setContentView(view.root) // add the desired view
        dialog.window?.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT) // It'll help to occupy the required screen size
        dialog.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND) // This will Make non accessible previous screen for other than Popup view
        dialog.window?.setGravity(Gravity.CENTER) // This will make it appear the Popup in TOP
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent) // It'll make the Dialog background as Transparent
        dialog.show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding  = DataBindingUtil.inflate<FragmentFactsDetailsBottomdialogBinding>(inflater, R.layout.fragment_facts_details_bottomdialog, container, false)
        binding.row = rowData
        return binding.root
    }

}