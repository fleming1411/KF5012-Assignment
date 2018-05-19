
public class JobsArray {
	private boolean complete, care1, care2, care3, care4, care5, care6;
	private String jobDesc;
	
	public JobsArray(boolean complete, String jobDesc, boolean care1,
			boolean care2, boolean care3, boolean care4, boolean care5,
			boolean care6) {
		this.complete=complete;
		this.jobDesc=jobDesc;
		this.care1=care1;
		this.care2=care2;
		this.care3=care3;
		this.care4=care4;
		this.care5=care5;
		this.care6=care6;
	}
	
	public boolean getComplete() {
		return complete;
	}
	
	public String getJobDesc() {
		return jobDesc;
	}
	
	public boolean getCare1() {
		return care1;
	}
	
	public boolean getCare2() {
		return care2;
	}
	
	public boolean getCare3() {
		return care3;
	}
	
	public boolean getCare4() {
		return care4;
	}
	
	public boolean getCare5() {
		return care5;
	}
	
	public boolean getCare6() {
		return care6;
	}
}
