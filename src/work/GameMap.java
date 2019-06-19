package work;

import java.awt.*;

import javax.swing.*;

public class GameMap extends JPanel implements Runnable{
    private int width;
    private int height;
    private int blockwidth=10;
    private int blockheight=10;
    private JLabel[][] labels;
//private int p=0;//
//private int o=0;//
    
    
    public GameMap(int width,int height){
    	this.width=width;
    	this.height=height;
    	this.setLayout(null);
    	this.labels = new JLabel[width][height];
    	this.InitMap();
    	this.Randomset();
    }
     
    

 // 界面初始化
 	private void InitMap(){
 		for (int i = 0; i < this.width; i++) {
 			for (int j = 0; j < this.height; j++) {
 				JLabel l = new JLabel();
 				l.setBounds(j * blockwidth, i * blockheight, blockwidth, blockheight);	// 设置每个小方格的边界 				                                                                    
 				l.setBorder(BorderFactory.createLineBorder(Color.black));// 设置边框为黑色
 				l.setOpaque(true);//
 				l.setBackground(Color.white);// 方格为白色
 				this.add(l);		// 将方格加入到容器中(即面板JPanel)
 				labels[i][j] = l;
 			}
 		}
 	}

 private void Randomset(){
	 for(int i=0;i<width;i++)
	 {
		 for(int j=0;j<height;j++)
		 {

			double rd=Math.random();
			 if(rd>0.5){labels[i][j].setBackground(Color.BLACK);}
			 else{labels[i][j].setBackground(Color.white);}
		 }
	 }
 }
 
 private void judge(int m,int n)
 {
	 //////////////////////////////////////////////////////////////
	 
	 
	 
	 //////////////////////////////////////////////////////////////
		 int i=0;int j=0;int count=0;
		 for(i=m-1;i<=m+1;i++) {
			 for(j=n-1;j<=n+1;j++) {
				 if(i < 0 || i >=width-1 || j < 0  
	                        || j >= height-1||(i==m&&j==n)) {
					 continue;
				 }
				 if(labels[i][j].getBackground().equals(Color.white)) {
					 count++;
				 }
			 }
			 if(count>3||count<2) {
				 labels[m][n].setBackground(Color.BLACK);
			 }
			 if(count==3) {
				 labels[m][n].setBackground(Color.white);
			 }
		 }
		
 }

 void test(){
	 for(int i=0;i<width;i++)
	 {
		 for(int j=0;j<height;j++)
		 {
			 judge(i,j);
		 }
	 }
 }

 
 
 
 @Override
	public void run() {
	 while(true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.test();
		}
 }
////////////////////////////////////////////
/*if(o<width){
this.judge(o, p);

if(p==height-1){p=0;o++;}

else p++;
}

		setVisible(true);
		 if(o==width){o=0;}
	 }
	
 }*/
////////////////////////////////////////////// 	
public static void main(String args[]){
	JFrame w=new JFrame();
	w.setSize(780, 780);
	GameMap map=new GameMap(100,100);
	w.add(map);
	w.setVisible(true);
	new Thread(map).start();
}
 	
}


