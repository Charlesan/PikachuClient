package com.pikachu.activity;

import com.pikachu.dao.UserDao;
import com.pikachu.res.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
				String name = edname1.getText().toString();
				String password = edpassword1.getText().toString();
				String nickname = ednickname.getText().toString();
				if (!(name.equals("") && password.equals("") && nickname.equals(""))) {
					UserDao userDao = new UserDao();
					if ( userDao.register(name, password, nickname) == 1 ) {
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
					else {
						// 弹出消息框
						new AlertDialog.Builder(RegistersActivity.this).setTitle("错误")
								.setMessage("注册失败！请重新输入。")
								.setPositiveButton("确定", null).show();
					}
				} else {
					new AlertDialog.Builder(RegistersActivity.this)
							.setTitle("帐号密码昵称不能为空").setMessage("帐号密码昵称不能为空")
							.setPositiveButton("确定", null);
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
