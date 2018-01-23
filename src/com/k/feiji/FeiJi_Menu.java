package com.k.feiji;

import com.baidu.mobstat.StatService;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class FeiJi_Menu extends FeiJi_BaseAc {

	private Button _FeiJi_Button_New, _FeiJi_Button_Score, _FeiJi_Button_Exit,
			feiji_bu_gravity, feiji_bu_about,feiji_bu_waigua;
    
    private ImageView feiji_image_about,feiji_image_x;
    private RelativeLayout feiji_rel_about;
    private Animation visiti,gone;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feiji_menu);
		Init();
	}

	private void Init() {
		// TODO Auto-generated method stub
		_FeiJi_Button_New = (Button) findViewById(R.id.feiji_bu_new);
		feiji_bu_gravity = (Button) findViewById(R.id.feiji_bu_gravity);
		_FeiJi_Button_Score = (Button) findViewById(R.id.feiji_bu_score);
		_FeiJi_Button_Exit = (Button) findViewById(R.id.feiji_bu_exit);
		feiji_image_about=(ImageView) findViewById(R.id.feiji_image_about);
		feiji_image_x=(ImageView) findViewById(R.id.feiji_image_x);
		feiji_rel_about=(RelativeLayout) findViewById(R.id.feiji_rel_about);
		feiji_bu_waigua=(Button) findViewById(R.id.feiji_bu_waigua);
		_FeiJi_Button_New.setOnClickListener(new OnClick());
		feiji_bu_gravity.setOnClickListener(new OnClick());
		feiji_bu_waigua.setOnClickListener(new OnClick());
		_FeiJi_Button_Score.setOnClickListener(new OnClick());
		_FeiJi_Button_Exit.setOnClickListener(new OnClick());
		feiji_image_x.setOnClickListener(new OnClick());
	
		visiti=AnimationUtils.loadAnimation(this, R.anim.visiti);
		gone= AnimationUtils.loadAnimation(this, R.anim.gone);
	}

	private class OnClick implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.feiji_bu_new:
				Toast.makeText(FeiJi_Menu.this, "����ɻ��ƶ�", 0).show();;
				Intent intent = new Intent(FeiJi_Menu.this, FeiJi_Main.class);
				intent.putExtra("mode", 0);
				startActivity(intent);
				finish();
				break;
			case R.id.feiji_bu_gravity:
				Intent intent1 = new Intent(FeiJi_Menu.this, FeiJi_Main.class);
				intent1.putExtra("mode", 1);
				startActivity(intent1);
				finish();
				break;
			case R.id.feiji_bu_waigua:
				Intent intent2 = new Intent(FeiJi_Menu.this, FeiJi_Main.class);
				intent2.putExtra("mode", 2);
				startActivity(intent2);
				finish();
				break;
			case R.id.feiji_bu_score:
				Intent i = new Intent(FeiJi_Menu.this, FeiJi_Score.class);
				startActivity(i);
				break;
			case R.id.feiji_bu_exit:
				finish();
				break;
			case R.id.feiji_image_x:
				feiji_rel_about.startAnimation(gone);
				feiji_rel_about.setVisibility(View.GONE);
				break;
			}
		}

	}

	public void onResume() {
		super.onResume();

		/**
		 * ҳ����ʼ��ÿ��Activity�ж���Ҫ��ӣ�����м̳еĸ�Activity���Ѿ�����˸õ��ã���ô��Activity����ز�����ӣ�
		 * ������StatService.onPageStartһ��onPageEnd��������ʹ��
		 */
		StatService.onResume(this);
	}

	public void onPause() {
		super.onPause();

		/**
		 * ҳ�������ÿ��Activity�ж���Ҫ��ӣ�����м̳еĸ�Activity���Ѿ�����˸õ��ã���ô��Activity����ز�����ӣ�
		 * ������StatService.onPageStartһ��onPageEnd��������ʹ��
		 */
		StatService.onPause(this);
	}
}
