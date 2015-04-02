/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * 
 * @author 网络1201班 邱焕妍 正向最大匹配算法
 */
public class 邱欢艳 {

	int m_maxLen;
	int m_posIndex;
	String m_result = " ";
	HashSet<String> set;

	public 邱欢艳(int MaxLen) throws FileNotFoundException, IOException {
		m_maxLen = MaxLen;
		m_posIndex = 0;
		set = new HashSet<String>();
		BufferedReader buff = new BufferedReader(new InputStreamReader(
				new FileInputStream("F://ChineseDic.txt"), "GBK"));
		for (String line = buff.readLine(); line != null; line = buff
				.readLine()) { // while (!buff.readLine().isEmpty())
			set.add(line.split(",")[0]);
		}
		buff.close();
	}

	// 正向最大匹配算法
	public void MM(String source, int len, int frompos) throws IOException {

		if (m_posIndex >= source.length() - 1) {
			return;
		}
		String tmp;
		tmp = SubString(source, len, frompos);

		if (Match(tmp)) { // 匹配
			m_result = m_result + tmp + "/";
			m_posIndex = m_posIndex + m_maxLen;
			m_maxLen = 3;
			MM(source, m_maxLen, m_posIndex);
		} else { // 不匹配
			if (m_maxLen > 1) {
				m_maxLen = m_maxLen - 1;
				MM(source, m_maxLen, m_posIndex);
			} else {
				m_result = m_result + "字典中没有'" + tmp + "'字/";
				m_posIndex = m_posIndex + 1;
				m_maxLen = 3;
				MM(source, m_maxLen, m_posIndex);
			}

		}
	}

	public String SubString(String source, int len, int frompos) {
		// 还需做判断，若所取的最大的字符数已经超过了源串剩下的子串，则处理。
		String tmp;
		int sxLen, Len;
		sxLen = source.length() - frompos; // 剩下的子串的长度
		if (len > sxLen) { // 所取长度大于剩下字串的长度
			Len = sxLen;
		} else {
			Len = len;
		}
		tmp = source.substring(frompos, frompos + Len);
		return tmp;
	}

	// 取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误

	public boolean Match(String str) {
		// if(set.contains(str)) return true;
		// else return false ;
		return set.contains(str);
	}

	public static void main(String args[]) throws IOException {
		Runtime run = Runtime.getRuntime(); 
		long s = System.currentTimeMillis();
		System.out.println(run.totalMemory());
		邱欢艳 mm = new 邱欢艳(3);
		String conString = "幼儿园地节目取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误取出了子串str后，就要打开文本文件（字典D），循环读取字典D中有否该子串，有则返回正确，否则返回错误";
		mm.MM(conString, 3, 0);
		System.out.println(mm.m_result);
		System.out.println(conString.length());
		long e = System.currentTimeMillis();
		System.out.println(e - s);
		bufferLoop: for (;;) {
			for (;;) {
				break bufferLoop;
			}
		}
		System.out.println(run.totalMemory());
	}
}
