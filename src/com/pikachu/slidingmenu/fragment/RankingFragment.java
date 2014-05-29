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
 * 用于显示排名的fragment
 * @author Wang Chao
 *
 */
public class RankingFragment extends Fragment{
	
	private Button rankingButton;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ranking_fragment, null);
		rankingButton = (Button)view.findViewById(R.id.rankingHeadButton);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		rankingButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((SlidingActivity) getActivity()).showLeft();
			}});
	}
}
