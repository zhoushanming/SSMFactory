package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.ItemMapper;
import cn.edu.usts.cs2018.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service(value = "itemService")
public class ItemServiceImpl implements IItemService {
    @Autowired
    ItemMapper mapper;
    @PostConstruct
    void init(){
        resetAllDrawingItems();
        resetAllCoatingItems();
    }
    void resetAllDrawingItems(){
        List<Item>dils=mapper.getItemsByStateAndCurrentState(0,1);
        for(Item item :dils){
            item.setCurentState(0);
            mapper.update(item);
        }
    }
    void resetAllCoatingItems(){
        List<Item>cils=mapper.getItemsByStateAndCurrentState(1,2);
        for(Item item :cils){
            item.setCurentState(1);
            mapper.update(item);
        }
    }
    @Override
    public Boolean insert(Item item) {
        return mapper.insert(item)>0;
    }

    @Override
    public Boolean update(Item item) {
        return mapper.update(item)>0;
    }

    @Override
    public Boolean delete(int id) {
        return mapper.delete(id)>0;
    }

    @Override
    public Item getItem(int id) {
        return mapper.getItem(id);
    }

    @Override
    public List<Item> getItems() {
        return mapper.getAllItems();
    }

    @Override
    public List<Item> getItemsByState(int state) {
        return mapper.getItemsByState(state);
    }

    @Override
    public List<Item> getItemsByMould(int mould) {
        return mapper.getItemsByMould(mould);
    }

    @Override
    public List<Item> getItemsByStateAndCurrentState(int state, int currentState) {
        return mapper.getItemsByStateAndCurrentState(state, currentState);
    }

    @Override
    public List<Item> getLimitedCountItemsByStateAndCurrentState(int count, int state, int currentState) {
        return mapper.getLimitedCountItemsByStateAndCurrentState(count, state, currentState);
    }

    @Override
    public List<Item> getItemsByDrawingMachine(int drawingMachineId) {
        return mapper.getItemsByDrawingMachine(drawingMachineId);
    }

    @Override
    public List<Item> getItemsByCoatingMachine(int coatingMachineId) {
        return getItemsByCoatingMachine(coatingMachineId);
    }

    @Override
    public List<Item> getRawItems() {
        return mapper.getItemsByState(0);
    }

    @Override
    public List<Item> getSemiItems() {
        return mapper.getItemsByState(1);
    }

    @Override
    public List<Item> getEndItems() {
        return mapper.getItemsByState(2);
    }

    @Override
    public Boolean sendToDrawing(int id, int drawingMachineId) {
        Item item=mapper.getItem(id);
        item.setDrawingMachineId(drawingMachineId);
        item.setCurentState(1);
        return update(item);
    }

    @Override
    public Boolean sendToCoating(int id, int coatingMachineId) {
        Item item=mapper.getItem(id);
        item.setCoatingMachineId(coatingMachineId);
        item.setCurentState(2);
        return update(item);
    }

    @Override
    public Boolean processComplete(int id, Date date) {
        Item item=mapper.getItem(id);
        item.setState(item.getState()+1);
        item.setDate(date);
        return update(item);
    }

    @Override
    public List<Item> getLimitedCountItemsForDrawing(int count) {
        return getLimitedCountItemsByStateAndCurrentState(count,0,0);
    }

    @Override
    public List<Item> getLimitedCountItemsForCoating(int count) {
        return getLimitedCountItemsByStateAndCurrentState(count,1,1);
    }
}
