package hu.lacroix82.stretchtopview;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Screen {

	private Screen() {}

	public static int getStatusBarHeight(Context c) {
		int result = 0;
		int resourceId = c.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = c.getResources().getDimensionPixelSize(resourceId);
		}

		return result;
	}

	public static int getScreenOrientation(Context mycontext) {
		return mycontext.getResources().getConfiguration().orientation;
	}

	public static int pxToDp(Context c, int px) {
		DisplayMetrics displayMetrics = c.getResources().getDisplayMetrics();
		int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
		return dp;
	}

	public static float dp2px(Context context, float dp) {
		Resources resources = context.getResources();
		DisplayMetrics metrics = resources.getDisplayMetrics();
		float px = dp * (metrics.densityDpi / 160f);
		return px;
	}

	public static int getDisplayWidth(Context c) {
		WindowManager window = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
		Display display = window.getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		int orientation = getScreenOrientation(c);
		if (orientation != Configuration.ORIENTATION_PORTRAIT) return width;
		else return height;
	}

	public static int getDisplayHeight(Context c) {
		WindowManager window = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
		Display display = window.getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		int orientation = getScreenOrientation(c);
		if (orientation != Configuration.ORIENTATION_PORTRAIT) return height;
		else return width;
	}

}
