package HashMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap<K, V> {
    private class Entity{
        K key;
        V value;
        public Entity(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Use Chaining method
    private ArrayList<LinkedList<Entity>> list;
    private int size = 0; // number of keys
    private float lf = 0.95f; // load factor = total number of keys / list.size()

    public MyHashMap() {
        list = new ArrayList<>();
        for(int i = 0; i < 23; i++) list.add(new LinkedList<>());
    }

    private void reHash() {
        System.out.println("We are now rehashing!");

        ArrayList<LinkedList<Entity>> old = list;
        list = new ArrayList<>();

        for(int i = 0; i < old.size() * 2; i++) {
            list.add(new LinkedList<>());
        }

        for(LinkedList<Entity> entities : old) {
            for(Entity e : entities) {
                put(e.key, e.value);
            }
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void put(K key, V value) {

        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        for(Entity e : entities) {
            if(e.key.equals(key)) {
                e.value = value;
                return;
            }
        }

        if((float)(size)/list.size() > lf) {
            reHash();
        }

        entities.add(new Entity(key, value));
        size++;
    }

    public V get(K key) throws Exception {
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        for(Entity e : entities) {
            if(e.key.equals(key)) {
                return e.value;
            }
        }

        throw new Exception("The Key is not present in the HashMap");

    }

    public void remove(K key) throws Exception {
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        Entity target = null;

        for(Entity e : entities) {
            if(e.key.equals(key)) {
                target = e;
                break;
            }
        }

        if(target != null) {
            entities.remove(target);
            size--;
        } else {
            throw new Exception("The key is not present in the HashMap");
        }
    }

    public boolean containsKey(K key) {
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);

        for(Entity e : entities) {
            if(e.key.equals(key)) {
                return true;
            }
        }

        return false;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for(LinkedList<Entity> entities : list) {
            sb.append("[ ");
            for(Entity e : entities) {
                sb.append(e.key);
                sb.append(" = ");
                sb.append(e.value);
                sb.append(" , ");
            }
            sb.append("], ");
        }
        sb.append("}");
        return sb.toString();
    }

}
