package com.pikachu.bean;

import java.util.List;
import java.util.Set;

import com.pikachu.slidingmenu.fragment.IllustratedHandbookFragment;

public class LoginUserInfo {
	private UserBean loginUser;
	
	private int curRank;
	
	private List<UserBean> topRank;
	
	private Set<Integer> loginUserHandBook;
	
	private IllustratedHandbookFragment illustratedHandbookFragment;
	
	private List<MonsterBean> localMonsters;
	
	private double lastLongitude;
	private double lastLatitude;
	
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

	public Set<Integer> getLoginUserHandBook() {
		return loginUserHandBook;
	}

	public void setLoginUserHandBook(Set<Integer> loginUserHandBook) {
		this.loginUserHandBook = loginUserHandBook;
	}

	public IllustratedHandbookFragment getIllustratedHandbookFragment() {
		return illustratedHandbookFragment;
	}

	public void setIllustratedHandbookFragment(
			IllustratedHandbookFragment illustratedHandbookFragment) {
		this.illustratedHandbookFragment = illustratedHandbookFragment;
	}

	public List<MonsterBean> getLocalMonsters() {
		return localMonsters;
	}

	public void setLocalMonsters(List<MonsterBean> localMonsters) {
		this.localMonsters = localMonsters;
	}

	public double getLastLongitude() {
		return lastLongitude;
	}

	public void setLastLongitude(double lastLongitude) {
		this.lastLongitude = lastLongitude;
	}

	public double getLastLatitude() {
		return lastLatitude;
	}

	public void setLastLatitude(double lastLatitude) {
		this.lastLatitude = lastLatitude;
	}

	public int getCurRank() {
		return curRank;
	}

	public void setCurRank(int curRank) {
		this.curRank = curRank;
	}
	
}

