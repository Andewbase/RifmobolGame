package z.nova.rifmobolgame.screen.singlevel

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import z.nova.rifmobolgame.databinding.FragmentSingLevelBinding
import z.nova.rifmobolgame.screen.base.BaseFragment

@AndroidEntryPoint
class SingLevelFragment : BaseFragment<FragmentSingLevelBinding>(FragmentSingLevelBinding::inflate), View.OnClickListener {

    private var mediaPlayer: MediaPlayer? = null

    private val viewModel by viewModels<SingLevelViewModel>()

    private val safeArgs: SingLevelFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idLvl = safeArgs.idLvl

        viewModel.getRoundMusic(idLvl)

        viewModel.roundMusicLivedata.observe(viewLifecycleOwner) { music ->

            binding.apply {
                btnLeftUp.setText(music.leftUpButton.name)
                btnRightUp.setText(music.rightUpButton.name)
                btnLeftBottom.setText(music.leftBottomButton.name)
                btnRightBottom.setText(music.rightBottomButton.name)
            }

            mediaPlayer = MediaPlayer.create(activity, music.music1)
            mediaPlayer!!.start()
        }

        viewModel.getRoundInfo(idLvl)
        viewModel.roundInfoLiveData.observe(viewLifecycleOwner) { info ->

            binding.apply {
                menuBackground.setImageResource(info.backgroundRound)
                textLevels.setText(info.textLvl)
                coupletText.setText(info.textCouplet)
            }
        }

        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnLeftUp.setOnClickListener(this)
        binding.btnRightUp.setOnClickListener(this)
        binding.btnLeftBottom.setOnClickListener(this)
        binding.btnRightBottom.setOnClickListener(this)

    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onClick(v: View) {

        val idLvl = safeArgs.idLvl

        releaseMediaPlayer()

        viewModel.roundMusicLivedata.observe(viewLifecycleOwner) { music ->
            mediaPlayer = MediaPlayer.create(activity, music.music2)
            mediaPlayer!!.start()
            v.background = ContextCompat.getDrawable(requireActivity(),music.backgroundButtonAnswer)

            music.checkingTheResponse()

            mediaPlayer!!.setOnCompletionListener {

                when(music.rightAnswer){
                    1 -> binding.btnLeftUp.background = ContextCompat.getDrawable(requireActivity(),music.backgroundButtonRightAnswer)
                    2 -> binding.btnRightUp.background = ContextCompat.getDrawable(requireActivity(),music.backgroundButtonRightAnswer)
                    3 -> binding.btnLeftBottom.background = ContextCompat.getDrawable(requireActivity(),music.backgroundButtonRightAnswer)
                    4 -> binding.btnRightBottom.background = ContextCompat.getDrawable(requireActivity(),music.backgroundButtonRightAnswer)
                }

                binding.apply {
                    when (v) {
                        btnLeftUp -> if (music.leftUpButton.isChecked) {

                            releaseMediaPlayer()
                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)
                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToWinDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }
                        } else {
                            releaseMediaPlayer()

                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)

                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToLoseDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }
                        }

                        btnRightUp -> if (music.rightUpButton.isChecked) {

                            releaseMediaPlayer()
                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)
                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToWinDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }

                        } else {
                            releaseMediaPlayer()
                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)
                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToLoseDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }
                        }

                        btnLeftBottom -> if (music.leftBottomButton.isChecked) {

                            releaseMediaPlayer()

                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)
                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToWinDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }
                        } else {
                            releaseMediaPlayer()
                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)
                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToLoseDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }
                        }

                        btnRightBottom -> if (music.rightBottomButton.isChecked) {

                            releaseMediaPlayer()

                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)
                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToWinDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }
                        } else {
                            releaseMediaPlayer()
                            GlobalScope.launch(Dispatchers.Main) {
                                delay(DELAY)
                                val action =
                                    SingLevelFragmentDirections.actionSingLevelFragmentToLoseDialogFragment(
                                        idLvl
                                    )
                                findNavController().navigate(action)
                            }
                        }
                    }
                }


            }

        }

        binding.apply {
            btnLeftUp.isClickable = false
            btnRightUp.isClickable = false
            btnLeftBottom.isClickable = false
            btnRightBottom.isClickable = false
        }
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
        releaseMediaPlayer()
    }

    private fun releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

    companion object Const{
        private const val DELAY = 1500L
    }

}