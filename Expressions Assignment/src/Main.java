public class Main {
    public static void main(String args[]){
        /*For the following expressions write out using code step by step how the
        compiler will evaluate it
        Example:
        System.out.println(2 * 5 + 3);
        System.out.println(10 + 3);
        System.out.println(13);
        Only complete one computation per line of code
        The output for every line is always equal to the same number
        In example above the out put should be
        13
        13
        13
        */
        //Expression 1
        System.out.println((9 - 4)+ 10/2 - (4 - 8)/3);
        System.out.println(5 + 10/2 - (4 - 8)/3);
        System.out.println(5 + 10/2 - -4/3);
        System.out.println(5 + 5 - -4/3);
        System.out.println(5 + 5 - -1);
        System.out.println(10 - -1);
        System.out.println(11);

        //Expression 2
        System.out.println(23%4 + (18 - 3 / 2));
        System.out.println(23%4 + (18 - 1));
        System.out.println(23%4 + 17);
        System.out.println(3 + 17);
        System.out.println(20);

        //Expression 3
        /* Following is the declaration for java.lang.Math.pow() method
        public static double pow(double a, double b) therefore it returns a double */
        System.out.println(((8 - 5) + Math.pow(3,4)/5));
        System.out.println((3 + Math.pow(3,4)/5));
        System.out.println((3 + 81d/5));
        System.out.println((3 + 16.2));
        System.out.println((19.2));
        System.out.println(19.2);

        //Expression 4
        System.out.println((9 % 4) - 8 + Math.pow(2,3) / 8 + (Math.sqrt(81) / 3));
        System.out.println(1 - 8 + Math.pow(2,3) / 8 + (Math.sqrt(81) / 3));
        System.out.println(1 - 8 + Math.pow(2,3) / 8 + (9 / 3));
        System.out.println(1 - 8 + Math.pow(2,3) / 8 + 3);
        System.out.println(1 - 8 + 8d / 8 + 3);
        System.out.println(1 - 8 + 1d + 3);
        System.out.println(-7 + 1d + 3);
        System.out.println(-6d + 3);
        System.out.println(-3d);

        //Expression 5
        // note: Math.sin gets radians
        System.out.println(((14 / 2 + 3) * Math.sin(45) + 2) - Math.pow(Math.sqrt(25), 3));
        System.out.println(((7 + 3) * Math.sin(45) + 2) - Math.pow(Math.sqrt(25), 3));
        System.out.println((10 * Math.sin(45) + 2) - Math.pow(Math.sqrt(25), 3));
        System.out.println((10 * 0.8509035245341184 + 2) - Math.pow(Math.sqrt(25), 3));
        System.out.println((8.509035245341184 + 2) - Math.pow(Math.sqrt(25), 3));
        System.out.println(10.509035245341184 - Math.pow(Math.sqrt(25), 3));
        System.out.println(10.509035245341184 - Math.pow(5d, 3));
        System.out.println(10.509035245341184 - 125d);
        System.out.println(-114.49096475465882);
    }
}
