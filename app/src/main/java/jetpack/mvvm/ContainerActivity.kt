package jetpack.mvvm

import jetpack.mvvm.base.BaseActivity
import jetpack.mvvm.databinding.ActivityContainerBinding

/**
 * Description：Fragment container activity
 */
class ContainerActivity : BaseActivity<ActivityContainerBinding>() {
    override fun getBinding(): ActivityContainerBinding {
        return ActivityContainerBinding.inflate(layoutInflater)
    }
}