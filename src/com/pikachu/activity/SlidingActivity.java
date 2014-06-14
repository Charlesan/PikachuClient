package com.pikachu.activity;

import java.util.List;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;

import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.MonsterBean;
import com.pikachu.dao.CommonSetting;
import com.pikachu.dao.MonsterDao;
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
	
	LocationManager mLocationManager;
	
	private final LocationListener mLocationListener = new LocationListener() {
	    @Override
	    public void onLocationChanged(Location location) {
	        //your code here
	    	updateUserLocation(location);
	    }

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private void updateUserLocation(Location location) {
    	if ( location != null ) {
//    		System.out.println("���ȣ�" + location.getLatitude());
//    		System.out.println("γ�ȣ�" + location.getLongitude());
    		MonsterDao monsterDao = new MonsterDao();
    		List<MonsterBean> localMonsters = monsterDao.getLocalMonster(location.getLongitude(), location.getLatitude(), CommonSetting.accuracy);
    		if ( localMonsters != null ) {
    			System.out.println("������" + localMonsters.size());
    			System.out.println("local���飺" + localMonsters);
    			LoginUserInfo.getInstance().setLocalMonsters(localMonsters);
    			LoginUserInfo.getInstance().setLastLatitude(location.getLatitude());
    			LoginUserInfo.getInstance().setLastLongitude(location.getLongitude());
    		}
    		else {
    			System.out.println("�ò������飡��");
    		}
    	}
    	else {
    		System.out.println("locationΪ��");
    	}
	}
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.main); //���ø�Activity�Ĳ���
		init();
		
		mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
        // ���ҵ�������Ϣ
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE); // �߾���
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW); // �͹���

        String provider = mLocationManager.getBestProvider(criteria, true); // ��ȡGPS��Ϣ
        Location location = mLocationManager.getLastKnownLocation(provider); // ͨ��GPS��ȡλ��

		
        System.out.println("�����λ�ã�" + location);
        updateUserLocation(location);

	    mLocationManager.requestLocationUpdates(provider, 60000, 200, mLocationListener);
		//initListener();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		mLocationManager.removeUpdates(mLocationListener);
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
	
    protected void dialog() { 
        AlertDialog.Builder builder = new Builder(SlidingActivity.this); 
        builder.setMessage("ȷ��Ҫ�˳���?"); 
        builder.setTitle("��ʾ"); 
        builder.setPositiveButton("ȷ��", 
                new android.content.DialogInterface.OnClickListener() { 
                    @Override 
                    public void onClick(DialogInterface dialog, int which) { 
                        dialog.dismiss(); 
                        SlidingActivity.this.finish(); 
                    } 
                }); 
        builder.setNegativeButton("ȡ��", 
                new android.content.DialogInterface.OnClickListener() { 
                    @Override 
                    public void onClick(DialogInterface dialog, int which) { 
                        dialog.dismiss(); 
                    } 
                }); 
        builder.create().show(); 
    } 
    
    @Override 
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { 
            dialog(); 
            return false; 
        } 
        return false; 
    }

}
