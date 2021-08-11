package bruno_brabosa.convidados.house_purchases.presentation.view.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import bruno_brabosa.convidados.house_purchases.R
import bruno_brabosa.convidados.house_purchases.databinding.FragmentSplashScreenBinding

class SplashScreenFragment : Fragment() {

    private lateinit var _binding: FragmentSplashScreenBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashScreenBinding.inflate(inflater, container, false)
        setUpLogoFade()

        return binding.root
    }

    private fun setUpLogoFade() {
        binding.imLogoSplash.alpha = 0f
        binding.imLogoSplash.animate().setDuration(1000).alpha(1f).withEndAction{
            findNavController().navigate(R.id.action_to_home_fragment)
        }
    }
}