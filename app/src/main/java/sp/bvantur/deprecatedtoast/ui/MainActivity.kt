package sp.bvantur.deprecatedtoast.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import sp.bvantur.deprecatedtoast.R
import sp.bvantur.deprecatedtoast.databinding.ActivityMainBinding
import sp.bvantur.deprecatedtoast.utils.ToastUtils

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.clickListener = this
    }

    override fun onClick(v: View?) {
        when(v?.id ?: return) {
            R.id.btnShowRegularToast -> ToastUtils.showRegular(this, getString(R.string.regular_message))
            R.id.btnShowErrorToast -> ToastUtils.showError(this, getString(R.string.error_message))
            R.id.btnShowSuccessToast -> ToastUtils.showSuccess(this, getString(R.string.success_message))
            R.id.btnShowWarningToast -> ToastUtils.showWarning(this, getString(R.string.warning_message))
        }
    }
}