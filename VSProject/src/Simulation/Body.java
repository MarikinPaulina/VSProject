package Simulation;
//Wykonanie: Paulina Marikin
public class Body 
{

	protected double mass;
	protected double x;
	protected double y;
	protected double vX;
	protected double vY;
	protected double angle;
	protected double vAngle;
	protected double dx;
	protected double dy;
	protected double dvx;
	protected double dvy;
	protected double radius;
	
	public Body(double x, double y, double vx, double vy, double mass,double angle,double vAngle)
	{
		this.x = x;
		this.y = y;
		this.vX = vx;
		this.vY = vy;
		this.mass = mass;
		this.angle = angle;
		this.vAngle = vAngle;
	}
	
	public Body(Body body)
	{
		this.x = body.x;
		this.y = body.y;
		this.vX = body.vX;
		this.vY = body.vY;
		this.mass = body.mass;
		this.angle = body.angle;
		this.vAngle = body.vAngle;
	}
	
	public double getMass() 
	{
		return mass;
	}
	
	public void setMass(double Mass)
	{
		mass = Mass;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getVx() {
		return vX;
	}

	public void setVx(double vx) {
		this.vX = vx;
	}

	public double getVy() {
		return vY;
	}

	public void setVy(double vy) {
		this.vY = vy;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public double getvAngle() {
		return vAngle;
	}

	public void setvAngle(double vAngle) {
		this.vAngle = vAngle;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getDvx() {
		return dvx;
	}

	public void setDvx(double dvx) {
		this.dvx = dvx;
	}

	public double getDvy() {
		return dvy;
	}

	public void setDvy(double dvy) {
		this.dvy = dvy;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	
	
	
}
