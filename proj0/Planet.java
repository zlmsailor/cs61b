public class Planet {
	
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName =img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName =p.imgFileName;
	}
	
	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		double r = Math.sqrt((dx * dx + dy * dy));
		return r;
	}
	
	public double calcForceExertedBy(Planet p) {
		double G = 6.67e-11;
		double F = (G * this.mass * p.mass)/Math.pow(this.calcDistance(p),2);
		return F;
	}
	
	public double calcForceExertedByX(Planet p) {
		double Fx=this.calcForceExertedBy(p)*(p.xxPos - this.xxPos) / this.calcDistance(p);
		return Fx;
	}
	
	public double calcForceExertedByY(Planet p) {
		double Fy=this.calcForceExertedBy(p)*(p.yyPos - this.yyPos) / this.calcDistance(p);
		return Fy;
	}
	
	public double calcNetForceExertedByX(Planet[] ps) {
		double FxNet = 0;
		for (Planet p: ps) {
			if(!this.equals(p)) {
				FxNet += this.calcForceExertedByX(p);
			}
		}
		return FxNet;
	}

	public double calcNetForceExertedByY(Planet[] ps) {
		double FyNet = 0;
		for (Planet p: ps) {
			if(!this.equals(p)) {
				FyNet += this.calcForceExertedByY(p);
			}
		}
		return FyNet;
	}

    public void update(double dt, double fX, double fY) {
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        this.xxVel += ax * dt;
        this.yyVel += ay * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }
	
	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
	}
}