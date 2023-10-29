package com.hspedu.override;

public class DynamicBind {
    public static void main(String[] args) {
        //when the function is called, the function will be bound with the runtime type of the object
        //when the variable is called, the variable doesn't have the bind; normally find it from down to top
        C c = new D();
        System.out.println(c.sum()); // call the function sum(), from c's runtime type : D to find sum
        //D doesn't have the sum() -> find C -> C has the sum()
        //call C.sum(), "return i", the i is variable, call the C.i
        //output 10(C.i)
        System.out.println(c.sum1());// call the function sum1(), from c's runtime type : D to find sum1
        //D doesn't have the sum1() -> find C -> C has the sum1()
        //call C.sum1(), "return getI()", find the getI(), from the this runtime type D
        // D has getI() -> call D.getI() -> "return i" - > return D.i
        //output 20(D.i)

        //finding the member function and member variable both is from the current class to top
        //the difference is that the current class of function is the runtime type,
        //the current class of variable is the current position class
    }
}

class C{
    int i = 10;
    public int sum(){
        return i;
    }
    public int sum1(){
        return getI();
    }

    public int getI() {
        return i;
    }
}

class D extends C{
    int i = 20;
//    public int sum(){
//        return i;
//    }
//    public int sum1(){
//        return getI();
//    }

    public int getI() {
        return i;
    }
}
