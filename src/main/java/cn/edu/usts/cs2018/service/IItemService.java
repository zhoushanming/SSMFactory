package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.entity.Item;

import java.util.Date;
import java.util.List;

public interface IItemService {
    public Boolean insert(Item item);
    public Boolean update(Item item);
    public Boolean delete(int id);

    public Item getItem(int id);
    public List<Item> getItems();
    public List<Item> getItemsByState(int state);
    public List<Item> getItemsByMould(int mould);
    public List<Item> getItemsByStateAndCurrentState(int state,int currentState);
    public List<Item> getLimitedCountItemsByStateAndCurrentState(int count,int state,int currentState);
    public List<Item> getItemsByDrawingMachine(int drawingMachineId);
    public List<Item> getItemsByCoatingMachine(int coatingMachineId);
    public List<Item> getRawItems();
    public List<Item> getSemiItems();
    public List<Item> getEndItems();

    public Boolean sendToDrawing(int id,int drawingMachineId);
    public Boolean sendToCoating(int id,int coatingMachineId);
    public Boolean processComplete(int id, Date date);

    public List<Item>getLimitedCountItemsForDrawing(int count);
    public List<Item>getLimitedCountItemsForCoating(int count);
}
