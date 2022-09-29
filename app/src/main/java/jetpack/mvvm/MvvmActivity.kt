package jetpack.mvvm

import android.content.Intent
import jetpack.mvvm.base.BaseVmActivity
import jetpack.mvvm.databinding.ActivityMvvmBinding
import jetpack.mvvm.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MvvmActivity : BaseVmActivity<ActivityMvvmBinding, HomeViewModel>() {

    override val viewModel: HomeViewModel by viewModel()

    override fun getBinding(): ActivityMvvmBinding {
        return ActivityMvvmBinding.inflate(layoutInflater).apply {
            viewmodel = viewModel
            lifecycleOwner = this@MvvmActivity
        }
    }

    override fun initialize() {
        viewBinding.testFragmentBtn.setOnClickListener {
            startActivity(Intent(this, ContainerActivity::class.java))
        }
    }

}