package z.nova.rifmobolgame.screen.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.viewbinding.ViewBinding
import com.yodo1.mas.Yodo1Mas

typealias InflateDialog<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseDialogFragment<VB: ViewBinding>(
    private val inflate: InflateDialog<VB>
) : DialogFragment() {

    private var _binding: VB? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dialog!!.setCancelable(false)
    }

    fun yodoMas (idLvlDialog: Int){
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
        _binding = null
    }
}