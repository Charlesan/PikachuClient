package com.pikachu.slidingmenu.fragment;

import com.pikachu.activity.SlidingActivity;
import com.pikachu.res.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * 用于显示雷达界面的fragment
 * @author Wang Chao
 *
 */
public class RadarFragment extends Fragment{
	
	private Button radarHeadButton;
	
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.radar_fragment, null);
		radarHeadButton = (Button)view.findViewById(R.id.radarHeadButton);
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
}
