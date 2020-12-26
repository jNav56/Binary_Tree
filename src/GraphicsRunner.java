import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Scanner;


public class GraphicsRunner extends JPanel {
	
	// Add buttons if time permits
	int opt = 41; // 0 for add, 14 for subtracting, 41 for inversion
	
	private void changeOPT() {
		++opt;
	}

    @Override
    public void paint(Graphics g) {
    	super.paint(g);
    	if(opt > 2 && opt < 11) {
    		adding(g);
    	} else if(opt > 14 && opt < 42) {
    		subtracting(g);
    	} else if(opt > 41 && opt < 100) {
    		inversion(g);
    	}
    	
    }

	private void adding(Graphics g) {
    	BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
    	
    	Font font = new Font("Verdana", Font.BOLD, 20);
    	g.setFont(font);
    	
    	int opt_range = opt - 2;
    	if(opt > 7 && opt < 11) {
    		opt_range = 6;
    	}
    	
    	switch(opt_range) {
    		case 1:
    			g.drawString("Adding 5", 30, 30);
    			t.add(5);
    			break;
    		case 2:
    			g.drawString("Adding 1", 30, 30);
    			t.add(5);
    			t.add(1);
    			break;
    		case 3:
    			g.drawString("Adding 7", 30, 30);
    			t.add(5);
    			t.add(1);
            	t.add(7);
            	break;
    		case 4:
    			g.drawString("Adding 14", 30, 30);
    			t.add(5);
    			t.add(1);
            	t.add(7);
            	t.add(14);
            	break;
    		case 5:
    			g.drawString("Adding 17", 30, 30);
    			t.add(5);
    			t.add(1);
            	t.add(7);
            	t.add(14);
            	t.add(17);
            	break;
    		case 6:
    			g.drawString("Adding 10", 30, 30);
    			t.add(5);
    			t.add(1);
            	t.add(7);
            	t.add(14);
            	t.add(17);
            	t.add(10);
            	break;
    	}
    	t.drawTree(g, 250);
    }
	
	private void subtracting(Graphics g) {
		
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.add(10);
		t.add(9);
    	t.add(14);
    	t.add(12);
    	t.add(5);
    	t.add(19);
    	t.add(16);
    	t.add(4);
    	t.add(8);
    	t.add(7);
    	t.add(6);
    	t.add(18);
    	t.add(15);
    	
    	int opt_range = 0;
    	if(opt > 14 && opt < 17) { // 15, 16
    		opt_range = 1;
    	} else if(opt > 16 && opt < 21) { // 17, 18, 19, 20
    		opt_range = 2;
    	} else if(opt > 20 && opt < 24) { // 21, 22, 23
    		opt_range = 3;
    	} else if(opt > 23 && opt < 26) { // 24, 25
    		opt_range = 4;
    	} else if(opt > 25 && opt < 30) { // 26, 27, 28, 29
    		opt_range = 5;
    	} else if(opt > 29 && opt < 32) { // 30, 31
    		opt_range = 6;
    	} else if(opt > 31 && opt < 34) { // 32, 33
    		opt_range = 7;
    	} else if(opt > 33 && opt < 38) { // 34, 35, 36, 37
    		opt_range = 8;
    	} else if(opt > 37 && opt < 42) { // 38, 39, 40, 41
    		opt_range = 9;
    	}
    	
    	Font font = new Font("Verdana", Font.BOLD, 20);
    	g.setFont(font);
    	
    	switch(opt_range) {
    		case 1:
    			g.drawString("Initial Graph", 30, 30);
    			break;
    		case 2:
    			g.drawString("Removing 4", 30, 30);
    			g.drawString("(No Children)", 30, 60);
    			break;
    		case 3:
    			g.drawString("Removing 4", 30, 30);
    			g.drawString("(No Children)", 30, 60);
    			t.remove(4);
    			break;
    		case 4:
    			g.drawString("Reset Graph", 30, 30);
    			break;
    		case 5:
    			g.drawString("Removing 19", 30, 30);
    			g.drawString("(1 Child)", 30, 60);
    			break;
    		case 6:
    			g.drawString("Removing 19", 30, 30);
    			g.drawString("(1 Child)", 30, 60);
    			t.remove(19);
    			break;
    		case 7:
    			g.drawString("Reset Graph", 30, 30);
    			break;
    		case 8:
    			g.drawString("Removing 14", 30, 30);
    			g.drawString("(2 Children)", 30, 60);
    			break;
    		case 9:
    			g.drawString("Removing 14", 30, 30);
    			g.drawString("(2 Children)", 30, 60);
    			t.remove(14);
    			break;
    	}
    	t.drawTree(g, 250);
    }
		
	private void inversion(Graphics g) {
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.add(10);
		t.add(9);
    	t.add(14);
    	t.add(12);
    	t.add(5);
    	t.add(19);
    	t.add(16);
    	t.add(4);
    	t.add(8);
    	t.add(7);
    	t.add(6);
    	t.add(18);
    	t.add(15);
    	
    	Font font = new Font("Verdana", Font.BOLD, 20);
    	g.setFont(font);
    	
    	if(opt > 41 && opt < 47) { // 42, 43, 44, 45, 46
    		g.drawString("Initial Graph", 30, 30);
    		t.drawTree(g, 250);
    	} else if(opt > 46 && opt < 52) { // 47, 48, 49, 50, 51
    		g.drawString("Initial Graph", 30, 30);
    		g.drawString("Inverted", 350, 30);
    		g.drawString("Graph", 350, 60);
    		t.drawTree(g, 220);
    		t.invertTree();
    		t.drawTree(g, 520);
    	}
	}
	
    public static void main(String[] args) throws InterruptedException {
    	
        JFrame jFrame = new JFrame("Binary Search Tree");
        GraphicsRunner gr = new GraphicsRunner();
        jFrame.add(gr);
        
//        Button b=new Button("Click Here");
//        b.setBounds(50,100,80,30);  
//        jFrame.add(b);
//        
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocation(100, 100);
//        jFrame.setSize(500, 500);
        jFrame.setSize(750, 500);
        jFrame.setVisible(true);
        
        
        while (true) {
        	gr.changeOPT();
			gr.repaint();
			Thread.sleep(1500);
		}
        
    }

}
