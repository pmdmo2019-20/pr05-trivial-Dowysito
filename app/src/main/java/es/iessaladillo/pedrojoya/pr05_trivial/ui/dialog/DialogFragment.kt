package es.iessaladillo.pedrojoya.pr05_trivial.ui.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainActivityViewModel

class DialogFragment : DialogFragment() {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.main_confirmation))
            .setMessage(getString(R.string.main_quit_game))
            .setPositiveButton(getString(R.string.main_yes)) { _ , _ ->
                viewModel.reply(true)
            }
            .setNegativeButton(getString(R.string.main_no)) { _ , _ ->
                viewModel.reply(false)
            }
            .create()
}