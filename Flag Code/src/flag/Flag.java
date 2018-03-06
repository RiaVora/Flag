package flag;
import java.awt.*;
import javax.swing.JFrame;

public class Flag extends JFrame {
	
	//Class Variable to customize for each star
	private int [ ] x1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	private int [ ] y1 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	
	//Star base values at radius 1 (0, 0)
	private double [ ] xg = {0.0/23.0, -7.0/23.0, -23.0/23.0, -12.0/23.0, -14.0/23.0, 0.0/23.0, 14.0/23.0, 12.0/23.0, 23.0/23.0, 7.0/23.0};
	private double [ ] yg = {-25.0/23.0, -10.0/23.0, -8.0/23.0, 4.0/23.0, 20.0/23.0, 12.0/23.0, 20.0/23.0, 4.0/23.0, -8.0/23.0, -10.0/23.0};
	
	//Init runs when Flag is created (in main)
	public Flag () {
		init();
		
	}

	//Run when Flag is called
	public void init() {
		
		//Set's the size of the window
		setSize(900,600);
		
		//Runs an method embedded in java JFrame class that reruns paint, over and over, among other things
		repaint();
	}
	
	//Paint part of the java JFrame class, redefined to create the scaling flag
	//Parts of Flag
	//Dimensions are multiplied by 400
	public void paint(Graphics g) {
		
		//Deletes the past graphics "painted" on
		super.paint(g);
		
		
		//SCALING VARIABLES
		
		//Preset dimensions of the window (what we set the size too)
		double ww = 900;
		double wh = 600;
		
		//Current dimensions of the window
		double width = this.getWidth();
		double height = this.getHeight();
		
		//The ratio/scale factor of the current window to the preset/flag one
		double sfw = (width/ww);
		double sfh = (height/wh);
		
		//The average of the two ratios, to get the scale factor for both height and width
		double sf = ((sfw + sfh)/2);
		
		
		//RED BACKGROUND
		
		//Cable No. 70180 Old Glory Red Color
		g.setColor(new Color(191, 13, 62));
		
		//Red Background Coordinates with Scale Factor
		int rx = (int)(50*sf);
		int ry = (int)(100*sf);
		
		//Red Background Dimensions with Scale Factor
		int rw = (int)(760*sf);
		int rh = (int)(400*sf);
		
		//Drawing of Red Background
		g.fillRect(rx, ry, rw, rh);
		
		
		//WHITE RECTANGLES
		
		//Cable No. 70001 White Color (Pure White)
		g.setColor(new Color(255, 255, 255));

		//White Rectangle Coordinates with Scale Factor
		int wrx = (int)(50*sf);
		int wry = (int)(131*sf);
		
		//White Rectangle Dimensions with Scale Factor
		int wrw = (int)(760*sf);
		int wrh = (int)(31*sf);
		
		//Drawing Loop of all 6 White Rectangles, 62 pixels apart
		for (int i = 0; i < 6; i++) {
			g.fillRect(wrx, (int)(wry + (62*sf*i)), wrw, wrh);
		}
		
		
		//BLUE UNION
		
		//Cable No. 70075 Old Glory Blue Color
		g.setColor(new Color(4, 30, 66));
		
		//Blue Rectangle Coordinates with Scale Factor
		int ux = (int)(50*sf);
		int uy = (int)(100*sf);
		
		//Blue Rectangle Dimensions with Scale Factor
		int uw = (int)(304*sf);
		int uh = (int)(217*sf);
		
		//Drawing of Blue Rectangle
		g.fillRect(ux, uy, uw, uh);
		
		
		//WHITE STARS
		
		
			//WHITE STAR VARIABLES
		
		//Cable No. 70001 White Color (Pure White)
		g.setColor(new Color(255, 255, 255));
		
		//Star radius with Scale Factor
		double radius = 12.32 * sf;
		
		//Initial Coordinates of first star relative to union, with Scale Factor
		double scx = ux + (sf*25.2);
		double scy = uy + (sf*21.6);

		//Pixel distance from separate stars
		double movex = (50.4*sf);
		double movey = (21.6*sf);
		
		
			//DRAWING OF THE WHITE STARS
		
		//Runs six times for the six stars in half of the rows
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 9; j++) {
				
				//For the row with six stars, creates 5 rows (j is even five times)
				if (j % 2 == 0) {
				
					//For the row with six stars, creates each star 50.4 pixels apart, and at each point at 5 rows 
					stars(radius, scx + (movex*i), scy + (movey*j));
					g.fillPolygon(x1, y1, 10);
				
				//Excludes one of the i's runs, so creates a row with only five stars, runs 4 times (j is odd five times)
				} else if (i != 5) {
					stars(radius, scx + ((movex*(i)) + (25.2*sf)), scy + (movey*j));
					g.fillPolygon(x1, y1, 10);
				}
			}
		}
	}
	
	//Method for personalizing stars
	public void stars(double radius, double starcenter_x, double starcenter_y) {
		
		//Uses the base values * radius to get the correct ra
		for (int i = 0; i < 10; i++) {
			x1[i] = (int)(xg[i] * radius);
			y1[i] = (int)(yg[i] * radius);
		}
		
		for (int i = 0; i < 10; i++) {
			x1[i] = (int)(x1[i] + starcenter_x);
			y1[i] = (int)(y1[i] + starcenter_y);
		}
	}
	
	}