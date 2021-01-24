package sp.bvantur.deprecatedtoast.utils

import android.app.Activity
import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.BaseTransientBottomBar.ANIMATION_MODE_FADE
import com.google.android.material.snackbar.Snackbar
import sp.bvantur.deprecatedtoast.R

object SnackbarUtils {
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
        val snackbar = Snackbar.make(activity.findViewById(android.R.id.content), textMessage, Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundColor(backgroundColor)
        setCorrectAnimationAndPosition(snackbar)
        snackbar.show()
    }

    private fun setCorrectAnimationAndPosition(snackbar: Snackbar) {
        val params = snackbar.view.layoutParams
        if (params is CoordinatorLayout.LayoutParams) {
            params.gravity = Gravity.TOP
        } else if (params is FrameLayout.LayoutParams) {
            params.gravity = Gravity.TOP
        }
        snackbar.view.layoutParams = params
        snackbar.animationMode = ANIMATION_MODE_FADE
    }
}