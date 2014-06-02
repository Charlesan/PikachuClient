package com.pikachu.slidingmenu.fragment;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.pikachu.activity.SlidingActivity;
import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.MonsterBean;
import com.pikachu.res.R;
import com.pikachu.util.Utils;

/**
 * 用于显示图鉴的fragment
 * @author Wang Chao
 *
 */
public class IllustratedHandbookFragment extends Fragment{
	
	private Button illustratedHandbookHeadButton;
	
	private TableLayout handbookTable;

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.illustrated_handbook_fragment, null);
		illustratedHandbookHeadButton = (Button)view.findViewById(R.id.illustratedHandbookHeadButton);
		
		handbookTable = (TableLayout)view.findViewById(R.id.handbookTable);
		List<MonsterBean> allMonsters = LoginUserInfo.getInstance().getAllMonster();
		for ( int i = 0; i < 20; i++ ) {
		for ( MonsterBean one : allMonsters ) {
			addOneRow(one);
		}
		}
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
	
	private void addOneRow(MonsterBean monster) {
		TableRow row = new TableRow(getActivity());
		
		TextView view1 = new TextView(getActivity());
		addOneViewStyle(view1);
		view1.setText("" + monster.getM_id());
		TextView view2 = new TextView(getActivity());
		addOneViewStyle(view2);
		view2.setText(monster.getM_name());
		
		ImageView view3 = new ImageView(getActivity());
//		TableRow.LayoutParams params = (TableRow.LayoutParams) view3.getLayoutParams();
//		params.width = 120;
//		params.height = 120;
//		view3.setLayoutParams( params ); 
		
//		view3.setLayoutParams(new TableRow.LayoutParams(500, 500));
		view3.setScaleType(ScaleType.FIT_CENTER);
		view3.setImageResource(Utils.getImageID("big_" + monster.getM_id()));
		
		row.addView(view1);
		row.addView(view2);
		row.addView(view3);
		
		TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(  
                ViewGroup.LayoutParams.WRAP_CONTENT,  
                ViewGroup.LayoutParams.WRAP_CONTENT);
		layoutParams.setMargins(0, 0, 0, 20);
		handbookTable.addView(row, layoutParams);
	}
	
	private void addOneViewStyle(TextView textView) {
		textView.setGravity(Gravity.CENTER);
		textView.setTextSize(20);
	}
}
