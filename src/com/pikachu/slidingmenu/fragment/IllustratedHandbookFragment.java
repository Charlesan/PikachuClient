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
 * 用于显示图鉴的fragment
 * @author Wang Chao
 *
 */
public class IllustratedHandbookFragment extends Fragment{
	
	private Button illustratedHandbookHeadButton;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.illustrated_handbook_fragment, null);
		illustratedHandbookHeadButton = (Button)view.findViewById(R.id.illustratedHandbookHeadButton);
		return view;
	}

	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		illustratedHandbookHeadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((SlidingActivity) getActivity()).showLeft();
			}});
	}
}
