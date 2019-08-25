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

        imgFileName = img;

    }

    public Planet(Planet p) {

        xxPos = p.xxPos;

        yyPos = p.yyPos;

        xxVel = p.xxVel;

        yyVel = p.yyVel;

        mass = p.mass;

        imgFileName = p.imgFileName;

    }

    public double calcDistance(Planet p) {

        double dx = Math.abs(xxPos-p.xxPos);

        double dy = Math.abs(yyPos-p.yyPos);

        return Math.sqrt(dx * dx + dy * dy);

    }

    public double calcForceExertedBy(Planet p) {

        double r = calcDistance(p);

        double F = 6.67 * 0.00000000001 * mass * p.mass / (r * r);

        return F;


    }

    public double calcForceExertedByX(Planet p) {

        double dx = p.xxPos - xxPos;

        double r = calcDistance(p);

        double f = calcForceExertedBy(p);

        double fx = f * dx / r;

        return fx;
    }

    public double calcForceExertedByY(Planet p) {

        double dy = p.yyPos - yyPos;

        double r = calcDistance(p);

        double f = calcForceExertedBy(p);

        double fy = f * dy / r;

        return fy;
    }

    public double calcNetForceExertedByX(Planet[] ps) {

        double fx = 0;

        int len = ps.length;

        for (int i = 0; i < len; i++) {

            if (this.equals(ps[i])) {
                continue;
            } else {
                fx += calcForceExertedByX(ps[i]);
            }
        }

        return fx;
    }

    public double calcNetForceExertedByY(Planet[] ps) {

        double fy = 0;

        int len = ps.length;

        for (int i = 0; i < len; i++) {

            if (this.equals(ps[i])) {
                continue;
            } else {
                fy += calcForceExertedByY(ps[i]);
            }
        }

        return fy;
    }

    public void update(double dt, double fX, double fY) {

        double a_x = fX / mass;

        double a_y = fY / mass;

        xxVel = xxVel + a_x * dt;

        yyVel = yyVel + a_y * dt;

        xxPos += xxVel * dt;

        yyPos += yyVel * dt;



    }

    public void draw() {
        String filename = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, filename);
    }
}