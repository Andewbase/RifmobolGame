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
import z.nova.rifmobolgame.databinding.FragmentLoseDialogBinding

@AndroidEntryPoint
class LoseDialogFragment : DialogFragment(R.layout.fragment_lose_dialog) {

    private var mBinding: FragmentLoseDialogBinding? = null
    private val binding get() = mBinding!!

    private val viewModel by viewModels<DialogViewModel>()

    private val safeArgs: LoseDialogFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog!!.setCancelable(false)

        mBinding = FragmentLoseDialogBinding.bind(view)

        var idLvlDialog = safeArgs.idLvlDialogLose

        viewModel.textDialogLoseLiveData.observe(viewLifecycleOwner) { text ->
            binding.textlose.setText(text.textDialog)
        }

        binding.btnClose.setOnClickListener {
            yodoMas(idLvlDialog)
            val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSinglListFragment()
            findNavController().navigate(action)
        }

        binding.btnContinue.setOnClickListener {
            yodoMas(idLvlDialog)

            if (idLvlDialog != LAST_LEVEL){
                val nextLevel = ++idLvlDialog
                val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSingLevelFragment(nextLevel)
                findNavController().navigate(action)
            }else{
                val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSinglListFragment()
                findNavController().navigate(action)
            }
        }

        binding.btncontinueback.setOnClickListener {
            val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSingLevelFragment(idLvlDialog)
            findNavController().navigate(action)
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