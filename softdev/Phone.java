package project;

import java.io.Serializable;

public class Phone implements Serializable{
	private String make;
	private String model;
	private int memory;
	private double camera;
	private double screenSize;
	private String smart;
	private int price;
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getMemory() {
		return memory;
	}
	public void setMemory(int memory) {
		this.memory = memory;
	}
	public double getCamera() {
		return camera;
	}
	public void setCamera(double camera) {
		this.camera = camera;
	}
	public double getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}
	public String getSmart() {
		return smart;
	}
	public void setSmart(String smart) {
		this.smart = smart;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Phone(String make, String model, int memory, double camera, double screenSize, String smart, int price) {
		super();
		this.make = make;
		this.model = model;
		this.memory = memory;
		this.camera = camera;
		this.screenSize = screenSize;
		this.smart = smart;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Make: "+this.make + "Model: "+this.model + "memory: "+this.memory + "camera: "+this.camera + "screenSize: "+this.screenSize + "smart: "+this.smart + "price: "+this.price; 
	}
	
}
