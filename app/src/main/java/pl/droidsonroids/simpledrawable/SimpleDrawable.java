package pl.droidsonroids.simpledrawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class SimpleDrawable extends Drawable {

	private final Paint paint = new Paint();
	private float radius;

	@Override
	public void inflate(@NonNull Resources r, @NonNull XmlPullParser parser, @NonNull AttributeSet attrs, @Nullable Resources.Theme theme) throws XmlPullParserException, IOException {
		super.inflate(r, parser, attrs, theme);
		final TypedArray attributes = r.obtainAttributes(attrs, R.styleable.SimpleDrawable);
		paint.setColor(attributes.getColor(R.styleable.SimpleDrawable_color, Color.BLACK));
		paint.setStyle(Paint.Style.FILL);
		radius = attributes.getDimension(R.styleable.SimpleDrawable_radius, 1);
		attributes.recycle();
	}

	@Override
	public void draw(@NonNull Canvas canvas) {
		canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, radius, paint);
	}

	@Override
	public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

	}

	@Override
	public void setColorFilter(@Nullable ColorFilter colorFilter) {

	}

	@Override
	public int getOpacity() {
		return PixelFormat.TRANSLUCENT;
	}
}
