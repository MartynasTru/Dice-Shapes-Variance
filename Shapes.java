package Shapes;

import java.util.Scanner;

public class Shapes {
    //Shape class
    public abstract class Shape {
        public abstract String getName (); // no implementation
        public double getArea () {
            return 0;
        }
        public double getVolume () {
            return 0;
        }

        //Point class
    import java.util.Scanner;

        public class Point extends Shape{
            private float x, y; // coordinates, could also be public as there is nothing
            // to protect, private for consistency with Circle/Cylinder
            public Point () {
                x = 0; y = 0;
            }
            public Point (float xval, float yval) {
                x = xval; y = yval;
            }
            // get and set methods for the coordinates
            public float getX(Scanner s) {
                while (true) {
                    try {
                        System.out.println("insert any value for x point");
                        this.x = s.nextFloat();
                        break;
                    } catch (Exception e) {
                        s.nextLine();
                    }
                }
                return x;
            }
            public float getY(Scanner s) {
                while (true) {
                    try {
                        System.out.println("insert any value for y point");
                        this.y = s.nextFloat();
                        break;
                    } catch (Exception e) {
                        s.nextLine();
                    }
                }
                return y;
            }
            public void setX (int xval) {
                x = xval;
            }
            public void setY (int yval) {
                y = yval;
            }
            @Override // overrides the Shape abstract method getName
            public String getName () {
                return "Point";
            }
            @Override // overrides the Object method toString (Shape inherits Object)
            public String toString () {
                return "[" + x + ", " + y + "]";
            }
        }
    }

    //Circle class
    import java.util.Scanner;

    public class Circle extends Point{
        protected double r; // its radius
        public Circle () {
            super(); r = 0;
        }
        public Circle (float x, float y, double r) {
            super(x, y); setRadius(r);
        }
        // get and set methods for the radius
        public double getRadius (Scanner s) {
            while (true) {
                try {
                    System.out.println("insert a positive value for radius");
                    this.r = s.nextFloat();
                    if(this.r > 0){
                        break;
                    } else {
                        s.nextLine();
                    }
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("insert a float value for radius");
                }
            }
            return r;
        }
        public void setRadius (double rval) {
            r = rval < 0 ? 0 : rval;
        }
        @Override // overrides Shape getArea
        public double getArea () {
            return Math.PI * r * r;
        }
        @Override // overrides Point getname
        public String getName () {
            return "Circle";
        }
        @Override // overrides and uses the Point toString implementation
        public String toString () {
            return "C = " + super.toString() + "; R = " + r;
        }
    }

    import java.util.Scanner;

    public class Cylinder extends Circle{
        private double h; // its height
        public Cylinder () {
            super(); h = 0;
        }
        public Cylinder (float x, float y, double r, double h) {
            super(x, y, r); setHeight(h);
        }
        // get and set methods for the height
        public double getHeight(Scanner s) {
            while (true) {
                try {
                    System.out.println("insert a positive value for radius");
                    h = s.nextFloat();
                    if(h > 0){
                        break;
                    } else {
                        s.nextLine();
                    }
                } catch (Exception e) {
                    s.nextLine();
                    System.out.println("insert a float value for height");
                }
            }
            return h;
        }
        public void setHeight (double hval) {
            h = hval < 0 ? 0 : hval;
        }

        @Override // overrides and uses Circle getArea
        public double getArea () {
            return 2*super.getArea() + 2*Math.PI*super.r*h;
        }

        @Override // overrides Shape getVolume
        public double getVolume () {
            return super.getArea() * h;
        }
        @Override // overrides Circle getname
        public String getName () {
            return "Cylinder";
        }
        @Override // overrides and uses the Circle toString implementation
        public String toString () {
            return super.toString() + "; H = " + h;
        }
    }

}



