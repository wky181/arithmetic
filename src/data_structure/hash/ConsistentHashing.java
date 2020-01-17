package data_structure.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

/**
 * @author 武凯焱
 * @date 2019/12/3 11:03
 * @Description: 一致性hash算法
 */

// 不考虑数据倾斜
public class ConsistentHashing {
    /**
     * 将key映射到2^32的环状空间里面
     */
    static long hash(String key) {
        ByteBuffer buf = ByteBuffer.wrap(key.getBytes());
        int seed = 0x1234ABCD;

        ByteOrder byteOrder = buf.order();
        buf.order(ByteOrder.LITTLE_ENDIAN);

        long m = 0xc6a4a7935bd1e995L;
        int r = 47;

        long h = seed ^ (buf.remaining() * m);

        long k;
        while (buf.remaining() >= 8) {
            k = buf.getLong();

            k *= m;
            k ^= k >>> r;
            k *= m;

            h ^= k;
            h *= m;
        }
        if (buf.remaining() > 0) {
            ByteBuffer finish = ByteBuffer.allocate(8).order(
                    ByteOrder.LITTLE_ENDIAN);
            // for big-endian version, do this first:
            // finish.position(8-buf.remaining());
            finish.put(buf).rewind();
            h ^= finish.getLong();
            h *= m;
        }

        h ^= h >>> r;
        h *= m;
        h ^= h >>> r;

        buf.order(byteOrder);
        return Math.abs(h);
    }
    interface HashNode {
        String getName();
    }
    // 定义空间节点
    static class Node implements HashNode{
        String name;
        String ip;

        public Node(String name, String ip) {
            this.name = name;
            this.ip = ip;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", ip='" + ip + '\'' +
                    '}';
        }

        @Override
        public String getName() {
            return this.name;
        }
    }

    /**
     * 节点列表
     */

    List<Node> nodes;

    TreeMap<Long,Node> treeMap = new TreeMap<>();
    /**
     * 储存放进来的数据并与其所属的节点绑定
     */
    TreeMap<Long,Node> keyAndNode = new TreeMap<>();
    public ConsistentHashing(List<Node> nodes){
        this.nodes = nodes;
        init();
    }
    public void addNode(Node node){
        long hash  = hash(node.ip);
        treeMap.put(hash,node);
        SortedMap<Long, Node> longNodeSortedMap = treeMap.headMap(hash);
        if (longNodeSortedMap.size() == 0){
            SortedMap<Long, Node> between = keyAndNode.subMap(0L, hash);
            for (Map.Entry<Long, Node> e : between.entrySet()) {
                e.setValue(node);
            }
            between =keyAndNode.tailMap(treeMap.lastKey());
            for (Map.Entry<Long, Node> e : between.entrySet()) {
                e.setValue(node);
            }
        }else {
            long from = longNodeSortedMap.lastKey();
            long to = hash;
            SortedMap<Long, Node> between = keyAndNode.subMap(from, to);
            for (Map.Entry<Long, Node> e : between.entrySet()) {
                e.setValue(node);
            }
        }

    }
    public void add(String key){
        long hash = hash(key);
        SortedMap<Long, Node> longNodeSortedMap = treeMap.tailMap(hash);
        if (longNodeSortedMap.size()==0){
            keyAndNode.put(hash(key),treeMap.firstEntry().getValue());
        }else {
            //获取该key所归属的node
            Node node = longNodeSortedMap.get(longNodeSortedMap.firstKey());
            keyAndNode.put(hash(key), node);
        }
    }
    public void init(){
        for (int i = 0; i < nodes.size() ; i++) {
            Node node = nodes.get(i);
            Long hash = hash(node.ip);
            treeMap.put(hash,node);
        }
    }
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("上海","192.168.0.1"));
        nodes.add(new Node("北京","10.168.0.2"));
        nodes.add(new Node("深圳","172.168.0.3"));
        nodes.add(new Node("广州","101.168.0.4"));
        nodes.add(new Node("杭州","192.168.0.5"));
        nodes.add(new Node("苏州","192.168.0.3"));
        ConsistentHashing consistentHashing = new ConsistentHashing(nodes);
        for (Map.Entry<Long,Node> entry: consistentHashing.treeMap.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
        consistentHashing.add("csfcdsf");
        consistentHashing.add("csf");
        consistentHashing.add("csfdsd");
        consistentHashing.add("csff");
        consistentHashing.add("cscdsf");

        }


}
