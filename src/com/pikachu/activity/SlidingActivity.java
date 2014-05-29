package com.pikachu.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.pikachu.res.R;
import com.pikachu.slidingmenu.fragment.LeftFragment;
import com.pikachu.slidingmenu.fragment.MainFragment;
import com.pikachu.slidingmenu.fragment.RightFragment;
import com.pikachu.slidingmenu.fragment.ViewPageFragment;
import com.pikachu.slidingmenu.fragment.ViewPageFragment.MyPageChangeListener;
import com.pikachu.slidingmenu.view.SlidingMenu;

public class SlidingActivity extends FragmentActivity {
	SlidingMenu mSlidingMenu;
	LeftFragment leftFragment;
	RightFragment rightFragment;
	ViewPageFragment viewPageFragment;
	
//	MainFragment mainFragment;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main); //设置该Activity的布局
		init();
		//initListener();
	}

	private void init() {
		mSlidingMenu = (SlidingMenu) findViewById(R.id.slidingMenu);
		mSlidingMenu.setLeftView(getLayoutInflater().inflate(
				R.layout.left_frame, null));
		mSlidingMenu.setRightView(getLayoutInflater().inflate(
				R.layout.right_frame, null));
		mSlidingMenu.setCenterView(getLayoutInflater().inflate(
				R.layout.center_frame, null));

		FragmentTransaction t = this.getSupportFragmentManager()
				.beginTransaction();
		leftFragment = new LeftFragment();
		t.replace(R.id.left_frame, leftFragment);		

		rightFragment = new RightFragment();
		t.replace(R.id.right_frame, rightFragment);

		viewPageFragment = new ViewPageFragment();
//		t.replace(R.id.center_frame, viewPageFragment);
		t.replace(R.id.center_frame, new MainFragment());
		t.commit();
	}

//	private void initListener() {
//		viewPageFragment.setMyPageChangeListener(new MyPageChangeListener() {
//			
//			@Override
//			public void onPageSelected(int position) {
//				if(viewPageFragment.isFirst()){
//					mSlidingMenu.setCanSliding(true,false);
//				}else if(viewPageFragment.isEnd()){
//					mSlidingMenu.setCanSliding(false,true);
//				}else{
//					mSlidingMenu.setCanSliding(false,false);
//				}
//			}
//		});
//	}

	public void showLeft() {
		mSlidingMenu.showLeftView();
	}

	public void showRight() {
		mSlidingMenu.showRightView();
	}

}
