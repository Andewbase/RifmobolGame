package z.nova.rifmobolgame.screen.multilevl

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.databinding.FragmentMultiLevelBinding
import z.nova.rifmobolgame.screen.base.BaseMultiFragment

@AndroidEntryPoint
class MultiLevelFragment : BaseMultiFragment<FragmentMultiLevelBinding>(FragmentMultiLevelBinding::inflate), View.OnClickListener {

    override val numberRound = 1

    private var scoreP1 = 0

    private var scoreP2 = 0

    private val viewModel by viewModels<MultiLevelViewModel>()

    private val safeArgs: MultiLevelFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idMultiLvl = safeArgs.idMultiLvl

        viewModel.getScore(scoreP1, scoreP2)
        viewModel.scoreP1.observe(viewLifecycleOwner) {
            binding.scoree1.text = it.toString()
        }
        viewModel.scoreP2.observe(viewLifecycleOwner) {
            binding.scoree2.text = it.toString()
        }

        viewModel.getRoundMusic(idMultiLvl)

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

        viewModel.getRoundInfo(idMultiLvl, numberRound)

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

        binding.p1btnLeftUp.setOnClickListener(this)
        binding.p1btnRightUp.setOnClickListener(this)
        binding.p1btnLeftBottom.setOnClickListener(this)
        binding.p1btnRightBottom.setOnClickListener(this)

        binding.p2btnLeftUp.setOnClickListener(this)
        binding.p2btnRightUp.setOnClickListener(this)
        binding.p2btnLeftBottom.setOnClickListener(this)
        binding.p2btnRightBottom.setOnClickListener(this)


    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onClick(v: View) {

        var idLvl = safeArgs.idMultiLvl

        val nextLvl = ++idLvl

        binding.apply {
            when(v){
                p1btnLeftUp -> {
                    idButtonP1 = 1
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                }
                p1btnRightUp -> {
                     idButtonP1 = 2
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                }
                p1btnLeftBottom -> {
                    idButtonP1 = 3
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                }
                p1btnRightBottom -> {
                    idButtonP1 = 4
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                }

                p2btnLeftUp -> {
                    idButtonP2 = 1
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whitered)
                }
                p2btnRightUp -> {
                    idButtonP2 = 2
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whitered)
                }
                p2btnLeftBottom -> {
                    idButtonP2 = 3
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whitered)
                }
                p2btnRightBottom -> {
                    idButtonP2 = 4
                    v.background = ContextCompat.getDrawable(requireActivity(),R.drawable.style_btn_stroke_whiteblack_press_whitered)
                }
            }
        }

        if (idButtonP1 > 0){
            binding.apply {
                p1btnLeftUp.isClickable = false
                p1btnRightUp.isClickable = false
                p1btnLeftBottom.isClickable = false
                p1btnRightBottom.isClickable = false
            }
        }

        if (idButtonP2 > 0) {
            binding.apply {
                p2btnLeftUp.isClickable = false
                p2btnRightUp.isClickable = false
                p2btnLeftBottom.isClickable = false
                p2btnRightBottom.isClickable = false
            }
        }

        if(idButtonP1 > 0 && idButtonP2 > 0) {

            releaseMediaPlayer()

            viewModel.roundMusicLivedata.observe(viewLifecycleOwner) { music ->

                mediaPlayer = MediaPlayer.create(activity, music.music2)
                mediaPlayer!!.start()

                music.checkingMultiTheResponse()

                mediaPlayer!!.setOnCompletionListener {

                    when (music.p1rightAnswer) {
                        1 -> binding.p1btnLeftUp.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                        2 -> binding.p1btnRightUp.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                        3 -> binding.p1btnLeftBottom.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                        4 -> binding.p1btnRightBottom.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                    }

                    when (music.p2rightAnswer) {
                        1 -> binding.p2btnLeftUp.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                        2 -> binding.p2btnRightUp.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                        3 -> binding.p2btnLeftBottom.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                        4 -> binding.p2btnRightBottom.background = ContextCompat.getDrawable(requireActivity(), music.backgroundButtonRightAnswer)
                    }

                    binding.apply {

                        when(idButtonP1){
                            1 -> if (music.p1leftUpButton.isChecked) {
                                ++scoreP1
                            }

                            2 -> if (music.p1rightUpButton.isChecked) {
                                ++scoreP1
                            }

                            3 -> if (music.p1leftBottomButton.isChecked) {
                                ++scoreP1
                            }

                            4 -> if (music.p1rightBottomButton.isChecked) {
                                ++scoreP1
                            }
                        }

                        when (idButtonP2) {
                            1 -> if (music.p2leftUpButton.isChecked) {
                                ++scoreP2
                            }

                            2 -> if (music.p2rightUpButton.isChecked) {
                                ++scoreP2
                            }

                            3 -> if (music.p2leftBottomButton.isChecked) {
                                ++scoreP2
                            }

                            4 -> if (music.p2rightBottomButton.isChecked) {
                                ++scoreP2
                            }
                        } //when
                    } //binding

                    GlobalScope.launch(Dispatchers.Main) {
                        releaseMediaPlayer()
                        delay(DELAY)
                        val action = MultiLevelFragmentDirections.actionMultiLevelFragmentToMultiLvlFragmentFragmentTwo(nextLvl, scoreP1, scoreP2)
                        findNavController().navigate(action)
                    }

                } //MediaPlayer.setOnCompletionListener
            } // viewModel.observe

        } //if
    }

}