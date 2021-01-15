package sp.bvantur.deprecatedtoast.utils

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.widget.Toast
import androidx.core.content.ContextCompat
import sp.bvantur.deprecatedtoast.R
import sp.bvantur.deprecatedtoast.databinding.LayoutCustomToastBinding

object ToastUtils {
    fun showRegularToast(activity: Activity, textMessage: String) {
        showToast(activity, textMessage)
    }

    fun showSuccessToast(activity: Activity, textMessage: String) {
        showToast(activity, textMessage, Color.GREEN)
    }

    fun showErrorToast(activity: Activity, textMessage: String) {
        showToast(activity, textMessage, Color.RED)
    }

    fun showWarningToast(activity: Activity, textMessage: String) {
        showToast(activity, textMessage, Color.argb(255, 255, 165, 0))
    }

    private fun showToast(activity: Activity, textMessage: String, backgroundColor: Int = ContextCompat.getColor(activity, R.color.teal_200)) {
        val toastView = LayoutCustomToastBinding.inflate(activity.layoutInflater).apply {
            root.setBackgroundColor(backgroundColor)
            message = textMessage
        }

        Toast(activity)
            .apply {
                setGravity(Gravity.TOP or Gravity.CENTER_HORIZONTAL or Gravity.FILL_HORIZONTAL, 0, 0)
                view = toastView.root
                duration = Toast.LENGTH_SHORT
            }.show()
    }
}