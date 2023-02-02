package z.nova.rifmobolgame.screen.base

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

typealias InflateMulti<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseMultiFragment<VB: ViewBinding>(
    private val inflate: InflateMulti<VB>
) : Fragment() {

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    protected abstract val numberRound: Int

    protected var mediaPlayer: MediaPlayer? = null

    protected var idButtonP1: Int = 0
    protected var idButtonP2: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
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

    protected companion object Const {
        const val DELAY = 1500L
    }
}