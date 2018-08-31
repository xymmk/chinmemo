
import java.util.ArrayList;
import java.util.List;

public class LrdTree {
	private List<node> tree = new ArrayList<node>();
	public List<node> getTree(){
		return tree;
	} 
	class node{
		int id = -1;
		int leftId = -1;
		int rightId = -1;
		int value = -1;
		int parent = -1;
		public node(int id,int leftId,int rightId, int value) {
			this.id = id;
			this.leftId = leftId;
			this.rightId = rightId;
			this.value = value;
		}
		public int getId() {
			return this.id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getValue() {
			return this.value;
		}		
		public void setValue(int value) {
			this.value = value;
		}
		public int getLeftNode() {
			return this.leftId;
		}
		public void setLeftNode(int node) {
			this.leftId = node;
		}
		public int getRightNode() {
			return this.rightId;
		}
		public void setRightNode(int node) {
			this.rightId = node;
		}
		public int getParent() {
			return this.parent;
		}
		public void setParent(int node) {
			this.parent = node;
		}
	}
	
	public static int getRoot(List<node> tree) {
		int target = 0;
		for(int i = 0 ;i < tree.size(); i++) {
			int value = tree.get(i).getValue() * -1;
			int flag = -1;
			for(int j= 0; j < tree.size(); j++) {
				if(value == tree.get(j).getLeftNode() || value == tree.get(j).getRightNode()) {
					flag = 0;
					break;
				}
				if(j == tree.size() - 1) {
					target = i;
				}
			}
			if(flag == 0) {
				continue;
			}
		}
		System.out.println("tree size " + tree.size() + " id " + tree.get(target).getId());
		return tree.get(target).getId();
	}
	
	public int createTree(int n, int childrenId) {
		if(childrenId == -1) {
			this.tree.add(new node(n*-1, -1, -1, n));
			return getRoot(this.tree);
		}else {
			node na = null;
			for(int i = 0; i < tree.size(); i++) {
				if(tree.get(i).getId() == childrenId) {
					na = tree.get(i);
				}
			}
			int leftId = na.getLeftNode();
			int rightId = na.getRightNode();
			int value = na.getValue();
			
			if(value >= n) {
				if(leftId == -1) {
					na.setLeftNode(n * -1);
					tree.add(new node(n*-1, -1,-1,n));
				}
				if(leftId != -1) {
					node leftNode = null;
					for(int i = 0; i < tree.size(); i++) {
						if(tree.get(i).getId() == leftId) {
							leftNode = tree.get(i);
						}
					}
					int leftNodeValue = leftNode.getValue();
					if(n < leftNodeValue) {
						createTree(n, leftId);
					}
					if(n >= leftNodeValue) {
						if(rightId == -1) {
							na.setRightNode(n * -1);
							tree.add(new node(n*-1,-1,-1,n));
						}
						if(rightId != -1) {
							
							node rightNode = null;
							for(int i = 0; i < tree.size(); i++) {
								if(tree.get(i).getId() == rightId) {
									rightNode = tree.get(i);
								}
							}
							createTree(n, rightNode.getId());
						}
					}
				}
				return getRoot(this.tree);
			}else {
				String isLeft = "";
				node parentNode = null;
				for(int i=0; i < tree.size(); i++) {
					if(childrenId == tree.get(i).getRightNode()) {
						parentNode = tree.get(i);
						isLeft = "no";
					}
				}
				for(int i=0; i < tree.size(); i++) {
					if(childrenId == tree.get(i).getLeftNode()) {
						parentNode = tree.get(i);
						isLeft = "yes";
					}
				}
				if(parentNode != null) {
					node nod = new node(n*-1,childrenId,-1,n);
					if("no".equals(isLeft)) {
						parentNode.setRightNode(n*-1);
					}else {
						parentNode.setLeftNode(n*-1);
					}
					tree.add(nod);
				}else {
					tree.add(new node(n*-1, childrenId,-1,n));
				}
				return getRoot(this.tree);
			}
		}
	}
	public static void main(String[] args) {
		int[] array = {2,8,10,7,100,9,50,3,60,6};
		LrdTree t = new LrdTree();
		int rootId = -1;
		for(int i = 0 ;i < array.length; i++) {
			if(i == 0) {
				rootId = t.createTree(array[i], -1);
			}else {
				rootId = t.createTree(array[i], rootId);
			}
		}
		List<node> tree = t.getTree();
		for(int i = 0; i < tree.size(); i++) {
			System.out.println("id:" + tree.get(i).getId() + " left:" + tree.get(i).getLeftNode() + " right:" + tree.get(i).getRightNode() + " value:" + tree.get(i).getValue());
		}
	}
}

