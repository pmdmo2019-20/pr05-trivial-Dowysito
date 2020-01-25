package ui.title

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.about.AboutFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.game.GameFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.rules.RulesFragment
import es.iessaladillo.pedrojoya.pr05_trivial.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.fragment_title.*

class TitleFragment : Fragment(R.layout.fragment_title) {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupViews()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        requireActivity().setTitle(R.string.app_name)
        (requireActivity() as AppCompatActivity).supportActionBar?.run {
            setDisplayHomeAsUpEnabled(false)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fragment_title, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.mnuRules -> {
                navigateToRules()
                true
            }
            R.id.mnuAbout -> {
                navigateToAbout()
                true
            }
            R.id.mnuSettings -> {
                navigateToSettings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    private fun navigateToAbout() {
        requireFragmentManager().commit {
            replace(R.id.fcContent, AboutFragment.newInstance())
        }
    }

    private fun navigateToRules() {
        requireFragmentManager().commit {
            replace(R.id.fcContent, RulesFragment.newInstance())
        }
    }

    private fun navigateToSettings() {
        requireFragmentManager().commit {
            replace(R.id.fcContent, SettingsFragment.newInstance())
        }
    }

    private fun setupViews() {
        btn_play.setOnClickListener{play()}
    }

    private fun play() {
        requireFragmentManager().commit {
            replace(R.id.fcContent, GameFragment())
        }
    }

    companion object {
        fun newInstance(): TitleFragment = TitleFragment()
    }
}