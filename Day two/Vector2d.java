package com.company.studingAT.DayTwo;

public class Vector2d extends AbstractVector
{
    private final double x, y;

    public Vector2d(double x, double y)
    {
        this.x = x;
        this.y = y;
    }


    public double GetX()
    {
        return x;
    }


    public double GetY()
    {
        return y;
    }


    public double Length() {
        return Math.sqrt(x * x + y * y);
    }


    public static Vector2d Add(Vector2d firstVector, Vector2d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
            double x = firstVector.GetX() +  secondVector.GetX();
            double y = firstVector.GetY() +  secondVector.GetY();
            return new Vector2d(x, y);
        }
        else throw new Exception("One of the vectors is null");
    }


    public static Vector2d Subtract(Vector2d firstVector, Vector2d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
        double x = firstVector.GetX() -  secondVector.GetX();
        double y = firstVector.GetY() -  secondVector.GetY();
        return new Vector2d(x, y);
        }
        else throw new Exception("One of the vectors is null");
    }


    public static Vector2d Negative(Vector2d vector) throws Exception {
        if(vector != null) {
            return new Vector2d(-vector.GetX(), -vector.GetY());
        }
        else throw new Exception("The vectors is null");
    }


    public static double ScalarMultiply(Vector2d firstVector, Vector2d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
            double x = firstVector.GetX() *  secondVector.GetX();
            double y = firstVector.GetY() *  secondVector.GetY();
            return x + y;
        }
        else throw new Exception("One of the vectors is null");
    }


    public static Vector3d vectorMultiply(Vector2d firstVector, Vector2d secondVector) throws Exception {
        if(firstVector != null || secondVector != null)
        {
            // Для того, что бы векторно перемножить 2-мерные вектора - необходимо представить их как трехмерные векторы с нулевой Z координатой
            double z = firstVector.GetX() * secondVector.GetY() - firstVector.GetY() * secondVector.GetX();
            return new Vector3d(0, 0, z);
        }
        else throw new Exception("One of the vectors is null");
    }
}
