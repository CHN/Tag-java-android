package com.EditHere.EditHere;

import java.util.ArrayList;

public final class TagManager {

    public ArrayList<Tag_Sample> tag_list = new ArrayList<Tag_Sample>();
    public String addTag(Object object, String tag){
        boolean exist=false;
        int index=0;
        for(int i=0;i<tag_list.size();i++) {
            Tag_Sample  temp_tag = tag_list.get(i);
        if(temp_tag.object == object){
            exist = true;
            index = i;
            break;
        }
        }
        if(exist){
            tag_list.get(index).tags.add(tag);
        }else {
            tag_list.add(new Tag_Sample());
            tag_list.get(tag_list.size()-1).object = object;
            tag_list.get(tag_list.size()-1).tags = new ArrayList<String>();
            tag_list.get(tag_list.size()-1).tags.add(tag);
        }

      return tag;
    }
    public String removeTagByIndexAndObject(Object object,int index){
        String return_val = new String();
        for(int i=0;i<tag_list.size();i++){
            if(object == tag_list.get(i).object){
                return_val =tag_list.get(i).tags.get(i);
                tag_list.get(i).tags.remove(index);
            }
        }
        return return_val;
    }
    public void removeTagByNameAndObject(Object object,String tag){
        for(int i=0;i<tag_list.size();i++){
            if(object == tag_list.get(i).object){
                for(int j=0;j<tag_list.get(i).tags.size();j++){
                      if(tag_list.get(i).tags.get(j) == tag){
                          tag_list.get(i).tags.remove(j);
                      }
                }
            }
        }
    }
    public void removeAllTagsByName(String tag){
        for(int i=0;i<tag_list.size();i++){
                for(int j=0;j<tag_list.get(i).tags.size();j++){
                    if(tag_list.get(i).tags.get(j) == tag){
                        tag_list.get(i).tags.remove(j);
                    }
                }
            }
    }
    public void removeAllTagsByIndex(int index){
        for(int i=0;i<tag_list.size();i++){
            if(index <tag_list.get(i).tags.size()) {
                tag_list.get(i).tags.remove(index);
            }
        }
    }
    public void removeObject(Object object){
          for(int i=0;i<tag_list.size();i++){
              if(tag_list.get(i).object == object){
                 tag_list.remove(i);
              }
          }
    }
    public void removeAllObjectsIfNoTag(){
        for(int i=0;i<tag_list.size();i++){
            if(tag_list.get(i).tags.size()==0){
                tag_list.remove(i);
            }
        }
    }
    public String[] getTagsByObject(Object object){
            for (int i = 0; i < tag_list.size(); i++) {
                Tag_Sample temp_tag = tag_list.get(i);
                if (temp_tag.object == object) {
                    String[] temp_array = new String[temp_tag.tags.size()];
                    for (int j = 0; j < temp_array.length; j++) {
                        temp_array[j] = temp_tag.tags.get(j);
                    }
                    return temp_array;
                }
            }
            return null;
    }
    public String[] getAllTags(){
        ArrayList<String> temp_array = new ArrayList<String>();
        for (int i = 0; i < tag_list.size(); i++) {
            Tag_Sample temp_tag = tag_list.get(i);
                for (int j = 0; j < temp_tag.tags.size(); j++) {
                    temp_array.add(temp_tag.tags.get(j));
                }
            }
            String[] return_val = new String[temp_array.size()];
                for(int i=0;i<temp_array.size();i++){
                    return_val[i] = temp_array.get(i);
                }
        return return_val;
    }
    public String getTagByIndexAndObject(Object object, int index){
        try {
            return getTagsByObject(object)[index];
        }finally {
            return "Unassigned of Tag element for this object";
        }

    }
    public Object[] getObjectListByTag(String tag){
        ArrayList<Object> temp_object = new ArrayList<Object>();

        for (int i=0;i < tag_list.size();i++){
            for(int j=0;j< tag_list.get(i).tags.size();j++){
                if(tag_list.get(i).tags.get(j) == tag){
                    temp_object.add(tag_list.get(i).object);
                    break;
                }
            }
        }
        Object[] temp_array = new Object[temp_object.size()];
        for(int i=0;i<temp_array.length;i++){
            temp_array[i] = temp_object.get(i);
        }
        return temp_array;
    }
    public int getTagCountByObject(Object object){
        return getTagsByObject(object).length;
    }
    public int getObjectCountByTag(String tag){
        int count =0;
        for (int i=0;i < tag_list.size();i++){
            for(int j=0;j< tag_list.get(i).tags.size();j++){
                if(tag_list.get(i).tags.get(j) == tag){
                    count++;
                }
            }
        }
        return count;
    }
    public String TagListToString(){
        StringBuilder temp_string=new StringBuilder();
        for(int i=0;i<tag_list.size();i++){
            temp_string.append("Object Class Name: ");
            temp_string.append( "|"+tag_list.get(i).object.getClass().getSimpleName()+"|");
            temp_string.append("\t");
            temp_string.append("Tags: ");
            for(int j=0;j<tag_list.get(i).tags.size();j++){
                temp_string.append("|"+tag_list.get(i).tags.get(j).toString()+"|");
                temp_string.append("\t");
            }
            temp_string.append("\n");
        }
        return temp_string.toString();
    }
    public String TagListToStringForObject(Object object){
        StringBuilder temp_string=new StringBuilder();
        temp_string.append("Object Class Name: ");
        temp_string.append("|"+ object.getClass().getSimpleName()+"|");
        temp_string.append("\t");
        temp_string.append("Tags: ");
        for(int i=0;i<tag_list.size();i++){
            if(object==tag_list.get(i).object) {
                for (int j = 0; j < tag_list.get(i).tags.size(); j++) {
                    temp_string.append("|"+tag_list.get(i).tags.get(j).toString()+"|");
                    temp_string.append("\t");
                }

            }
            temp_string.append("\n");
        }
        return temp_string.toString();
    }
    private final class Tag_Sample{
        Object object;
        ArrayList<String> tags;
    }
}
