// Copyright 2025 Alex Chandarana

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sierpinski extends JPanel {
	public static void main(String[] args) {
		
		// Create the JFrame
		JFrame frame = new JFrame("Sierpinski Triangle");
		frame.setSize(1000,1000); // fits nicely on a 1080p screen
		frame.setLocationRelativeTo(null); // center frame on screen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminates program when window is closed
		
		// Add panel so I can actually draw a triangle
		Sierpinski panel = new Sierpinski();
		frame.add(panel);
		
		
		// Show the window
		frame.setVisible(true);
	}
	
	public void paintComponent(Graphics g) {
		
		// Creates the original equalateral (not really but it looks good) trangle
		int x1 = 100;
		int x2 = 900;
		int x3 = 500;
		int y1 = 807;
		int y2 = 807;
		int y3 = 100;
		int[] originalXPoints = {x1, x2, x3};
		int[] originalYPoints = {y1, y2, y3};
		g.setColor(randomColor());
		g.fillPolygon(originalXPoints, originalYPoints, 3);
		
		// Begins recursively drawing new (white) triangles
		drawTriangles(g, x1, y1, x2, y2, x3, y3);
	}
	
	private void drawTriangles(Graphics g, int x1, int y1, int x2, int y2, int x3, int y3) {
		// A distance, with my calculation, of 8 seems to equate to about 4 pixels.
		if (distance(x1, x2) < 8) {
			return;
		}
		
		// calculates midpoints for centering the new triangle
		int mx12 = (x1 + x2) / 2;
		int my12 = (y1 + y2) / 2;

		int mx23 = (x2 + x3) / 2;
		int my23 = (y2 + y3) / 2;
        
		int mx31 = (x3 + x1) / 2;
		int my31 = (y3 + y1) / 2;
		
		g.setColor(randomColor());
		
		int[]invX = {mx12, mx23, mx31};
		int[] invY = {my12, my23, my31};
		g.fillPolygon(invX, invY, 3);
		
		// Recursively draws the triangles
		drawTriangles(g, x1, y1, mx12, my12, mx31, my31);
		drawTriangles(g, mx12, my12, x2, y2, mx23, my23);
		drawTriangles(g, mx31, my31, mx23, my23, x3, y3);
	}
	
	private double distance(int x1, int x2) {
		return Math.abs(x2-x1);
	}
	
	// Random color for every triangle because black and white is boring
	private Color randomColor() {
		Random r = new Random();
		int red = r.nextInt(255);
		int green = r.nextInt(255);
		int blue = r.nextInt(255);
		Color randomColor = new Color(red, green, blue);
		return randomColor;
	}
}