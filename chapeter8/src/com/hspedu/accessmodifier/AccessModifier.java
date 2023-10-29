package com.hspedu.accessmodifier;

import com.hspedu.pkg.C;
import com.hspedu.pkg.SubclassOfA;

public class AccessModifier {
    public static void main(String[] args) {
        //There are four types of access modifier in java
        //public: the declared class are be accessed by all class
        //protected: the declared class are be accessed by the same class, the subclass
        // and class in the same package
        //default(no keyword): the declared class are be accessed by the same class and
        // the class in the same pakcage
        //private: the declared class are be accessed by the same class

        //AccessModifier SameClass SamePackage SubClass DifferentPackage
        //public            Y           Y           Y           Y
        //protected         Y           Y           Y           N
        //default           Y           Y           N(difpkg)   N
        //private           Y           N           N           N

        //only public and default(no keyword) can be used for class access control

        A a = new A();
        a.test();

        B b = new B();
        b.test();

        C c = new C();
        c.test();

        SubclassOfA subclassOfA = new SubclassOfA();
        subclassOfA.test();

    }
}
