package com.keen.interfacetest;

public class Test {
    public static void main(String[] args) {
        callUSBInterface(new PhoneUSB());
        callUSBInterface(new CameraUSB());
        System.out.println(USBInterface.a);
        System.out.println(PhoneUSB.a);
        System.out.println(new PhoneUSB().a);
    }
    public static void callUSBInterface(USBInterface usbInterface){
        usbInterface.work();
        usbInterface.stop();
    }
}

class PhoneUSB implements USBInterface{
    @Override
    public void work() {
        System.out.println("phone is working");
    }

    @Override
    public void stop() {
        System.out.println("phone is stopping");
    }
}

class CameraUSB implements USBInterface{
    @Override
    public void work() {
        System.out.println("camera is working");
    }

    @Override
    public void stop() {
        System.out.println("camera is stopping");
    }
}

