package kr.fit.login;

public class CalDTO {

	private int c_num;
	private String C_title;
	private String C_id;
	private String C_start;
	private String C_end;
	private String C_URL;
	private String C_con;
	private String C_allday;

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public String getC_title() {
		return C_title;
	}

	public void setC_title(String c_title) {
		C_title = c_title;
	}

	public String getC_id() {
		return C_id;
	}

	public void setC_id(String c_id) {
		C_id = c_id;
	}

	public String getC_start() {
		return C_start;
	}

	public void setC_start(String c_start) {
		C_start = c_start;
	}

	public String getC_end() {
		return C_end;
	}

	public void setC_end(String c_end) {
		C_end = c_end;
	}

	public String getC_URL() {
		return C_URL;
	}

	public void setC_URL(String c_URL) {
		C_URL = c_URL;
	}

	public String getC_con() {
		return C_con;
	}

	public void setC_con(String c_con) {
		C_con = c_con;
	}

	public String getC_allday() {
		return C_allday;
	}

	public void setC_allday(String c_allday) {
		C_allday = c_allday;
	}

	@Override
	public String toString() {
		return "CalDTO [c_num=" + c_num + ", C_title=" + C_title + ", C_id=" + C_id + ", C_start=" + C_start
				+ ", C_end=" + C_end + ", C_URL=" + C_URL + ", C_con=" + C_con + ", C_allday=" + C_allday + "]";
	}

}
