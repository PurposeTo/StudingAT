package com.company.studingAT;

import com.company.studingAT.DayTwo.Vector3d;

public class Main {
    public static void main(String[] args) {
        Vector3d firstVector = new Vector3d(5,2,8);
        Vector3d secondVector = new Vector3d(6,3,23);
        Vector3d thirdVector = null;

        try {
            thirdVector = Vector3d.vectorMultiply(firstVector, secondVector);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(thirdVector.GetX() + " " + thirdVector.GetY() + " " + thirdVector.GetZ() + " ");
    }
}
