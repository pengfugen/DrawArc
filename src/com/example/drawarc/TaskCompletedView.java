package com.example.drawarc;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class TaskCompletedView extends View {

	private Paint mArcBGPaint;
	private Paint mTaskProgress;
	private float mProgress;
	
	public TaskCompletedView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init();
	}
	
	private void init()
	{
        mArcBGPaint = new Paint(Paint.ANTI_ALIAS_FLAG); 
        mArcBGPaint.setStyle(Paint.Style.FILL); 
        mArcBGPaint.setStrokeWidth(20); 
        mArcBGPaint.setColor(0xff171717); 
         
        mTaskProgress = new Paint(Paint.ANTI_ALIAS_FLAG); 
        mTaskProgress.setStyle(Paint.Style.STROKE); 
        mTaskProgress.setStrokeWidth(20); 
        mTaskProgress.setColor(0xFF00B0F0); 
        //BlurMaskFilter mBGBlur = new BlurMaskFilter(8, BlurMaskFilter.Blur.INNER); 
        //mArcBGPaint.setMaskFilter(mBGBlur); 
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		RectF rectf = new RectF(80, 80, 300, 300);
		//canvas.drawRect(rectf,mArcBGPaint);
        
		canvas.drawArc(rectf, 0, 360, false, mArcBGPaint);
		
		RectF rectf2 = new RectF(70, 70, 310, 310);
		
		//canvas.drawRect(rectf2,mTaskProgress);
        
		canvas.drawArc(rectf2, -90, mProgress, false, mTaskProgress);
	}
	
	public void updateTaskProgress(float progress)
	{
		mProgress = (progress/100)*360;
		invalidate();
	}
	

	
}
