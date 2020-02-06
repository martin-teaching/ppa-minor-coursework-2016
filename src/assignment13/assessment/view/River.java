package assignment13.assessment.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import assignment13.assessment.controller.Controller;
import assignment13.assessment.model.Game;
import assignment13.assessment.model.pieces.Pieces;

/**
 * This assignment will likely be very tricky to mark.
 * 
 * So, I would advise looking for the following simple things:
 * 
 * 1. That the student can run their code, and show you a simple execution of the game where the game is won, and where the game is lost.
 * 2. That the student adheres to one form of the model view controller paradigm. You'll find different acceptable forms of the diagram here: https://github.kcl.ac.uk/MC/ppa-minor-coursework-ta/tree/ta/briefs/coursework13/e6FdNaws. Students who don't have any form of MVC separation should get at most 2/5.
 * 3. That the student has a reasonable representation in their model, such as not just having a single class called piece, from which everything extends, but appreciating the importance of using interfaces to allow type flexibility.
 *
 * @author Martin
 */
public class River extends JFrame implements Observer {

	private Controller controller;
	private JPanel boat, river, eastBank, westBank, controls;
	private ArrayList<JLabel> pieces;
	
	public River(Controller controller) {
		
		this.controller = controller;
		
		overallFrame();
		river();
		eastBank();
		westBank();
		boat();
		controls();
		
		pieces = new ArrayList<JLabel>();
		
		init();
		
		pack();
		setVisible(true);
	
		setUIFont(new javax.swing.plaf.FontUIResource("Monospace",Font.PLAIN,11));
		
	}
	
	private void overallFrame() {
		
		setTitle("Fox, Goose and Bag of Beans.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1024, 776));
		setLayout(new BorderLayout());
		
	}
	
	/**
	 * River and grass banks are background images. Thus, use paintComponent.
	 */
	private void river() {
		
		river = new JPanel() {
			
			public void paintComponent(Graphics panelGraphics) {
				
				BufferedImage boatImage = null;
				
				try {
				
					boatImage = ImageIO.read( new File("resources/coursework13/water.png") );
					
				} catch (IOException e) {
					
					e.printStackTrace();
				
				}
				
				panelGraphics.drawImage(boatImage, 0, 0, null);
					
			}
		
		};
		
		river.setLayout(new BorderLayout());
		
		add(river, BorderLayout.CENTER);
		
	}

	
	private void eastBank() {
		
		eastBank = new JPanel() {
			
			public void paintComponent(Graphics panelGraphics) {
				
				BufferedImage grassImage = null;
				
				try {
				
					grassImage = ImageIO.read( new File("resources/coursework13/grass.png") );
					
				} catch (IOException e) {
					
					e.printStackTrace();
				
				}
				
				panelGraphics.drawImage(grassImage, 0, 0, null);
					
			}
		
		};
		
		eastBank.setLayout(new GridLayout(0, 1));
		
		eastBank.setPreferredSize(new Dimension(150, 100));
		
		add(eastBank, BorderLayout.EAST);
		
		
	}
	
	private void westBank() {
		
		westBank = new JPanel() {
			
			public void paintComponent(Graphics panelGraphics) {
				
				BufferedImage grassImage = null;
				
				try {
				
					grassImage = ImageIO.read( new File("resources/coursework13/grass.png") );
					
				} catch (IOException e) {
					
					e.printStackTrace();
				
				}
				
				panelGraphics.drawImage(grassImage, 0, 0, null);
					
			}
		
		};
		
		westBank.setLayout(new GridLayout(0, 1));
		
		westBank.setPreferredSize(new Dimension(150, 100));
		
		add(westBank, BorderLayout.WEST);
		
		
	}
	
	private void boat() {
		
		boat = new JPanel() {
			
			public void paintComponent(Graphics panelGraphics) {
				
				BufferedImage boatImage = null;
				
				try {
				
					boatImage = ImageIO.read( new File("resources/coursework13/boat.png") );
					
				} catch (IOException e) {
					
					e.printStackTrace();
				
				}
				
				panelGraphics.drawImage(boatImage, 0, 0, null);
					
			}
		
		};
		
		boat.setPreferredSize(new Dimension(300, 100));
		
		boat.setLayout(new GridLayout(1, 0));
		
	}	
	
	//
	
	private JButton createButton(String text, String name) {
		
		JButton button = new JButton(text);
		button.setName(name);
		button.addActionListener(controller);
		return button;
		
	}

	private void controls() {
		
		controls = new JPanel();
		add(controls, BorderLayout.SOUTH);
		
		controls.add(new JLabel("Boat: "));
		controls.add(createButton("<", "left-boat"));
		controls.add(createButton(">", "right-boat"));
		
		controls.setLayout(new FlowLayout());
		
	}
	
	//

	/**
	 * Pieces are foreground labels.
	 * 
	 * @param url
	 * @param id
	 * @param text
	 */
	public void addPiece(String url, String id, String text) {
		
		try {
			
			JLabel pieceImage = new JLabel();
			pieceImage.setIcon( new ImageIcon( ImageIO.read ( new File(url) ) ) );
			pieceImage.setName(id + "");
			pieceImage.setHorizontalAlignment(JLabel.CENTER);
			pieces.add(pieceImage);
			
			controls.add(new JLabel(text));
			controls.add(createButton("<", "left-" + id));
			controls.add(createButton(">", "right-" + id));
			
		} catch (IOException e) {
	
			e.printStackTrace();
		
		}
		
	}
	
	public void init() {
		
		addPiece("resources/coursework13/fox.png", Pieces.FOX, "Fox: ");
		addPiece("resources/coursework13/goose.png", Pieces.GOOSE, "Goose: ");
		addPiece("resources/coursework13/beans.png", Pieces.BEANS, "Beans: ");
		addPiece("resources/coursework13/farmer.png", Pieces.FARMER, "Farmer: ");
		addToEastBank(Pieces.FOX);
		addToEastBank(Pieces.GOOSE);
		addToEastBank(Pieces.BEANS);
		addToEastBank(Pieces.FARMER);
		
		moveBoatRight();
		
	}
	
	//
	
	private JLabel getPiece(String id) {
		
		for ( JLabel label : pieces ) {
			
			if ( label.getName().equals(id) ) return label;
				
		}
		
		return null;
	}
	
	public void removeFromEastBank(String piece) {
		
		eastBank.remove(getPiece(piece));
		repaint();
		
	}

	public void addToBoat(String piece) {
		
		boat.add(getPiece(piece));
		revalidate();
		
	}
	
	public void moveBoatLeft() {
		
		river.remove(boat);
		repaint();
		river.add(boat, BorderLayout.WEST);
		revalidate();
		
	}
	
	public void removeFromBoat(String piece) {
		
		boat.remove(getPiece(piece));
		repaint();
		
	}
	
	public void addToWestBank(String piece) {
		
		westBank.add(getPiece(piece));
		revalidate();
	
	}
	
	public void removeFromWestBank(String piece) {
		
		westBank.remove(getPiece(piece));
		repaint();
		
	}
	
	public void moveBoatRight() {
		
		river.remove(boat);
		repaint();
		river.add(boat, BorderLayout.EAST);
		revalidate();
		
	}
	
	public void addToEastBank(String piece) {
		
		eastBank.add(getPiece(piece));
		revalidate();
		
	}

	@Override
	public void update(Observable o, Object arg) {
		
		// Not strictly needed, but nice to have an explicit removal.
		boat.removeAll();
		westBank.removeAll();
		eastBank.removeAll();
		
		if ( o instanceof Game ) {
			
			Game model = (Game)o;
			
			if ( model.getRiver().boatOnLeft() ) {
				
				moveBoatLeft();
				
			} else {
				
				moveBoatRight();
			
			}
			
			for ( JLabel label : pieces ) {
				
				if ( model.getRiver().onRightBank( model.pieceToPassenger( label.getName() ) ) ) {
					
					addToEastBank(label.getName());
					
				} else if ( model.getRiver().onLeftBank( model.pieceToPassenger(label.getName() ) ) ) {
					
					addToWestBank(label.getName());
					
				} else {
					
					addToBoat(label.getName());
					
				}
				
			}
			
			if ( model.gameOver() ) {
			
				setTitle("Game over: " + model.getOutcome());
			
			} else {
				
				setTitle("Score: " + model.getScore());
				
			}
			
		}
		
	}
	
	//
	
	public static void setUIFont(FontUIResource f) {
		
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		
		while (keys.hasMoreElements()) {
		
			Object key = keys.nextElement();
			
			Object value = UIManager.get(key);
			
			if (value != null && value instanceof FontUIResource) UIManager.put(key, f);
		
		}
	
	}
	
}
