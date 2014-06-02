package com.pikachu.activity;

import java.util.List;

import com.pikachu.bean.LoginUserInfo;
import com.pikachu.bean.UserBean;
import com.pikachu.dao.UserDao;
import com.pikachu.res.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegistersActivity extends Activity {
	private EditText edname1;
	private EditText edpassword1;
	private EditText ednickname;
	private Button btregister1;
	private Button btreturn;
	
	public ProgressDialog dialog = null;
	
	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			if ( msg.what == 1 ) {
				dialog.dismiss();
				new AlertDialog.Builder(RegistersActivity.this)
				.setTitle("注册成功").setMessage("注册成功")
				.setPositiveButton("确定", null).show();
				
				// 弹出消息框
				AlertDialog.Builder builder = new AlertDialog.Builder(RegistersActivity.this);
				builder.setTitle("提示")
						.setMessage("恭喜您，注册成功！")
						.setCancelable(false)
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog, int id) {
										// 跳转到登录界面
										Intent in = new Intent();
										in.setClass(RegistersActivity.this, LoginActivity.class);
										startActivity(in);
										// 销毁当前activity
										RegistersActivity.this.onDestroy();
									}
								});
				builder.show();
			}
			else if ( msg.what == 0 ) {
				dialog.dismiss();
				// 弹出消息框
				new AlertDialog.Builder(RegistersActivity.this).setTitle("错误")
						.setMessage("您输入的账号或昵称已存在！请重新输入。")
						.setPositiveButton("确定", null).show();
			}
			else {
				dialog.dismiss();
				// 弹出消息框
				new AlertDialog.Builder(RegistersActivity.this).setTitle("错误")
						.setMessage("注册失败，请检查您的网络！")
						.setPositiveButton("确定", null).show();
			}
		}
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		edname1 = (EditText) findViewById(R.id.edname1);
		edpassword1 = (EditText) findViewById(R.id.edpassword1);
		ednickname = (EditText) findViewById(R.id.ednickname);
		btregister1 = (Button) findViewById(R.id.btregister1);
		btreturn = (Button) findViewById(R.id.btreturn);
		
		btregister1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String name = edname1.getText().toString();
				final String password = edpassword1.getText().toString();
				final String nickname = ednickname.getText().toString();
				if (!(name.equals("") && password.equals("") && nickname.equals(""))) {
					dialog = ProgressDialog.show(RegistersActivity.this, "请稍等", "提交数据中...", true);
					new Thread() {
						public void run() {
							UserDao userDao = new UserDao();
							int result = userDao.register(name, password, nickname);
							Message msg = new Message();
							if ( result == 1 ) {
								msg.what = 1;
							}
							else if ( result == 3 ) {
								msg.what = 0;
							}
							else {
								msg.what = -1;
							}
							handler.sendMessage(msg);
						}
					}.start();
				} else {
					new AlertDialog.Builder(RegistersActivity.this)
							.setTitle("帐号密码昵称不能为空").setMessage("帐号密码昵称不能为空")
							.setPositiveButton("确定", null).show();
				}

			}
		});
		
		btreturn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// 跳转到登录界面
				Intent in = new Intent();
				in.setClass(RegistersActivity.this, LoginActivity.class);
				startActivity(in);
				// 销毁当前activity
				RegistersActivity.this.onDestroy();
			}
		});
	}
}
