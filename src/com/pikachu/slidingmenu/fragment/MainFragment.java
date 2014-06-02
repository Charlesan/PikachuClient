package com.pikachu.slidingmenu.fragment;

import com.pikachu.activity.SlidingActivity;
import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.UserBean;
import com.pikachu.res.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * 用于显示用户个人信息的fragment
 * @author Wang Chao
 *
 */
public class MainFragment extends Fragment {
	
	private Button mainFragmentHeadButton;
	
	private TextView idTextView;
	private TextView nickNameTextView;
	private TextView achievementTextView;
	private TextView scoreTextView;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.main_fragment, null);
		mainFragmentHeadButton = (Button)view.findViewById(R.id.mainFragmentHeadButton);
		
		UserBean loginUser = LoginUserInfo.getInstance().getLoginUser();
		idTextView = (TextView) view.findViewById(R.id.txtid2);
		nickNameTextView = (TextView) view.findViewById(R.id.txtnickname2);
		achievementTextView = (TextView) view.findViewById(R.id.txtachievement2);
		scoreTextView = (TextView) view.findViewById(R.id.txtscore2);
		idTextView.setText(loginUser.getU_login_id());
		nickNameTextView.setText(loginUser.getU_name());
		achievementTextView.setText(loginUser.getU_number() + "只精灵");
		scoreTextView.setText(loginUser.getU_mark() + "");
		
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		mainFragmentHeadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((SlidingActivity) getActivity()).showLeft();
			}});
	}

}
