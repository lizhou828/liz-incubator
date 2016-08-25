import com.liz.common.utils.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhou on 2016/7/31.
 */
public class JsonTest {
    public static void main(String[] args){
        Father father = new Father();
        Son son = new Son(1,"Mike");
        father.setSon(son);
        List<Daughter> daughterList = new ArrayList<Daughter>();
        Daughter daughter1 = new Daughter(2,"Louis");
        daughterList.add(daughter1);
        Daughter daughter2 = new Daughter(3,"Abby");
        daughterList.add(daughter2);
        father.setDaughterList(daughterList);
        System.out.println(father);

        System.out.println("father after Json : " + JsonUtil.parse(father));


    }
}

class Father {
    private Son son;
    private List<Daughter> daughterList;


    public Son getSon() {
        return son;
    }

    public void setSon(Son son) {
        this.son = son;
    }

    public List<Daughter> getDaughterList() {
        return daughterList;
    }

    public void setDaughterList(List<Daughter> daughterList) {
        this.daughterList = daughterList;
    }

    @Override
    public String toString() {
        return "Father{" +
                "son=" + son +
                ", daughterList=" + daughterList +
                '}';
    }
}
class Son{
    private int id;
    private String name;

    public Son(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Son{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
class Daughter{
    private int id;
    private String name;

    public Daughter(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Daughter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
