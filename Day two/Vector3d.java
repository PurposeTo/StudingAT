package com.company.studingAT.DayTwo;

public class Vector3d extends AbstractVector
{
    private final double x, y, z;

    public Vector3d(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    public double GetX()
    {
        return x;
    }


    public  double GetY()
    {
        return y;
    }


    public  double GetZ()
    {
        return z;
    }

    public double Length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static Vector3d Add(Vector3d firstVector, Vector3d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
            double x = firstVector.GetX() +  secondVector.GetX();
            double y = firstVector.GetY() +  secondVector.GetY();
            double z  = firstVector.GetZ() +  secondVector.GetZ();
            return new Vector3d(x, y, z);
        }
        else throw new Exception("One of the vectors is null");
    }


    public static Vector3d Subtract(Vector3d firstVector, Vector3d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
            double x = firstVector.GetX() -  secondVector.GetX();
            double y = firstVector.GetY() -  secondVector.GetY();
            double z = firstVector.GetZ() -  secondVector.GetZ();
            return new Vector3d(x, y, z);
        }
        else throw new Exception("One of the vectors is null");
    }


    public static Vector3d Negative(Vector3d vector) throws Exception {
        if(vector != null) {
            return new Vector3d(-vector.GetX(), -vector.GetY(), -vector.GetZ());
        }
        else throw new Exception("The vectors is null");
    }


    public static double ScalarMultiply(Vector3d firstVector, Vector3d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
            double x = firstVector.GetX() *  secondVector.GetX();
            double y = firstVector.GetY() *  secondVector.GetY();
            double z = firstVector.GetZ() *  secondVector.GetZ();
            return x + y + z;
        }
        else throw new Exception("One of the vectors is null");
    }


    public static Vector3d vectorMultiply(Vector3d firstVector, Vector3d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
            double x = firstVector.GetY() * secondVector.GetZ() - firstVector.GetZ() * secondVector.GetY();
            double y = -(firstVector.GetX() * secondVector.GetZ() - firstVector.GetZ() * secondVector.GetX());
            double z = firstVector.GetX() * secondVector.GetY() - firstVector.GetY() * secondVector.GetX();
            return new Vector3d(x, y, z);
        }
        else throw new Exception("One of the vectors is null");
    }
}
