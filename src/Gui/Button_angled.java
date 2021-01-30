package Gui;

import javafx.scene.image.Image;

public class Button_angled {

	private int x1, x2, x3, x4, x5, x6, y1, y2, width, height;
	private String text="";
	private boolean isHover;
	private Image image;
	
	public Button_angled(int x1, int y1, int width, int height) {
		super();
		this.x1 = x1;
		this.y1 = y1;
		this.width = width;
		this.height = height;
		
		//Button Position festlegen
		x2 = this.x1 + this.width / 2 + 15;
		x3 = x2 + 15;
		x4 = this.x1 + this.width;
		x5 = x2 - 40;
		x6 = x2 - 25;
		
		y2 = this.y1 + this.height;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getX3() {
		return x3;
	}

	public void setX3(int x3) {
		this.x3 = x3;
	}

	public int getX4() {
		return x4;
	}

	public void setX4(int x4) {
		this.x4 = x4;
	}

	public int getX5() {
		return x5;
	}

	public void setX5(int x5) {
		this.x5 = x5;
	}

	public int getX6() {
		return x6;
	}

	public void setX6(int x6) {
		this.x6 = x6;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isHover() {
		return isHover;
	}

	public void setHover(boolean isHover) {
		this.isHover = isHover;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	
	
}
