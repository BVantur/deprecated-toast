package sp.bvantur.deprecatedtoast.utils

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.widget.Toast
import androidx.core.content.ContextCompat
import sp.bvantur.deprecatedtoast.R
import sp.bvantur.deprecatedtoast.databinding.LayoutCustomToastBinding

object ToastUtils {
    fun showRegular(activity: Activity, textMessage: String) {
        show(activity, textMessage)
    }

    fun showSuccess(activity: Activity, textMessage: String) {
        show(activity, textMessage, Color.GREEN)
    }

    fun showError(activity: Activity, textMessage: String) {
        show(activity, textMessage, Color.RED)
    }

    fun showWarning(activity: Activity, textMessage: String) {
        show(activity, textMessage, Color.argb(255, 255, 165, 0))
    }

    private fun show(
        activity: Activity,
        textMessage: String,
        backgroundColor: Int = ContextCompat.getColor(activity, R.color.teal_200)
    ) {
        val toastView = LayoutCustomToastBinding.inflate(activity.layoutInflater).apply {
            root.setBackgroundColor(backgroundColor)
            message = textMessage
        }

        Toast(activity)
            .apply {
                setGravity(
                    Gravity.TOP or Gravity.CENTER_HORIZONTAL or Gravity.FILL_HORIZONTAL,
                    0,
                    0
                )
                view = toastView.root
                duration = Toast.LENGTH_SHORT
            }.show()
    }
}