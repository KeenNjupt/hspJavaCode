import java.util.Scanner;

public class HotKey { //look the of hierarchy of class: press ctrl + h
    String name;
    int a;
    //1.express alt + insert, select generator and select constructor
    //select the member variable needed to be initialized
    public HotKey(String name, int a) {
        this.name = name;
        this.a = a;
    }

    //input main press enter generate the main method
    public static void main(String[] args) {

        //2.format the code: ctrl + alt + l
        int a = 1 + 1 + 2 * 3 * 6;
        //3.delete one line: ctrl + d
        //4.duplicate one line: ctrl + alt + down arrow
        //5.go to usage of method : ctrl + window
        show();
        // 6.input new Scanner(System.in).var and press enter
        //will automatically generate the variable name and statement
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);

        //7. input sout and press enter
        //will automatically System.out.println();
        System.out.println();

        //8. input fori and press enter
        //will automatically generate the for iteration loop
        for (int i = 0; i < 10; i++) {

        }
        //the main, sout, fori are all the template
        //we can customize the template
        //file -> settings -> editor -> Live templates
        //need to select the context of the template added
        System.out.print(" ");
    }
    public static void show(){

    }

}

