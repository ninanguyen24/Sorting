/*Nina Nguyen
CSC 212
April 27, 2017
Program 2: Rectangle2D*/


#ifndef RECTANGLE2D_H
#define RECTANGLE2D_H

#include <iostream>
#include <cmath>

using namespace std;

class Rectangle2D {
private:
	double x, y;
	double width, height;
	//const int SIZE; //Problem 11.11

public:
	double getX() const;
	double getY() const;
	void setX(double);
	void setY(double);
	double getWidth() const;
	double getHeight() const;
	void setWidth(double);
	void setHeight(double);
	Rectangle2D();
	Rectangle2D(double, double, double, double);
	double getArea() const;
	double getPerimeter() const;
	bool contains(double, double);
	bool contains(Rectangle2D &);
	bool overlaps(Rectangle2D &);

};
	const int SIZE = 2;
	Rectangle2D getRectangle(const double[][SIZE], int); //non-member function

#endif
