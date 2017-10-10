package tree;
/**
 * 数组实现的二叉树
 * @author yw395
 *       (0)
 *   5(1)     8(2)
 *2(3) 6(4) 9(5)   7(6)
 */
public class BinaryTree2 {

	private Node m_Root;
	public BinaryTree2(){
		
		m_Root = new Node();
	}
	
	public Node searchNode(int nodeIndex){
		return m_Root.searchNode(nodeIndex);
	}
	
	public boolean addNode(int nodeIndex,int direction,Node pNode ){
		Node temp = searchNode(nodeIndex);
		if(temp == null){
			return false;
		}
		
		if(direction ==0 ){
			temp.pLChild = pNode;
		}
		else if(direction == 1){
			temp.pRChild = pNode;
		}
		return true;
	}
	//TODO 未完成
	public Node deleteNode(int nodeIndex){
		return deleteNode(nodeIndex,m_Root);
	}
	//TODO 未完成
	private Node deleteNode(int nodeIndex,Node node){
		
		Node temp = new Node();
		if(node.index == nodeIndex){
			temp.data  = node.data;
			temp.index = node.index; 
			node = null;
			return temp;
		}
		
		if(node.pLChild != null){
			temp = deleteNode(nodeIndex, node.pLChild);
			if(temp != null){
				return temp;
			}
		}
		if(node.pRChild != null){
			temp = deleteNode(nodeIndex, node.pRChild);
			if(temp != null){
				return temp;
			}
		}
		
		return null;
	}
	
	public void preOrderTraverse(){
		m_Root.preOrder();
	}
	public void inOrderTraverse(){
		m_Root.inOrder();
	}
	public void postOrderTraverse(){
		m_Root.postOrder();
	}
	
	public static void main(String[] args) {
		
		BinaryTree2 tree = new BinaryTree2();
		
		Node node1 = new Node();
		node1.index = 1;
		node1.data = 5;
		
		Node node2 = new Node();
		node2.index = 2;
		node2.data = 8;
		
		Node node3 = new Node();
		node3.index = 3;
		node3.data = 2;
		
		Node node4 = new Node();
		node4.index = 4;
		node4.data = 6;
		
		Node node5 = new Node();
		node5.index = 5;
		node5.data = 9;
		
		Node node6 = new Node();
		node6.index = 6;
		node6.data = 7;
		/*
		 *       (0)
		 *   5(1)     8(2)
		 *2(3) 6(4) 9(5)   7(6)
		 */
		
		tree.addNode(0, 0, node1);
		tree.addNode(0, 1, node2);
		
		tree.addNode(1, 0, node3);
		tree.addNode(1, 1, node4);
		
		tree.addNode(2, 0, node5);
		tree.addNode(2, 1, node6);
		
		System.out.println("*****前序遍历*****");
		tree.preOrderTraverse();
//		System.out.println("*****中序遍历*****");
//		tree.inOrderTraverse();
//		System.out.println("*****后序遍历*****");
//		tree.postOrderTraverse();
		
		Node n = tree.deleteNode(6);
		System.out.println(n);
		System.out.println("*****前序遍历*****");
		tree.preOrderTraverse();
	}
}

class Node{
	public int index;
	public int data;
	Node pParent;
	Node pLChild;
	Node pRChild;
	public Node() {
		index = 0;
		data = 0;
	}
	
	public void preOrder(){
		System.out.println("index="+index+",data="+data);
		if(this.pLChild != null){
			this.pLChild.preOrder();
		}
		if(this.pRChild != null){
			this.pRChild.preOrder();
		}
	}
	
	public void inOrder(){
		if(this.pLChild != null){
			this.pLChild.inOrder();
		}
		System.out.println("index="+index+",data="+data);
		if(this.pRChild != null){
			this.pRChild.inOrder();
		}
	}
	
	public void postOrder(){
		if(this.pLChild != null){
			this.pLChild.postOrder();
		}
		if(this.pRChild != null){
			this.pRChild.postOrder();
		}
		System.out.println("index="+index+",data="+data);
	}
	
	public Node searchNode(int nodeIndex){
		if(this.index == nodeIndex){
			return this;
		}
		Node temp = null;
		if(this.pLChild != null){
			if(this.pLChild.index == nodeIndex){
				return this.pLChild;
			}
			else{
				temp = this.pLChild.searchNode(nodeIndex);
				if(temp != null) {
					return temp;
				}
			}
		}
		if(this.pRChild != null){
			if(this.pRChild.index == nodeIndex){
				return this.pRChild;
			}
			else{
				temp =  this.pRChild.searchNode(nodeIndex);
				if(temp != null) {
					return temp;
				}
			}
		}
		return null;
	}
	
}
