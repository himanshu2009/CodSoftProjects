import java.util.Scanner;

public class StudentGradecalculator {
    public static void main(String[] args) {

        System.out.println("Welcome to Grade Calculator ");
        Scanner sc = new Scanner(System.in);

        String name;

        while(true){

            try {

                System.out.println("Enter Your Name Here ");
                name= sc.nextLine();

                if(name.matches("^[a-zA-Z ]+$"))
                {
                    break;
                }
                else{
                    throw new Exception("Invalid input. Please enter your name.");
                }


            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }


        System.out.println("Enter your all Subjects Marks (out of 100)");


        String subjects[] = new String[]{"Maths", "Operating System", "Data Communication and Networking", "DBMS", "TCP/IP", "ADVANCED ALGORITHMS"};

        int sum = 0;
        int marks[] = new int[subjects.length];


        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.println("Enter your " + subjects[i] + " marks (less than  or equal 100):");
                try {
                    int m = sc.nextInt();
                    if (m < 100) {
                        marks[i] = m;
                        sum += marks[i];
                        break; // Break the loop if valid input is provided.
                    } else {
                        System.out.println("Please enter a number less than or equal to 100.");
                    }
                } catch (Exception e) {
                    System.out.println("Enter a valid integer.");
                    sc.nextLine(); // Clear the input buffer.
                }
            }

        }

        int Average = sum / subjects.length;
        System.out.println(Average);


        String grade;
        if (Average >= 90) {
            grade = "A+";
        } else if (Average >= 80) {
            grade = "A";
        } else if (Average >= 70) {
            grade = "B";
        } else if (Average >= 60) {
            grade = "C";
        } else if (Average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }


        String result = "";
        switch (grade) {
            case "A+":

                result = "Excellent";
                break;
            case "A":

                result = "Very Good";
                break;


            case "B":

                result = "Good";
                break;


            case "C":

                result = "Decent";
                break;

            case "D":

                result = "Average";
                break;

            case "F":
                result = "Below Average";

        }

        System.out.println("Result:");

        System.out.println("**********************************");


        System.out.println("Dear Student :" +name);
        System.out.println("Your Total marks :" + sum);
        System.out.println("Your Average of total Marks:" + Average);
        System.out.println("Your Final Grade is :" + grade);
        System.out.println("Status :" + result);

        System.out.println("**********************************");

    }


}




