package jetpack.mvvm

import jetpack.mvvm.base.BaseVmFragment
import jetpack.mvvm.databinding.FragmentMvvmBinding
import jetpack.mvvm.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Description：MvvmFragment
 */
class MvvmFragment : BaseVmFragment<FragmentMvvmBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()

    override fun getBinding(): FragmentMvvmBinding {
        return FragmentMvvmBinding.inflate(layoutInflater).apply {
            viewmodel = viewModel
            lifecycleOwner = this@MvvmFragment
        }
    }
}