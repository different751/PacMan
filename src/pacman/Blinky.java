package pacman;



import jig.Entity;
import jig.ResourceManager;
import jig.Vector;

import java.util.ArrayList;
import java.util.Stack;

import org.newdawn.slick.Animation;






/**
 * A class representing a transient explosion. The game should monitor
 * explosions to determine when they are no longer active and remove/hide
 * them at that point.
 */
class Blinky extends Entity {
	public Animation Blinkani;
	public int countdown;
	public int state=0;
	public Vector velocity;
	public int nexttile;
	public int currenttilex=14;
	public int currenttiley=11;
	public int nexttilex=0;
	public int nexttiley=0;
	public int check=0;
	public float blinkx=232;
	public float blinky=232;
	public int desired=0;
	public int current=0;
	public int key=0;
	Stack<Node> officalstack = new Stack<Node>();
	public Node officalnode = null;

	public Blinky(final float x, final float y) {
		super(x,y);
		Blinkani = new Animation(ResourceManager.getSpriteSheet(PacManGame.BL_BL_RSC, 28, 28),100);
		addAnimation(Blinkani);
		Blinkani.setLooping(true);
		//addImageWithBoundingBox(ResourceManager.getImage(PacManGame.PACMAN_PACMAN_RSC));
		countdown=0;
		//ResourceManager.getSound(BounceGame.BANG_EXPLOSIONSND_RSC).play();
	}

	
	public void choice(int mazex, int mazey, PacManGame pg){
		//System.out.println(currenttilex +","+ currenttiley);
		if(state==0){
			officalstack=this.getstack(this.getshortestpath2(currenttilex, currenttiley, mazex, mazey, pg));
			if(officalstack.isEmpty()==false){
				officalnode = officalstack.pop();
			}
			
		System.out.println(officalnode.x + " , "+ officalnode.y);
			
		if(currenttiley-officalnode.y==-1){
			//move down
				desired =2;
				this.move(pg);
				System.out.println("down");
		}
	
		 if(currenttilex-officalnode.x==-1){
			//move right
			
			desired =4;
			this.move(pg);
			System.out.println("right");
		}
	
		 if(currenttiley-officalnode.y==1){
			//move up
			  
				desired=1;
				this.move(pg);
				System.out.println("up");
			
		}
	System.out.println(currenttilex-officalnode.y);
		  if(currenttilex-officalnode.x==1){
			//move left
				desired=3;
				this.move(pg);
				System.out.println("left");

		}
			
			/*if(currenttiley < mazey){
				//move down
					desired =2;
					this.move(pg);
			}
		
			 if(currenttilex < mazex){
				//move right
				
				desired =4;
				this.move(pg);
			}
		
			 if(currenttiley> mazey){
				//move up
				  
					desired=1;
					this.move(pg);
				
			}
		
			  if(currenttilex > mazex){
				//move left
					desired=3;
					this.move(pg);
	
			}*/
		}
		
		if(state==1){
			
			if(check>0){
				blinkx-=1.6;
				check-=1;
				pg.blinky.setX(blinkx);
			}
			else{
				state=0;
				currenttilex=nexttilex;
			}
			
			
		}
		if(state==2){
			if(check>0){
				blinkx+=1.6;
				check-=1;
				pg.blinky.setX(blinkx);
			}
			else{
				state=0;
				currenttilex=nexttilex;
			}
		}
		if(state==3){
			if(check>0){
				blinky-=1.6;
				check-=1;
				pg.blinky.setY(blinky);
			}
			else{
				state=0;
				currenttiley=nexttiley;
			}
		}
		if(state==4){
			
			if(check>0){
				blinky+=1.6;
				check-=1;
				pg.blinky.setY(blinky);
			}
			else{
				state=0;
				currenttiley=nexttiley;
			}
		}
		
	}
	
	public void choice2(int mazex, int mazey, PacManGame pg){
		//System.out.println(currenttilex +","+ currenttiley);
		
		if(state==0){
			officalstack=this.getstack(this.getshortestpath(currenttilex, currenttiley, mazex, mazey, pg));
			if(officalstack.isEmpty()==false){
				officalnode = officalstack.pop();
			}
			
		System.out.println(officalnode.x + " , "+ officalnode.y);
			
		if(currenttiley-officalnode.y==-1){
			//move down
				desired =2;
				this.move2(pg);
				System.out.println("down");
		}
	
		 if(currenttilex-officalnode.x==-1){
			//move right
			
			desired =4;
			this.move2(pg);
			System.out.println("right");
		}
	
		 if(currenttiley-officalnode.y==1){
			//move up
			  
				desired=1;
				this.move2(pg);
				System.out.println("up");
			
		}
	System.out.println(currenttilex-officalnode.y);
		  if(currenttilex-officalnode.x==1){
			//move left
				desired=3;
				this.move2(pg);
				System.out.println("left");

		}
			//old AI
			/*if(currenttiley < mazey){
				//move down
					desired =2;
					this.move2(pg);
			}
		
			 if(currenttilex < mazex){
				//move right
				
				desired =4;
				this.move2(pg);
			}
		
			 if(currenttiley> mazey){
				//move up
				  
					desired=1;
					this.move2(pg);
				
			}
		
			  if(currenttilex > mazex){
				//move left
					desired=3;
					this.move2(pg);
	
			}*/
		  
		}
		
		if(state==1){
			
			if(check>0){
				blinkx-=1.6;
				check-=1;
				pg.blinky.setX(blinkx);
			}
			else{
				state=0;
				currenttilex=nexttilex;
			}
			
			
		}
		if(state==2){
			if(check>0){
				blinkx+=1.6;
				check-=1;
				pg.blinky.setX(blinkx);
			}
			else{
				state=0;
				currenttilex=nexttilex;
			}
		}
		if(state==3){
			if(check>0){
				blinky-=1.6;
				check-=1;
				pg.blinky.setY(blinky);
			}
			else{
				state=0;
				currenttiley=nexttiley;
			}
		}
		if(state==4){
			
			if(check>0){
				blinky+=1.6;
				check-=1;
				pg.blinky.setY(blinky);
			}
			else{
				state=0;
				currenttiley=nexttiley;
			}
		}
		
	}
	
	private void move(PacManGame pg){
		if(desired==3){
			if(pg.mazecando[currenttiley][currenttilex-1]!=1){
				state=1;
				nexttilex=currenttilex-1;
				nexttiley=currenttiley;
				key=3;
				check=10;
				current=3;
				return;
			}
			else if(current==3){
				//state=3;
				return;
			}
			return;
		}
		
		if(desired==1){
			if(pg.mazecando[currenttiley-1][currenttilex]!=1){
				state=3;
				nexttilex=currenttilex;
				nexttiley=currenttiley-1;
				key=1;
				check=10;
				current=1;
				return;
			}
			else if(current==1){
				//state=0;
				return;
			}
			
			return;
		}
		
		if(desired==2){
			if(pg.mazecando[currenttiley+1][currenttilex]!=1){
				state=4;
				nexttilex=currenttilex;
				nexttiley=currenttiley+1;
				key=2;
				check=10;
				current=2;
				return;
			}
			else if(current==2){
				//state=0;
				return;
			}
			return;
		}
		
		if(desired==4){
			if(pg.mazecando[currenttiley][currenttilex+1]!=1){
				state=2;
				nexttilex=currenttilex+1;
				nexttiley=currenttiley;
				key=4;
				check=10;
				current=4;
				return;
			}
			else if(current==4){
				//state=0;
				return;
			}
			return;
		}
		return;
	}
	
	private void move2(PacManGame pg){
		if(desired==3){
			if(pg.maze2cando[currenttiley][currenttilex-1]!=1){
				state=1;
				nexttilex=currenttilex-1;
				nexttiley=currenttiley;
				key=3;
				check=10;
				current=3;
				return;
			}
			else if(current==3){
				//state=3;
				return;
			}
			return;
		}
		
		if(desired==1){
			if(pg.maze2cando[currenttiley-1][currenttilex]!=1){
				state=3;
				nexttilex=currenttilex;
				nexttiley=currenttiley-1;
				key=1;
				check=10;
				current=1;
				return;
			}
			else if(current==1){
				//state=0;
				return;
			}
			
			return;
		}
		
		if(desired==2){
			if(pg.maze2cando[currenttiley+1][currenttilex]!=1){
				state=4;
				nexttilex=currenttilex;
				nexttiley=currenttiley+1;
				key=2;
				check=10;
				current=2;
				return;
			}
			else if(current==2){
				//state=0;
				return;
			}
			return;
		}
		
		if(desired==4){
			if(pg.maze2cando[currenttiley][currenttilex+1]!=1){
				state=2;
				nexttilex=currenttilex+1;
				nexttiley=currenttiley;
				key=4;
				check=10;
				current=4;
				return;
			}
			else if(current==4){
				//state=0;
				return;
			}
			return;
		}
		return;
	}
	
	public Node getshortestpath(int srcx,int srcy,int destx,int desty, PacManGame pg){
		//System.out.println(currenttilex +" , "+ currenttiley);
		
		int graph[][] = new int[31][28];
		
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				graph[i][z]=pg.maze2cando[i][z];
			}
		}
		
		
		
		//PriorityQueue<Node> q = new PriorityQueue<Node>();
		ArrayList<Node> path = new ArrayList<Node>();
		ArrayList<Node> q = new ArrayList<Node>();
		//ArrayList<Node> open = new ArrayList<Node>();
		int min=1;
		int elementpop=0;
		Node root = new Node();
//		Node currentnode= new Node();
		
		
		
		
		root.x=srcx;
		root.y= srcy;
		root.cost=0;
		root.parent=null;
		
		q.add(root);
		
		graph[srcy][srcx]=-1;
		
		System.out.println(graph[currenttiley+1][currenttilex] +" , up "+ graph[currenttiley-1][currenttilex] +" , right" +graph[currenttiley][currenttilex+1] +" , left "+ graph[currenttiley][currenttilex-1] 
				+", currenttiles " + currenttilex + currenttiley +" , pg " + pg.maze2[currenttiley][currenttilex] +" , pg left " + pg.maze2[currenttiley][currenttilex-1]);
		
		while(q.isEmpty()==false){
			Node currentnode= new Node();
			min =300;
			for(int i=0;i<q.size();i++){
				if(q.get(i).cost<min){
					min=q.get(i).cost;
					elementpop=i;
					//currentnode=q.remove(i);
				}
			}
			
			currentnode=q.remove(elementpop);
			
			
			if(currentnode.x==destx && currentnode.y==desty){
				//break;
				return(currentnode);
			}
			
			if(graph[currentnode.y][currentnode.x+1]==0){
				Node child1 = new Node();
				child1.x=currentnode.x+1;
				child1.y=currentnode.y;
				child1.parent=currentnode;
				child1.cost=currentnode.cost + 1;
				graph[child1.y][child1.x]=-1;
				q.add(child1);
				
			}
			else if(graph[currentnode.y][currentnode.x+1]==-1){
				Node child1 = new Node();
				child1.x=currentnode.x+1;
				child1.y=currentnode.y;
				child1.parent=currentnode;
				child1.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child1.x && q.get(i).y==child1.y){
						if(q.get(i).cost>child1.cost){
							q.remove(i);
							q.add(child1);
						}
						break;
					}
				}
				
			}
			
			if(graph[currentnode.y][currentnode.x-1]==0){
				Node child2 = new Node();
				child2.x=currentnode.x-1;
				child2.y=currentnode.y;
				child2.parent=currentnode;
				child2.cost=currentnode.cost + 1;
				graph[child2.y][child2.x]=-1;
				q.add(child2);
				
			}
			else if(graph[currentnode.y][currentnode.x-1]==-1){
				Node child2 = new Node();
				child2.x=currentnode.x-1;
				child2.y=currentnode.y;
				child2.parent=currentnode;
				child2.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child2.x && q.get(i).y==child2.y){
						if(q.get(i).cost>child2.cost){
							q.remove(i);
							q.add(child2);
						}
						break;
					}
				}
				
			}
			
			
			if(graph[currentnode.y+1][currentnode.x]==0){
				Node child3 =new Node();
				child3.x=currentnode.x;
				child3.y=currentnode.y+1;
				child3.parent=currentnode;
				child3.cost=currentnode.cost + 1;
				graph[child3.y][child3.x]=-1;
				
				q.add(child3);
			}
			else if(graph[currentnode.y+1][currentnode.x]==-1){
				Node child3 =new Node();
				child3.x=currentnode.x;
				child3.y=currentnode.y+1;
				child3.parent=currentnode;
				child3.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child3.x && q.get(i).y==child3.y){
						if(q.get(i).cost>child3.cost){
							q.remove(i);
							q.add(child3);
						}
						break;
					}
				}
				
			}
			
			if(graph[currentnode.y-1][currentnode.x]==0){
				Node child4 = new Node();
				child4.x=currentnode.x;
				child4.y=currentnode.y-1;
				child4.parent=currentnode;
				child4.cost=currentnode.cost + 1;
				graph[child4.y][child4.x]=-1;
				
				q.add(child4);
				
			}
			else if(graph[currentnode.y-1][currentnode.x]==-1){
				Node child4 = new Node();
				child4.x=currentnode.x;
				child4.y=currentnode.y-1;
				child4.parent=currentnode;
				child4.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child4.x && q.get(i).y==child4.y){
						if(q.get(i).cost>child4.cost){
							q.remove(i);
							q.add(child4);
						}
						break;
					}
				}
				
			}
			
			path.add(currentnode);
			
			
		}
		
		return(path.get(path.size()-1));
		
	}
	
	public Node getshortestpath2(int srcx,int srcy,int destx,int desty, PacManGame pg){
		//System.out.println(currenttilex +" , "+ currenttiley);
		
		int graph[][] = new int[31][28];
		
		for(int i=0;i<31;i++){
			for(int z=0;z<28;z++){
				graph[i][z]=pg.mazecando[i][z];
			}
		}
		
		
		
		//PriorityQueue<Node> q = new PriorityQueue<Node>();
		ArrayList<Node> path = new ArrayList<Node>();
		ArrayList<Node> q = new ArrayList<Node>();
		//ArrayList<Node> open = new ArrayList<Node>();
		int min=1;
		int elementpop=0;
		Node root = new Node();
//		Node currentnode= new Node();
		
		
		
		
		root.x=srcx;
		root.y= srcy;
		root.cost=0;
		root.parent=null;
		
		q.add(root);
		
		graph[srcy][srcx]=-1;
		
		System.out.println(graph[currenttiley+1][currenttilex] +" , up "+ graph[currenttiley-1][currenttilex] +" , right" +graph[currenttiley][currenttilex+1] +" , left "+ graph[currenttiley][currenttilex-1] 
				+", currenttiles " + currenttilex + currenttiley +" , pg " + pg.maze[currenttiley][currenttilex] +" , pg left " + pg.maze[currenttiley][currenttilex-1]);
		
		while(q.isEmpty()==false){
			Node currentnode= new Node();
			min =300;
			for(int i=0;i<q.size();i++){
				if(q.get(i).cost<min){
					min=q.get(i).cost;
					elementpop=i;
					//currentnode=q.remove(i);
				}
			}
			
			currentnode=q.remove(elementpop);
			
			
			if(currentnode.x==destx && currentnode.y==desty){
				//break;
				return(currentnode);
			}
			//System.out.println(currentnode.x);
			if(graph[currentnode.y][currentnode.x+1]==0){
				Node child1 = new Node();
				child1.x=currentnode.x+1;
				child1.y=currentnode.y;
				child1.parent=currentnode;
				child1.cost=currentnode.cost + 1;
				graph[child1.y][child1.x]=-1;
				q.add(child1);
				
			}
			else if(graph[currentnode.y][currentnode.x+1]==-1){
				Node child1 = new Node();
				child1.x=currentnode.x+1;
				child1.y=currentnode.y;
				child1.parent=currentnode;
				child1.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child1.x && q.get(i).y==child1.y){
						if(q.get(i).cost>child1.cost){
							q.remove(i);
							q.add(child1);
						}
						break;
					}
				}
				
			}
			
			if(graph[currentnode.y][currentnode.x-1]==0){
				Node child2 = new Node();
				child2.x=currentnode.x-1;
				child2.y=currentnode.y;
				child2.parent=currentnode;
				child2.cost=currentnode.cost + 1;
				graph[child2.y][child2.x]=-1;
				q.add(child2);
				
			}
			else if(graph[currentnode.y][currentnode.x-1]==-1){
				Node child2 = new Node();
				child2.x=currentnode.x-1;
				child2.y=currentnode.y;
				child2.parent=currentnode;
				child2.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child2.x && q.get(i).y==child2.y){
						if(q.get(i).cost>child2.cost){
							q.remove(i);
							q.add(child2);
						}
						break;
					}
				}
				
			}
			
			
			if(graph[currentnode.y+1][currentnode.x]==0){
				Node child3 =new Node();
				child3.x=currentnode.x;
				child3.y=currentnode.y+1;
				child3.parent=currentnode;
				child3.cost=currentnode.cost + 1;
				graph[child3.y][child3.x]=-1;
				
				q.add(child3);
			}
			else if(graph[currentnode.y+1][currentnode.x]==-1){
				Node child3 =new Node();
				child3.x=currentnode.x;
				child3.y=currentnode.y+1;
				child3.parent=currentnode;
				child3.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child3.x && q.get(i).y==child3.y){
						if(q.get(i).cost>child3.cost){
							q.remove(i);
							q.add(child3);
						}
						break;
					}
				}
				
			}
			
			if(graph[currentnode.y-1][currentnode.x]==0){
				Node child4 = new Node();
				child4.x=currentnode.x;
				child4.y=currentnode.y-1;
				child4.parent=currentnode;
				child4.cost=currentnode.cost + 1;
				graph[child4.y][child4.x]=-1;
				
				q.add(child4);
				
			}
			else if(graph[currentnode.y-1][currentnode.x]==-1){
				Node child4 = new Node();
				child4.x=currentnode.x;
				child4.y=currentnode.y-1;
				child4.parent=currentnode;
				child4.cost=currentnode.cost + 1;
				
				for(int i=0;i<q.size();i++){
					if(q.get(i).x==child4.x && q.get(i).y==child4.y){
						if(q.get(i).cost>child4.cost){
							q.remove(i);
							q.add(child4);
						}
						break;
					}
				}
				
			}
			
			path.add(currentnode);
			
			
		}
		
		return(path.get(path.size()-1));
		
	}
	
	public Stack<Node> getstack(Node a){
		Stack<Node> nodestack = new Stack<Node>();
		
		while(a!=null){
			nodestack.add(a);
			a=a.parent;
		}
		nodestack.pop();
		return(nodestack);
	}
	
	
	public int getblinkmazex(){
		return(currenttilex);
	}
	
	public int getblinkmazey(){
		return(currenttiley);
	}
	
	public void update(final int delta) {
		translate(velocity.scale(delta));
		
	}
	
}