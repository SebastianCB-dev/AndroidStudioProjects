package com.example.juego;

import android.graphics.Canvas;

public class juegoLoopThread extends Thread {
	private boolean corriendo=false;
	private surfaceView sv;
	int fps=10;
	public juegoLoopThread(surfaceView v) {
		sv=v;
	}
	public void setCorriendo(boolean c) {
		corriendo=c;
	}
	@Override
	public void run() {
		long intervaloTiempo=1000/fps;
		long iniciaTiempo;
		long pausaTiempo;
		while (corriendo) {
			Canvas c=null;
			iniciaTiempo=System.currentTimeMillis();
			try {
				c=sv.getHolder().lockCanvas();
				synchronized (sv.getHolder()) {
					sv.onDraw(c);
				}
			}
			finally {
				if (c!=null) {
					sv.getHolder().unlockCanvasAndPost(c);
				}
			}
			pausaTiempo=intervaloTiempo-(System.currentTimeMillis()-iniciaTiempo);
			try {
				if (pausaTiempo>0) 
					sleep(pausaTiempo);
				else
					sleep(10);
			}
			catch (Exception e) {
				
			}
			
				
			
		}
	}
	
	
	

}
