package es.iessaladillo.pedrojoya.pr05_trivial.ui.rules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R


class RulesFragment : Fragment(R.layout.fragment_rules) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().setTitle(R.string.rules_title)
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }
    }




    companion object {
        fun newInstance(): RulesFragment = RulesFragment()
    }
}