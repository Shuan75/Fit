package kr.fit.program;

public class ProgramDTO {

	private String c_code;
	private String c_name;
	private String c_price;
	private String c_level;
	private String c_period;
	private String c_day;
	private String c_time;
	private String c_id;
	private String u_name;
	private int c_total;
	private String c_content;

	public ProgramDTO() {
	}

	public String getC_code() {
		return c_code;
	}

	public void setC_code(String c_code) {
		this.c_code = c_code;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_price() {
		return c_price;
	}

	public void setC_price(String c_price) {
		this.c_price = c_price;
	}

	public String getC_level() {
		return c_level;
	}

	public void setC_level(String c_level) {
		this.c_level = c_level;
	}

	public String getC_period() {
		return c_period;
	}

	public void setC_period(String c_period) {
		this.c_period = c_period;
	}

	public String getC_day() {
		return c_day;
	}

	public void setC_day(String c_day) {
		this.c_day = c_day;
	}

	public String getC_time() {
		return c_time;
	}

	public void setC_time(String c_time) {
		this.c_time = c_time;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public int getC_total() {
		return c_total;
	}

	public void setC_total(int c_total) {
		this.c_total = c_total;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	@Override
	public String toString() {
		return "ProgramDTO [c_code=" + c_code + ", c_name=" + c_name + ", c_price=" + c_price + ", c_level=" + c_level
				+ ", c_period=" + c_period + ", c_day=" + c_day + ", c_time=" + c_time + ", c_id=" + c_id + ", u_name="
				+ u_name + ", c_total=" + c_total + ", c_content=" + c_content + "]";
	}
	
	

}// class end
