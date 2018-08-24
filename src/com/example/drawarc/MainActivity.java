package com.example.drawarc;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity {

	ArcProgressView mArcProgress;
	TaskCompletedView mTaskProgress;
	TextView text;
	private int value = 0;
	private int i = 0;
	private final static int time = 1000*2;
	
	Handler mHandler = new Handler();
	
	private Runnable r = new Runnable()
	{
		public void run()
		{
			mTaskProgress.updateTaskProgress(value+2);
			value++;
			i++;
			//text.setText("timer:"+i+"");
			mHandler.postDelayed(r, time);
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mArcProgress = (ArcProgressView)this.findViewById(R.id.arc_progress);
		mTaskProgress = (TaskCompletedView)this.findViewById(R.id.task_complete);
		text = (TextView)this.findViewById(R.id.text);
		if(text == null)
		{
			Log.v("pengfugen", "is null====");
		}
		mArcProgress.calcSpeed();
		if(value <= 98)
		{
			mHandler.post(r);
		}
		else
		{
			mHandler.removeCallbacks(r);
		}
	}
}
