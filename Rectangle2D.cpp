/*Nina Nguyen
CSC 212
April 27, 2017
Program 2: Rectangle2D*/

#include "Rectangle2D.h"
#include <iostream>
#include <cmath>

using namespace std;

//Note to self: doesn't go here, try declaring in header.
//const int SIZE = 2;

//No parameter constructor
Rectangle2D::Rectangle2D() {
	x = 0;
	y = 0;
	width = 1;
	height = 1;
}

Rectangle2D::Rectangle2D(double newX, double newY, double newWidth, double newHeight) {
	x = newX;
	y = newY;
	width = newWidth;
	height = newHeight;
}

bool Rectangle2D::contains(double x, double y) {
	double w = width / 2;
	double h = height / 2;
	if (x >= this-> x - w && x <= this-> x + w) {
		if (y >= this-> y - h && y <= this-> y + h) {
			return true;
		}
		else {
			return false;
		}
	}
	else {
		return false;
	}
}

bool Rectangle2D::contains(Rectangle2D &r){
	double w = width / 2;
	double h = height / 2;
	if ((this -> x - w <= r.getX() - r.getWidth() / 2) && (this -> x + w >= r.getX() + r.getWidth() / 2)) {
		if ((this -> y - h <= r.getY() - r.getHeight() / 2) && (this -> y + h >= r.getY() + r.getHeight() / 2)) {
			return true;
		}
		else {
			return false;
		}
	}
	else {
		return false;
	}
}

bool Rectangle2D::overlaps(Rectangle2D &r) {
	double w = r.getWidth() / 2;
	double h = r.getHeight() / 2;

	if (this -> contains(r.getX() - w, (r.getX() - w) + h)) { //top left of rectangle
		return true;
	}
	if (this -> contains(r.getX() + w, r.getX() + w + h)) { //top right of rectangle
		return true;
	}
	if (this -> contains(r.getX() - w, r.getX() - w - h)) { //bottom left of rectangle
		return true;
	}
	if (this ->contains(r.getX()+ w, (r.getX() + w) - h)) { //bottom right of rectangle
		return true;
	}
	else {
		return false;
	}
}

Rectangle2D getRectangle(const double points[][SIZE], int x) { //non-member function. This took a while to figure out!
	double minX = points[0][0];//first x point
	double minY = points[0][1];//first y point
	double maxX = points[0][0];//first x point
	double maxY = points[0][1];//first y point

	for (int i = 0; i < x; i++) {// int "x" for number of pairs
		for (int j = 0; j < SIZE; j++) {
			if (points[i][0] > maxX) {
				maxX = points[i][0]; // replace maxX if point is larger
			}
			if (points[i][0] < minX) {
				minX = points[i][0]; // replace minX if point is smaller
			}
			if (points[i][1] > maxY) {
				maxY = points[i][1]; // replace maxY if point is larger
			}
			if (points[i][1] < minY) {
				minY = points[i][1]; // replace minY if point is smaller
			}
		}
	}
	double middleX = (minX + maxY) / 2; //get the middle "x" point
	double middleY = (minY + maxY) / 2; //get the middle "y" point
	double rectangleWidth = maxX - minX; //get the width
	double rectangleHeight = maxY - minY; //get the height
	return Rectangle2D(middleX, middleY, rectangleWidth, rectangleHeight); //used as parameters
}

//definitions below are pretty self explanatory
double Rectangle2D::getX() const {
	return x;
}

double Rectangle2D::getY() const {
	return y;
}

void Rectangle2D::setX(double newX) {
	x = newX;
}

void Rectangle2D::setY(double newY) {
	y = newY;
}

double Rectangle2D::getWidth() const {
	return width;
}

double Rectangle2D::getHeight() const {
	return height;
}

void Rectangle2D::setWidth(double newWidth) {
	width = newWidth;
}

void Rectangle2D::setHeight(double newHeight) {
	height = newHeight;
}

double Rectangle2D::getArea() const {
	return (width * height);
}

double Rectangle2D::getPerimeter() const {
	return (width + height) * 2;
}
