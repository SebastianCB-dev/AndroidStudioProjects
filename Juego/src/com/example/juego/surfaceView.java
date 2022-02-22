package com.example.juego;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder.*;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class surfaceView extends SurfaceView {

	private Bitmap bmp;
	private SurfaceHolder holder;
	juegoLoopThread jlt;
	int x=0;
	int velocidadX=1;
	
		
	public surfaceView(Context context) {
		super(context);
		jlt=new juegoLoopThread(this);
		holder=getHolder();
		holder.addCallback(new Callback() {
			
			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void surfaceCreated(SurfaceHolder holder) {
/*				Canvas c= holder.lockCanvas();
				onDraw(c);
				holder.unlockCanvasAndPost(c);
*/								
				jlt.setCorriendo(true);
				jlt.start();
			}
			
			@Override
			public void surfaceChanged(SurfaceHolder holder, int format, int width,
					int height) {
				// TODO Auto-generated method stub
				
			}
		});
				
		bmp=BitmapFactory.decodeResource(getResources(), R.drawable.ico_and);
	}
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);
		if (x>getWidth()-bmp.getWidth())
			velocidadX=-1;
		if (x<=0)
			velocidadX=1;
		x=x+5*velocidadX;
		canvas.drawBitmap(bmp, x, 10, null);
		
	}

}
