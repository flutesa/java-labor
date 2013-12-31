import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		//Example();
		//Two();
		//Four();
		//Six();
		//Eight();
		//Ten();
		//Twelve();
  }
	
	public static void Two(){	
		JFrame fr=new JFrame("Упругая окружность");
		fr.setPreferredSize( new Dimension(400, 400));
		final JPanel pan = new JPanel();
		
		fr.add(pan);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		
		Timer tm = new Timer(500, new ActionListener(){
			int i=0,x=100,y=100,delta = 20,r = 50;
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Graphics2D gr = (Graphics2D)pan.getRootPane().getGraphics();
					pan.update(gr);
					
					GeneralPath path = new GeneralPath();
					path.append(new Ellipse2D.Double(x, y, r, r), true);
					if(x+delta+r>=400 || x<=0)
						delta*=-1;
					
					AffineTransform tranforms = AffineTransform.getRotateInstance((i), x+=delta, y);
					gr.transform(tranforms);
					gr.draw(path);
				}
			});
		tm.start();
	}
	
	public static void Four(){
		JFrame fr=new JFrame("Отрезок");
		fr.setPreferredSize( new Dimension(400, 400));
		final JPanel pan = new JPanel();
		
		fr.add(pan);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		
		Timer tm = new Timer(500, new ActionListener(){
			int i=0,x=100,y=200;
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Graphics2D gr = (Graphics2D)pan.getRootPane().getGraphics();
					pan.update(gr);
					
					GeneralPath path = new GeneralPath();
					//Line2D line = new Line2D.Double(100, 100, 200, 200);
					path.append(new Line2D.Double(x, x, y, y), true);
					
					gr.setColor(Color.getHSBColor((float) 0.1*i, 1, 1));

					AffineTransform tranforms = AffineTransform.getRotateInstance((i++), y, y);
					gr.transform(tranforms);
					gr.draw(path);
				}
			});
		tm.start();
	}

	public static void Six(){
		JFrame fr=new JFrame("Вращение четырехугольника вокруг центра тяжести");
		fr.setPreferredSize( new Dimension(400,400));
		
		final JPanel pan= new JPanel();
		
		fr.add(pan);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		
		Timer tm= new Timer(400, new ActionListener(){
			int i=0,x=100,y=100,h = 100,w = 100;
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
					pan.update(gr);
					
					GeneralPath path=new GeneralPath();
					path.append(new Rectangle(x,y,w,h),true);
					
					float centerX = x + (w)/2;
					float centerY = y + (h)/2;
					
					AffineTransform tranforms = AffineTransform.getRotateInstance((i++)*0.5, centerX, centerY);
					gr.transform(tranforms);
					gr.draw(path);
				}
			});
		tm.start();
	}
	
	public static void Eight(){
		JFrame fr=new JFrame("Точка");
		fr.setPreferredSize( new Dimension(400,400));		
		Global.s = 0;
		
		final JPanel pan= new JPanel();
		final JButton plus = new JButton();
		final JButton minus= new JButton();
		
		plus.setText("+");
		minus.setText("-");
		
		plus.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Global.s++;
			}
		});
		
		minus.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Global.s--;
			}
		});
		
		
		fr.add(pan);
		pan.add(plus);
		pan.add(minus);
		
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		
		Timer tm= new Timer(400, new ActionListener(){
			int i=0,x=100,y=100;
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
					pan.update(gr);
					
					GeneralPath path=new GeneralPath();
					
					path.append(new Ellipse2D.Double(x, y, 10, 10),true);
					gr.fillOval(x, y, 10, 10);
					
					//float centerX = x + (w)/2;
					//float centerY = y + (h)/2;
					
					AffineTransform tranforms = AffineTransform.getRotateInstance((i), x+=Global.s, y);
					
					gr.transform(tranforms);
					gr.draw(path);
				}
			});
		tm.start();
	}
	
	public static void Ten(){
		JFrame fr=new JFrame("Строка");
		String[] sourse = {"Dungeon","Ariel","Batang","Impact","Mistral"};
		
		fr.setPreferredSize( new Dimension(400,400));
		
		final JDesktopPane  pan= new JDesktopPane();
		
		fr.add(pan);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		
		final JComboBox box = new JComboBox(sourse);
		box.setBounds(250,0,100,50);
		pan.add(box);
		
		Timer tm= new Timer(20, new ActionListener(){
			int i=0,x=0,h = 20,w = 100;
			String content = "Watch this!", newContent = "";
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Graphics2D gr=(Graphics2D)pan.getRootPane().getGraphics();
					x++;
					
					String value = box.getSelectedItem().toString();
					
					int count = pan.getComponentCount();
					if(count > 1)
						pan.remove(1);
					
					if(x+w >= 400){
						newContent = "";
						for(int j=0; j<content.length(); j++){
							char c = content.charAt(j);
							double r = Math.random()*10;
							if(r >= 5 ){
								c = Character.toLowerCase(c);
								newContent += c;
							}
							else{
								c = Character.toUpperCase(c);
								newContent += c;
							}
						}
						content = newContent;
						JLabel label = new JLabel(content);
						label.setBounds(x, x, w, h);
						label.setFont(new Font(value, Font.PLAIN, 12));
						pan.add(label);
						x=0;
					}
					else
					{
						JLabel label = new JLabel(content);
						label.setFont(new Font(value, Font.PLAIN, 12));
						label.setBounds(x, x, w, h);
						pan.add(label);
					}

					pan.updateUI();
				}
			});
		tm.start();
	}

	public static void Twelve(){
		JFrame fr=new JFrame("Орбиты");
		fr.setPreferredSize( new Dimension(400, 400));
		final JPanel pan = new JPanel();
		
		fr.add(pan);
		fr.setVisible(true);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.pack();
		
		Timer tm = new Timer(200, new ActionListener(){
			int i=0,x=100,y=100,delta = 20,r = 30,k = 0, tmp = 0;
			
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Graphics2D gr = (Graphics2D)pan.getRootPane().getGraphics();
					pan.update(gr);
					
					GeneralPath path = new GeneralPath();
					
					if(delta>0){
						path.append(new Ellipse2D.Double(200,100,40,40), true);
						gr.setColor(Color.red);
						gr.fillOval(200, 100, 40, 40);
						
						Ellipse2D follower =  new Ellipse2D.Double(x, y, r, r);
						
						path.append(follower, false);
						gr.setColor(Color.black);
						gr.fillOval(x,y,r,r);
					}
					else{
						Ellipse2D follower =  new Ellipse2D.Double(x, y, r, r);
						
						path.append(follower, false);
						gr.setColor(Color.black);
						gr.fillOval(x,y,r,r);
						
						path.append(new Ellipse2D.Double(200,100,40,40), false);
						gr.setColor(Color.red);
						gr.fillOval(200, 100, 40, 40);
					}
					
					
					if(x+delta+r>=400 || x<=0)
						delta*=-1;
					
					AffineTransform tranforms = AffineTransform.getRotateInstance((i), x+=delta, y);
					gr.transform(tranforms);
					gr.draw(path);
				}
			});
		tm.start();
	}


}
