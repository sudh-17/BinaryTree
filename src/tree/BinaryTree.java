package tree;
/**
 * 数组实现的二叉树
 * @author yw395
 *
 */
public class BinaryTree {

	private int[] m_pTree;
	private int m_iSize;
	
	public BinaryTree(int size,int pRoot){
		m_pTree = new int[size];
		m_iSize = size;
		m_pTree[0]=pRoot;
	}
	
	
	
	public int searchNode(int nodeIndex){
		
		if(nodeIndex <0 || nodeIndex >= m_iSize)
		{
			return -1;
		}
		if(m_pTree[nodeIndex] == 0){
			
			return -1;
		}
		return m_pTree[nodeIndex];
	}
	
	public boolean addNode(int nodeIndex,int direction,int pNode){
		
		if(nodeIndex < 0 || nodeIndex >= m_iSize)
		{
			return false;
		}
		if(m_pTree[nodeIndex] == 0){  //父节点是空值
			
			return false;
		}
		if(direction == 0){
			if(nodeIndex*2+1 < 0 || nodeIndex*2+1 >= m_iSize)
			{
				return false;
			}
			if(m_pTree[nodeIndex*2+1] != 0){
				
				return false;
			}
			m_pTree[nodeIndex*2+1] = pNode;
		}
		else if(direction == 1){
			if(nodeIndex*2+2 < 0 || nodeIndex*2+2 >= m_iSize)
			{
				return false;
			}
			if(m_pTree[nodeIndex*2+2] != 0){
				
				return false;
			}
			m_pTree[nodeIndex*2+2] = pNode;
		}
		return true;
	}
	
	public int deleteNode(int nodeIndex ){
		if(nodeIndex < 0 || nodeIndex >= m_iSize)
		{
			return 0;
		}
		if(m_pTree[nodeIndex] == 0){  //父节点是空值
			
			return 0;
		}
		int pNode = m_pTree[nodeIndex];
		m_pTree[nodeIndex] = 0;
		return pNode;
		
	}
	public void treeTraverse(){
		for(int i:m_pTree){
			System.out.print(i+" ");
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(10,3);
		tree.addNode(0, 0, 5);
		tree.addNode(0, 1, 8);
		
		tree.addNode(1, 0, 2);
		tree.addNode(1, 1, 6);
		
		tree.addNode(2, 0, 9);
		tree.addNode(2, 1, 7);
		
		tree.treeTraverse();//遍历
		System.out.println();
		
		int node = tree.searchNode(2);//搜索
		System.out.println("下标为2的节点=="+node);
		
		node = tree.deleteNode(6);
		System.out.println("删除下标为6的节点=="+node);
	}
}
