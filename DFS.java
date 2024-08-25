import java.util.*;
class DFS{
     public static class Edge{
        int scr;
        int dest;
        // int wt;
        
        public Edge(int s,int d){
            this.scr=s;
            this.dest=d;
            // this.wt=w;

        }
     }
     public static void createGraph(ArrayList<Edge>graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]= new ArrayList<Edge>();//har index pr ek new arraylist create ho jye ge or har index pr ek 
            
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
    

         graph[3].add(new Edge(3, 1));
         graph[3].add(new Edge(3, 4));
         graph[3].add(new Edge(3, 5));

         graph[4].add(new Edge(4, 2));
         graph[4].add(new Edge(4, 3));
         graph[4].add(new Edge(4, 5));

         graph[5].add(new Edge(5, 3));
         graph[5].add(new Edge(5, 4));
         graph[5].add(new Edge(5, 6));

         graph[6].add(new Edge(6, 5));
     }
     public static void bsf(ArrayList<Edge>graph[],int V){
        Queue<Integer> q= new LinkedList<>();
        boolean vis[]= new boolean[V];
        q.add(0);//this is the start it can be any 
        while (!q.isEmpty()) {
            int curr=q.remove();
            if(vis[curr]==false){
                System.out.print(curr+"  ");
                vis[curr]=true;

                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e= graph[curr].get(i);
                    q.add(e.dest);//sare k sare neighbour queue me add ho jyn ge 
                }
            }


            
        }
     }
     public static void dfs(ArrayList<Edge>graph[],int curr,boolean vis[]){
System.out.print(curr+" ");
vis[curr]=true;
for (int i = 0; i < graph[curr].size(); i++) {
    //neigbour k liyay 
    Edge e = graph[curr].get(i);//edge nikal lia 
    //e.dest jo hai wo neighbour hai 
    if(vis[e.dest]==false){

        dfs(graph, e.dest, vis);//agle level ka curr iss ke wja se gaya
    }
    
}
     }
     public static void PathFromSource(ArrayList<Edge>graph[],boolean vis[],int curr, String Path,int tar){
if(curr==tar){
    System.out.println(Path);
    return;
}
for (int i = 0; i < graph[curr].size(); i++) {
    Edge e = graph[curr].get(i);
    if(!vis[e.dest]){
        vis[curr]=true;//jis level pr khare hain use visit kar k agle ko call lagani hai 
    PathFromSource(graph, vis, e.dest, Path+e.dest, tar);
vis[curr]=false;
//visit ka modification sb se important hai 
    }

}
     }
    public static void main(String[] args) {
        int V=7;
        
        //     1-------3
        //    /        | \
        //    0        |  5---6
        //     \       | /
        //      2------4
        
    ArrayList<Edge> graph[]=new ArrayList[V]; 
    createGraph(graph);
    boolean vis[]= new boolean[V];
    // bsf(graph,V);
    // System.out.println(); 
    // dfs(graph, 0, vis);
    int scr= 0,tar=5;
    PathFromSource(graph,vis, scr,"0", tar);
    }
}