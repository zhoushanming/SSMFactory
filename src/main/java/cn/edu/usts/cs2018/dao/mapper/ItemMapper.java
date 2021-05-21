package cn.edu.usts.cs2018.dao.mapper;

import cn.edu.usts.cs2018.entity.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    public int insert(Item item);
    public int update(Item item);
    public int delete(int id);

    public Item getItem(int id);
    public List<Item> getAllItems();
    public List<Item> getItemsByState(int state);
    public List<Item> getItemsByMould(int mould);
    public List<Item> getItemsByStateAndCurrentState(@Param("state") int state,@Param("curentState") int curentState);
    public List<Item> getItemsByDrawingMachine(int drawingMachineId);
    public List<Item> getItemsByCoatingMachine(int coatingMachineId);
    public List<Item> getLimitedCountItemsByStateAndCurrentState(@Param("count")int count,@Param("state") int state,@Param("curentState") int curentState);
}
