package z.nova.rifmobolgame.screen.singlevel.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.yodo1.mas.Yodo1Mas
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.data.local.GameData.LAST_LEVEL
import z.nova.rifmobolgame.databinding.FragmentWinDialogBinding

@AndroidEntryPoint
class WinDialogFragment: DialogFragment(R.layout.fragment_win_dialog) {

    private var mBinding: FragmentWinDialogBinding? = null
    private val binding get() = mBinding!!

    private val viewModel by viewModels<DialogViewModel>()

    private val safArgs: WinDialogFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog!!.setCancelable(false)

        mBinding = FragmentWinDialogBinding.bind(view)

        var idLvlDialog = safArgs.idLvlDialogWin

        viewModel.textDialogWinLiveData.observe(viewLifecycleOwner) { text ->
            binding.textwin.setText(text.textDialog)
        }

        binding.btnClose.setOnClickListener {
            yodoMas(idLvlDialog)
            val action = WinDialogFragmentDirections.actionWinDialogFragmentToSinglListFragment()
            findNavController().navigate(action)
        }

        binding.btnContinue.setOnClickListener {
            yodoMas(idLvlDialog)

            if (idLvlDialog != LAST_LEVEL){
                val nextLevel = ++idLvlDialog
                val action = WinDialogFragmentDirections.actionWinDialogFragmentToSingLevelFragment(nextLevel)
                findNavController().navigate(action)
            }else{
                val action = WinDialogFragmentDirections.actionWinDialogFragmentToSinglListFragment()
                findNavController().navigate(action)
            }
        }
    }

    private fun yodoMas(idLvlDialog: Int) {
        when (idLvlDialog) {
            5 -> if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
            }
            10 -> if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
            }
            15 -> if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
            }
            20 -> if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
            }
            25 -> if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
            }
            30 -> if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
            }
            35 -> if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(requireActivity())
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}