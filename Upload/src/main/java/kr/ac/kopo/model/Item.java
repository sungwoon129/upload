package kr.ac.kopo.model;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Item {
	String filename;
	long size;
	
	MultipartFile uploadFile;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {//uploadFile은 input태그의 name과 대소문자나 -_까지 완벽히 똑같아야한다
		this.uploadFile = uploadFile;
		filename = uploadFile.getOriginalFilename();
		size = uploadFile.getSize();
	}

	public boolean transferTo(String path) {
		if(uploadFile != null) {
			try { // commons-fileupload가 어딘가에 만들어 뒀을 어딘지 모르는 곳에서 우리가 저장할 곳으로 옮겨준다
				uploadFile.transferTo(new File( path + filename));
				
				return true;
			} catch (IllegalStateException e) { //파일이 열려있거나 잠겨있을 때 파일업로드를 할려하면 예외발생
				e.printStackTrace();
			} catch (IOException e) { //모든예외
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	
}
