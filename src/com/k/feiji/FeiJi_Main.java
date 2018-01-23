package com.k.feiji;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCTextureCache;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.types.ccColor4B;

import com.baidu.mobstat.StatService;

import android.os.Bundle;

public class FeiJi_Main extends FeiJi_BaseAc {

	private CCGLSurfaceView _FeiJi_Surface;
	private CCScene _FeiJi_Scene;

	private int m=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_FeiJi_Surface = new CCGLSurfaceView(this);
		setContentView(_FeiJi_Surface);
		m=getIntent().getIntExtra("mode", 0);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		CCDirector.sharedDirector().end();
		CCTextureCache.sharedTextureCache().removeAllTextures();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		CCDirector.sharedDirector().pause();
		StatService.onPause(this);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		CCDirector.sharedDirector().resume();
		StatService.onResume(this);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// cocos2d里习惯以左下角作为原点,时间单位是秒
		CCDirector.sharedDirector().attachInView(_FeiJi_Surface);// 把cocos2d绑定在GLSurfaceView这个载体上
		// CCDirector.sharedDirector().setDeviceOrientation(
		// CCDirector.kCCDeviceOrientationLandscapeLeft);
		// CCDirector.sharedDirector().setDisplayFPS(true);//显示 FPS
		// CCDirector.sharedDirector().setAnimationInterval(1.0f / 60.0f);//
		// 每秒的贞数
		_FeiJi_Scene = CCScene.node();

		if (m==0) {
			FeiJi_Play _Layer = new FeiJi_Play(ccColor4B.ccc4(255, 255, 255, 255));
//			_Layer.GetContext(FeiJi_Main.this);
			_FeiJi_Scene.addChild(_Layer);
		}else if (m==1) {
			FeiJi_Play2 _Layer = new FeiJi_Play2(ccColor4B.ccc4(255, 255, 255, 255),this);
			_FeiJi_Scene.addChild(_Layer);
		}else {
			FeiJi_Play3 _Layer = new FeiJi_Play3(ccColor4B.ccc4(255, 255, 255, 255));
//			_Layer.GetContext(FeiJi_Main.this);
			_FeiJi_Scene.addChild(_Layer);
		}
		

		CCDirector.sharedDirector().runWithScene(_FeiJi_Scene);// 运行场景

		CCDirector.sharedDirector().pause();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		CCDirector.sharedDirector().end();
	}
}
