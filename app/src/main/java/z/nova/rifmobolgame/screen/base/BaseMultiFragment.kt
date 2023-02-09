package z.nova.rifmobolgame.screen.base

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.databinding.FragmentMultiLevelBinding
import z.nova.rifmobolgame.screen.multilevl.MultiLevelViewModel

abstract class BaseMultiFragment: Fragment(R.layout.fragment_multi_level), View.OnClickListener {

    private var _binding: FragmentMultiLevelBinding?= null
    protected val binding get() = _binding!!

    protected abstract val numberRound: Int

    protected var mediaPlayer: MediaPlayer? = null

    protected val viewModel by viewModels<MultiLevelViewModel>()

    protected var idButtonP1: Int = 0
    protected var idButtonP2: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMultiLevelBinding.bind(view)

        viewModel.roundMusicLivedata.observe(viewLifecycleOwner) { music ->
            binding.apply {
                p1btnLeftUp.setText(music.p1leftUpButton.name)
                p1btnRightUp.setText(music.p1rightUpButton.name)
                p1btnLeftBottom.setText(music.p1leftBottomButton.name)
                p1btnRightBottom.setText(music.p1rightBottomButton.name)

                p2btnLeftUp.setText(music.p2leftUpButton.name)
                p2btnRightUp.setText(music.p2rightUpButton.name)
                p2btnLeftBottom.setText(music.p2leftBottomButton.name)
                p2btnRightBottom.setText(music.p2rightBottomButton.name)
            }
            mediaPlayer = MediaPlayer.create(activity, music.music1)
            mediaPlayer!!.start()
        }

        viewModel.roundInfoLiveData.observe(viewLifecycleOwner) { info ->
            binding.apply {
                menuBackground.setImageResource(info.backgroundRound)
                textLevels.setText(info.textLvl)
                coupletText.setText(info.textCouplet)
            }
        }

        binding.p1btnLeftUp.setOnClickListener(this)
        binding.p1btnRightUp.setOnClickListener(this)
        binding.p1btnLeftBottom.setOnClickListener(this)
        binding.p1btnRightBottom.setOnClickListener(this)

        binding.p2btnLeftUp.setOnClickListener(this)
        binding.p2btnRightUp.setOnClickListener(this)
        binding.p2btnLeftBottom.setOnClickListener(this)
        binding.p2btnRightBottom.setOnClickListener(this)

    }

    override fun onStart() {
        super.onStart()
        if (mediaPlayer != null) {
            mediaPlayer!!.start()
        }
    }

    override fun onPause() {
        super.onPause()
        if (mediaPlayer != null){
            mediaPlayer!!.pause()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        releaseMediaPlayer()
    }

   protected fun releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

    protected companion object {
        const val DELAY = 1500L
    }
}