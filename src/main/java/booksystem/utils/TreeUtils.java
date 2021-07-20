package booksystem.utils;

import booksystem.pojo.Category;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {
    private  String name;
    private  String id;
    private  String pid;
    private  List<TreeUtils> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getPid() {
        return pid;
    }

    public List<TreeUtils> getChildren() {
        return children;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setChildren(List<TreeUtils> children) {
        this.children = children;
    }

    public TreeUtils() {
    }

    public TreeUtils(String name, String id, String pid) {
        this.name = name;
        this.id = id;
        this.pid = pid;
    }

    /**
     * 递归（先得到父节点）再递归
     * @param list
     * @return
     */
    public static List<TreeUtils> getTreeResult(List<TreeUtils> list){
        List<TreeUtils> listResult =new ArrayList<>();
        for (TreeUtils t:list   ) {
            if (t.getPid().equals("999")){
                listResult.add(t);// 得到父类
            }
        }
        secondTree(list, listResult);
        return listResult;
    }

    /**
     * 父节点获取子节点
     * @param list
     * @param listResult
     * @return
     */

    public static  void secondTree(List<TreeUtils> list,List<TreeUtils> listResult) {
        for (TreeUtils tResult : listResult) {
            List<TreeUtils> childrens = new ArrayList<>();
            for (TreeUtils t : list) {
                if (t.getPid().equals("999")) {
                    continue;
                }
                if (tResult.getId().equals(t.getPid())) {
                    childrens.add(t);
                }
            }
            tResult.setChildren(childrens);
            if (!tResult.getChildren().isEmpty()) {
                secondTree(list, tResult.getChildren());
            }
        }
    }
}
