package com.sensin.sensitive.filter.test;

import com.sensin.sensitive.filter.WordFilter;
import org.junit.Test;

import java.util.Arrays;

/**
 *  测试 敏感词过滤
 *
 * @author hewen
 * @date 2019/8/22 10:29
 */
public class TestSensitiveWdFilter {

	@Test
	public void TestFilter() {
		String str = "就是这样";
		WordFilter WordFilter = new WordFilter();
		String s = "你是逗比吗？ｆｕｃｋ！fUcK,你竟然用法轮功，法@!轮!%%%功," + str;
		System.out.println("解析问题： " + s);
		System.out.println("解析字数 : " + s.length());
		String re;
		long nano = System.nanoTime();
		re = WordFilter.doFilter(s);
		nano = (System.nanoTime() - nano);
		System.out.println("解析时间 : " + nano + "ns");
		System.out.println("解析时间 : " + nano / 1000000 + "ms");
		System.out.println(re);
		System.out.println();

		nano = System.nanoTime();
		System.out.println("是否包含敏感词： " + WordFilter.isContains(s));
		nano = (System.nanoTime() - nano);
		System.out.println("解析时间 : " + nano + "ns");
		System.out.println("解析时间 : " + nano / 1000000 + "ms");

		//加入自定义词汇
		WordFilter.addSensitiveWord(Arrays.asList(str,"？"));
		re = WordFilter.doFilter(s);
		System.out.println("自定义词汇最终版: " + re);

	}

}
