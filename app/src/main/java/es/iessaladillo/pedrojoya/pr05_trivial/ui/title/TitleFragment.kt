package ui.title

import android.os.Bundle
import androidx.fragment.app.Fragment
import es.iessaladillo.pedrojoya.pr05_trivial.R
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment(R.layout.fragment_title) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
//        btn_play.setOnClickListener{play()}
    }
//
//    private fun play() {
//        supportFragmentManager.commit {
//            replace(R.id.fcContent,
//                MainFragment.newInstance(getString(R.string.main_favourites)))
//        }
//    } ​
    companion object {
        fun newInstance(): TitleFragment = TitleFragment()
    }
}