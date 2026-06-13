import javax.swing.JOptionPane;

public class SolveEquations {

    public static void Ptb1(String x, String y){
        double a = Double.parseDouble(x);
        double b = Double.parseDouble(y);
        double Result = 0;

        if (a == 0 && b != 0) { 
            JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm.",
                "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        } else if (a == 0 && b == 0) {
            JOptionPane.showMessageDialog(null, "Phương trình có vô số nghiệm.",
                "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Result = (-b) / a;
            JOptionPane.showMessageDialog(null, "Phương trình có nghiệm: x=" + Result,
                "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void Ptb2(String x, String y, String z){

        double a = Double.parseDouble(x);
        double b = Double.parseDouble(y);
        double c = Double.parseDouble(z);

        if(a==0){
            Ptb1(y, z);
        }
        else{
            double delta= b*b - 4*a*c;

            if (delta<0) {
                JOptionPane.showMessageDialog(null, "Phương trình vô nghiệm.",
                "Kết quả", JOptionPane.INFORMATION_MESSAGE);
            }else if (delta==0) {
                double Result= -b/(2*a);
                JOptionPane.showMessageDialog(null, "Phương trình nghiệm kép: x1=x2="+ Result,
                "Kết quả", JOptionPane.INFORMATION_MESSAGE);
            }else{
                double n1= (-b+Math.sqrt(delta))/(2*a);
                double n2= (-b-Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null, "Phương trình có 2 nghiệm: x1="+ n1 + ", x2="+ n2 ,
                "Kết quả", 0);
        }
        }
    }

    public static void Hpt2a(String x1, String y1, String z1, String x2, String y2, String z2){
        
        double a1 = Double.parseDouble(x1);
        double a2 = Double.parseDouble(x2);
        double b1 = Double.parseDouble(y1);
        double b2 = Double.parseDouble(y2);
        double c1 = Double.parseDouble(z1);
        double c2 = Double.parseDouble(z2);
        
        double D  = a1*b2-a2*b1;
        double D1 = c1*b2-c2*b1;
        double D2 = a1*c2-a2*c1;

        if(D!=0) 
        {
            double m1 = D1/D;
            double m2 = D2/D;

            JOptionPane.showMessageDialog(null, "x1="+ m1 +", x2=" + m2,
         "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        }else if(D==0 && (D1!=0||D2!=0)) {
            JOptionPane.showMessageDialog(null, "Hệ pt vô nghiệm.",
         "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        }else if(D==0 && D1==0 && D2==0){
             JOptionPane.showMessageDialog(null, "Hệ pt có vô số nghiệm",
         "Kết quả", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        
        String command;
        command = JOptionPane.showInputDialog(null, 
        "Chọn dạng phương trình cần giải: \nPhương trình bậc 1    (Ấn số 1) \nPhương trình bậc 2    (Ấn số 2) \nHệ phương trình 2 ẩn(Ấn số 3) ",
        "Giải phương trình", JOptionPane.INFORMATION_MESSAGE);
        int num= Integer.parseInt(command);
        if(num==1) {
            String strNum1, strNum2;
            strNum1 = JOptionPane.showInputDialog(null,
              "Vui lòng nhập hệ số a", "Giải phương trình bậc nhất 1 ẩn", 
              JOptionPane.INFORMATION_MESSAGE);

            strNum2 = JOptionPane.showInputDialog(null, 
              "Vui lòng nhập hệ số b", "Giải phương trình bậc nhất 1 ẩn",
              JOptionPane.INFORMATION_MESSAGE);

            Ptb1(strNum1, strNum2);
        }
        
        if(num==2) {
            String str1, str2, str3;
            str1 = JOptionPane.showInputDialog(null,
             "Vui lòng nhập hệ số a", "Giải phương trình bậc hai ", 
             JOptionPane.INFORMATION_MESSAGE);

            str2 = JOptionPane.showInputDialog(null, 
             "Vui lòng nhập hệ số b", "Giải phương trình bậc hai",
             JOptionPane.INFORMATION_MESSAGE);

            str3 = JOptionPane.showInputDialog(null, 
             "Vui lòng nhập hệ số c", "Giải phương trình bậc hai",
             JOptionPane.INFORMATION_MESSAGE);

            Ptb2(str1,str2,str3);
        }
            
        if(num==3) {
            String stra1, stra2, strb1, strb2, strc1, strc2;
            stra1 = JOptionPane.showInputDialog(null,
             "Vui lòng nhập hệ số a1", "Giải hệ pt 2 ẩn", 
             JOptionPane.INFORMATION_MESSAGE);

            strb1 = JOptionPane.showInputDialog(null,
             "Vui lòng nhập hệ số b1", "Giải hệ pt 2 ẩn", 
             JOptionPane.INFORMATION_MESSAGE);

            strc1 = JOptionPane.showInputDialog(null,
             "Vui lòng nhập hệ số c1", "Giải hệ pt 2 ẩn", 
             JOptionPane.INFORMATION_MESSAGE);

            stra2 = JOptionPane.showInputDialog(null, 
             "Vui lòng nhập hệ số a2", "Giải hệ pt 2 ẩn",
             JOptionPane.INFORMATION_MESSAGE);

            strb2 = JOptionPane.showInputDialog(null,
             "Vui lòng nhập hệ số b2", "Giải hệ pt 2 ẩn", 
             JOptionPane.INFORMATION_MESSAGE);

            strc2 = JOptionPane.showInputDialog(null,
             "Vui lòng nhập hệ số c2", "Giải hệ pt 2 ẩn", 
             JOptionPane.INFORMATION_MESSAGE);

            Hpt2a(stra1,strb1,strc1,stra2,strb2,strc2);
        }
        System.exit(0);
    }

}
