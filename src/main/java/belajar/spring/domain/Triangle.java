package belajar.spring.domain;

public class Triangle {
	
	private String type;

	public void draw(){
		System.out.println("menggambar bentuk segitiga");
	}
	
	public void getTriangleType(){
		System.out.println("bentuk Segitiga adalah "+getType());
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
