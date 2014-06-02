package com.pikachu.slidingmenu.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

import com.pikachu.activity.SlidingActivity;
import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.UserBean;
import com.pikachu.res.R;

public class LeftFragment extends Fragment implements OnClickListener {

	private Button mainFragmentButton;
	private Button radarButton;
	private Button cameraButton;
	private Button illustratedHandbookButton;
	private Button myRankingButton;
	private Button settingButton;
	private Button exitButton;
	
	//用于记录当前被点击的侧边栏按钮
	private Button currentButton;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.left, null);
		
		UserBean loginUser = LoginUserInfo.getInstance().getLoginUser();
		TextView name_textview = (TextView)view.findViewById(R.id.name_textview);
		name_textview.setText(loginUser.getU_login_id());
		TextView grade_textview = (TextView)view.findViewById(R.id.grade_textview);
		grade_textview.setText(loginUser.getU_name());

		mainFragmentButton = (Button) view
				.findViewById(R.id.main_fragment_button);
		radarButton = (Button) view
				.findViewById(R.id.radar_button);
		cameraButton = (Button) view.findViewById(R.id.camera_button);
		illustratedHandbookButton = (Button) view.findViewById(R.id.illustrated_handbook_button);
		myRankingButton = (Button) view.findViewById(R.id.my_ranking_button);
		settingButton = (Button) view.findViewById(R.id.setting_button);
		exitButton = (Button) view.findViewById(R.id.exit_button);

		mainFragmentButton.setBackgroundColor(Color.GRAY);
		currentButton = mainFragmentButton;

		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		mainFragmentButton.setOnClickListener(this);
		radarButton.setOnClickListener(this);
		cameraButton.setOnClickListener(this);
		illustratedHandbookButton.setOnClickListener(this);
		myRankingButton.setOnClickListener(this);
		settingButton.setOnClickListener(this);
		exitButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		FragmentManager fm = getFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		switch (view.getId()) {

		case R.id.main_fragment_button:
			currentButton.setBackgroundColor(Color.TRANSPARENT);
			currentButton = mainFragmentButton;
			mainFragmentButton.setBackgroundColor(Color.GRAY);
			((SlidingActivity) getActivity()).showLeft();
			ft.replace(R.id.center_frame, new MainFragment());
			break;
		case R.id.radar_button:
			currentButton.setBackgroundColor(Color.TRANSPARENT);
			currentButton = radarButton;
			radarButton.setBackgroundColor(Color.GRAY);
			((SlidingActivity) getActivity()).showLeft();
			ft.replace(R.id.center_frame, new RadarFragment());
			break;
		case R.id.camera_button:
			currentButton.setBackgroundColor(Color.TRANSPARENT);
			currentButton = cameraButton;
			cameraButton.setBackgroundColor(Color.GRAY);
			((SlidingActivity) getActivity()).showLeft();
			ft.replace(R.id.center_frame, new CameraFragment());
			break;
		case R.id.illustrated_handbook_button:
			currentButton.setBackgroundColor(Color.TRANSPARENT);
			currentButton = illustratedHandbookButton;
			illustratedHandbookButton.setBackgroundColor(Color.GRAY);
			((SlidingActivity) getActivity()).showLeft();
			ft.replace(R.id.center_frame, new IllustratedHandbookFragment());
			break;
		case R.id.my_ranking_button:
			currentButton.setBackgroundColor(Color.TRANSPARENT);
			currentButton = myRankingButton;
			myRankingButton.setBackgroundColor(Color.GRAY);
			((SlidingActivity) getActivity()).showLeft();
			ft.replace(R.id.center_frame, new RankingFragment());
			break;
		case R.id.setting_button:
			currentButton.setBackgroundColor(Color.TRANSPARENT);
			currentButton = settingButton;
			settingButton.setBackgroundColor(Color.GRAY);
			((SlidingActivity) getActivity()).showLeft();
			ft.replace(R.id.center_frame, new SettingFragment());
			break;
		case R.id.exit_button:
			currentButton.setBackgroundColor(Color.TRANSPARENT);
			currentButton = exitButton;
			exitButton.setBackgroundColor(Color.GRAY);
			// 弹出消息框
			AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
			builder.setMessage("您确定要退出应用？")
					.setCancelable(false)
					.setPositiveButton("是",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									getActivity().finish();
								}
							})
					.setNegativeButton("否",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									dialog.cancel();
								}
							});
			builder.show();
			break;
		default:
			break;
		}
		// 不要忘记提交
		ft.commit();

	}

	public Button getMainFragmentButton() {
		return mainFragmentButton;
	}

	public void setMainFragmentButton(Button mainFragmentButton) {
		this.mainFragmentButton = mainFragmentButton;
	}
	
	
}
