package jetpack.mvvm.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import jetpack.mvvm.ContentLoadingDialog

/**
 * Description：MVVM base fragment
 */
abstract class BaseVmFragment<VB : ViewDataBinding, VM : BaseViewModel> : BaseFragment<VB>() {
    abstract val viewModel: VM

    private val loadingDialog by lazy { ContentLoadingDialog(requireContext()) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserver()
    }

    open fun addObserver() {
        viewModel.dataLoading.observe(viewLifecycleOwner) {
            if (it) {
                loadingDialog.showDialog()
            } else {
                loadingDialog.hideDialog()
            }
        }
    }

}

