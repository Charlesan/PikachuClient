package com.pikachu.slidingmenu.fragment;

import java.util.List;

import com.pikachu.activity.LoginActivity;
import com.pikachu.activity.SlidingActivity;
import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.MonsterBean;
import com.pikachu.bean.UserBean;
import com.pikachu.dao.CommonSetting;
import com.pikachu.dao.MonsterDao;
import com.pikachu.dao.UserDao;
import com.pikachu.res.R;
import com.pikachu.util.Utils;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

/**
 * 用于显示雷达界面的fragment
 * @author Wang Chao
 *
 */
public class RadarFragment extends Fragment {
	
	private Button radarHeadButton;
	
	private TableLayout localMonsterTable;
	
	public ProgressDialog dialog = null;
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if ( msg.what == 1 ) {
				((Button)msg.obj).setText("已抓取");
				((Button)msg.obj).setBackgroundColor(Color.GRAY);
				((Button)msg.obj).setClickable(false);
				dialog.dismiss();
				new AlertDialog.Builder(getActivity()).setTitle("提示")
				.setMessage("抓取成功！")
				.setPositiveButton("确定", null).show();
			}
			else if ( msg.what == 0 ){
				dialog.dismiss();
				// 弹出消息框
				new AlertDialog.Builder(getActivity()).setTitle("错误")
						.setMessage("抓取失败，请重新操作！")
						.setPositiveButton("确定", null).show();
			}
		}
	};
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.radar_fragment, null);
		radarHeadButton = (Button)view.findViewById(R.id.radarHeadButton);
		
		localMonsterTable = (TableLayout)view.findViewById(R.id.localMonsterTable);
		
		List<MonsterBean> localMonsters = LoginUserInfo.getInstance().getLocalMonsters();
		if ( localMonsters != null ) {
			for ( int i = 0; i < localMonsters.size(); i++ ) {
				addOneRow(i+1, localMonsters.get(i));
			}
		}
		
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		radarHeadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((SlidingActivity) getActivity()).showLeft();
			}});
	}
	
	private void addOneRow(int order, final MonsterBean monster) {
		TableRow row = new TableRow(getActivity());
		
		TextView view1 = new TextView(getActivity());
		addOneViewStyle(view1);
		view1.setText("" + order);
		row.addView(view1);
		
		ImageView view3 = new ImageView(getActivity());
//		TableRow.LayoutParams params = (TableRow.LayoutParams) view3.getLayoutParams();
//		params.width = 120;
//		params.height = 120;
//		view3.setLayoutParams( params ); 
			
//		view3.setLayoutParams(new TableRow.LayoutParams(80, 80));
		view3.setScaleType(ScaleType.FIT_CENTER);
		view3.setImageResource(Utils.getImageID("small_" + monster.getM_number()));
		row.addView(view3);
		
		TextView view2 = new TextView(getActivity());
		addOneViewStyle(view2);
		view2.setText(CommonSetting.getMonsterNameByNumber(monster.getM_number()));
		row.addView(view2);
		
		final Button view4 = new Button(getActivity());
		if ( LoginUserInfo.getInstance().getLoginUserHandBook() != null && LoginUserInfo.getInstance().getLoginUserHandBook().contains(monster.getM_number()) )  {
			view4.setText("已抓取");
			view4.setBackgroundColor(Color.LTGRAY);
			view4.setClickable(false);
		}
		else {
			double latitudeDiff = Math.abs(monster.getM_latitude() - LoginUserInfo.getInstance().getLastLatitude());
			double longitudeDiff =  Math.abs(monster.getM_longitude() - LoginUserInfo.getInstance().getLastLongitude());
			if ( latitudeDiff <= CommonSetting.accuracy/2.00 && longitudeDiff <= CommonSetting.accuracy/2.00 ) {
				view4.setText("抓取");
				view4.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if ( LoginUserInfo.getInstance().getLoginUserHandBook() != null && LoginUserInfo.getInstance().getLoginUserHandBook().contains(monster.getM_number()) ) {
							new AlertDialog.Builder(getActivity()).setTitle("提示")
							.setMessage("该精灵您已抓取过！")
							.setPositiveButton("确定", null).show();
							view4.setText("已抓取");
							view4.setClickable(false);
							return;
						}
						dialog = ProgressDialog.show(getActivity(), "请稍等", "正在操作中...", true);
						new Thread() {
							public void run() {
								UserDao userDao = new UserDao();
								int result = userDao.catchMonster(LoginUserInfo.getInstance().getLoginUser().getU_id(), monster.getM_id());
								Message msg = new Message();
								if ( result == 1 ) {
									msg.what = 1;
									msg.obj = view4; 
									
									//更新本地用户数据！！！！
									LoginUserInfo loginUserInfo = LoginUserInfo.getInstance();
									if (loginUserInfo != null) {
										String loginUserID = loginUserInfo.getLoginUser().getU_login_id();
										UserBean loginUser = userDao.getUserBean(loginUserID);
										loginUserInfo.setLoginUser(loginUser);
										
										loginUserInfo.setCurRank(userDao.getUserRank(loginUserID));
										
										List<UserBean> topRank = userDao.getTopRank();
										loginUserInfo.setTopRank(topRank);
										
										loginUserInfo.setLoginUserHandBook(userDao.getUserHandbook(loginUserID));
										
										loginUserInfo.setIllustratedHandbookFragment(new IllustratedHandbookFragment());
										
										MonsterDao monsterDao = new MonsterDao();
										List<MonsterBean> localMonsters = monsterDao.getLocalMonster(loginUserInfo.getLastLongitude(), loginUserInfo.getLastLatitude(), CommonSetting.accuracy);
										if ( localMonsters != null )
											loginUserInfo.setLocalMonsters(localMonsters);
									}
								}
								else 
									msg.what = 0;
								handler.sendMessage(msg);
							}
						}.start();
					}});
			}
			else {
				view4.setText("距离太远");
				view4.setBackgroundColor(Color.LTGRAY);
				view4.setClickable(false);
			}
		}
		row.addView(view4);

		
		TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(  
                ViewGroup.LayoutParams.WRAP_CONTENT,  
                ViewGroup.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(0, 0, 0, 20);
		localMonsterTable.addView(row, layoutParams);
	}
	
	private void addOneViewStyle(TextView textView) {
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(20);
	}
}
