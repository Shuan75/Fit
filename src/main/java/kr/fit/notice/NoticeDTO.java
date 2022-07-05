package kr.fit.notice;

public class NoticeDTO {

	private int bbs_num;
	private String bbs_diff;
	private int bbs_grpno;
	private int bbs_indent;
	private int bbs_ansnum;
	private String bbs_cdate;	
    private String bbs_title;
    private String bbs_contents;
    private String bbs_id;
    private String bbs_rating;
    
    public NoticeDTO() {
    	
    }

	public int getBbs_num() {
		return bbs_num;
	}

	public void setBbs_num(int bbs_num) {
		this.bbs_num = bbs_num;
	}

	public String getBbs_diff() {
		return bbs_diff;
	}

	public void setBbs_diff(String bbs_diff) {
		this.bbs_diff = bbs_diff;
	}

	public int getBbs_grpno() {
		return bbs_grpno;
	}

	public void setBbs_grpno(int bbs_grpno) {
		this.bbs_grpno = bbs_grpno;
	}

	public int getBbs_indent() {
		return bbs_indent;
	}

	public void setBbs_indent(int bbs_indent) {
		this.bbs_indent = bbs_indent;
	}

	public int getBbs_ansnum() {
		return bbs_ansnum;
	}

	public void setBbs_ansnum(int bbs_ansnum) {
		this.bbs_ansnum = bbs_ansnum;
	}

	public String getBbs_cdate() {
		return bbs_cdate;
	}

	public void setBbs_cdate(String bbs_cdate) {
		this.bbs_cdate = bbs_cdate;
	}

	public String getBbs_title() {
		return bbs_title;
	}

	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}

	public String getBbs_contents() {
		return bbs_contents;
	}

	public void setBbs_contents(String bbs_contents) {
		this.bbs_contents = bbs_contents;
	}

	public String getBbs_id() {
		return bbs_id;
	}

	public void setBbs_id(String bbs_id) {
		this.bbs_id = bbs_id;
	}

	public String getBbs_rating() {
		return bbs_rating;
	}

	public void setBbs_rating(String bbs_rating) {
		this.bbs_rating = bbs_rating;
	}

	@Override
	public String toString() {
		return "NoticeDTO [bbs_num=" + bbs_num + ", bbs_diff=" + bbs_diff + ", bbs_grpno=" + bbs_grpno + ", bbs_indent="
				+ bbs_indent + ", bbs_ansnum=" + bbs_ansnum + ", bbs_cdate=" + bbs_cdate + ", bbs_title=" + bbs_title
				+ ", bbs_contents=" + bbs_contents + ", bbs_id=" + bbs_id + ", bbs_rating=" + bbs_rating + "]";
	}
    
    
	
}
