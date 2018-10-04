package spring;

public class BoaderFile {
	private String writeNum;
	private long filesize;
	private String originalFile;
	private String storedFileName;
	
	public BoaderFile(String writeNum, long filesize, String originalFile, String storedFileName) {
		this.writeNum = writeNum;
		this.filesize = filesize;
		this.originalFile = originalFile;
		this.storedFileName = storedFileName;
	}
	public String getWriteNum() {
		return writeNum;
	}
	public void setWriteNum(String writeNum) {
		this.writeNum = writeNum;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getOriginalFile() {
		return originalFile;
	}
	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
}
