package com.ys.workdaily.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * @author YuanShuai E-mail:shyuanshuai@163.com
 * @date 2016年6月2日 下午9:27:32
 *
 */
public class DateTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String value;

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 自定义JSTL标签，将long类型转换成date类型
	 * 
	 * @author YuanShuai E-mail:shyuanshuai@163.com
	 * @date 2016年6月2日 下午9:27:13 (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		String vv = "" + value;
		long time = Long.valueOf(vv);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = dateformat.format(c.getTime());
		try {
			pageContext.getOut().write(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}

}
