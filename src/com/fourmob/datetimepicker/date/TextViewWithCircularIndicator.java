package com.fourmob.datetimepicker.date;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;
import de.azapps.mirakel.helper.MirakelPreferences;
import de.azapps.mirakelandroid.R;


public class TextViewWithCircularIndicator extends TextView {
	private final int mCircleColor;
	Paint mCirclePaint = new Paint();
	private boolean mDrawCircle;
	private final String mItemIsSelectedText;

	public TextViewWithCircularIndicator(Context context, AttributeSet attributeSet) {
		super(context, attributeSet);
		Resources localResources = context.getResources();
		boolean dark=MirakelPreferences.isDark();
		this.mCircleColor = localResources.getColor(dark?R.color.clock_red:R.color.blue);
		this.mItemIsSelectedText = context.getResources().getString(R.string.item_is_selected);
		init();
	}

	private void init() {
		this.mCirclePaint.setFakeBoldText(true);
		this.mCirclePaint.setAntiAlias(true);
		this.mCirclePaint.setColor(this.mCircleColor);
		this.mCirclePaint.setTextAlign(Paint.Align.CENTER);
		this.mCirclePaint.setStyle(Paint.Style.FILL);
		this.mCirclePaint.setAlpha(60);
	}

	public void drawIndicator(boolean drawIndicator) {
		this.mDrawCircle = drawIndicator;
	}

	public CharSequence getContentDescription() {
		CharSequence text = getText();
		if (this.mDrawCircle)
			text = String.format(this.mItemIsSelectedText, text);
		return text;
	}

	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (this.mDrawCircle) {
			int width = getWidth();
			int heigth = getHeight();
			int radius = Math.min(width, heigth) / 2;
			canvas.drawCircle(width / 2, heigth / 2, radius, this.mCirclePaint);
		}
	}
}