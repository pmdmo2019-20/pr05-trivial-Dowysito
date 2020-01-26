package es.iessaladillo.pedrojoya.pr05_trivial.ui.game

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.entity.Question
import es.iessaladillo.pedrojoya.pr05_trivial.ui.about.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.gameover.GameOverFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.gamewon.GameWonFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainActivityViewModel
import kotlinx.android.synthetic.main.fragment_game.*

class GameFragment: Fragment(R.layout.fragment_game) {

    private val viewModel: MainActivityViewModel by activityViewModels()


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        requireActivity().setTitle(getString(R.string.game_question_title,viewModel.currentQuestion+1,viewModel.numberQuestions))
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(true)
        }
        setupViews()
    }

    private fun setupViews() {
        viewModel.currentFrag.value=1
        txt_QuestionTitle.text=viewModel.getQuestion(viewModel.currentQuestion).title
        ans0.text=viewModel.getQuestion(viewModel.currentQuestion).answers.get(0).title
        ans1.text=viewModel.getQuestion(viewModel.currentQuestion).answers.get(1).title
        ans2.text=viewModel.getQuestion(viewModel.currentQuestion).answers.get(2).title
        ans3.text=viewModel.getQuestion(viewModel.currentQuestion).answers.get(3).title
        btn_submit.setOnClickListener { chckContinue() }
    }

    private fun chckContinue() {
        var selected = 0
        when (answers.checkedRadioButtonId){
            R.id.ans0 -> selected=0
            R.id.ans1 -> selected=1
            R.id.ans2 -> selected=2
            R.id.ans3 -> selected=3
        }

        if (viewModel.getQuestion(viewModel.currentQuestion).answers.get(selected).correct){
            continuePlaying()
        }
        else{
            gameLost()
        }
    }

    private fun gameLost() {
        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcContent, GameOverFragment.newInstance())
        }
    }

    fun continuePlaying(){
        if (viewModel.currentQuestion+1==viewModel.numberQuestions){
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fcContent, GameWonFragment.newInstance())
            }
        }
        else {
            viewModel.currentQuestion++
            requireActivity().supportFragmentManager.commit {
                replace(R.id.fcContent, GameFragment.newInstance())
            }
        }
    }

    companion object {
        fun newInstance(): GameFragment = GameFragment()
    }
}