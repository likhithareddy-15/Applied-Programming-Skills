import java.util.*;
class Solution{
public List<List<Integer>> levelOrder(TreeNode root){
List<List<Integer>> r=new ArrayList<>();
if(root==null)return r;
Queue<TreeNode> q=new LinkedList<>();
q.offer(root);
while(!q.isEmpty()){
int s=q.size();
List<Integer> l=new ArrayList<>();
for(int i=0;i<s;i++){
TreeNode n=q.poll();
l.add(n.val);
if(n.left!=null)q.offer(n.left);
if(n.right!=null)q.offer(n.right);
}
r.add(l);
}
return r;
}
}