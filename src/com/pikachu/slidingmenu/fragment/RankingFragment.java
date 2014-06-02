package com.pikachu.slidingmenu.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pikachu.activity.SlidingActivity;
import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.UserBean;
import com.pikachu.res.R;

/**
 * 用于显示排名的fragment
 * @author Wang Chao
 *
 */
public class RankingFragment extends Fragment{
	
	private Button rankingButton;
	
	private TableLayout rankingTable;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.ranking_fragment, null);
		rankingButton = (Button)view.findViewById(R.id.rankingHeadButton);
		
		rankingTable = (TableLayout) view.findViewById(R.id.rankingTable);
		
		List<UserBean> topRank = LoginUserInfo.getInstance().getTopRank();
		for ( int i = 0; i < topRank.size(); i++ ) {
			addOneRow(i + 1, topRank.get(i));
		}
		
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
	
	private void addOneRow(int order, UserBean user) {
		TableRow row = new TableRow(getActivity());
		
		TextView view1 = new TextView(getActivity());
		addOneViewStyle(view1);
		view1.setText("" + order);
		TextView view2 = new TextView(getActivity());
		addOneViewStyle(view2);
		view2.setText(user.getU_name());
		TextView view3 = new TextView(getActivity());
		addOneViewStyle(view3);
		view3.setText("" + user.getU_number());
		TextView view4 = new TextView(getActivity());
		addOneViewStyle(view4);
		view4.setText("" + user.getU_mark());
		
		row.addView(view1);
		row.addView(view2);
		row.addView(view3);
		row.addView(view4);
		
		TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(  
                ViewGroup.LayoutParams.WRAP_CONTENT,  
                ViewGroup.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(0, 0, 0, 20);
		rankingTable.addView(row, layoutParams);
	}
	
	private void addOneViewStyle(TextView textView) {
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(15);
	}
}
