package com.pikachu.slidingmenu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.pikachu.activity.SlidingActivity;
import com.pikachu.res.R;

/**
 * 用于捕捉精力的fragment
 * @author Wang Chao
 *
 */
public class SettingFragment extends Fragment{
	
	private Button settingButton;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.setting_fragment, null);
		settingButton = (Button)view.findViewById(R.id.settingHeadButton);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		settingButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((SlidingActivity) getActivity()).showLeft();
			}});
	}
}
