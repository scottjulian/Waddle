package com.scottjulian.Waddle;

import com.scottjulian.Waddle.util.node.UndirectedGraphNode;

import java.util.HashMap;
import java.util.Map;


public class Graphs {

    /**
     * https://leetcode.com/problems/clone-graph/
     *
     * @param node
     * @return
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer,UndirectedGraphNode> cloneMap = new HashMap<Integer,UndirectedGraphNode>();
        return clone(node, cloneMap);
    }

    private UndirectedGraphNode clone(UndirectedGraphNode node, Map<Integer,UndirectedGraphNode> map) {
        if(node == null){
            return null;
        }
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        else{
            UndirectedGraphNode root = new UndirectedGraphNode(node.label);
            map.put(node.label, root);
            for(UndirectedGraphNode neighbor : node.neighbors){
                root.neighbors.add(clone(neighbor, map));
            }
            return root;
        }
    }

}
