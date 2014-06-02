package com.pikachu.util;

import java.lang.reflect.Field;

import com.pikachu.res.R;

/**
 * 工具集类
 * 
 * @author Wang Chao
 * 
 */
public class Utils {
	public static int getImageID(String imageName) {
		Class draw = R.drawable.class;

		try {
			Field field = draw.getDeclaredField(imageName);
			return field.getInt(imageName);
		} catch (Exception e) {
			return R.drawable.ic_launcher;
		}
	}
}
