import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("--- Equation Solver ---");
            System.out.println("1. Solve linear equation (ax + b = 0)");
            System.out.println("2. Solve 2x2 linear system");
            System.out.println("3. Solve quadratic equation (ax^2 + bx + c = 0)");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number 1-4.\n");
                continue;
            }

            if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    solveLinear(sc);
                    break;
                case 2:
                    solveLinearSystem(sc);
                    break;
                case 3:
                    solveQuadratic(sc);
                    break;
                default:
                    System.out.println("Invalid choice.\n");
            }
            System.out.println();
        }
        sc.close();
    }

    private static void solveLinear(Scanner sc) {
        try {
            System.out.print("Enter a: ");
            double a = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter b: ");
            double b = Double.parseDouble(sc.nextLine().trim());

            if (a == 0) {
                if (b == 0) {
                    System.out.println("Infinite solutions (any x satisfies 0x + 0 = 0).");
                } else {
                    System.out.println("No solution (0x + b = 0 with b != 0).");
                }
            } else {
                double x = -b / a;
                System.out.println("Solution: x = " + x);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    private static void solveLinearSystem(Scanner sc) {
        try {
            System.out.println("System form: a11*x1 + a12*x2 = b1");
            System.out.println("             a21*x1 + a22*x2 = b2");
            System.out.print("Enter a11: ");
            double a11 = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter a12: ");
            double a12 = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter a21: ");
            double a21 = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter a22: ");
            double a22 = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter b1: ");
            double b1 = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter b2: ");
            double b2 = Double.parseDouble(sc.nextLine().trim());

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12; // determinant for x1
            double D2 = a11 * b2 - a21 * b1; // determinant for x2

            if (Math.abs(D) > 1e-12) {
                double x1 = D1 / D;
                double x2 = D2 / D;
                System.out.println("Unique solution:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else {
                // D == 0
                if (Math.abs(D1) < 1e-12 && Math.abs(D2) < 1e-12) {
                    System.out.println("Infinitely many solutions.");
                } else {
                    System.out.println("No solution.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    private static void solveQuadratic(Scanner sc) {
        try {
            System.out.print("Enter a: ");
            double a = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter b: ");
            double b = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Enter c: ");
            double c = Double.parseDouble(sc.nextLine().trim());

            if (a == 0) {
                // reduce to linear bx + c = 0
                System.out.println("Coefficient a is 0. Reducing to linear equation:");
                if (b == 0) {
                    if (c == 0) {
                        System.out.println("Infinite solutions (0 = 0).");
                    } else {
                        System.out.println("No solution (c != 0).");
                    }
                } else {
                    double x = -c / b;
                    System.out.println("Linear solution: x = " + x);
                }
                return;
            }

            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double sqrtD = Math.sqrt(delta);
                double x1 = (-b + sqrtD) / (2 * a);
                double x2 = (-b - sqrtD) / (2 * a);
                System.out.println("Two real roots:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (Math.abs(delta) < 1e-12) {
                double x = -b / (2 * a);
                System.out.println("Double root: x = " + x);
            } else {
                System.out.println("No real roots (discriminant < 0).");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }
}
