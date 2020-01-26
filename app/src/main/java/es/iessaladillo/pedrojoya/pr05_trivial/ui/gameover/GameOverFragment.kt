package es.iessaladillo.pedrojoya.pr05_trivial.ui.gameover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_game_over.*
import kotlinx.android.synthetic.main.fragment_gamewon.*

class GameOverFragment  : Fragment(R.layout.fragment_game_over) {

    private val viewModel: MainActivityViewModel by activityViewModels()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().setTitle(R.string.about_title)
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }
        setUpViews()
    }

    private fun setUpViews() {
        viewModel.currentFrag.value=0
        btn_tryAgain.setOnClickListener { tryAgain() }
    }

    private fun tryAgain() {
        viewModel.shuffleAndPlay()
        requireFragmentManager().commit {
            replace(R.id.fcContent, GameFragment())
        }
    }


    companion object {
        fun newInstance(): GameOverFragment = GameOverFragment()
    }
}