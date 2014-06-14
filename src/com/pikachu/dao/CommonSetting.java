package com.pikachu.dao;

public class CommonSetting {
	
	public final static double accuracy = 0.048;
	
	final static String MYURL = "http://blaveam.sinaapp.com/pikachu/";
	static String[] strMonsterName = new String[152]; //151Ö»¾«Áé
	
	public static String getMonsterNameByNumber(int num)
	{
		if (num>=1 && num <=151)
			return strMonsterName[num];
		else
			return "È±Ê¡";
	}
	
	static
	{
		
		strMonsterName[0] = "";
		strMonsterName[1] = "ÃîÍÜÖÖ×Ó";
		strMonsterName[2] = "ÃîÍÜ²İ";
		strMonsterName[3] = "ÃîÍÜ»¨";
		strMonsterName[4] = "Ğ¡»ğÁú";
		strMonsterName[5] = "»ğ¿ÖÁú";
		strMonsterName[6] = "Åç»ğÁú";
		strMonsterName[7] = "½ÜÄá¹ê";
		strMonsterName[8] = "¿¨ßä¹ê";
		strMonsterName[9] = "Ë®¼ı¹ê";
		strMonsterName[10] = "ÂÌÃ«³æ";
		strMonsterName[11] = "Ìú¼×Ó¼";
		strMonsterName[12] = "°Í´óºû";
		strMonsterName[13] = "¶À½Ç³æ";
		strMonsterName[14] = "Ìú¿ÇÀ¥";
		strMonsterName[15] = "´óÕë·ä";
		strMonsterName[16] = "²¨²¨";
		strMonsterName[17] = "±È±ÈÄñ";
		strMonsterName[18] = "±Èµñ";
		strMonsterName[19] = "Ğ¡À­´ï";
		strMonsterName[20] = "À­´ï";
		strMonsterName[21] = "ÁÒÈ¸";
		strMonsterName[22] = "´ó×ìÈ¸";
		strMonsterName[23] = "°¢°ØÉß";
		strMonsterName[24] = "°¢°Ø¹Ö";
		strMonsterName[25] = "Æ¤¿¨Çğ";
		strMonsterName[26] = "À×Çğ";
		strMonsterName[27] = "´©É½Êó";
		strMonsterName[28] = "´©É½Íõ";
		strMonsterName[29] = "Äá¶àÀ¼";
		strMonsterName[30] = "Äá¶àÄÈ";
		strMonsterName[31] = "Äá¶à";
		strMonsterName[32] = "Äá¶àÀÊ";
		strMonsterName[33] = "Äá¶àÁ¦Åµ";
		strMonsterName[34] = "Äá¶àÍõ";
		strMonsterName[35] = "Æ¤Æ¤";
		strMonsterName[36] = "Æ¤Î÷";
		strMonsterName[37] = "ÁùÎ²";
		strMonsterName[38] = "¾ÅÎ²";
		strMonsterName[39] = "ÅÖ¶¡";
		strMonsterName[40] = "ÅÖ¶¡";
		strMonsterName[41] = "³¬Òôòğ";
		strMonsterName[42] = "´ó×ìòğ";
		strMonsterName[43] = "×ßÂ·²İ";
		strMonsterName[44] = "³ô³ô»¨";
		strMonsterName[45] = "°ÔÍõ»¨";
		strMonsterName[46] = "ÅÉÀ­Ë¹";
		strMonsterName[47] = "ÅÉÀ­Ë¹ÌØ";
		strMonsterName[48] = "Ã«Çò";
		strMonsterName[49] = "Ä©Èë¶ê";
		strMonsterName[50] = "µØÊó";
		strMonsterName[51] = "ÈıµØÊó";
		strMonsterName[52] = "ß÷ß÷";
		strMonsterName[53] = "Ã¨ÀÏ´ó";
		strMonsterName[54] = "´ïÑ¼";
		strMonsterName[55] = "¸ç´ïÑ¼";
		strMonsterName[56] = "ºï¹Ö";
		strMonsterName[57] = "»ğ±¬ºï";
		strMonsterName[58] = "¿¨µÙ¹·";
		strMonsterName[59] = "·çËÙ¹·";
		strMonsterName[60] = "ÎÃÏãòòò½";
		strMonsterName[61] = "ÎÃÏãÍÜ";
		strMonsterName[62] = "¿ìÓ¾ÍÜ";
		strMonsterName[63] = "¿­Î÷";
		strMonsterName[64] = "ÓÂ¼ªÀ­";
		strMonsterName[65] = "ºúµØ";
		strMonsterName[66] = "ÍóÁ¦";
		strMonsterName[67] = "ºÀÁ¦";
		strMonsterName[68] = "¹ÖÁ¦";
		strMonsterName[69] = "À®°ÈÑ¿";
		strMonsterName[70] = "¿Ú´ô»¨";
		strMonsterName[71] = "´óÊ³»¨";
		strMonsterName[72] = "Âêè§Ë®Ä¸";
		strMonsterName[73] = "¶¾´ÌË®Ä¸";
		strMonsterName[74] = "Ğ¡È­Ê¯";
		strMonsterName[75] = "Â¡Â¡Ê¯";
		strMonsterName[76] = "Â¡Â¡ÑÒ";
		strMonsterName[77] = "Ğ¡»ğÂí";
		strMonsterName[78] = "ÁÒÑæÂí";
		strMonsterName[79] = "´ô´ôÊŞ";
		strMonsterName[80] = "´ôºÓÂí";
		strMonsterName[81] = "Ğ¡´Å¹Ö";
		strMonsterName[82] = "ÈıºÏ´Å¹Ö";
		strMonsterName[83] = "´ó´ĞÑ¼";
		strMonsterName[84] = "à½à½";
		strMonsterName[85] = "à½à½Àû";
		strMonsterName[86] = "Ğ¡º£Ê¨";
		strMonsterName[87] = "°×º£Ê¨";
		strMonsterName[88] = "³ôÄà";
		strMonsterName[89] = "³ô³ôÄà";
		strMonsterName[90] = "´óÉà±´";
		strMonsterName[91] = "Ìú¼×±´";
		strMonsterName[92] = "¹íË¹";
		strMonsterName[93] = "¹íË¹Í¨";
		strMonsterName[94] = "¹¢¹í";
		strMonsterName[95] = "´óÑÒÉß";
		strMonsterName[96] = "ËØÀûÆÕ";
		strMonsterName[97] = "ËØÀûÅÄ";
		strMonsterName[98] = "´óÇ¯Ğ·";
		strMonsterName[99] = "¾ŞÇ¯Ğ·";
		strMonsterName[100] = "À×µçÇò";
		strMonsterName[101] = "ÍçÆ¤µ¯";
		strMonsterName[102] = "µ°µ°";
		strMonsterName[103] = "Ò¬µ°Ê÷";
		strMonsterName[104] = "À­À­";
		strMonsterName[105] = "àÄÀ­àÄÀ­";
		strMonsterName[106] = "É³ÍßÀÉ";
		strMonsterName[107] = "°¬±ÈÀÉ";
		strMonsterName[108] = "´óÉàÍ·";
		strMonsterName[109] = "ÍßË¹µ¯";
		strMonsterName[110] = "Ë«µ¯ÍßË¹";
		strMonsterName[111] = "Ìú¼×Ï¬Å£";
		strMonsterName[112] = "Ìú¼×±©Áú";
		strMonsterName[113] = "¼ªÀûµ°";
		strMonsterName[114] = "ÂûÌÙ¹Ö";
		strMonsterName[115] = "´üÁú";
		strMonsterName[116] = "Ä«º£Âí";
		strMonsterName[117] = "º£´ÌÁú";
		strMonsterName[118] = "½Ç½ğÓã";
		strMonsterName[119] = "½ğÓãÍõ";
		strMonsterName[120] = "º£ĞÇĞÇ";
		strMonsterName[121] = "±¦Ê¯º£ĞÇ";
		strMonsterName[122] = "ÎüÅÌÄ§Å¼";
		strMonsterName[123] = "·ÉÌìó«òë";
		strMonsterName[124] = "ÃÔ´½æ¢";
		strMonsterName[125] = "µç»÷ÊŞ";
		strMonsterName[126] = "Ñ¼×ì»ğÁú";
		strMonsterName[127] = "´ó¼×";
		strMonsterName[128] = "¿ÏÌ©ÂŞ";
		strMonsterName[129] = "ÀğÓãÍõ";
		strMonsterName[130] = "±©ÀğÁú";
		strMonsterName[131] = "³ËÁú";
		strMonsterName[132] = "°Ù±ä¹Ö";
		strMonsterName[133] = "ÒÁ²¼";
		strMonsterName[134] = "Ë®¾«Áé";
		strMonsterName[135] = "À×¾«Áé";
		strMonsterName[136] = "»ğ¾«Áé";
		strMonsterName[137] = "3DÁú";
		strMonsterName[138] = "¾ÕÊ¯ÊŞ";
		strMonsterName[139] = "¶à´Ì¾ÕÊ¯ÊŞ";
		strMonsterName[140] = "»¯Ê¯¿ø";
		strMonsterName[141] = "Á­µ¶¿ø";
		strMonsterName[142] = "»¯Ê¯ÒíÁú";
		strMonsterName[143] = "¿¨±ÈÊŞ";
		strMonsterName[144] = "¼±¶³Äñ";
		strMonsterName[145] = "ÉÁµçÄñ";
		strMonsterName[146] = "»ğÑæÄñ";
		strMonsterName[147] = "ÃÔÁú";
		strMonsterName[148] = "¹ş¿ËÁú";
		strMonsterName[149] = "¿ìÁú";
		strMonsterName[150] = "³¬ÃÎ";
		strMonsterName[151] = "ÃÎ»Ã";

	}

}
