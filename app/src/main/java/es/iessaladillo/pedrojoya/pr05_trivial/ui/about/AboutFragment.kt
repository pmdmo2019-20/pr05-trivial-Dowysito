package es.iessaladillo.pedrojoya.pr05_trivial.ui.about

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R

class AboutFragment : Fragment(R.layout.fragment_about) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().setTitle(R.string.about_title)
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }
    }




    companion object {
        fun newInstance(): AboutFragment = AboutFragment()
    }
}