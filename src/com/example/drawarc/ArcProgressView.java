package com.example.drawarc;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class ArcProgressView extends View {

	private Paint mArcPaint;
	private Paint mArcBGPaint;
	private Paint mRecfPaint;

	private RectF mOval;
	private float mSweep = 0;
	private int mSpeedMax = 200;
	private int mThreshold = 100;
	private int mIncSpeedValue = 90;
	private float mCenterX;
	private float mCenterY;
	private float mSpeedArcWidth = 30;

	private final float SPEED_VALUE_INC = 2;
	
	
	
	public ArcProgressView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	private void init()
	{
		mRecfPaint = new Paint(Paint.ANTI_ALIAS_FLAG); 
		mRecfPaint.setStyle(Paint.Style.STROKE); 
		mRecfPaint.setStrokeWidth(1);
		mRecfPaint.setColor(0xff81ccd6);
        
		mArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG); 
        mArcPaint.setStyle(Paint.Style.STROKE); 
        mArcPaint.setStrokeWidth(mSpeedArcWidth); 
//        mPaint.setStrokeCap(Paint.Cap.ROUND); 
        mArcPaint.setColor(0xff81ccd6); 
        //BlurMaskFilter mBlur = new BlurMaskFilter(8, BlurMaskFilter.Blur.INNER); 
        //mArcPaint.setMaskFilter(mBlur); 
         
        mArcBGPaint = new Paint(Paint.ANTI_ALIAS_FLAG); 
        mArcBGPaint.setStyle(Paint.Style.STROKE); 
        mArcBGPaint.setStrokeWidth(mSpeedArcWidth+10); 
        mArcBGPaint.setColor(0xff171717); 
         
        //BlurMaskFilter mBGBlur = new BlurMaskFilter(8, BlurMaskFilter.Blur.INNER); 
        //mArcBGPaint.setMaskFilter(mBGBlur); 
	}
	
	private void drawSpeed(Canvas canvas) {
		
        mOval = new RectF(80, 60, 320, 300);
        
        canvas.drawRect(mOval,mRecfPaint);
        
		canvas.drawArc(mOval, 179, 360, false, mArcBGPaint);

		mSweep = (float) mIncSpeedValue / mSpeedMax * 180; 
		if (mIncSpeedValue > mThreshold) {
			mArcPaint.setColor(0xFFFF0000);
		} else {
			mArcPaint.setColor(0xFF00B0F0);
		}

		canvas.drawArc(mOval, 180, mSweep, false, mArcPaint);
	}

	public  void calcSpeed() {
			
			invalidate();
	}
	
	@Override 
	protected void onSizeChanged(int w, int h, int ow, int oh) { 
	        super.onSizeChanged(w, h, ow, oh); 
	        Log.i("DrawArc", w+""); 
	        Log.i("DrawArc", h+""); 
	        
	    }
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		drawSpeed(canvas);
	}
	
	
	

}
