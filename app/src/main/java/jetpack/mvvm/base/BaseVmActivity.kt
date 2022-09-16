package jetpack.mvvm.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import jetpack.mvvm.ContentLoadingDialog

/**
 * Description：MVVM base activity
 */
abstract class BaseVmActivity<VB : ViewDataBinding, VM : BaseViewModel> : BaseActivity<VB>() {
    protected val viewModel by lazy { ViewModelProvider(this).get(getVmClass()) }

    private val loadingDialog by lazy { ContentLoadingDialog(this) }

    abstract fun getVmClass(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addObserver()
    }

    open fun addObserver() {
        viewModel.dataLoading.observe(this) {
            if (it) {
                loadingDialog.showDialog()
            } else {
                loadingDialog.hideDialog()
            }
        }
    }

}

