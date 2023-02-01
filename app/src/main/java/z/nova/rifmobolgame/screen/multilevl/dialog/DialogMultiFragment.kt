package z.nova.rifmobolgame.screen.multilevl.dialog

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yodo1.mas.Yodo1Mas
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.databinding.FragmentDialogMultiBinding

@AndroidEntryPoint
class DialogMultiFragment : DialogFragment(R.layout.fragment_dialog_multi) {

    private var mBinding: FragmentDialogMultiBinding? = null
    private val binding get() = mBinding!!

    private val viewModel by viewModels<DialogMultiViewModel>()

    private val safArgs: DialogMultiFragmentArgs by navArgs()

    @SuppressLint("ResourceAsColor")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog!!.setCancelable(false)

        mBinding = FragmentDialogMultiBinding.bind(view)

        val scoreP1 = safArgs.scoreP1Lvl

        val scoreP2 = safArgs.scoreP2Lvl

        viewModel.getMultiDialogText(scoreP1, scoreP2)

        viewModel.multiDialogTextLiveData.observe(viewLifecycleOwner) { text ->
            binding.apply {
                textwin.setText(text.textDialog)
                multiScoreP1.text = text.scoreP1.toString()
                multiScoreP2.text = text.scoreP2.toString()
                btnClose.setTextColor(text.colorText)
                btnContinue.setTextColor(text.colorText)
                textwin.setTextColor(text.colorText)
                scoreMulti.setTextColor(text.colorText)
                multiScoreP1.setTextColor(text.colorText)
                multiScoreP2.setTextColor(text.colorText)
                dashMulti.setTextColor(text.colorText)
            }
        }

        binding.btnClose.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded){
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
                val action = DialogMultiFragmentDirections.actionDialogMultiFragmentToMainMenuFragment()
                findNavController().navigate(action)
            }else{
                val action = DialogMultiFragmentDirections.actionDialogMultiFragmentToMainMenuFragment()
                findNavController().navigate(action)
            }
        }

        binding.btnContinue.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded){
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
                val action = DialogMultiFragmentDirections.actionDialogMultiFragmentToMainMenuFragment()
                findNavController().navigate(action)
            }else{
                val action = DialogMultiFragmentDirections.actionDialogMultiFragmentToMainMenuFragment()
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}