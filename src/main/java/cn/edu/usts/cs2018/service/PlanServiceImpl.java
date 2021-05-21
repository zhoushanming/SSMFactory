package cn.edu.usts.cs2018.service;

import cn.edu.usts.cs2018.dao.mapper.PlanMapper;
import cn.edu.usts.cs2018.entity.Item;
import cn.edu.usts.cs2018.entity.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "planService")
public class PlanServiceImpl implements IPlanService {
    @Autowired
    PlanMapper mapper;
    @Autowired
    IItemService itemService;
    @Override
    public Boolean insert(Plan plan) {
        if(mapper.insert(plan)==0)return false;
        Item item=new Item();
        item.setMouldId(plan.getSpec());
        item.setWeight((double)plan.getAmount());   /// !!!!!!!
        item.setState(0);
        item.setCurentState(0);
        itemService.insert(item);
        return true;
    }

    @Override
    public Boolean update(Plan plan) {
        return mapper.update(plan)>0;
    }

    @Override
    public Boolean delete(int id) {
        return mapper.delete(id)>0;
    }

    @Override
    public Plan getPlan(int id) {
        return mapper.getPlan(id);
    }

    @Override
    public List<Plan> getPlans() {
        return mapper.getPlans();
    }
}
