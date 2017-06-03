package clas.work.lesson07;

public class CounterThread  {
	
//	private int count = 0;
//	protected  void increment(){
//		count = count +1;
//		System.err.printf("%s: counter = %s", getName(), count);
//	}
	
//	@Override
//	public void run() {
//		for(int i = 0; i<10; i++){
//			increment();
//		}
//	
//	  }
//	}
class Tree{
	Node root;
public void put (int key, String value){
	Node newNode = new Node(key,value);
		if (root==null)
			root = newNode;
	//			}else{
		//			put(root,newNode);
				}
	}

void put (Node node, Node newNode){
	if (node.key < newNode.key){
		if (node.right==null){
			node.right = newNode;
			
		}
	}else{
		if (node.left ==null){
			node.left=newNode;
		}else{
			put (node.left, newNode);
		}
	}
}

class Node{
	int key;
	String value;
	Node left;
	Node right;
	
	
	public Node (int key, String value){
		this.key =key;
		this.value = value;
	}
}
public class TreeSampleApp{
	
	public void main(String[] args) {
		
	}
}
}



