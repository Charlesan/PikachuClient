package com.pikachu.bean;

import java.util.List;

public class LoginUserInfo {
	private UserBean loginUser;
	
	private List<UserBean> topRank;
	
	private volatile static LoginUserInfo loginUserInfo;
	
	public static LoginUserInfo getInstance() {
		if ( loginUserInfo == null ) {
			synchronized ( LoginUserInfo.class ) {
				if ( loginUserInfo == null ) {
					loginUserInfo = new LoginUserInfo();
				}
			}
		}
		
		return loginUserInfo;
	}

	public UserBean getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(UserBean loginUser) {
		this.loginUser = loginUser;
	}

	public List<UserBean> getTopRank() {
		return topRank;
	}

	public void setTopRank(List<UserBean> topRank) {
		this.topRank = topRank;
	}
	
}

