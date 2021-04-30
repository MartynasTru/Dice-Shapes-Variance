package Assignment1part2;

import java.util.Scanner;

public class ShapeTest {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Point point = new Point();
        Circle circle = new Circle();
        Cylinder cylinder = new Cylinder();
        int countOfArray = 0;
        Shape[] shapeList = new Shape[1000];
        int userShapeChoice;
        if(args.length == 0){
            System.out.print("Please choose your action: Point(1), Circle(2), Cylinder(3), PrintAllShapes(4), Delete(5), Exit(6)\n");
            while(true){
                try {
                    userShapeChoice = s.nextInt();
                    if(userShapeChoice>0 && userShapeChoice <7){
                        // checking users input and doing actions
                        if (userShapeChoice == 1) {
                            float x = point.getX(s);
                            float y = point.getY(s);
                            Point output = new Point(x, y);
                            System.out.printf("%s - %s \nArea - %f \nVolume - %f \n", output.getName(), output.toString(), output.getArea(), output.getVolume());
                            shapeList[countOfArray] = output;
                            countOfArray++;
                        }
                        else if (userShapeChoice == 2){
                            float x = circle.getX(s);
                            float y = circle.getY(s);
                            double r = circle.getRadius(s);
                            Point output = new Circle(x, y, r);
                            System.out.printf("%s - %s \nArea - %f \nVolume - %f \n", output.getName(), output.toString(), output.getArea(), output.getVolume());
                            shapeList[countOfArray] = output;
                            countOfArray++;
                        }
                        else if (userShapeChoice == 3){
                            float x = cylinder.getX(s);
                            float y = cylinder.getY(s);
                            double r = cylinder.getRadius(s);
                            double h = cylinder.getHeight(s);
                            Point output = new Cylinder(x, y, r, h);
                            System.out.printf("%s - %s \nArea - %f \nVolume - %f \n", output.getName(), output.toString(), output.getArea(), output.getVolume());
                            shapeList[countOfArray] = output;
                            countOfArray++;
                        }
                        else if (userShapeChoice == 4){
                            for(int i =0; i<countOfArray; i++){
                                System.out.printf("[%d] %s\n", i, (shapeList[i]));
                            }
                        }
                        else if(userShapeChoice == 5){
                            if (countOfArray != 0) {
                                System.out.println("insert number of the shape u want to delete:");
                                int deletedShape;
                                while (true) {
                                    try {
                                        deletedShape = s.nextInt();
                                        if(deletedShape >=0 && deletedShape<countOfArray){
                                            for(int i=deletedShape; i<countOfArray; i++){
                                                shapeList[i] = shapeList[i + 1];
                                            }
                                            countOfArray --;
                                            break;
                                        } else {
                                            System.out.println("The shape you are trying to delete does not exist, you will be returned to main menu");
                                            break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("insert integer value for shape number point");
                                        s.nextLine();
                                    }
                                }
                            } else {
                                System.out.println("There is nothing to delete");
                            }
                        }
                        else {
                            System.out.print("Goodbye!\n");
                            System.exit(0); // terminate program
                        }
                        System.out.print("Please choose your next action: Point(1), Circle(2), Cylinder(3), PrintAllShapes(4), Delete(5), Exit(6)\n");

                    } else {
                        System.out.println("it has to be a value between 1 and 6 included");
                    }
                } catch (Exception e){
                    System.out.println("it has to be an integer value");
                    s.nextLine();
                }

            }
        } else {
            System.out.print("please run the program with no values beforehand\n");
            System.exit(0); // terminate program
        }
    }
}
