package com.example.demo.study.object;

public class GeometricTest {

    public static void main(String[] args) {

        GeometricTest test = new GeometricTest();

        Circle c1 = new Circle(2.3, "white", 1.0);
        test.displayGeometricObject(c1);
        Circle c2 = new Circle(2.3, "white", 1.0);
        test.displayGeometricObject(c2);

        System.out.println(test.equalsArea(c1, c2));

    }

     public void displayGeometricObject(GeometricObject o){
         System.out.println("面积是：" + o.findArea());
     }

    // 测试两个对象的面积是否相当
    public boolean equalsArea(GeometricObject o1, GeometricObject o2){
        return o1.findArea() == o2.findArea();
    }

}

class GeometricObject{ //几何图形

    protected String color;
    protected double weight;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public double findArea(){
        return 0.0;
    }

}

class Circle extends GeometricObject{

    protected double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, double weight) {
        super(color, weight);
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return 3.14 * radius * radius;
    }
}

class MyRectangle extends GeometricObject{

    private double width;
    private double heigth;

    public MyRectangle(double width, double heigth, String color, double weight) {
        super(color, weight);
        this.width = width;
        this.heigth = heigth;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeigth() {
        return heigth;
    }

    public void setHeigth(double heigth) {
        this.heigth = heigth;
    }

    @Override
    public double findArea() {
        return width * heigth;
    }
}

