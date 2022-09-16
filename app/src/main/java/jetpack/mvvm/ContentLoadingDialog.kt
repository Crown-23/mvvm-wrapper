package jetpack.mvvm

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialog

class ContentLoadingDialog(context: Context, theme: Int = R.style.TransparentDialog) : AppCompatDialog(context, theme) {
    private var mStartTime: Long = -1
    private var mPostedHide = false
    private var mPostedShow = false
    private var mDismissed = false
    private var mHandler: Handler = Handler(Looper.getMainLooper())

    private val mDelayedHide = Runnable {
        mPostedHide = false
        mStartTime = -1L
        dismiss()
    }

    private val mDelayedShow = Runnable {
        mPostedShow = false
        if (!mDismissed) {
            mStartTime = System.currentTimeMillis()
            show()
        }
    }

    init {
        setContentView(R.layout.dialog_loading)
        setCancelable(true)
        setCanceledOnTouchOutside(false)
    }

//    override fun onAttachedToWindow() {
//        super.onAttachedToWindow()
//        removeCallbacks()
//    }
//
//    override fun onDetachedFromWindow() {
//        super.onDetachedFromWindow()
//        removeCallbacks()
//    }

    private fun removeCallbacks() {
        mHandler.removeCallbacks(mDelayedHide)
        mHandler.removeCallbacks(mDelayedShow)
    }

    fun showDialog(tip: String = "") {
        if (!TextUtils.isEmpty(tip)) {
            findViewById<TextView>(R.id.loading_text)?.text = tip
        }

        mStartTime = -1
        mDismissed = false
        mHandler.removeCallbacks(mDelayedHide)
        mPostedHide = false
        if (!mPostedShow) {
            mHandler.postDelayed(mDelayedShow, MIN_DELAY.toLong())
            mPostedShow = true
        }
    }

    fun hideDialog() {
        mDismissed = true
        mHandler.removeCallbacks(mDelayedShow)
        mPostedShow = false
        val diff = System.currentTimeMillis() - mStartTime
        if (diff >= MIN_SHOW_TIME || mStartTime == -1L) {
            dismiss()
        } else {
            if (!mPostedHide) {
                mHandler.postDelayed(mDelayedHide, MIN_SHOW_TIME - diff)
                mPostedHide = true
            }
        }
    }

    override fun dismiss() {
        super.dismiss()
        removeCallbacks()
    }

    companion object {
        private const val MIN_SHOW_TIME: Int = 500
        private const val MIN_DELAY: Int = 300
    }

}